package com.xxliao.datastructure.linerar_list.stack.linked_list;

/**
 * @author xxliao
 * @description: 链表实现栈 测试客户端
 * @date 2024/5/28 13:47
 */

public class TestClient {

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(1);
        linkedListStack.push(3);
        linkedListStack.push(5);

        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack.pop());
    }
}
