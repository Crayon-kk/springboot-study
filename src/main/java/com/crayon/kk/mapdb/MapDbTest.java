package com.crayon.kk.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.Serializer;

import java.util.concurrent.ConcurrentMap;

/**
 * @Author 张海锋
 * @Date 2021/7/8 16:51
 */
public class MapDbTest {
    public static void main(String[] args) {
        DB db = DBMaker
                .fileDB("file.txt")
                .make();
        ConcurrentMap<String,Long> map = db
                .hashMap("map", Serializer.STRING, Serializer.LONG)
                .createOrOpen();
        map.put("something", 111L);

    }
}
