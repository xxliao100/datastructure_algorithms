package com.xxliao.algorithms.sort.shell_sort;

/**
 * @author xxliao
 * @description: 希尔排序
 * @date 2024/5/30 21:44
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] array = {1,6,2,6,8,3,8,3,9,3,4,6,56,8};
        System.out.print("排序前：");
        printArray(array);
        sort(array);
        System.out.print("排序后：");
        printArray(array);
    }


    /**
     * @description  希尔排序
     * @author  xxliao
     * @date  2024/5/30 21:46
     */
    public static void sort(int[] array) {
        // 定义gap,初始等于length
        int gap = array.length;
        while(gap > 1) {
            gap = gap / 2;
            // 单次gap排序
            for (int i = 0; i < array.length - gap; i++) {
                int end = i;
                int nextItem = array[end+gap];
                while(end >= 0) {
                    if(array[end] > nextItem) {
                        // 前面的值比后面大,换到后面位置去
                        array[end+gap] = array[end];
                        end = end - gap;// end小于gap时候是退出里层循环，end大于gap的时候是进行下一次的轮询
                    }else {
                        // 前面的值小于等于后面的值，不用替换
                        break;
                    }
                }
                array[end+gap] = nextItem;
            }
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
