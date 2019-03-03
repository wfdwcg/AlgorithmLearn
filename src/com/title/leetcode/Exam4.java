package com.title.leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by lichuang.lc on 2019/3/2.
 */
public class Exam4 {

    //https://leetcode.com/problems/reverse-words-in-a-string/description/
    //151 翻转一个字符串中的字符
    //先整体翻转一次
    //然后对各个单词（已空格为界）再翻转一次
    //双指针法
    public String reverseWords(String s) {
        if (s == null) return null;

        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++; // skip spaces
            while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }

    public String reverseWords2(String s) {
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    //https://leetcode.com/problems/majority-element/description/
    //169 给定一个大小为n的数组，有个元素出现次数不小于n/2，找出这个元素
    //维持一个节点坑位major和相应的数目统计count
    //* 如果发现相同节点就累加count，否则就递减count
    //* 最终遍历完成获取到的major即是
    public int majorityElement(int[] num) {
        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else{
                count--;
            }
        }
        return major;
    }


    //https://leetcode.com/problems/rotate-array/description/
    //189 将一个数组右移k位
    /**
     * ** 常规
     * 新建一个相同大小的数组B
     * 将从A[n-1-k]到A[n-1]分别设置到B的B[0]到B[k-1]
     * 将A[0]到A[n-2-k]分别设置到B[k]到B[n-1]


     ** 逆序
     * 先将整个数组逆序得到B
     * 将B的前k个元素逆序得到C
     * 将C的后n-k-1个元素逆序得到最终结果
     */

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    //https://leetcode.com/problems/reverse-bits/description/
    //190 将一个32位无符号整数的二进制表示反转
    //* A从后往前，B从前往后
    // A&1然后左移，对应B然后右移
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }


    //https://leetcode.com/problems/number-of-1-bits/description/
    //191 获取一个32位无符号整数中比特1的个数
    //* 从左到右，按位与1取与运算，如果该位为1，则得到1并相加
    public static int hammingWeight(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }


}
