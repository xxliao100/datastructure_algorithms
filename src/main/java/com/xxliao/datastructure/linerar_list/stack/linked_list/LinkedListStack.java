package com.xxliao.datastructure.linerar_list.stack.linked_list;

import java.util.EmptyStackException;

/**
 * @author xxliao
 * @description: 用单向链表实现栈
 * @date 2024/5/28 13:41
 */

public class LinkedListStack {

    //链表表头（栈顶）
    private Node top;

    //构造方法
    public LinkedListStack() {
        this.top = null;
    }

    //判断栈是否为空
    public boolean isEmpty (){
        return top == null;
    }

    //压栈
    public void push(Object data) {
        // 添加节点
        Node newNode = new Node(data);
        if(top == null) {
            //空栈，first直接赋值
            top = newNode;
        }else if(top.data == null) {
            //first元素为null，直接加入栈顶，这里可以根据实际情况处理
            top.data = newNode;
        }else {
            newNode.next = top;
            top = newNode;
        }
    }

    //弹栈
    public Object pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }else {
            Object result = top.data;
            top = top.next;
            return result;
        }
    }

    //查看栈顶元素
    public Object top() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }else {
            return top.data;
        }
    }

    //清空栈
    public void clear() {
        top = null;
    }
}