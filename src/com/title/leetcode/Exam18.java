package com.title.leetcode;

import com.title.leetcode.Exam2.ListNode;

/**
 * Created by lichuang.lc on 2019/3/3.
 */
public class Exam18 {

    //https://leetcode.com/problems/middle-of-the-linked-list/description/
    //876 给定一个链表，头结点为head，返回其中间节点，如果中间有两个就返回第二个
    //双指针：步长为1和2，遍历链表，快的遍历完成后，慢的正好在中间
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



}
