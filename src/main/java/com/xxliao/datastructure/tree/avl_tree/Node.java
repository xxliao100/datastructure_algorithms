package com.xxliao.datastructure.tree.avl_tree;

/**
 * @author xxliao
 * @description: AVL树的节点类
 * @date 2024/5/28 23:46
 */

public class Node {
    //数据
    public int data;
    //高度，单个node的高度为1，空树高度为-1
    public int height;
    //左子节点
    public Node left;
    //右子节点
    public Node right;

    //构造方法
    public Node(int data) {
        this.data = data;
        this.height= 0;//添加后会自增高度,初始化为0
    }
}
