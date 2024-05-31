package com.xxliao.algorithms.recursion.demo;

/**
 * @author xxliao
 * @description: 利用递归实现 打印100次 hello word
 * @date 2024/5/29 23:42
 */
public class Demo01 {


    public static void main(String[] args) {
        print("hello word",100);
    }

    /**
     * @description  打印 count 次 message 信息
     * @author  xxliao
     * @date  2024/5/29 23:44
     */
    public static void print(String message,int count) {
        if(count > 0) {// 递归的结束条件
            System.out.println(message); // 函数的功能
            print(message,count-1); //函数的等价关系式
        }
    }
}
