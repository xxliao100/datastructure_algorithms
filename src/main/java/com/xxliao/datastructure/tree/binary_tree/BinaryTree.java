package com.xxliao.datastructure.tree.binary_tree;

/**
 * @author xxliao
 * @description: 二叉树的实现 以二叉搜索树为例
 * @date 2024/5/28 23:01
 */

public class BinaryTree {

    //根节点
    private Node root;

    //元素个数
    private int size;

    //构造方法
    public BinaryTree() {
        root = null;
        size = 0;
    }

    //判断是否为空
    public boolean isEmpty() {
        return root == null;
    }

    //获取根节点
    public Node getRoot() {
        return root;
    }

    /**
     * 添加数据
     * 插入的数据会成为新的叶子节点，然后我们需要遍历查找具体要插入的位置，
     * 以及记录插入位置的父节点，用于利用父节点的leftChildNode或者rightChildNode将新节点关联到书中。
     */
    public boolean add(int data) {
        //添加节点
        Node newNode = new Node(data);
        if(root == null) {
            //根节点为空，插入节点直接为root，插入成功
            root = newNode;
            size++;
            return true;
        }else {
            //记录当前节点
            Node current = root;
            //记录当前节点的父节点
            Node parent = null;
            //遍历查找
            while(current != null) {
                parent = current;
                if(data < current.data) {
                    //小于当前节点，继续从左子节点查找
                    current = current.leftChildNode;
                    if(current == null) {
                        //当前节点为空，则该为NULL的位置就是新节点要插入的位置
                        parent.leftChildNode = newNode;
                        size++;
                        return true;
                    }
                }else if(data > current.data){
                    //大于当前节点，继续从右子节点查找
                    current = current.rightChildNode;
                    if(current == null) {
                        //当前节点为空，则该为NULL的位置就是新节点要插入的位置
                        parent.rightChildNode = newNode;
                        size++;
                        return true;
                    }
                }else {
                    //该插入数在树中已经存在，暂不考虑
                    System.out.println("Can't add:"+data);
                }
            }
            return false;
        }
    }

    //删除数据
    public boolean remove(int data) {
        if(isEmpty()) {
            throw new RuntimeException("Tree is empty,Can't remove!");
        }
        //记录当前节点，就是要删除的节点
        Node current = root;
        //记录当前节点的父节点
        Node parent = null;
        //标记删除节点是否是父节点的左子节点
        boolean isLeftChild = false;

        //遍历查找要删除的节点current
        while(current.data != data) {
            parent = current;
            if(data< current.data) {
                //小于，继续从左子节点查找
                isLeftChild = true;
                current = current.leftChildNode;
            }else {
                //大于，继续从右子节点查找
                isLeftChild = false;
                current = current.rightChildNode;
            }
            if(current == null) {
                //没有查找到
                return false;
            }
        }

        if(current.leftChildNode == null && current.rightChildNode == null) {
            //删除节点为叶子节点
            if(current == root) {
                //删除节点为根节点
                root = null;
            }else if(isLeftChild) {
                //删除节点为父节点的左子节点
                parent.leftChildNode = null;
            }else {
                //删除节点为父节点的右子节点
                parent.rightChildNode = null;
            }
        }else if(current.leftChildNode != null && current.rightChildNode == null) {
            //删除节点只有一个左子节点
            if(current == root) {
                //删除节点为根节点
                root = null;
            }else if(isLeftChild) {
                //删除节点为父节点的左子节点
                parent.leftChildNode = current.leftChildNode;
            }else {
                //删除节点为父节点的右子节点
                parent.rightChildNode = current.leftChildNode;
            }
        }else if(current.leftChildNode == null && current.rightChildNode != null) {
            //删除节点只有一个子节点，右子节点
            if(current == root) {
                //删除节点为根节点
                root = current.rightChildNode;
            }else if(isLeftChild) {
                //删除节点为父节点的左子节点
                parent.leftChildNode = current.rightChildNode;
            }else {
                //删除节点为父节点的右子节点
                parent.rightChildNode = current.rightChildNode;
            }
        }else {
            //删除节点存在两个子节点，找出替代节点
            Node successor = getSuccessor(current);
            if(current == root) {
                //删除节点是根节点，根节点等于体检节点
                root = successor;
            }else if(isLeftChild) {
                //删除节点是父节点的左子节点
                parent.leftChildNode = successor;
            }else {
                //删除节点是父节点的右子节点
                parent.rightChildNode = successor;
            }
        }
        return true;
    }

    //找出当前节点的替代节点
    private Node getSuccessor(Node deleteNode) {
        // 替代节点
        Node successor = deleteNode;
        // 替代节点的父节
        Node successorParent = deleteNode;
        // 遍历时的当前节点
        Node current = deleteNode.rightChildNode; // 从右子树找出右子树最小值
        //遍历
        while(current != null) {
            //替代节点的父节点向下移动，变成替代节点
            successorParent = successor;
            //替代节点向下移动，变成当前节点
            successor = current;
            //当前节点向左子节点遍历（找出最小值替换）
            current = current.leftChildNode;
        }
        //后继节点不是删除节点的右子节点，将后继节点替换删除节点
        if(successor != deleteNode.rightChildNode){
            successorParent.leftChildNode= successor.rightChildNode;
            successor.rightChildNode = deleteNode.rightChildNode;
        }
        return successor;
    }

    //前序遍历
    public void preOrder(Node current){
        if(current != null){
            //根节点
            System.out.print(current.data+" ");
            //左子树遍历
            preOrder(current.leftChildNode);
            //右子树遍历
            preOrder(current.rightChildNode);
        }
    }

    //中序遍历
    public void infixOrder(Node current){
        if(current != null){
            //左子树遍历
            infixOrder(current.leftChildNode);
            //根节点
            System.out.print(current.data+" ");
            //右子树遍历
            infixOrder(current.rightChildNode);
        }
    }

    //后序遍历
    public void postOrder(Node current){
        if(current != null){
            //左子树遍历
            postOrder(current.leftChildNode);
            //右子树遍历
            postOrder(current.rightChildNode);
            //根节点
            System.out.print(current.data+" ");
        }
    }


}
