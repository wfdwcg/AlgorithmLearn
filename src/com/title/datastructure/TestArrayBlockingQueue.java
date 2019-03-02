package com.title.datastructure;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by lichuang.lc on 2019/3/1.
 * 阻塞队列 可用于实现生产者消费者模型、线程池
 */
public class TestArrayBlockingQueue {
    ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(100);

    class Produce extends Thread{
        private int i=0;
        private ArrayBlockingQueue<Integer> arrayBlockingQueue;
        public Produce(ArrayBlockingQueue<Integer> arrayBlockingQueue){
            this.arrayBlockingQueue=arrayBlockingQueue;
        }
        @Override
        public void run(){
            try {
                while (i<1000) {
                    arrayBlockingQueue.put(i);
                    if (++i%100==0){//每生产100个，休息10s
                        Thread.sleep(10000);
                    }
                }
            }catch (InterruptedException e){
                System.out.println("produce queue InterruptedException");
            }
        }
    }
    class Consume implements Runnable{
        private ArrayBlockingQueue<Integer> arrayBlockingQueue;
        public Consume(ArrayBlockingQueue<Integer> arrayBlockingQueue){
            this.arrayBlockingQueue=arrayBlockingQueue;
        }
        @Override
        public void run(){
            try{
                while (true){
                    Integer poll = arrayBlockingQueue.poll(5, TimeUnit.SECONDS);//如果queue为null，那么5秒之后再去队列中取数据
                    if (poll!=null) {
                        System.out.println(Thread.currentThread().getName() + "--consume --" + poll);
                    }

                }
            }catch (InterruptedException e){
                System.out.println("consume queue InterruptedException");
            }
        }
    }

}
