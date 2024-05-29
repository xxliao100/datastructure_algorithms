package com.xxliao.datastructure.linerar_list.stack.array;

/**
 * @author xxliao
 * @description: 简单数组实现栈
 * @date 2024/5/28 13:34
 */

public class ArrayStack {

    //栈顶
    private int top;

    //栈深度
    private int capacity;

    //容器数组
    private int[] array;

    //构造方法
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.array = new int[capacity];
    }

    //判断栈是否为空
    public boolean isEmpty (){
        return top == -1;
    }

    //判断是否满栈
    public boolean isFull() {
        return top == capacity -1;
    }

    //向栈中添加数据
    public void push(int data) {
        if(isFull()) {
            System.out.println("Stack is full, Can't push");
        }else {
            array[++top] = data;
        }
    }

    //查看并返回栈顶数据
    public int pop() {
        if(isEmpty()) {
            throw new RuntimeException("Stack is empty, Can't pop");
        }else {
            return array[top--];
        }
    }

    //清空栈
    public void clear() {
        top = -1;
    }
}
