package com.xxliao.algorithms.complexity;

/**
 * @author xxliao
 * @description: 算法复杂度
 *
 * 时间复杂度解释：
   公式：T(n) = O(f(n))
    T(n)：代码执行的时间；
    n：数据规模；
    f(n):每行代码执行次数总和
    O：代码的实行与f(n)表达式成正比

 * @date 2024/5/27 18:23
 */

public class Complexity01 {

    /**
     * @description  下面中的T(n)=O(m*n)，也就是代码执行时间随着数据规模的增加而平方增长，那么时间复杂度就是 T(n)=O(n^2)
     * @author  xxliao
     * @date  2024/5/27 18:32
     */
    public int sumOne(int n) {
        int s=0;
        int i=1;
        int j=1;
        for(;i<=n;i++){ // n
            j=1;
            for(;j<=n;j++){ //n*n
                s=s+i+j; //n*n
            }
        }
        return s;
    }

    public int sumTwo(int n) {
        int s=0;
        int i=1;
        int j=1;
        for(;i<=n;i++){ //t*n
            s=s+i; //t*n
        }
        for(;i<=n;i++){// n
            j=1;
            int m = 1;
            for(;j<=m;j++){ //n*m
                s=s+i+j; //n*m
            }
        }
        return s;
    }
}
