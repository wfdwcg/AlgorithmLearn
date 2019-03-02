package com.title.leetcode;

/**
 * Created by lichuang.lc on 2019/3/2.
 */
public class Exam13 {

    //633 给定一个非负整数，判断是否可表示为 a^2 + b^2 的形式
    public boolean isSquare(int c){
        for(int i=(int)Math.sqrt(c); i>=0; i--){
            if(i * i ==c){
                return true; //a^2 + 0
            }
            int d = c - i*i;
            int t = (int)Math.sqrt(d);
            if(t*t == d){
                return true;
            }
        }
        return false;
    }

}
