package com.title.algorithm;

import java.util.Stack;
import java.lang.Integer;

/**
 * Created by lichuang.lc on 2019/2/22.
 */
public class StackExams {

    /**问题1
     * 设计一个栈，除了push和pop，还支持min方法以返回栈元素的最小值。
     * push、pop、min的时间复杂度需要为O(1)
     */
    //解法：使用两个栈，一个记录所有值，一个记录最小值
    public class NewStack{
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>(); //记录最小值

        public void push(int value){
            if(value<=min()){
                s2.push(value);
            }
            s1.push(value);
        }
        public int pop(){
            int value = s1.pop();
            if(value==min()){
                s2.pop();
            }
            return value;
        }
        public int min(){
            if(s2.isEmpty()){
                return java.lang.Integer.MAX_VALUE;
            }
            return s2.peek();
        }
    }

}
