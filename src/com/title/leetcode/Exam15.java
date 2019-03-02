package com.title.leetcode;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichuang.lc on 2019/2/25.
 */
public class Exam15 {
    //https://leetcode.com/problems/largest-number-at-least-twice-of-others/
    //747 查找数组中最大元素是否大于其他所有元素的两倍
    //解法1：存储最大和次大（只与这两个有关）
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secondMx = Integer.MIN_VALUE;
        int index = -1;
        if(nums==null || nums.length==0){
            return -1;
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                secondMx = max;
                max = nums[i];
                index = i;
            }else if(nums[i]>secondMx){
                secondMx = nums[i];
            }
        }
        if(max >= 2*secondMx){
            return index;
        }
        return -1;
    }


    //https://leetcode.com/problems/self-dividing-numbers/
    //728 给定一个数，输出小于它的所有自相除序列（能被索引组成自己的单数字整除）
    //解法1：按照定义
    public static List<Integer> selfDividingNumbers(int left, int right) {
        if(left>right){
            return new ArrayList<>();
        }
        List<Integer> out = new ArrayList<>();
        for(int i=left;i<=right;i++){
            int num = Integer.MAX_VALUE;
            int intNu = i;
            while(i>0) {
                num = intNu % 10; //组成数字的单数字 0-9
                if ((num==0) || (i%num!=0)){ //quick num!=0
                    break;
                }
                intNu = intNu/10;
                if(intNu==0){
                    out.add(i);
                    System.out.println(i);
                    break; //quick
                }
            }
        }
        return out;
    }


    public static List<Integer> selfDividingNumbers2(int left, int right) {
        if(left>right){
            return new ArrayList<>();
        }
        List<Integer> out = new ArrayList<>();
        for(int i=left;i<=right;i++){
            char[] chs = String.valueOf(i).toCharArray();
            for(int j=chs.length-1;j>=0;j--){
                int num = chs[j]-'0';
                if(num==0 || i%num != 0){
                    break;
                }else if(j==0){
                    out.add(i);
                    break;
                }
            }
        }
        return out;
    }

    //解法3 最优
    public List<Integer> selfDividingNumbers3(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if ((j % 10 == 0) || (i % (j % 10) != 0)) break;
            }
            if (j == 0) list.add(i);
        }
        return list;
    }

    public static void main(String[] args){
        System.out.println(selfDividingNumbers2(10,22).toString());
    }


}
