package com.title.leetcode;

/**
 * Created by lichuang.lc on 2019/2/25.
 */
public class Exam16 {

    //https://leetcode.com/problems/rotate-string/
    //796  判断是否为移位后的词
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

}
