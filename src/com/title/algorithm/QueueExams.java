package com.title.algorithm;

import java.util.Stack;

/**
 * Created by lichuang.lc on 2019/2/24.
 */
public class QueueExams {
    //题目1：使用两个栈来实现一个队列

    public class NewQueue<T>{ //先进先出
        Stack<T> stackOldEst, stackNewest;

        public NewQueue(){
            stackNewest = new Stack<>();
            stackOldEst = new Stack<>();
        }

        public int size(){
            return stackOldEst.size()+stackNewest.size();
        }
        public void add(T value){
            stackNewest.push(value);
        }
        //将新add的元素逆序放入old栈（push+pop）
        private void shiftStacks(){
            if(stackOldEst.isEmpty()){
                while (!stackNewest.isEmpty()){
                    stackOldEst.push(stackNewest.pop());
                }
            }
        }
        //栈顶，最先进入队列的元素（经过了一次调换）
        public T peek(){
            shiftStacks();
            return stackOldEst.peek();
        }
        public T remove(){
            shiftStacks();
            return stackOldEst.pop();
        }
    }
}
