package com.title.leetcode;

/**
 * Created by lichuang.lc on 2019/3/3.
 */
public class Exam19 {

    //https://leetcode.com/problems/sort-array-by-parity/description/
    //907 给定一个非负整数数组，返回其中的偶数集合加上奇数集合
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = 0; j < A.length; j++)
            if (A[j] % 2 == 0) {
                int tmp = A[i];
                A[i++] = A[j];
                A[j] = tmp;;
            }
        return A;
    }


    //https://leetcode.com/problems/reverse-only-letters/description/
    //917 给定一个字符串返回其逆序，其中字母逆序，其他符号保持不变
    //双指针 从两端遍历
    //* 分别从两端找到字母，然后交换
    public String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        for (int i = 0, j = S.length() - 1; i < j; ++i, --j) {
            while (i < j && !Character.isLetter(sb.charAt(i))) ++i;
            while (i < j && !Character.isLetter(sb.charAt(j))) --j;
            sb.setCharAt(i, S.charAt(j));
            sb.setCharAt(j, S.charAt(i));
        }
        return sb.toString();
    }

}
