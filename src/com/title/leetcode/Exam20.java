package com.title.leetcode;

/**
 * Created by lichuang.lc on 2019/3/3.
 */
public class Exam20 {

    //https://leetcode.com/problems/n-repeated-element-in-size-2n-array/description/
    //961 给定一个2N长度的数组，包含N+1个不同的元素，其实一个元素重复N次，找出这个元素
    //根据N个数字的排布规律
    public int repeatedNTimes(int[] A) {
        for (int i = 2; i < A.length; ++i)
            if (A[i] == A[i - 1] || A[i] == A[i - 2])
                return A[i];
        return A[0];
    }


    //解法2  桶定位，count表示数组对应元素的个数，但要求桶的尺寸大于数组中最大元素
    public int repeatedNTimes2(int[] A) {
        int[] count = new int[10000];
        for (int a : A)
            if (count[a]++ == 1)
                return a;
        return -1;
    }


    //https://leetcode.com/problems/add-to-array-form-of-integer/description/
    //989

}
