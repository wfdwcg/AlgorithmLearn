package com.title.algorithm;

import com.sun.org.apache.bcel.internal.generic.RET;
import com.sun.org.apache.regexp.internal.RE;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by lichuang.lc on 2019/2/22.
 */
public class LinkListExams {

    private static class LinkedListNode<E> {
        E item;
        LinkedListNode<E> next;
        LinkedListNode<E> prev;

        LinkedListNode(LinkedListNode<E> prev, E element, LinkedListNode<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /**题目1
     * 编写代码，移除未排序链表中的重复节点
     * 如果允许使用临时缓冲区，又如何处理？
     */

    //使用缓冲区，时间O(N), N为节点数目
    public void deleteRepeatNodes1(LinkedListNode node){
        HashMap map = new HashMap();
        LinkedListNode prev = null;
        while (node!=null){
            if(map.containsKey(node.item)){
                prev.next = node.next;
            }else {
                map.put(node.item,true);
                prev = node;
            }
            node = node.next;
        }
    }

    //不使用缓冲区，双指针
    //空间O(1) 时间O(N^2)
    public void deleteRepeatNodes2(LinkedListNode head){
        if(head==null){
            return;
        }

        LinkedListNode current = head;
        while (current!=null){
            LinkedListNode runner = current;
            while (runner.next!=null){
                if(runner.next.item == current.item){
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }

    /**题目2
     * 找出单向链表中倒数第K个节点
     */



    /**题目3
     * 确定一个链表是否为回文(节点为整数)
     */

    //快慢两指针，2倍速，一个到末尾，一个正好到中间
    //回文则以中心对称
    public boolean isHw1(LinkedListNode head){
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        Stack<Integer> stack = new Stack<>();
        while (fast!=null && slow!=null){
            stack.push((int)slow.item);
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast!=null){//奇数个节点时
            slow=slow.next;
        }
        while (slow!=null){
            int top = stack.pop().intValue();
            if(top!=(int)slow.item){
                return false;
            }
            slow=slow.next;
        }
        return true;
    }


    //递归


}
