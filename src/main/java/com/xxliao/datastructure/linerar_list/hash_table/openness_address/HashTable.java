package com.xxliao.datastructure.linerar_list.hash_table.openness_address;

/**
 * @author xxliao
 * @description: 线性探测 实现哈希表
 * @date 2024/5/28 18:34
 */
public class HashTable {

    // hash数组
    private Integer[] array;

    // 数组容量
    private int capacity;
    // 数组中元素个数
    private int size;

    /** 构造函数*/
    public HashTable(int capacity) {
        array = new Integer[capacity];
        this.capacity = capacity;
    }

    /** 对数据项进行hash化,为了简单:对容量取余*/
    public int hash(Integer value) {

        return value % capacity;
    }

    /** 判断是否满了*/
    public boolean isFull() {

        return (size == capacity);
    }

    /** 判断是否为空*/
    public boolean isEmpty() {

        return (size == 0);
    }

    /** 添加数据*/
    public void insert(Integer value) {
        if(isFull()) {
            System.out.println("Table is full,Expansion");
            expansion();
        }
        int key = hash(value);
        while(array[key] != null) {
            // 指针下移
            key++;
            // 对key重新取余,防止key大于容量情况出现
            key = key % capacity;
        }
        array[key] = value;
        size++;
    }

    /** 删除数据*/
    public boolean remove(Integer value) {
        if(isEmpty()) {
            System.out.println("Table is Empty,Can't remove");
            return false;
        }
        int key = hash(value);
        while(array[key] != null) {
            if(array[key] == value) {
                //找到删除项
                array[key] = null;
                size--;
                return true;
            }
            key++;
            key = key % capacity;
        }
        return false;
    }

    /** 查找数据,判断是否存在*/
    public boolean find(Integer value) {
        if(isEmpty()) {
            System.out.println("Table is Empty");
            return false;
        }
        int key = hash(value);
        while(array[key] != null) {
            if(array[key] == value) {
                return true;
            }
            key++;
            key = key % capacity;
        }
        return false;
    }

    /** 数组扩容,原数据放入新数组时重新进行Hash计算*/
    private void expansion() {
        //  记录原数据
        Integer [] oldArray = array;
        //  数据个数清零
        size = 0;
        //  扩容
        capacity = capacity +  (capacity >> 1);
        array = new Integer[capacity];
        // 迁移原数据
        for(int i=0; i<oldArray.length; i++) {
            insert(oldArray[i]);
        }

    }

    /** 打印数据数据*/
    public void print(){
        System.out.print("Table:");
        for(int j = 0 ; j < capacity ; j++){
            if(array[j] != null){
                System.out.print(array[j] + " ");
            }else{
                System.out.print("** ");
            }
        }
        System.out.println();
    }
}