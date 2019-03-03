package com.title.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by lichuang.lc on 2019/2/25.
 */
public class Exam9 {

    //求第三个最大的数
    //bug
    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;
        for(Integer n :nums){
            if(n.equals(max) || n.equals(secondMax) || n.equals(thirdMax)){
                continue;
            }
            if(max==null || n>max){
                thirdMax = secondMax;
                secondMax = max;
                max = n;
            }else if(secondMax==null ||  n>secondMax){
                thirdMax = secondMax;
                secondMax = n;
            }else if(thirdMax==null || n>thirdMax){
                thirdMax = n;
            }
        }
        return thirdMax==null?max : thirdMax;
    }

    //https://leetcode.com/problems/add-strings/
    //415 两个大字符串数字之和
    public String addStrings(String num1, String num2) {
        if(num1==null || num2==null){
            return null;
        }
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        if(chs1.length<chs2.length){
            return addByArray(chs1,chs2);
        }else {
            return addByArray(chs2,chs1);
        }

    }

    private String addByArray(char[] smallArr, char[] bigArr){
        int outlength = bigArr.length+1;
        char[] out = new char[outlength];
        for(int i=smallArr.length-1;i>=0;i--){
            int sum = (bigArr[i] - '0') + (smallArr[i] - '0');
            if (sum > 9) {
                sum = sum % 10;
                out[outlength+i-smallArr.length - 1]='1';
            }
            out[outlength+i-smallArr.length] += (char)sum;
        }
        for(int j=smallArr.length; j<bigArr.length; j++){
            int sum = (bigArr[j] - '0') + (out[j] - '0');
            if (sum > 9) {
                sum = sum % 10;
                out[outlength+j-bigArr.length - 1]='1';
            }
            out[outlength+j-bigArr.length] += (char)sum;
        }
        return out.toString();
    }

    //解法2：最优
    public String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }


    public static void main(String [] args){
        System.out.println("11");
        Map map = new HashMap<>();
        map.keySet();
        map.entrySet();
        for(int i=0;i<0;i++){
            System.out.println("00");
        }
    }

    //448
    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
    //找出不在数组里的所有数(1-n)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(nums==null){
            return new ArrayList<>();
        }
        int size = nums.length;
        boolean[] newArr = new boolean[size+1]; //quick  size+1不是size
        for(int i=0; i<size; i++){
            newArr[nums[i]] = true;
        }

        List<Integer> out = new ArrayList<>();
        for(int j=1; j<=size; j++){
            if(!newArr[j]){
                out.add(j);
            }
        }
        return out;
    }


    //438
    //https://leetcode.com/problems/find-all-anagrams-in-a-string/
    //找一个字符串中对给定序列的所有同异型子序列
    //abab ab
    //438 解法1--逐次取出子序列，然后排序比较
    public List<Integer> findAnagrams1(String s, String p) {
        if(s==null || p==null){
            return new ArrayList<>();
        }
        int pSize = p.length();
        int sSize = s.length();
        if(sSize==0 || pSize==0 || sSize<pSize){
            return new ArrayList<>();
        }
        char[] arr2 = p.toCharArray();
        Arrays.sort(arr2);
        int numOfP = getNumber(p);
        List<Integer> out = new ArrayList<>();
        for(int i=0;i<sSize-pSize+1;i++){
            String sSubs = s.substring(i,i+pSize);
            if(isSameArray(sSubs,arr2,numOfP)){
                out.add(i);
            }
        }
        return out;
    }

    private int getNumber(String ss){
        char[] chs = ss.toCharArray();
        int num = 0;
        for(int i=0;i<ss.length();i++){
            num += (int)chs[i];
        }
        return num;
    }

    private boolean isSameArray(String s1, char[] arr2, int numOfP){
        char[] arr1 = s1.toCharArray();

        if(arr1.length!=arr2.length){
            return false;
        }
        int numOfSs = getNumber(s1);
        if(numOfSs!=numOfP){
            return false;
        }
        Arrays.sort(arr1);
        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }


    //解法2：入桶计数
    public List<Integer> findAnagrams2(String s, String p) {
        if(s==null || p==null){
            return new ArrayList<>();
        }
        int pSize = p.length();
        int sSize = s.length();
        if(sSize==0 || pSize==0 || sSize<pSize){
            return new ArrayList<>();
        }
        int[] bucksOfP = putBuckets(p);
        List<Integer> out = new ArrayList<>();
        for(int i=0;i<sSize-pSize+1;i++){
            String sSubs = s.substring(i,i+pSize);
            int[] bucks = putBuckets(sSubs);
            if(isSameArray(bucksOfP,bucks)){
                out.add(i);
            }
        }
        return out;
    }

    private boolean isSameArray(int[] bucksOfP, int[] bucks){
        for(int i=0;i<bucksOfP.length;i++){
            if(bucksOfP[i] != bucks[i]){
                return false;
            }
        }
        return true;
    }

    private int[] putBuckets(String pp){
        char[] chs = pp.toCharArray();
        int[] bucks = new int[26];
        for(int i=0;i<chs.length;i++){
            bucks[(int)(chs[i]-'a')]++;
        }
        return bucks;
    }


    //https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
    //438 变位词的集合
    //* * 滑动窗口
    //* 初始化大小为p.size的窗口
    //* 遍历S的字符，每次移入一个字符
    //* 使用桶来判定S中连续三个字符与窗口中的字符是否一致
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;

        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.

        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;

        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE;

        //loop at the begining of the source string
        while(end < s.length()){

            char c = s.charAt(end);//get a character

            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);// plus or minus one
                if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            end++;

            //increase begin pointer to make it invalid/valid again
            while(counter == 0 /* counter condition. different question may have different condition */){

                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if(map.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
                }

                /* save / update(min/max) the result if find a target*/
                // result collections or result int value

                begin++;
            }
        }
        return result;
    }


}
