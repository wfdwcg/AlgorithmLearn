package com.title.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lichuang.lc on 2019/3/2.
 */
public class Exam3 {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    //https://leetcode.com/problems/symmetric-tree/description/
    //101 判断一个二叉树是否对称
    public boolean isSymmetric(TreeNode root) {
        return root==null || isSymmetricHelp(root.left, root.right);
    }

    private boolean isSymmetricHelp(TreeNode left, TreeNode right){
        if(left==null || right==null) {
            return left == right;
        }
        if(left.val!=right.val) {
            return false;
        }
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }


    //https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
    //104 给定一个二叉树，获取它的最大深度
    class Solution {
        public int maxDepth(TreeNode root) {
            if(root==null){
                return 0;
            }
            return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
        }
    }


    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
    //107 二叉树逆序遍历输出
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }


    //https://leetcode.com/problems/balanced-binary-tree/description/
    //110 判断二叉树是否平衡


    //https://leetcode.com/problems/path-sum/description/
    //112 给定一个二叉树和一个特定值，判断从根到叶子是否有路径节点的和为这个值
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


    //https://leetcode.com/problems/single-number/description/
    //136 给定一个整数数组，其中除了一个元素出现一次，其余都出现两次，找出这个元素
    //循环遍历做异或操作
    int singleNumber(int A[], int n) {
        int result = 0;
        for (int i = 0; i<n; i++)
        {
            result ^=A[i];
        }
        return result;
    }


    //https://leetcode.com/problems/linked-list-cycle/description/
    //141 判断一个链表是否有环
    /*public boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }*/



}
