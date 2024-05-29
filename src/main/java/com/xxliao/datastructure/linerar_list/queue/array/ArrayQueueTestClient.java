package com.xxliao.datastructure.linerar_list.queue.array;

/**
 * @author xxliao
 * @description: 数组实现队列 测试客户端
 * @date 2024/5/28 14:38
 */

public class ArrayQueueTestClient {

    public static void main(String[] args) {
        //创建队列
        ArrayQueue arrayQueue = new ArrayQueue(5);
        //一次添加1~5,
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        arrayQueue.enQueue(4);
        arrayQueue.enQueue(5);
        //arrayQueue.enQueue(6);
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        //System.out.println(arrayQueue.deQueue());
    }

}
