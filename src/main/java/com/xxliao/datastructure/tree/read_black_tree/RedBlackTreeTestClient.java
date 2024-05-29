package com.xxliao.datastructure.tree.read_black_tree;

import java.util.TreeMap;

/**
 * @author xxliao
 * @description: 红黑树 测试客户端
 * @date 2024/5/29 0:44
 */

public class RedBlackTreeTestClient {

    public static void main(String[] args) {
        // 创建树
        RedBlackTree avlTree = new RedBlackTree();
        // 数据源,无序的1~10
        int[] array = { 4, 6, 1, 3, 2, 7, 8, 9, 5, 10 };
        // 添加数据
        for (int i = 0; i < array.length; i++) {
            avlTree.put(array[i]);
        }
        // 前序遍历
        System.out.print("前序遍历");
        avlTree.preOrder(avlTree.getRoot());
        System.out.println();
        // 中序遍历
        System.out.print("中序遍历");
        avlTree.infixOrder(avlTree.getRoot());
        System.out.println();
        // 后序遍历
        System.out.print("后序遍历");
        avlTree.postOrder(avlTree.getRoot());
        System.out.println();
        // 删除5
        System.out.println("删除5");
        avlTree.remove(5);
        // 前序遍历
        System.out.print("前序遍历");
        avlTree.preOrder(avlTree.getRoot());
        System.out.println();
        // 中序遍历
        System.out.print("中序遍历");
        avlTree.infixOrder(avlTree.getRoot());
        System.out.println();
        // 后序遍历
        System.out.print("后序遍历");
        avlTree.postOrder(avlTree.getRoot());
        System.out.println();
    }
}

