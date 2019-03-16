package com.title.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lichuang.lc on 2019/3/14.
 */
public class CodeExam3 {

    //LRU缓存 实现：map存储KV，链表确定次序
    public class LruCache{
        //缓存容量
        private int sizeLimit;

        private LinkNode head = new LinkNode(Integer.MIN_VALUE);
        private LinkNode tail = new LinkNode(Integer.MIN_VALUE);

        private Map<String,LinkNode> cache = new ConcurrentHashMap<>();

        public LruCache(int sizeLimit){
            this.sizeLimit = sizeLimit;
        }

        private class LinkNode{
            int value;
            LinkNode prev;
            LinkNode next;

            public LinkNode(int value){
                this.value = value;
            }
        }


        public Integer getValue(String key){
            if(!cache.containsKey(key)){
                return null;
            }
            LinkNode node = cache.get(key);
             //TODO 移位到最新位置
            node.prev.next = node.next;
            node.next.prev = node.prev;

            node.next = tail;
            tail.prev.next = node;
            node.prev = tail.prev;
            tail.prev = node;
            //存在缓存表
            cache.put(key, node);
            return node.value;
        }



        public void setValue(String key, Integer value){
            if(cache.get(key)!=null){
                cache.put(key,new LinkNode(value));
                return;
            }
            if(cache.size() == sizeLimit){ //TODO 移除末尾节点
                cache.remove(head.next);
                head.next = head.next.next;
                head.next.prev = head;
            }
            LinkNode linkNode = new LinkNode(value);
            cache.put(key,linkNode);
            //TODO 节点插入最新位置
            linkNode.next = tail;
            tail.prev.next = linkNode;
            linkNode.prev = tail.prev;
            tail.prev = linkNode;
        }
    }

}
