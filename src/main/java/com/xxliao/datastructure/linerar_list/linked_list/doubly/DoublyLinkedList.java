package com.xxliao.datastructure.linerar_list.linked_list.doubly;

/**
 * @author xxliao
 * @description: 双向双端链表的实现类
 * @date 2024/5/28 12:55
 */

public class DoublyLinkedList {
    // 表头节点
    private Node head;
    // 表尾节点
    private Node tail;
    // 链表长度
    private int size;

    // 构造方法,使表头、表尾节点为null
    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return head == null;
    }

    // 从表头添加
    public void addFirst(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            // 空链表，表头表尾都是新结点
            tail = newNode;
        } else {
            // 不是空链表，将新结点添加在first的前驱结点上
            head.pre = newNode;
        }
        // 新结点的后驱结点指向原来的first结点(原来链表表头)，双向指定
        newNode.next = head;
        // 新结点作为表头节点
        head = newNode;
        size++;
    }

    // 从表头删除
    public Object deleteFirst() {
        Node deleteNode = head;
        if (head.next == null) {
            // 只有一个元素，last置为null
            tail = null;
        } else {
            // 将原表头结点的后驱结点（将作为新的表头结点）的前驱结点置为null，
            head.next.pre = null;
        }
        head = head.next;
        size--;
        return deleteNode.data;
    }

    // 从表尾添加
    public void addLast(Object data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            // 空链表，表头表尾都是新结点
            head = newNode;
        } else {
            // 不是空链表，将新结点添加在last的后驱结点上
            tail.next = newNode;
        }
        // 新结点的前驱结点指向原来的last结点(原来链表表尾)
        newNode.pre = tail;
        // 新结点作为表尾节点
        tail = newNode;
        size++;
    }

    // 从表尾删除
    public Object deleteLast() {
        Node deleteNode = tail;
        if (head.next == null) {
            // 只有一个元素，first置为null
            head = null;
        } else {
            // 将原表尾结点的前驱结点（将作为新的表尾结点）的后驱结点置为null，
            tail.pre.next = null;
        }
        tail = tail.pre;
        size--;
        return deleteNode.data;
    }

    // 添加在某元素后面
    public boolean addAfter(Object d, Object data) {
        // 当前节点
        Node current = head;
        while (!d.equals(current.data)) {
            // 不相等，继续查找
            if (current.next == null) {
                // 没有找到
                return false;
            }
        }
        Node newNode = new Node(data);
        if (current == tail) {
            // 表尾添加
            addLast(data);
        } else {
            // 中间添加
            newNode.next = current.next;
            current.next.pre = newNode;
        }
        current.next = newNode;
        newNode.pre = current;
        size++;
        return true;
    }

    //判断链表是否包含某元素
    public boolean contain(Object data) {
        //当前节点
        Node current = head;
        if(data == null) {
            // 遍历，查找是否有元素相同存在
            while(current.next != null) {
                if(current.data == null) {
                    return true;
                }
            }
        }else {
            // 遍历，查找是否有元素相同存在
            while(current.next != null) {
                if(data.equals(current.data)) {
                    return true;
                }
            }
        }
        return false;
    }
}
