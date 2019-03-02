package com.title.leetcode;

/**
 * Created by lichuang.lc on 2019/2/27.
 */
public class Exam8 {
    //https://leetcode.com/problems/find-the-difference/
    //389 找个增添的那个不同的字符
    public char findTheDifference(String s, String t) {
        // Initialize variables to store sum of ASCII codes for
        // each string
        int charCodeS = 0, charCodeT = 0;
        // Iterate through both strings and char codes
        for (int i = 0; i < s.length(); ++i) charCodeS += (int)s.charAt(i);
        for (int i = 0; i < t.length(); ++i) charCodeT += (int)t.charAt(i);
        // Return the difference between 2 strings as char
        return (char)(charCodeT - charCodeS);
    }

}
