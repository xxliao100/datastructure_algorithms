package com.xxliao.algorithms.sort.count_sort;

/**
 * @author xxliao
 * @description: 计数排序
 * @date 2024/5/30 21:12
 */
public class CountSort {

    public static void main(String[] args) {
        int[] scores = {95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        for (int n : countSort(scores, 90)) {
            System.out.print(n + " ");
        }
    }

    /**
     * @description  计数排序
     * array : 待排序数组
     * offset : 数组起始数 -- 为了节约数据空间
     * @author  xxliao
     * @date  2024/5/30 21:13
     */
    public static int[] countSort(int[] array, int offset) {
        // 创建累计数组
        int[] nums = new int[array.length];
        // 遍历待排序数组，将各个元素的进行出现次数标记到累计数组中
        for(int i = 0; i < array.length; i++) {
            int n = array[i] - offset;
            nums[n]++;//累计数组中改索引的值加1
        }
        // 定义最终结果数组
        int[] result = new int[array.length];
        // 定义最终结果数组添加数据索引指针
        int resultIndex = 0;
        //遍历累计数组，填充最终结果数组
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) { //有值
                for(int j = 0; j < nums[i]; j++) {
                    result[resultIndex++] = i + offset;
                }

            }
        }
        return result;
    }
}
