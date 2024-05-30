package com.xxliao.algorithms.binary_search.demo;

/**
 * @author xxliao
 * @description: 在一个有序集合中，查找某数是否存在 -- 基础实现
 * @date 2024/5/30 0:40
 */
public class Demo01 {

    public static void main(String[] args) {
        //有序数组
        int[] nums = {3, 12, 24, 31, 46, 48, 52, 66, 69, 79, 82};
        System.out.println(binarySearch(nums,66));
        System.out.println(binarySearch(nums,55));
    }

    /**
     * @description  二分法基础实现
     * @author  xxliao
     * @date  2024/5/30 0:47
     */
    public static int binarySearch(int[] array,int destNum) {
        // 低索引
        int low = 0;
        // 高索引
        int high = array.length -1;
        // 中间索引
        int mid = 0;
        while(low<=high) {
            mid = (low + high) / 2;
            if(array[mid] == destNum) {
                return mid; //相等，找到该索引
            }else if(destNum < array[mid]){
                high = mid - 1; // 比中间值小，
            }else{
                low = mid + 1; // 比中间值大
            }
        }
        return -1;
    }
}
