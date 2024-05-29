package com.xxliao.datastructure.linerar_list.queue.linked_list;

/**
 * @author xxliao
 * @description: 链表实现队列 测试客户端
 * @date 2024/5/28 14:57
 */

public class LinkedListQueueTextClient {

    public static void main(String[] args) {
        // 创建队列
        LinkedListQueue linkQueue = new LinkedListQueue();
        //一次添加1~25
        for (int i = 1; i <= 25; i++) {
            linkQueue.enQueue(i);
        }
        System.out.println("size is" + linkQueue.size);
        for (int i = 1; i <= 25; i++) {
            System.out.print(linkQueue.deQueue()+"    ");
        }
    }
}
