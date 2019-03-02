package com.title.datastructure;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by lichuang.lc on 2019/3/1.
 *
 * 基于红黑树实现的排序Map
 * TreeMap的增删改查和统计相关的操作的时间复杂度都为 O(logn)
 * key的值不允许重复（重复则覆盖），也不允许为null，按照key的自然顺序排序或者Comparator接口指定的排序方法进行排序
 */
public class TestTreeMap {

    public static void testTreeMap(){
        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("t",9);
        treeMap.put("d",15);
        treeMap.put("a",99);
        treeMap.put("h",1);
        System.out.println(treeMap.toString()); //默认输出按照key排序的结果

        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("t",9);
        hashMap.put("d",15);
        hashMap.put("a",99);
        hashMap.put("h",1);
        //自定义排序规则 实现按value排序
        TreeMap<String,Integer> treeMap2 = new TreeMap<>(new TestComparator(hashMap));
        treeMap2.putAll(hashMap);
        System.out.println(treeMap2.toString()); //输出按照value排序的结果
    }

    static class TestComparator implements Comparator<String> {
        private Map<String,Integer> testmap;

        public TestComparator(Map map){
            this.testmap = map;
        }
        @Override
        public int compare(String s1, String s2){
            if (testmap.get(s1) > testmap.get(s2)){
                return 1;
            }else if(testmap.get(s1) < testmap.get(s2)){
                return -1;
            }
            // 如果比较value，相同的value的Key将会发生合并，即Value的值是不允许重复的
            // 必须返回 0，否则get方法将返回null
            return 0;
        }
    }

    public static void main(String [] args){
        testTreeMap();
    }

}
