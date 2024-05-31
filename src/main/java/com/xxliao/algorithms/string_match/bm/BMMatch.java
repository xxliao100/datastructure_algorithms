package com.xxliao.algorithms.string_match.bm;

import java.util.Arrays;

/**
 * @author xxliao
 * @description: 字符串匹配 BM算法
 * @date 2024/5/31 16:19
 */

public class BMMatch {

    public static void main(String[] args) {
        String main = "acabcbcbacabc";
        String pattern = "";
        System.out.println(match(main,pattern));
    }

    private static final int CHARACTER_SIZE = 256; // 英文字符的种类，2^8

    /**
     * @description  BM算法匹配字符串，匹配成功返回P在S中的首字符下标，匹配失败返回-1
     * @author  xxliao
     * @date  2024/5/31 16:20
     */
    public static int match(String main, String pattern) {

        char[] main_array = main.toCharArray();
        char[] pattern_array = pattern.toCharArray();
        int main_length = main_array.length;
        int pattern_length = pattern_array.length;

        // 模式串为空字符串 或者 主串长度小于模式串长度，返回-1
        if (pattern_length == 0 || main_length < pattern_length) {
            return -1;
        }

        int[] bad_char_array = buildBadCharacter(pattern_array);
        int[] good_char_array = buildGoodSuffix(pattern_array);

        // 从尾部开始匹配，其中i指向主串，j指向模式串
        for (int i = pattern_length - 1; i < main_length; ) {
            int j = pattern_length - 1;
            for (; main_array[i] == pattern_array[j]; i--, j--) {
                if (j == 0) {   // 匹配成功返回首字符下标
                    return i;
                }
            }

            // 每次后移“坏字符规则”和“好后缀规则”两者的较大值
            // 注意此时i（坏字符）已经向前移动，所以并非真正意义上的规则
            i += Math.max(bad_char_array[main_array[i]], good_char_array[pattern_length - 1 - j]);
        }

        return -1;
    }

    /**
     * @description  坏字符规则表，数组内默认填充的是后移位数
     * @author  xxliao
     * @date  2024/5/31 16:30
     */
    private static int[] buildBadCharacter(char[] pattern) {
        int pattern_length = pattern.length;
        int[] bad_char_array = new int[CHARACTER_SIZE]; // 记录坏字符出现时后移位数

        Arrays.fill(bad_char_array, pattern_length);  // 默认后移整个模式串长度

        for (int i = 0; i < pattern_length - 1; i++) {
            int ascii = pattern[i];  // 当前字符对应的ASCII值
            bad_char_array[ascii] = pattern_length - 1 - i;   // 对应的后移位数，若重复则以最右边为准
        }

        return bad_char_array;
    }

    /**
     * @description  非真正意义上的好字符规则表，后移位数还加上了当前好后缀的最大长度
     * @author  xxliao
     * @date  2024/5/31 16:30
     */
    private static int[] buildGoodSuffix(char[] pattern) {
        int pattern_length = pattern.length;
        int[] good_char_array = new int[pattern_length];   // 记录好后缀出现时后移位数
        int last_prefix_pos = pattern_length;   // 好后缀的首字符位置

        for (int i = pattern_length - 1; i >= 0; i--) {
            // 判断当前位置（不含）之后是否是好后缀，空字符也是好后缀
            if (isPrefix(pattern, i + 1)) {
                last_prefix_pos = i + 1;
            }
            // 如果是好后缀，则good_char_array=pLen，否则依次为pLen+1、pLen+2、...
            good_char_array[pattern_length - 1 - i] = last_prefix_pos - i + pattern_length - 1;
        }

        // 上面在比较好后缀时，是从模式串的首字符开始的，但实际上好后缀可能出现在模式串中间。
        // 比如模式串EXAMPXA，假设主串指针在比较P时发现是坏字符，那么XA就是好后缀，
        // 虽然它的首字符X与模式串的首字符E并不相等。此时suffixLen=2表示将主串指针后移至模式串末尾，
        // pLen-1-i=4表示真正的好字符规则，同样主串指针后移，使得模式串前面的XA对齐主串的XA
        for (int i = 0; i < pattern_length - 1; i++) {
            int suffixLen = suffixLength(pattern, i);
            good_char_array[suffixLen] = pattern_length - 1 - i + suffixLen;
        }

        return good_char_array;
    }

    /**
     * @description  判断是否是好后缀，即模式串begin（含）之后的子串是否匹配模式串的前缀
     * @author  xxliao
     * @date  2024/5/31 16:30
     */
    private static boolean isPrefix(char[] pattern, int begin) {
        for (int i = begin, j = 0; i < pattern.length; i++, j++) {
            if (pattern[i] != pattern[j]) {
                return false;
            }
        }

        return true;
    }

    /**
     * @description  返回模式串中以pattern[begin]（含）结尾的后缀子串的最大长度
     * @author  xxliao
     * @date  2024/5/31 16:30
     */
    private static int suffixLength(char[] pattern, int begin) {
        int suffixLen = 0;

        int i = begin;
        int j = pattern.length - 1;
        while (i >= 0 && pattern[i] == pattern[j]) {
            suffixLen++;
            i--;
            j--;
        }
        return suffixLen;
    }
}
