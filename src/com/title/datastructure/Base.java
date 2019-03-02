package com.title.datastructure;

import java.util.Map;
import java.util.Objects;

/**
 * Created by lichuang.lc on 2019/3/2.
 */
public class Base {

    //双链表
    public static class LinkedListNode<E> {
        E item;
        LinkedListNode<E> next;
        LinkedListNode<E> prev;

        LinkedListNode(LinkedListNode<E> prev, E element, LinkedListNode<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    //栈 数组实现
    Object[] stack;

    //队列 数组实现
    Object[] queue;

    //哈希表 --HashMap
    static class HashMapNode<K,V> implements Map.Entry<K,V> {
        final int hash;
        final K key;
        V value;
        HashMapNode<K,V> next;

        HashMapNode(int hash, K key, V value, HashMapNode<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }

}
