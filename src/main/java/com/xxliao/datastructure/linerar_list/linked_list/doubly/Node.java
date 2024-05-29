package com.xxliao.datastructure.linerar_list.linked_list.doubly;

/**
 * @author xxliao
 * @description: 双向链表的节点类实现
 * @date 2024/5/28 12:54
 */

public class Node {
    //数据
    public Object data;
    //前驱结点
    public Node pre;
    //后驱结点
    public Node next;

    //构造方法
    public Node(Object data) {
        this.data = data;
    }

    //toString
    @Override
    public String toString() {
        return "DLLNode [data=" + data + ", pre=" + pre + ", next=" + next + "]";
    }
}
