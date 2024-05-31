package com.xxliao.algorithms.string_match.hash;

/**
 * @author xxliao
 * @description: 字符串匹配 RK算法，hash匹配
 * @date 2024/5/31 13:59
 */
public class HashMatch {

    public static void main(String[] args) {
        System.out.println(match("abcvdcd","vdcd"));
    }

    /**
     * @description  字符串hash 匹配
     * @author  xxliao
     * @date  2024/5/31 14:00
     */
    public static boolean match(String main, String pattern) {
        int hash_pattern = hash(pattern);
        for (int i = 0; i <= (main.length() - pattern.length()); i++) {
            // 主串截串后与子串的hash值比较
            if (hash_pattern==hash(main.substring(i, i + pattern.length()))) {
                return true;
            }
        }
        return false;
    }

    /**
     * @description  求出字符串的hash值，这里简单实现，实际业务没这么简单
     * @author  xxliao
     * @date  2024/5/31 14:01
     */
    public static int hash(String src) {
        int hash = 0;
        for (int i = 0; i < src.length(); i++) {
            hash *= 26;
            hash += src.charAt(i) - 97;
        }
        return hash;
    }
}
