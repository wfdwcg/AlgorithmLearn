package com.title.leetcode;

import java.util.Stack;

/**
 * Created by lichuang.lc on 2019/3/3.
 */
public class Exam5 {

    //https://leetcode.com/problems/remove-linked-list-elements/description/
    //203 移除链表里等于给定值的所有节点
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }


    //https://leetcode.com/problems/count-primes/description/
    //204 统计小于给定非负数的所有素数个数
    //构造不是素数的数组
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }


    //https://leetcode.com/problems/implement-queue-using-stacks/description/
    //232 使用栈实现队列
    class MyQueue {

        Stack<Integer> input = new Stack();
        Stack<Integer> output = new Stack();

        public void push(int x) {
            input.push(x);
        }

        public void pop() {
            peek();
            output.pop();
        }

        public int peek() {
            if (output.empty())
                while (!input.empty())
                    output.push(input.pop());
            return output.peek();
        }

        public boolean empty() {
            return input.empty() && output.empty();
        }
    }



    //https://leetcode.com/problems/palindrome-linked-list/description/
    //235 判断链表是否为回文
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }




}
