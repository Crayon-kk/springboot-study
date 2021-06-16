package com.crayon.kk.zk;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

/**
 * @author 75510
 */
@Service
public class DistributedLockByCurator implements InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(DistributedLockByCurator.class);

    /**
     * zk下的创建的目录
     */
    private final static String ROOT_PATH_LOCK = "root";

    private CountDownLatch cdl = new CountDownLatch(1);

    private CuratorFramework curatorFramework;

    public DistributedLockByCurator(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
    }


    /**
     * 获取分布式锁
     */
    public void acquireLock(String path) {
        String keyPath = "/" + ROOT_PATH_LOCK + "/" + path;
        while (true) {
            try {
                curatorFramework
                        .create()
                        .creatingParentsIfNeeded()
                        .withMode(CreateMode.EPHEMERAL)
                        .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                        .forPath(keyPath);
                log.info("acquireLock|success to acquire lock for path:{}", keyPath);
                break;
            } catch (Exception e) {
                log.info("acquireLock|failed to acquire lock for path:{}", keyPath);
                log.info("acquireLock|while try again ...");
                try {
                    if (cdl.getCount() <= 0) {
                        cdl = new CountDownLatch(1);
                    }
                    cdl.await();
                } catch (InterruptedException e1) {
                    log.error("再次创建失败");
                }
            }
        }
    }

    /**
     * 释放分布式锁
     */
    public boolean releaseLock(String path) {
        try {
            String keyPath = "/" + ROOT_PATH_LOCK + "/" + path;
            if (curatorFramework.checkExists().forPath(keyPath) != null) {
                curatorFramework.delete().forPath(keyPath);
            }
        } catch (Exception e) {
            log.error("releaseLock|failed to release lock|path:{}", path, e);
            return false;
        }
        return true;
    }


    /**
     * 创建 watcher 事件
     */
    private void addWatch() throws Exception {
        String keyPath = "/" + ROOT_PATH_LOCK;
        final PathChildrenCache cache = new PathChildrenCache(curatorFramework, keyPath, false);
        cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        cache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) {
                if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)) {
                    String oldPath = event.getData().getPath();
                    log.info("addWatch|success to release lock for path:{}", oldPath);
                    if (oldPath.contains(ROOT_PATH_LOCK)) {
                        //释放计数器，让当前的请求获取锁
                        cdl.countDown();
                    }
                }
            }
        });
    }


    //创建父节点，并创建永久节点
    @Override
    public void afterPropertiesSet() {
        curatorFramework = curatorFramework.usingNamespace("lockNamespace");
        String path = "/" + ROOT_PATH_LOCK;
        try {
            if (curatorFramework.checkExists().forPath(path) == null) {
                curatorFramework.create()
                        .creatingParentsIfNeeded()
                        .withMode(CreateMode.PERSISTENT)
                        .withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
                        .forPath(path);
            }
            addWatch();
            log.info("root path 的 watcher 事件创建成功");
        } catch (Exception e) {
            log.error("connect zookeeper fail,please check the log >> {}", e.getMessage(), e);
        }
    }
}