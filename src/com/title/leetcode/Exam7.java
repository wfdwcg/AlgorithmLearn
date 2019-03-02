package com.title.leetcode;

/**
 * Created by lichuang.lc on 2019/3/2.
 */
public class Exam7 {

    //300 给定一个未排序整数数组，查找最长增长序列的长度（包含离散序列）
    //动态规划
    public int lengthOfLIS(int[] nums){
        int [] dp = new int[nums.length+1];
        int res = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1); //从0开始，每次累加1  max{0,dp[j]+1}
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }



    //342 判断一个32位整数是否为4的乘方
    public boolean isPowOfFour(int num){
        while((num!=0) && (num%4==0)){
            num = num/4;
        }
        return num==1;
    }

}
