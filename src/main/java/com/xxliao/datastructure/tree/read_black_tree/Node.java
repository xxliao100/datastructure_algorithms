package com.xxliao.datastructure.tree.read_black_tree;

/**
 * @author xxliao
 * @description: 红黑树节点类实现
 * @date 2024/5/29 0:42
 */
public class Node {
    //存储数据,int方便实现
    public int data;
    //左子节点
    public Node left;
    //右子节点
    public Node right;
    //父节点
    public Node parent;
    //红色,color为true
    public static final boolean RED = true;
    //黑色,color为true
    public static final boolean BLACK = false;
    //颜色初始为黑色,红黑树新增时改为红色
    public boolean color = BLACK;

    //构造方法
    Node(int data, Node parent) {
        this.data = data;
        this.parent = parent;
        left = null;
        right = null;
        color = RED;
    }
}

