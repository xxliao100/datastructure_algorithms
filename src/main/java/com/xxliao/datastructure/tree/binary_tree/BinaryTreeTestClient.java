package com.xxliao.datastructure.tree.binary_tree;

/**
 * @author xxliao
 * @description: 二叉搜索树 测试客户端
 * @date 2024/5/28 23:22
 */

public class BinaryTreeTestClient {

    public static void main(String[] args) {
        //创建树
        BinaryTree binaryTree = new BinaryTree();
        //数据源,无序的1~10
        int[] array = {4,6,1,3,2,7,8,9,5,10};
        //添加数据
        for (int i = 0; i < array.length; i++) {
            binaryTree.add(array[i]);
        }
        //前序遍历
        System.out.print("前序遍历");
        binaryTree.preOrder(binaryTree.getRoot());
        System.out.println();
        //中序遍历
        System.out.print("中序遍历");
        binaryTree.infixOrder(binaryTree.getRoot());
        System.out.println();
        //后序遍历
        System.out.print("后序遍历");
        binaryTree.postOrder(binaryTree.getRoot());
        System.out.println();
        //删除5
        System.out.println("删除5");
        binaryTree.remove(5);
        //前序遍历
        System.out.print("前序遍历");
        binaryTree.preOrder(binaryTree.getRoot());
        System.out.println();
        //中序遍历
        System.out.print("中序遍历");
        binaryTree.infixOrder(binaryTree.getRoot());
        System.out.println();
        //后序遍历
        System.out.print("后序遍历");
        binaryTree.postOrder(binaryTree.getRoot());
        System.out.println();
    }
}
