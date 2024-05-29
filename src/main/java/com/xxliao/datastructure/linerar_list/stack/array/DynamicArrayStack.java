package com.xxliao.datastructure.linerar_list.stack.array;

/**
 * @author xxliao
 * @description: 动态数组实现栈 -可以扩容
 * @date 2024/5/28 13:38
 */

public class DynamicArrayStack {

    //栈顶
    private int top;

    //栈深
    private int capacity;

    //默认深度
    private final int DEFAULT_CAPACITY = 16;

    //容器数组
    private int[] array;

    //构造方法
    public DynamicArrayStack() {
        top = -1;
        capacity = DEFAULT_CAPACITY;
        array = new int [capacity];
    }

    //判断是否为空
    public boolean isEmpty() {
        return top == -1;
    }

    //判断是否满栈
    public boolean isFull() {
        return top == capacity -1;
    }

    //添加
    public void push(int data) {
        if(isFull()) {
            //满栈,扩容
            enStack();
        }
        array[++top] = data;
    }

    //栈扩容方法
    public void enStack() {
        int newCapacity  = capacity + (capacity >> 1);
        int[] newArray = new int [newCapacity];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity = newCapacity;
        array = newArray;
    }

    //返回栈顶数据
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty,Can't pop");
        }
        return array[top--];
    }

    //清空栈
    public void clear() {
        top = -1;
    }
}