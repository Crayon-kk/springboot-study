package com.crayon.kk.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author 张海锋
 * @Date 2021/7/8 16:51
 */
public class MapDbTest {
    public static void main(String[] args) {
//        DB db = DBMaker
//                .fileDB("file.txt")
//                .make();
//        ConcurrentMap<String,Long> map = db
//                .hashMap("map", Serializer.STRING, Serializer.LONG)
//                .createOrOpen();
        File fil = new File("file1.db");
        System.out.println(fil.length());
        DB db = DBMaker
                .fileDB("file.db")
                .fileLockDisable()
                .checksumHeaderBypass()
                .closeOnJvmShutdown()
                .make();
        ConcurrentMap<String,Long> allConsumerMap = db
                .hashMap("map", Serializer.STRING, Serializer.JAVA)
                .createOrOpen();
        allConsumerMap.entrySet().stream().forEach(System.out::println);
        System.out.println(allConsumerMap.size());
    }
}
