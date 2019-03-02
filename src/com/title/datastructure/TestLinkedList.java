package com.title.datastructure;

import java.util.LinkedList;
import sun.security.timestamp.TSRequest;

/**
 * Created by lichuang.lc on 2019/3/1.
 */
public class TestLinkedList {

    public static void testLinkedList(){
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(9);
        linkedList.add(8);
        linkedList.add(3);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.getFirst());
    }

    public static void main(String [] args){
        testLinkedList();
    }

}
