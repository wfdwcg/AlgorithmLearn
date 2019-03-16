package com.title.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by lichuang.lc on 2019/3/1.
 */
public class Exam1 {

    //https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
    //3 从字符串中获取最长不重复子串

    //使用set，每次放入一个字符
    //* 每次放入时先做去重判断，如果有重复就存下来set的数目，删除set所有字符，并把当前字符放入
    //* 字符读取完毕后，找出最大的数目（每次存数目时与之前做比对，只存大的那个）
    public int lengthOfLongestSubstring(String s){
        if(s==null || s.length()==0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0,j=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }


    //https://leetcode.com/problems/median-of-two-sorted-arrays/description/
    //4 求两个已排序数组的中位数


    //https://leetcode.com/problems/reverse-integer/description/
    //反转32位有符号整数
    public int reverse1(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    //解法2--转成字符串，对非负部分反转



    //https://leetcode.com/problems/implement-strstr/description/
    //28 查询子串在给定字符串中匹配的起始位置，如果不匹配则返回-1
    //逐个字符比较
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }


    //https://leetcode.com/problems/search-insert-position/description/
    //35 给一个已排序数组，查找给定字符在数组的位置，如果不在。就返回它应该插入的位置
    //二分查找
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (nums.length == 0) {
            return 0;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }


    //https://leetcode.com/problems/trapping-rain-water/
    //42 盛雨水问题 阶梯围成的横纵坐标能盛多少雨水
    //单调栈解法
    public int saveCountOfWater(int [] height){
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                int t = s.pop();
                if (s.isEmpty()) continue;
                res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
            }
        }
        return res;
    }



}
