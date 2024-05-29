package com.xxliao.datastructure.tree.binary_tree;

/**
 * @author xxliao
 * @description: 二叉树的节点类
 * @date 2024/5/28 23:00
 */
public class Node {

    // 数据项
    public int data;

    // 左子节点
    public Node leftChildNode;

    // 右子节点
    public Node rightChildNode;

    // 构造方法
    public Node(int data) {
        this.data = data;
        leftChildNode = null;
        rightChildNode = null;
    }

    // 查看节点数据
    @Override
    public String toString() {
        return "BinaryTreeNode [data=" + data + "]";
    }
}
