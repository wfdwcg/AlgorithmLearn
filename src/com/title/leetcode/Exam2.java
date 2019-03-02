package com.title.leetcode;

/**
 * Created by lichuang.lc on 2019/3/2.
 */
public class Exam2 {

    //https://leetcode.com/problems/maximum-subarray/description/
    //53 给一个整数数组，查找一个具有最大和的子数组并返回这个最大和
    public static int maxSubArray(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }


    //https://leetcode.com/problems/sqrtx/description/
    //69 求整数x的平方根
    //二分查找
    public int sqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    //https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    //83 移除已排序链表中的重复元素节点
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    //https://leetcode.com/problems/merge-sorted-array/description/
    //88 合并两个已排序的数组
    public void merge(int A[], int m, int B[], int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1){
            A[k--]= (A[i]>B[j]) ? A[i--] : B[j--];
        }
        while (j>-1){
            A[k--]=B[j--];
        }
    }


    //



}
