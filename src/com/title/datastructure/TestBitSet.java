package com.title.datastructure;

import java.util.BitSet;

/**
 * Created by lichuang.lc on 2019/3/1.
 * 位域运算
 */
public class TestBitSet {

    public static void testBitSet(){
        BitSet bitSet = new BitSet();
        bitSet.set(4);
        bitSet.set(20);
        bitSet.set(8);
        System.out.println(bitSet.get(2));
        System.out.println(bitSet.get(8));
        System.out.println(bitSet.toString());
    }

    public static void main(String [] args){
        testBitSet();
    }

}
