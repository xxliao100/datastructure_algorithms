package com.xxliao.datastructure.linerar_list.queue.linked_list;

/**
 * @author xxliao
 * @description: 链表实现队列
 * @date 2024/5/28 14:56
 */

public class LinkedListQueue {

    //对头索引
    public Node front;
    //队尾索引
    public Node rear;
    //队列元素数量
    public int size;

    //构造方法
    public LinkedListQueue() {
        front= null;
        rear = null;
        size = 0;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return front == null;
    }

    //入队
    public void enQueue(Object data) {
        Node newNode = new Node(data);
        if(isEmpty()) {
            //空队列添加
            front = rear = newNode;
        }else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    //出队
    public Object deQueue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is Empty!");
        }
        Object result = front.data;

        if(front.next == null) {
            //只有一个元素
            front = rear = null;
        }else {
            front = front.next;
        }
        size--;
        return result;
    }

    //获取元素个数
    public int size() {
        return size;
    }
}
