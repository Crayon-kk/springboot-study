package com.crayon.kk.utils;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author 张海锋
 * @Date 2021/7/20 17:06
 */
public class CollectionsCastUtils {

    public static void main(String[] args) {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = Maps.newHashMap();
        map.put("1",1);
        map.put("2",1);
        list.add(map);
        Map<Set<String>, Map<String, Object>> collect = list.stream().collect(Collectors.toMap(Map::keySet, Function.identity(), (key1, key2) -> key2));

        System.out.println(collect);


    }
}
