package com.xxliao.datastructure.linerar_list.stack.array;

/**
 * @author xxliao
 * @description: 数组实现栈 测试客户端
 * @date 2024/5/28 13:56
 */

public class ArrayStackTestClient {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(3);
        arrayStack.push(5);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
    }
}
