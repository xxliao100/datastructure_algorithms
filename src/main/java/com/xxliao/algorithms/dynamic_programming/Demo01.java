package com.xxliao.algorithms.dynamic_programming;

/**
 * @author xxliao
 * @description: 利用动态规划实现
 * 斐波那契数列：0、1、1、2、3、5、8、13、21、34、55.....
 * 规律：从第3个数开始，每个数等于前面两个数的和
 *
 * @date 2024/6/1 1:17
 */
public class Demo01 {

    public static void main(String[] args) {
        System.out.println(fib(9));
    }

    /**
     * @description  动态规划实现 斐波那契数列
     * @author  xxliao
     * @date  2024/6/1 1:23
     */
    public static int fib(int n) {
        // 定义当前数组，也就是0 ~ n 数组
        int[] array = new int[n+1];
        // 定义边界
        array[0] = 0;
        array[1] = 1;

        // if(i>=2) 则 	dp[i] = dp[i-1] + dp[i-2]; dp方程
        int i = 2;
        for(; i <= n; i++){
            array[i] = array[i-1] + array[i-2];
        }
        return array[i-1]; // 循环结束加了1
    }
}
