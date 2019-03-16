package com.title.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by lichuang.lc on 2019/3/14.
 */
public class CodeExam2 {

    //解法1
    public List<String> getRepeatStrings1(String[] arr){
        List<String> result = new ArrayList<>();
        if(arr==null || arr.length==0){
            return result;
        }

        Set set = new HashSet<>();
        for(String ss : arr){
            if(set.contains(ss)){
                result.add(ss);
            }else {
                set.add(ss);
            }
        }
        return result;
    }

    //解法2
    public List<String> getRepeatStrings2(String[] arr){
        List<String> result = new ArrayList<>();
        if(arr==null || arr.length==0){
            return result;
        }

        Map<String,Boolean> map = new HashMap<>();
        for(String ss : arr){
            if(map.containsKey(ss)){
                result.add(ss);
            }else {
                map.put(ss,Boolean.TRUE);
            }
        }
        return result;
    }


    //问题3：最大递增子序列
    public List<Integer> getIncreaseArray(int[] arr){
        if(arr.length == 0) {
            return null;
        }
        int maxSequence = 0;
        int minMark=0; //上下标
        int maxMark=0;
        int count = 1; //连续递增长度
        for(int i=0;i<arr.length - 1;i++){
            if(arr[i] < arr[i+1]){
                count++;
                maxMark++;
            }else{
                if(count > maxSequence){
                    maxSequence = count;
                    maxMark=i;
                }else {
                    count=1;
                    minMark=i+1;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(minMark);
        result.add(maxMark);
        return result;
    }



}
