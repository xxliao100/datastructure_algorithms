package com.xxliao.datastructure.linerar_list.array;

import javax.sql.XADataSource;

/**
 * @author xxliao
 * @description: 数据结构 - 线性表 - array
 *
 数组是（Array）是 有限个相同类型 的变量所组成的 有序 集合，数组中的每一个变量为称为元素。数组是最简单、最常用的数据结构。

 数组是用一组 连续的内存空间 来存储一组具有 相同类型 的数据。
 *
 * @date 2024/5/27 22:50
 */
public class Array {

    // 定义数组
    int[] array = new int[10];

    // 定义计数器
    int count = 0;

    // 初始化，填充0-4空间的值
    public Array() {
        array[0] = 3;
        array[1] = 1;
        array[2] = 2;
        array[3] = 5;
        array[4] = 4;
        count = 5;
    }

    /**
     * @description  根据索引获取元组的值
     * @author  xxliao
     * @date  2024/5/28 11:35
     */
    public int get(int index) {
        return array[index];
    }

    /**
     * @description  修改元素
      index: 索引
      value: 值
     * @author  xxliao
     * @date  2024/5/28 11:36
     */
    public void update(int index, int value) {
        array[index] = value;
    }

    /**
     * @description  从数组尾部添加
     * @author  xxliao
     * @date  2024/5/28 11:38
     */
    public void insertTail(int value) {
        if(count >= array.length) { //判断是否扩容
            resize();
        }
        array[count++] = value;
    }

    /**
     * @description  从中间添加
     * @author  xxliao
     * @date  2024/5/28 11:42
     */
    public void insertMiddle(int index, int value) {
        if(count >= array.length) { // 判断是否扩容
            resize();
        }
        for (int i = array.length-1; i >= index; i--) {
            // 从尾部开始遍历，看是否有值，有值就移动。
            if (array[i] != 0) {
                array[i+1]=array[i];
            }
        }
        array[index]=value;
        count++;
    }

    /**
     * @description  扩容，增加一倍空间
     * @author  xxliao
     * @date  2024/5/28 11:45
     */
    public void resize(){
        int[] numsNew=new int[array.length*2];
        System.arraycopy(array,0,numsNew,0,array.length);
        array=numsNew;
    }

    /**
     * @description  删除元素，并移动
     * @author  xxliao
     * @date  2024/5/28 11:47
     */
    public void deleteMiddle(int index){
        for(int i=index+1;i<array.length;i++){
            array[i-1] = array[i];
        }
        count--;
    }

    /**
     * @description  遍历数组
     * @author  xxliao
     * @date  2024/5/28 11:48
     */
    public void display() {
        for (int value : array) {
            System.out.print(value+" ");
        }
        System.out.println("=====================");
    }

    /**
     * @description  遍历数组
     * @author  xxliao
     * @date  2024/5/28 11:48
     */
    public void display2() {
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i]+" ");
        }
        System.out.println("=====================");
    }

}
