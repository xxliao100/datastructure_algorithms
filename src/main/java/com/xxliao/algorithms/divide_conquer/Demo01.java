package com.xxliao.algorithms.divide_conquer;

/**
 * @author xxliao
 * @description: 将字符串中的小写字母转化为大写字母
 * “abcde”转化为"ABCDE"
 * 我们可以利用分治的思想将整个字符串转化成一个一个的字符处理
 * @date 2024/5/31 21:35
 */

public class Demo01 {

    public static void main(String[] args) {
        String ss="abcde";
        System.out.println(toUpCase(ss.toCharArray(),0));
    }

    /**
     * @description  将char[] 中小写字母转大写字母
     * @author  xxliao
     * @date  2024/5/31 21:39
     */
    public static char[] toUpCase(char[] array,int i){
        if(i>=array.length)
            // 递归结束条件
            return array;
        // 解决：递归地求解各个子问题，若子问题足够小，则直接求解
        array[i]=toUpCaseUnit(array[i]);
        // 向下递归
        return toUpCase(array,i+1);
    }

    /**
     * @description  char字符，小写转大写
     * @author  xxliao
     * @date  2024/5/31 21:39
     */
    public static char toUpCaseUnit(char c){
        int n=c;
        if (n<97 || n>122){
            return ' ';
        }
        return (char)Integer.parseInt(String.valueOf(n-32));
    }
}
