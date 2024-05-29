package com.xxliao.datastructure.linerar_list.queue.array;

/**
 * @author xxliao
 * @description: 动态数组实现队列 测试客户端
 * @date 2024/5/28 14:52
 */

public class DynamicArrayQueueTestClient {

    public static void main(String[] args) {
        //创建队列，默认容量10
        DynamicArrayQueue arrayQueue = new DynamicArrayQueue();
        //一次添加1~17
        for (int i = 1; i <= 17; i++) {
            arrayQueue.enQueue(i);
        }
        for (int i = 1; i <= 17; i++) {
            System.out.print(arrayQueue.deQueue()+"    ");
        }
    }
}
