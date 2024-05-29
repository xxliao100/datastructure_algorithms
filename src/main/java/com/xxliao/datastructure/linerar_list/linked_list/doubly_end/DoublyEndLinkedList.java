package com.xxliao.datastructure.linerar_list.linked_list.doubly_end;

/**
 * @author xxliao
 * @description: 双端链表实现类
 * @date 2024/5/28 12:47
 */

public class DoublyEndLinkedList {

    //表头节点
    private Node head;
    //表尾节点
    private Node tail;
    //链表长度
    private int size;

    //构造,使表头节点为null
    public DoublyEndLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    //是否为空,判断表头是否为空
    public boolean isEmpty() {
        return head == null;
    }

    //在开始位置添加
    public void addFirst(Object data) {
        //创建新节点
        Node addNode = new Node(data);
        //使新节点的next指向链表的表头
        addNode.next = head;
        //表头指向新节点
        head = addNode;
        //长度加1
        size++;
    }

    //从表头开始删除
    public Object deleteFirst() {
        if(isEmpty()) {
            return null;
        }
        Node temp = head;
        head = head.next;
        size--;
        return temp.data;
    }

    //在末尾位置添加
    public void addLast(Object data) {
        Node addNode = new Node(data);
        if(isEmpty()) {
            //空链表，first，last均为addNode
            head = addNode;
        }else {
            tail.next = addNode;
        }
        //最末节点指向新节点
        tail = addNode;
        size++;
    }

    //查看链表的所有元素
    public void display() {
        //当前节点
        Node current = head;
        //循环找出最末节点
        while(current.next != null) {
            System.out.println(current.toString());
            current = current.next;
        }
    }

    //判断某元素是否在链表中
    public boolean contain(Object data) {
        //当前节点
        Node current = head;
        if(data == null) {
            //循环找出最末节点
            while(current.next != null) {
                if(current.data == null) {
                    return true;
                }
                current = current.next;
            }
        }else {
            //循环找出最末节点
            while(current.next != null) {
                if(data.equals(current.data)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }
}
