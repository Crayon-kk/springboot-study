package com.crayon.kk.mapdb;

import org.mapdb.DB;
import org.mapdb.DBMaker;
import org.mapdb.HTreeMap;
import org.mapdb.Serializer;

/**
 * @Author 张海锋
 * @Date 2021/7/8 16:51
 */
public class MapDbTest {
    public static void main(String[] args) {
        DB db = DBMaker
                .fileDB("dop-dls-all-api-stat.db")
                .fileLockDisable()
                .checksumHeaderBypass()
                .closeOnJvmShutdown()
                .make();
        HTreeMap map = db
                .hashMap("map", Serializer.STRING, Serializer.JAVA)
                .createOrOpen();
        map.entrySet().forEach(System.out::println);
    }
}
