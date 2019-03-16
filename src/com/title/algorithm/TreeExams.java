package com.title.algorithm;

/**
 * Created by lichuang.lc on 2019/2/22.
 *
 * 二叉查找树：对任意树节点值X，它的左子树节点值均小于X，右子树节点值均大于X
 */
public class TreeExams {

    private static class TreeNode<E> {
        E item;
        TreeNode<E> left;
        TreeNode<E> right;

        TreeNode(TreeNode<E> left, E element, TreeNode<E> right) {
            this.item = element;
            this.left = left;
            this.right = right;
        }

        TreeNode(E element) {
            this.item = element;
        }
    }

    private int getHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) +1;
    }

    /**题目1
     * 判断二叉树是否平衡（两颗子树高度差不超过1）
     */

    //解法1：递归法
    //时间O(Nlog(N))
    public boolean isBalanceTree1(TreeNode root){
        if(root==null){
            return true;
        }
        int heightDiff = Math.abs(getHeight(root.left)-getHeight(root.right));
        if(heightDiff>1){
            return false;
        }else {
            return isBalanceTree1(root.left) && isBalanceTree1(root.right);
        }
    }

    //解法2：提前返回
    //获取子树高度时，顺带判断子树是否平衡
    public boolean isBalanceTree2(TreeNode root){
        return checkHeight(root)!=-1;
    }

    private int checkHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = checkHeight(root.left);
        if(leftHeight==-1){ //左子树不平衡
            return -1;
        }
        int rightHeight = checkHeight(root.right);
        if(rightHeight==-1){ //左子树不平衡
            return -1;
        }

        int heightDiff = Math.abs(leftHeight-rightHeight);
        if(heightDiff>1){
            return -1;
        }else {
            return Math.max(leftHeight,rightHeight)+1;
        }
    }

    /**题目2
     * 给定一个有序整数数组，元素各不相同且按升序排序
     * 根据这个数组创建一颗高度最小的二叉查找树
     */
    public TreeNode createTree(int arr[], int start, int end){
        if(end<start){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createTree(arr,start,mid-1);
        root.right = createTree(arr, mid+1,end);
        return root;
    }

    public TreeNode createTree(int arr[]){
        return createTree(arr,0,arr.length-1);
    }

    /**题目3
     * 检查一个二叉树是否为二叉查找树
     */
    //解法1：中序遍历
    //将所有元素复制到数组，然后检查数组是否有序
    int index=0;
    public boolean isBST(TreeNode root){
        if(root==null){
            return false;
        }
        int[] arr = new int[100];
        copyBSTToArray(root,arr);
        for(int i=1;i<arr.length;i++){
            if(arr[i]<=arr[i-1]){
                return false;
            }
        }
        return true;
    }

    public void copyBSTToArray(TreeNode root, int arr[]){
        if(root==null){
            return;
        }
        copyBSTToArray(root.left,arr);
        arr[index] = (int)root.item;
        index++;
        copyBSTToArray(root.right,arr);
    }

    //解法2：递归检查，也是中序遍历
    int lastVal = Integer.MIN_VALUE;
    public boolean isBST2(TreeNode node){
        if(node==null){
            return true;
        }
        if(!isBST2(node.left)){ //左
            return false;
        }
        if((int)node.item<=lastVal){//中
            return false;
        }
        lastVal = (int)node.item;

        if(!isBST2(node.right)){//右
            return false;
        }
        return true;
    }


    //解法3：递归检查左右子树
    public boolean isBST3(TreeNode root){
        return isBST3(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBST3(TreeNode root, int min, int max){
        if(root==null){
            return true;
        }
        if((int)root.item<min || (int)root.item>=max){
            return false;
        }
        if(!isBST3(root.left,min, (int)root.item) || !isBST3(root.right, (int)root.item,max)){
            return false;
        }
        return true;
    }

    /**题目4
     * 找出二叉树中某两个节点的第一个共同祖先
     */
    //时间 O(N)
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(!isProgeny(root,p) || !isProgeny(root,q)){
            return null;
        }
        return commonAncestorHelper(root,p,q);
    }

    public TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
        if(root==null || root==p || root==q){
            return root;
        }
        boolean isPLeft = isProgeny(root.left,p);
        boolean isqLeft = isProgeny(root.left,q);

        //pq分布在左右子树，则root即为第一个共同祖先
        if(isPLeft != isqLeft){
            return root;
        }
        //pq在同一侧
        TreeNode childSide = isPLeft ? root.left : root.right;
        return commonAncestorHelper(childSide,p,q);
    }

    //p是否为root的后代
    public boolean isProgeny(TreeNode root, TreeNode p){
        if(root==null){
            return false;
        }
        if(root==p){
            return true;
        }
        return isProgeny(root.left,p) || isProgeny(root.right,p);
    }

}
