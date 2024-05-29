package com.xxliao.datastructure.linerar_list.queue.array;

/**
 * @author xxliao
 * @description: 动态数组实现队列
 * @date 2024/5/28 14:50
 */

public class DynamicArrayQueue {
    //对头索引
    public int front;
    //队尾索引
    public int rear;
    //队列容量
    public int capacity;
    //容器
    public Object[] array;
    //默认队列容量为10
    public final int DEFAULT_CAPACITY = 16;

    //构造方法，无参
    public DynamicArrayQueue() {
        front= -1;
        rear = -1;
        capacity = DEFAULT_CAPACITY;
        array = new Object[capacity];
    }

    //构造方法，有参,这里暂不验证capacity合法性
    public DynamicArrayQueue(int capacity) {
        front= -1;
        rear = -1;
        this.capacity = capacity;
        array = new Object[capacity];
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == -1;
    }

    //判断队列是否为空
    private boolean isFull() {
        //队列中元素个数（队尾索引加1） 取余 容器容量 等于 0，代表满
        return ((rear+1)%capacity == front);
    }

    //队列扩容
    private void resizeQueue() {
        capacity = capacity + (capacity >> 1);
        Object[] oldArray = array;
        array = new Object[capacity];
        for (int i = 0; i < oldArray.length; i++) {
            array[i] =  oldArray[i];
        }
    }

    //入队
    public void enQueue(Object data) {
        if(isFull()) {
            //当前队列满对，扩容
            resizeQueue();
        }
        if(isEmpty()) {
            //空队列添加
            array[++front] = data;// front -> 1
            rear = front;
        }else {
            //不是第一次添加,数组元素一次向后移动
            for(int i =rear+1; i>0; i--){
                array[i] = array[i-1];
            }
            array[front] = data;
            rear++;
        }
    }

    //出队
    public Object deQueue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        Object result = array[rear];
        array[rear--] = null;
        return result;
    }
}
