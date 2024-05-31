package com.xxliao.algorithms.sort.quick_sort;

import java.util.Arrays;

/**
 * @author xxliao
 * @description: 快速排序 - 双边循环
 * @date 2024/5/30 11:44
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {4,7,3,5,6,2,8,1};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * @description  快速排序 - 双边循环 - 递归
     * @author  xxliao
     * @date  2024/5/30 11:58
     */
    public static void quickSort(int[] array, int start, int end) {
        // 设置递归结束条件
        if(start >= end)
            return;

        // 得到基准元素位置
        int pivotIndex = partition(array,start,end);

        //根据基准元素，分成两部分进行递归排序
        quickSort(array,start,pivotIndex - 1);
        quickSort(array,pivotIndex + 1,end);
    }

    /**
     * @description  分治 双边循环法
     * @author  xxliao
     * @date  2024/5/30 12:01
     */
    private static int partition(int[] array, int start, int end) {
        // 选用第一个位置的元素，作为基准元素
        int pivot = array[start];
        // 记录左右标识点
        int left = start;
        int right = end;

        while(left != right) {
            // 控制right往左移动
            while(left < right && array[right] > pivot) {
                right--;
            }
            // 控制left往右移动
            while (left < right && array[left] <= pivot) {
                left++;
            }
            // 交换left和right元素
            if(left < right) {
                int p = array[left];
                array[left] = array[right];
                array[right] = p;
            }
        }
        // 基准元素 与 指针重合元素交换
        array[start] = array[left];
        array[left] = pivot;
        return left;
    }
}
