package com.xxliao.algorithms.binary_search.demo;

/**
 * @author xxliao
 * @description:
 * 一个有序数组有一个数出现1次，其他数出现2次，找出出现一次的数
 * 比如：1 1 2 2 3 3 4 4 5 5 6 6 7 出现1次的数是7
 *
 * 使用二分查找： 1 有序、 2、时间复杂度 O(logn)
 * 偶数位索引跟后面的比相同，奇数位索引跟前面的比相同 则说明前面的都对
 * 偶数位索引跟前面的比相同，奇数位索引跟后面的比相同 则说明后面的都对
 *
 * @date 2024/5/30 1:06
 */

public class Demo03 {
    public static void main(String[] args) {
        int[] nums={1,2,2,3,3,4,4,5,5};
        //int[] nums = {1,1, 2, 2, 3, 4, 4, 5, 5,6,6,7,7};
        System.out.println(binarySearch(nums));
    }

    public static int binarySearch(int[] nums) {
        //低位索引
        int low = 0;
        //高位索引
        int high = nums.length - 1;
        //中间索引
        int mid = 0;
        while (low < high) {

            mid = (low + high) / 2;

            if (mid % 2 == 0) {//偶数位

                if (nums[mid] == nums[mid + 1]) {
                    // 与后面的数相等,前面的都对
                    low = mid + 1;
                } else if (nums[mid] == nums[mid - 1]) {
                    // 与前面的数相等,后面的都对
                    high = mid - 1;
                } else {// 就是这个数
                    return nums[mid];
                }
            } else {//奇数位

                if (nums[mid] == nums[mid - 1]) {
                    // 与前面的数相等,前面的都对
                    low = mid + 1;
                } else if (nums[mid] == nums[mid + 1]) {
                    //与后面的数相等,后面的都对
                    high = mid - 1;
                } else { // 就是这个数
                    return nums[mid];
                }
            }
        }
        //low=high
        return nums[low];
    }
}
