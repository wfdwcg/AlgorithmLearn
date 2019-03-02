package com.title.algorithm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 存储相关题目
 * Created by lichuang.lc on 2019/2/23.
 */
public class StoreExams {

    /**题目1
     * 给定一个输入文件包含40亿个非负整数，设计一种算法，产生一个不在该文件的整数
     * 假定有1GB内存可供使用
     */
    //解法1：位域实现
    long numbers = (int)(Integer.MAX_VALUE)+1;
    byte[] bitField = new byte[(int)(numbers/8)];
    public int findOtherNumber() throws FileNotFoundException{
        Scanner in = new Scanner(new FileReader("file.txt"));
        while (in.hasNextInt()){
            int n = in.nextInt();
            bitField[n/8] |= 1<<(n%8);
        }

        for(int i=0;i<bitField.length;i++){
            for(int j=0;j<8;j++){ //每个byte里8个位遍历
                if((bitField[i] & (1<<j))==0){
                    return i*8 + j;
                }
            }
        }
        return -1;
    }

}
