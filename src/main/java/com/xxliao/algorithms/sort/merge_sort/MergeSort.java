package com.xxliao.algorithms.sort.merge_sort;

/**
 * @author xxliao
 * @description: 归并排序
 * @date 2024/5/30 21:44
 */
public class MergeSort {

    public static void main(String[] args) {
        // 定义数据
        int[] array = {14,12,15,13,11,16,23,12,14,67,54,11,23};
        // 定义临时存放数据数组
        int[] temp = new int[array.length];
        System.out.print("排序前：");
        printArray(array);
        sort(array,0,array.length-1,temp);
        System.out.print("排序后：");
        printArray(array);
    }


    /**
     * @description  希尔排序
     * @author  xxliao
     * @date  2024/5/30 21:46
     */
    public static void sort(int[] array, int low, int high, int[] temp) {
        if(low < high){//设置递归结束条件
            // 获取中间索引
            int mid = (low + high) / 2;
            // 对左侧序列进行拆分排序
            sort(array,low,mid,temp);
            // 对右边序列进行拆分排序
            sort(array,mid+1,high,temp);
            // 合并两个序列
            merge(array,low,mid,high,temp);
        }
    }

    /**
     * @description  合并两个序列
     * @author  xxliao
     * @date   0:45
     */
    private static void merge(int[] array, int low, int mid, int high, int[] temp) {
        // 定义遍历temp序列的索引指针
        int i = low;
        // 定义左、右序列的开始索引
        int leftStartIndex = low;
        int rightStartIndex = mid + 1;
        // 从两个序列开始索引开始比较，并按大小一次放到temp中
        while(leftStartIndex <= mid && rightStartIndex <= high) {
            if(array[leftStartIndex] < array[rightStartIndex]) {
                // 左边第一个元素 小于 右边同位置的元素，将最小值放入temp中，然后继续向后比较
                temp[i++] = array[leftStartIndex++];
            }else {
                // 右边小于等于左边，将最小值放入temp中，然后继续向后比较
                temp[i++] = array[rightStartIndex++];
            }
        }
        // 左边序列还有剩余
        while(leftStartIndex <= mid)
            temp[i++] = array[leftStartIndex++];
        // 右边序列还有剩余
        while(rightStartIndex <= high)
            temp[i++] = array[rightStartIndex++];
        // 将temp数列中数据 复制到 原数组中
       while(low <= high) {
           array[low] = temp[low];
           low++;
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
