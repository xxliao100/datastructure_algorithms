package com.xxliao.algorithms.string_match.brute_force;

/**
 * @author xxliao
 * @description: BF算法 - 暴力匹配算法
 * @date 2024/5/31 12:56
 */
public class BruteForceMatch {

    public static void main(String[] args) {
        System.out.println(match("ccaaac","caaac"));
    }


    /**
     * @description  字符串匹配，暴力匹配
     * main:主串
     * sub: 模式串
     * @author  xxliao
     * @date  2024/5/31 12:57
     */
    public static boolean match(String main,String pattern) {
        char[] mainChars = main.toCharArray();
        char[] patternChars = pattern.toCharArray();
        // 遍历主串，然后循环内部遍历模式串，进行比对
        for(int i = 0; i <= main.length()- pattern.length(); i++) {
            boolean flag = true;
            int temp = i;
            for (int j = 0; j < pattern.length(); j++) {
                if(mainChars[temp++] != patternChars[j]) {
                    flag = false;
                }
            }
            if(flag)
                return true;
        }
        return false;
    }

}
