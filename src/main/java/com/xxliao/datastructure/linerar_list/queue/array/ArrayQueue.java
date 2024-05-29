package com.xxliao.datastructure.linerar_list.queue.array;

/**
 * @author xxliao
 * @description: 数组实现队列
 * @date 2024/5/28 14:37
 */

public class ArrayQueue {

    //对头索引
    public int front;
    //队尾索引
    public int rear;
    //队列容量
    public int capacity;
    //容器
    public Object[] array;

    //构造方法，这里暂不验证capacity合法性
    public ArrayQueue(int capacity) {
        front= -1;
        rear = -1;
        this.capacity = capacity;
        array = new Object[capacity];
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == -1;
    }

    //判断队列是否满
    public boolean isFull() {
        //队列中元素个数（队尾索引加1） 取余 容器容量 等于front（-1，0），代表满，
        // rear 和 front 初始的时候 就是 0 % capacity == -1 ,不满
        // 开始工作后，添加元素后，front 变为了 0
        return ((rear+1)%capacity == front);
    }

    //入队
    public void enQueue(Object data) {
        if(isFull()) {
            throw new RuntimeException("Queue is Full!");
        }
        if(isEmpty()) {
            //空队列添加
            array[++front] = data; // front 变为了 1
            rear = front;
        }else {
            //不是第一次添加,数组元素依次向后移动
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
