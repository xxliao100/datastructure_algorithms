package com.xxliao.datastructure.linerar_list.stack.array;

/**
 * @author xxliao
 * @description: 动态数组实现栈 测试客户端
 * @date 2024/5/28 13:56
 */

public class DynamicArrayStackTestClient {
    public static void main(String[] args) {
        DynamicArrayStack arrayStack = new DynamicArrayStack();
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(510);
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(510);
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(510);
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(510);
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(510);
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(510);
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        arrayStack.push(510);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}
