package com.title.datastructure;

import java.util.ArrayDeque;

/**
 * Created by lichuang.lc on 2019/3/1.
 * 双端队列
 */
public class TestArrayDeque {

    public static void testArrayDeque(){
        ArrayDeque deque = new ArrayDeque();
        deque.addFirst(6);
        deque.addFirst(3);
        deque.addLast(11);
        deque.addLast(18);
        System.out.println(deque.toString());
        System.out.println(deque.getFirst());
        System.out.println(deque.getLast());
    }

    public static void main(String [] args){
        testArrayDeque();
    }

}
