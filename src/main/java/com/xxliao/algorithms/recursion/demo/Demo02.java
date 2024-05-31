package com.xxliao.algorithms.recursion.demo;

/**
 * @author xxliao
 * @description: 利用递归实现如下功能：
 * 斐波那契数列：1、1、2、3、5、8、13、21、34、55.....
 * 规律：从第3个数开始，每个数等于前面两个数的和
 * 递归分析：
 * 函数的功能：返回n的前两个数的和
 * 递归结束条件：从第三个数开始，n<=2
 * 函数的等价关系式：fun(n)=fun(n-1)+fun(n-2)
 * @date 2024/5/29 23:47
 */

public class Demo02 {

    public static void main(String[] args) {
        System.out.println(fun(9));
    }

    //用于存储每次的计算结果
    static int[] sub=new int[10];
    /**
     * @description  斐波那契数列 实现，
     * @author  xxliao
     * @date  2024/5/29 23:49
     */
    public static int fun(int n) {
        if(n==1 || n==2)
            return 1;
        if(sub[n]==0){
            sub[n]=fun(n-1)+fun(n-2);
        }
        return sub[n];
    }
}
