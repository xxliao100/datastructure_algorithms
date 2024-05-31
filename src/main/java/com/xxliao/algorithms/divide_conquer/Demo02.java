package com.xxliao.algorithms.divide_conquer;

/**
 * @author xxliao
 * @description: 比如: 2^10 2的10次幂
 * 采用分治法
 * @date 2024/5/31 21:44
 */

public class Demo02 {

    public static void main(String[] args) {
        System.out.println( dividpow(2,10) );
    }

    public static int dividpow(int x,int n){
        //递归结束 任何数的1次方都是它本身
        if(n==1){
            return x;
        }
        //每次分拆成幂的一半
        int half=dividpow(x,n/2);
        //偶数
        if(n%2==0){
            return half*half;
        }
        else{
            return half*half*x;
        }
    }
}
