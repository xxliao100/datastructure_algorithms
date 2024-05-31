package com.xxliao.algorithms.sort.insertion_sort;

/**
 * @author xxliao
 * @description: 插入排序
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
     * @description  插入排序
     * @author  xxliao
     * @date  2024/5/30 21:46
     */
    public static void sort(int[] array) {
        for (int i = 1; i <= array.length - 1; i++) {
            int temp = array[i]; //记录当前值
            int j = i -1; //记录值索引的前一个值，也就是当前值，需要和前面0 ~  i-1 范围的值进行比较。
            while(j >= 0 && array[j] > temp) { //前面的值 比 后面的值大，进行交换
                array[j+1] = array[j]; // 将大的值往后移动一位，原值在temp中
                j--;
            }
            // 找到放置的位置，赋值
            array[j+1] = temp;
            printArray(array);
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
