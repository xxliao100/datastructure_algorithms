package com.xxliao.datastructure.linerar_list.hash_table.linked_address;

/**
 * @author xxliao
 * @description: 链地址实现哈希表 节点类
 * @date 2024/5/28 18:58
 */
public class Node {

    String key;
    String value;
    // 指向下一个结点
    Node next;

    public Node(String key, String value, Node next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
