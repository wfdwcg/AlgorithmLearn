package com.title.datastructure;

import java.util.Stack;

/**
 * Created by lichuang.lc on 2019/3/1.
 */
public class TestStack {

    public static void testStack(){
        Stack stack = new Stack();
        stack.add(1);
        stack.add(3);
        stack.add(2);
        stack.push(8);
        stack.push(-2);
        System.out.println(stack.peek());
        System.out.println(stack.elementAt(2));
        System.out.println(stack.pop());
    }

    public static void main(String [] args){
        testStack();
    }

}
