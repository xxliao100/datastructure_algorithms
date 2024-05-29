package com.xxliao.algorithms.complexity;

/**
 * @author xxliao
 * @description: 常见复杂度
O(1)：最简单的、也是最好理解的，也就是常量级复杂度。
    并不表示只执行了一行代码，只是代码的执行不随着 数据规模n 的增加而增加，也就是常量级别。
    在实际应用中，通常使用 冗余字段存储 来将O(n)转换成O(1)，比如：SDS、字典、跳跃表等。

O(log n)、O(n log n)：
 下面代码：
    i=1;
    while(i <= n){
        i = i * 2;
    }
 中2^x=n，那么 x=log2n，忽略系数就是 x=logn,则T(n)=O(logn)，如果将代码执行n遍，呢么T(n)=O(n logn)

O(n):这是一个常见的时间复杂度，很多线性表的操作都是O(n)，比如：数组的插入删除，链表的遍历等。

O(m+n):代码的时间复杂度 由两个数据的规模 来决定
代码距离：
    int sum(int m,int n){
        int s1=0;
        int s2=0;
        int i=1;
        int j=1;
        for(;i<=m;i++){
            s1=s1+i; // 执行最多
        }
        for(;j<=n;j++){
            s2=s2+j; //执行最多
        }
        return s1+s2;
    }

O(m*n):根据乘法法则代码的复杂度就是两端时间复杂度的乘积，当m=n时候，O(m*n) => O(n^2)
代码举例：
    int sum(int m,int n){
        int s=0;
        int i=1;
        int j=1;
        for(;i<=m;i++){// m
            j=1;
            for(;j<=n;j++){ //m*n
                s=s+i+j; //m*n
            }
        }
        return s;
    }

 * @date 2024/5/27 18:37
 */

public class Complexity02 {

}
