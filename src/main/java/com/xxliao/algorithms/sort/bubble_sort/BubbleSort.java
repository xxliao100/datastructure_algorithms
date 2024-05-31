package com.xxliao.algorithms.sort.bubble_sort;

import java.util.Arrays;

/**
 * @author xxliao
 * @description: 冒泡排序（bubble sort）
 *
 * 冒泡排序是一种基础的交换排序，该算法中每个元素都可以像小气泡一样，根据自身大小，一点一点地向着数组地一侧移动。
 *
 * 具体算法：冒泡排序是将相邻地元素两两比较，当一个元素大于右侧相邻元素时，交换它们地位置，当一个元素小于或等于右侧相邻元素时，位置不表
 *
 * @date 2024/5/30 11:11
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        sortOptimize(array);
    }

    /**
     * @description  冒泡排序
     * @author  xxliao
     * @date  2024/5/30 11:15
     */
    public static void sort(int[] array) {
        for (int i = 0; i <array.length - 1; i++) {
            for(int j=0;j<array.length - 1 - i;j++) {
                int temp = 0;// 临时变量 用于交换
                if(array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        Arrays.stream(array).forEach(System.out::print);
    }

    /**
     * @description  冒泡排序 - 带标识位
     * @author  xxliao
     * @date  2024/5/30 11:15
     */
    public static void sortOptimize(int[] array) {
        for (int i = 0; i <array.length - 1; i++) {
            boolean flag = true;
            for(int j=0;j<array.length - 1 - i;j++) {
                int temp = 0;// 临时变量 用于交换
                if(array[j] > array[j+1]) {
                    flag = false; //需要交换，flag改为false
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if(flag) { //已经排序好
                break;
            }
        }
        Arrays.stream(array).forEach(System.out::print);
    }

}
