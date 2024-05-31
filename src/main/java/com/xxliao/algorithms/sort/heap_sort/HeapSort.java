package com.xxliao.algorithms.sort.heap_sort;

import java.util.Arrays;

/**
 * @author xxliao
 * @description: 堆排序
 * @date 2024/5/30 16:49
 */
public class HeapSort {

    public static void main(String []args){
        int[] array = {7,6,4,3,5,2,10,9,8};
        System.out.println("排序前："+ Arrays.toString(array));
        sort(array);
        System.out.println("排序后："+Arrays.toString(array));
    }

    /**
     * @description  堆排序
     * @author  xxliao
     * @date  2024/5/30 16:51
     */
    public static void sort(int[] array) {
        // 把无序数组构建成最大堆
        for(int i = array.length/2-1; i >= 0; i--) {//从 length/2 -1 的位置向上（索引值变小）比较。
            adjustHeap(array,i,array.length);
        }
        // 调整对结构,交换堆顶元素和末尾元素，调整新的堆顶
        for(int i = array.length-1; i > 0; i--){
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            adjustHeap(array, 0, i);
        }
    }


    /**
     * @description  根据传入节点，向下比较自己的子节点是否符合大顶堆规则，不符合就交换。
     * @author  xxliao
     * @date  2024/5/30 17:12
     */
    private static void adjustHeap(int[] array, int parentIndex, int length) {
        // temp 保存父索引值
        int temp = array[parentIndex];
        // 左子节点索引
        int child = 2 * parentIndex + 1;

        while(child < length) {
            if(child+1 < length && array[child] < array[child+1]) {
                // 左子节点小于右子节点，将child指向右子节点。
                child++;
            }
            if(temp >= array[child])
                // 父节点大于等于子节点最大的节点，不用管
                break;
            array[parentIndex] = array[child];
            parentIndex = child;
            child = 2 * child + 1;
        }
        array[parentIndex] = temp;
    }

}
