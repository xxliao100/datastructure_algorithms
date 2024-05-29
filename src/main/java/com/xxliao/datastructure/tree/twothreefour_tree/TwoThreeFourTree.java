package com.xxliao.datastructure.tree.twothreefour_tree;

/**
 * @author xxliao
 * @description: 234树实现类
 * @date 2024/5/29 0:51
 */

public class TwoThreeFourTree {
    
    // 根节点
    private Node root = new Node();

    // 利用当前节点和数据项的值,查找写一个子节点
    public Node getNextChild(Node currentNode, Integer nowDataItem) {
        // 获取当前节点的数据项个数
        int dataItemCount = currentNode.getDataItemCount();
        // 遍历比较
        for (int j = 0; j < dataItemCount; j++) {
            if (nowDataItem < currentNode.getDataItem(j)) {
                // 数据项比当前节点数据项比较,小于的话,返回左侧的子节点
                return currentNode.getChild(j);
            }
        }
        // 传入数据项值比当前节点数据项都大,返回最右侧子节点
        return currentNode.getChild(dataItemCount - 1);
    }

    // 判断否数据项是否存在
    public boolean isExist(Integer dataItem) {
        Node currentNode = root;
        while (true) {
            if (currentNode.findDataItemIndex(dataItem) != -1)
                // 在当前节点找到该数据项,返回索引
                return true;
            else if (currentNode.isLeafNode())
                return false;
            else
                currentNode = getNextChild(currentNode, dataItem);
        }
    }

    // 插入一个数据项
    public void add(Integer dataItem) {
        Node currentNode = root;
        while (true) {
            if (currentNode.isFull()) {
                // 当前节点满了,分裂当前节点
                split(currentNode);
                currentNode = currentNode.getParent();
                currentNode = getNextChild(currentNode, dataItem);
            } else if (currentNode.isLeafNode())
                break;
            else
                currentNode = getNextChild(currentNode, dataItem);
        }
        currentNode.insertItem(dataItem);
    }

    // 分裂节点
    public void split(Node currentNode) {
        // 定义从左到右 第二个数据项 和 第三个数据项
        Integer item, rightItem;
        // 定义父节点 ,以及最右侧两个子节点
        Node parent, child3, child4;
        int itemIndex;
        // 记录当前节点第三个数据项,并删除
        rightItem = currentNode.removeDataItem();
        // 记录当前节点第二个数据项,并删除
        item = currentNode.removeDataItem();
        // 记录当前节点第三个子节点,并删除
        child3 = currentNode.removeNode(2);
        // 记录当前节点第四个子节点,并删除
        child4 = currentNode.removeNode(3);
        // 创建分裂节点兄弟节点
        Node brotherNode = new Node();
        // 分裂节点的最大数据项作为兄弟节点的数据下个
        brotherNode.insertItem(rightItem);
        // 分裂节点的第三个和第四个子节点作为兄弟节点的子节点
        brotherNode.connectChild(0, child3);
        brotherNode.connectChild(1, child4);
        // 开始分裂
        if (currentNode == root) {
            // 根节点分裂情况,创建新的根节点,原根节点作为新根节点的子节点,并记录分裂节点的父节点
            root = new Node();
            parent = root;
            root.connectChild(0, currentNode);
        } else {
            // 记录分裂节点的父节点
            parent = currentNode.getParent();
        }
        // 将要分裂节点的的中间数据项插入到父节点中 并且获取到插入的索引
        itemIndex = parent.insertItem(item);
        // 获取父节点中数据项的个数
        int dataItemCount = parent.getDataItemCount();
        // 循环根据
        for (int j = dataItemCount - 1; j > itemIndex; j--) { //
            Node temp = parent.removeNode(j); // 父节点和要拆分的接待你断开连接
            parent.connectChild(j + 1, temp); // 父节点和要拆分的原节点重新连接 位置为原要拆分节点的中间的数据项在父节点中位置的左边
        }
        parent.connectChild(itemIndex + 1, brotherNode); // 然后在原要拆分节点新的位置的右边插入新的右边节点
    }

    // 打印一整棵树
    public void displayTree() {
        recDisplayTree(root, 0, 0);
    }

    // 打印树 传入要从那个节开始打 从那层开始的 哪个节点开始的 前序遍历
    private void recDisplayTree(Node thisNode, int level, int childNumber) {
        System.out.print("level=" + level + " child=" + childNumber + " "); // 先打印当前节点的状况
        thisNode.displayNode();

        int dataItemCount = thisNode.getDataItemCount();
        for (int j = 0; j < dataItemCount + 1; j++) { // 遍历每一个子节点并打印 递归
            Node nextNode = thisNode.getChild(j);
            if (nextNode != null) // 如果
                recDisplayTree(nextNode, level + 1, j); // 向下层递归
            else
                return; // 递归结束
        }
    }
}


