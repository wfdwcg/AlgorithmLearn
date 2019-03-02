package com.title.datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lichuang.lc on 2019/3/1.
 * 最小堆：任意父结点的值都<=左右子结点的值
 */
public class TestPriorityQueue {

    //优先队列（最小堆--二叉堆）
    public static void testPriorityQueue(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(5);
        queue.add(2);
        queue.add(8);
        queue.add(1);
        System.out.println(queue.peek()); //队列头部始终为最小元素
        System.out.println(queue.poll()); //每次弹出最小元素

        //自行实现TestComparator构建最大堆的优先队列
        PriorityQueue<Integer> queueMax = new PriorityQueue<>(new TestComparator());
        queueMax.add(5);
        queueMax.add(2);
        queueMax.add(8);
        queueMax.add(1);
        System.out.println(queueMax.peek()); //队列头部始终为最大元素
    }

    public static void main(String [] args){
        testPriorityQueue();
    }

    //PriorityQueue<Integer> queuede = new PriorityQueue<>(new TestComparator());

    static class TestComparator implements Comparator{
        @Override
        public int compare(Object o1, Object o2){
            Integer int1 = (Integer)o1;
            Integer int2 = (Integer)o2;
            if(int1.compareTo(int2)>0){
                return -1;
            }else if(int1.compareTo(int2)==0){
                return 0;
            }
            return 1;
        }
    }
}
