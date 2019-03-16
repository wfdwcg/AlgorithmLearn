/*
package com.title.test;

*/
/**
 * Created by lichuang.lc on 2019/3/5.
 *//*

public class TestExam {
    public int countWater(int[] arr){
        if(arr==null || arr.length<3){
            return 0;
        }
        int max = getMax(arr);
        int countOfWater = 0;
        for(int i=1; i<=max; i++){
            int[] arrNew = new int[arr.length];
            for(int j=0; j<arr.length; j++){
                if(arr[j] > i){
                    arrNew[j]=1;
                }else {
                    arrNew[j]=0;
                }
            }
            int countOfZero = 0;
            for(int k=0; k<arrNew.length; k++){
                if(arrNew[k]==0){
                    countOfZero++;
                }
            }
            countOfWater += dealWithCount(countOfZero);
        }
        return countOfWater;
    }

    private int getMax(int[] arr){

    }

    private int dealWithCount(int countOfZero){

    }

}*/
