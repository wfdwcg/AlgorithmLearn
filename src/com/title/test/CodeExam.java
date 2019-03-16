package com.title.test;

/**
 * Created by lichuang.lc on 2019/3/12.
 */
public class CodeExam {

    public int getNum(long [] arr){
        long min = 0;
        long max = 2 * Integer.MAX_VALUE + 1;

        long result = min;
        //终止阈值
        int num = 10;

        while (min < max) {
            long mid = (min + max) / 2;
            if (arr[mid] == (arr[min]+arr[max])/2) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        //return result;
    }


}
