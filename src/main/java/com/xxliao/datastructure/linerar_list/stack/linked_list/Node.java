package com.xxliao.datastructure.linerar_list.stack.linked_list;

/**
 * @author xxliao
 * @description: 链表实现栈的节点类
 * @date 2024/5/28 12:31
 */
public class Node {

    //存储数据
    protected Object data;

    //下个节点
    public Node next;

    //构造
    public Node(Object data) {
        this.data = data;
    }

    //toString查看输出
    public String toString() {
        return "Node [data=" + data + ", next=" + next + "]";
    }
}
