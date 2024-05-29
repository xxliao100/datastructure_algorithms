package com.xxliao.datastructure.linerar_list.linked_list.doubly_end;

/**
 * @author xxliao
 * @description: 双端链表节点类
 * @date 2024/5/28 12:46
 */
public class Node {

    //存储数据
    public Object data;

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
