package com.title.datastructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lichuang.lc on 2019/3/1.
 * 排序相关
 */
public class TestSort {

    //.sort--Arrays.sort--归并排序
    public static void testSort(){
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(3);
        list.add(99);
        list.add(9);
        list.sort(Comparator.comparing(Integer::intValue));
        System.out.println(list.toString());
        list.sort(Comparator.comparing(Integer::intValue).reversed());
        System.out.println(list.toString());
    }

    public static void main(String [] args){
        testSort();
    }
}
