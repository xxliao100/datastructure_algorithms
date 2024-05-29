package com.xxliao.datastructure.tree.twothreefour_tree;

/**
 * @author xxliao
 * @description: 234树节点类,这里为了简便实现，节点类的数据项为Integer数据
 * @date 2024/5/29 0:49
 */

public class Node {

    // 节点子节点数量最多为4
    private static final int CHILD_NODE_COUNT = 4;
    // 节点数据项个数
    private int dataItemCount;
    // 父节点
    private Node parent;
    // 子节点
    private Node[] children = new Node [CHILD_NODE_COUNT];
    // 节点数据项
    private Integer[] dataItems = new Integer [CHILD_NODE_COUNT -1];

    // 构造方法
    public Node() {
        this.dataItemCount = 0;
    }
    // 判断当前节点是否已满
    public boolean isFull() {

        return (dataItemCount == CHILD_NODE_COUNT -1);
    }
    // 获取父节点
    public Node getParent() {

        return parent;
    }

    // 获取指定位置的子节点
    public Node getChild(int childIndex) {

        return children[childIndex];
    }

    // 判断节点是否为叶子节点
    public boolean isLeafNode() {

        return children[0] == null;
    }

    // 获取节点的数据项个数
    public int getDataItemCount() {

        return dataItemCount;
    }

    // 获取指定位置的数据项
    public int getDataItem(int dataItemIndex) {

        return dataItems[dataItemIndex];
    }

    // 连接子节点
    public void connectChild(int childIndex, Node child) {
        if(child != null) {
            children[childIndex] = child;
            child.parent = this;
        }
    }

    // 去掉子节点
    public Node removeNode(int childIndex) {
        Node removeNode = children[childIndex];
        children[childIndex] = null;
        return removeNode;
    }

    // 查找具体数据项在数据项数组中的索引位置
    public int findDataItemIndex(Integer dataItem) {
        for(int i=0; i< CHILD_NODE_COUNT-1; i++) {
            if(dataItems[i] == null) {
                break;
            }else if(dataItems[i].equals(dataItem)) {
                return i;
            }
        }
        return -1;
    }

    //插入数据项
    public int insertItem(Integer newDataItem) {
        dataItemCount ++;
        for(int i=CHILD_NODE_COUNT-2; i>=0; i--) {
            if(dataItems[i] == null) {
                continue;
            }
            if(newDataItem < dataItems[i]) {
                dataItems[i+1] = dataItems[i];
            }else {
                dataItems[i+1] = newDataItem;
                return i+1;
            }
        }
        dataItems[0] = newDataItem;
        return 0;
    }

    //删除大数据项
    public Integer removeDataItem() {
        Integer removeDataItem = dataItems[dataItemCount - 1];
        dataItems[dataItemCount - 1] = null;
        dataItemCount --;
        return removeDataItem;
    }

    // 打印节点
    public void displayNode() {
        for (int i=0; i<dataItemCount; i++)  {
            System.out.println("/" + dataItems[i]);
        }
        System.out.println("/");
    }

}

