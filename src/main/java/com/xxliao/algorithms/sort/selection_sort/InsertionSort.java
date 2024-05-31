package com.xxliao.algorithms.sort.selection_sort;

/**
 * @author xxliao
 * @description: 选择排序
 * @date 2024/5/30 21:44
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {1,6,2,6,8,3,8,3,9,3,4,6,56,8};
        System.out.print("排序前：");
        printArray(array);
        sort(array);
        System.out.print("排序后：");
        printArray(array);
    }


    /**
     * @description  选择排序
     * @author  xxliao
     * @date  2024/5/30 21:46
     */
    public static void sort(int[] array) {
        // 定义最小值索引
        //保存参与单趟排序的第一个数和最后一个数的下标
        int begin = 0, end = array.length - 1;
        while (begin < end) {
            //保存最大值的下标
            int maxIndex = begin;
            //保存最小值的下标
            int minIndex = begin;
            //找出最大值和最小值的下标
            for (int i = begin; i <= end; ++i) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            //最小值放在序列开头
            int temp = array[minIndex];
            array[minIndex] = array[begin];
            array[begin] = temp;

            //防止最大的数在begin位置被换走
            if (begin == maxIndex)
                maxIndex = minIndex;

            //最大值放在序列结尾
            temp = array[maxIndex];
            array[maxIndex] = array[end];
            array[end] = temp;

            ++begin;
            --end;
        }
    }

    /**
     * @description  打印数组
     * @author  xxliao
     * @date  2024/5/30 21:47
     */
    public static void printArray(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
