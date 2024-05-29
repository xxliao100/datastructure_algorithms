package com.xxliao.datastructure.tree.avl_tree;

/**
 * @author xxliao
 * @description: AVL树实现类
 * @date 2024/5/28 23:47
 */

public class AVLTree {

    // 记录根节点
    public Node root;
    // 结点个数
    public int size;

    // 构造方法
    public AVLTree() {
        root = null;
        size = 0;
    }

    // 返回树中的节点数量
    public int size() {
        return size;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return root == null;
    }

    // 返回节点的高度
    public int height(Node node) {
        return node == null ? -1 : node.height;
    }

    // 返回根节点
    public Node getRoot() {
        return root;
    }

    /**
     * 四种旋转方式中的LL旋转, 当是节点左子树的左子树节添加节点造成的不平衡,采用LL情况,节点整体右旋
     */
    public Node llRotate(Node node) {
        Node nodeLeft = node.left; // 记录左子节点
        node.left = nodeLeft.right;// 将坐子节点的右节点 给当前节点的左子节点
        nodeLeft.right = node; //
        node.height = Math.max(height(node.right), height(node.left)) + 1;
        nodeLeft.height = Math.max(height(nodeLeft.left), node.height) + 1;
        return nodeLeft;
    }

    /**
     * 四种旋转方式中的RR旋转, 当是节点右子树的右子树节添加节点造成的不平衡,采用RR情况,节点整体左旋
     */
    public Node rrRotate(Node node) {
        Node nodeRight = node.right;
        node.right = nodeRight.left;
        nodeRight.left = node;
        node.height = Math.max(height(node.right), height(node.left)) + 1;
        nodeRight.height = Math.max(height(nodeRight.right), node.height) + 1;
        return nodeRight;
    }

    /**
     * 四种旋转方式中的LR旋转, 当是节点左子树的右子树节添加节点造成的不平衡,采用LR情况,先左子树左旋、然后节点整体右旋
     */
    public Node lrRotate(Node node) {
        node.left = rrRotate(node.left);// 左子树先左旋
        return llRotate(node);// 整体右旋
    }

    /**
     * 四种旋转方式中的RL旋转, 当是节点右子树的左子树节添加节点造成的不平衡,采用RL情况,先左子树右旋、然后节点整体左旋
     */
    public Node rlRotate(Node node) {
        node.right = llRotate(node.right);// 右子树先右旋
        return rrRotate(node);// 整体左旋
    }

    /**
     * 插入数据
     */
    public void insert(int data) {
        root = insert(root, data);
        size++;
    }

    /**
     * 插入数据,私有递归
     */
    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data > node.data) {
            // 插入数据位置在当前节点右子树
            node.right = insert(node.right, data);
            if (height(node.right) - height(node.left) == 2) {
                // node右子树高度比node左子树高度大2,发生不平衡
                if (node.right.data > data) {
                    // 在右子树的左子树上,rl旋转
                    node = rlRotate(node);
                } else {
                    // 在右子树的左子树上,rr旋转
                    node = rrRotate(node);
                }
            }
        } else if (data < node.data) {
            // 插入数据位置在当前节点左子树,继续向当前节点的左子节点添加
            node.left = insert(node.left, data);
            if (height(node.left) - height(node.right) == 2) {
                // node左子树高度比node右子树高度大2,发生不平衡
                if (node.left.data > data) {
                    // 还是在左子树的左子树上,ll旋转
                    node = llRotate(node);
                } else {
                    // 在左子树的右子树上,lr旋转
                    node = lrRotate(node);
                }
            }
        } else {
            // 相等,无需再次添加
            return null;
        }
        // 树高度加1
        node.height = Math.max(height(node.right), height(node.left)) + 1;
        return node;
    }

    /**
     * 删除元素
     */
    public void remove(int data) {
        root = remove(root, data);
        size--;
    }

    /**
     * 删除节点,私有递归
     */
    private Node remove(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data > node.data) {
            // 删除节点在当前节点的右子树上
            node.right = remove(node.right, data);
            if (height(node.left) - height(node.right) == 2) {
                // 从右侧删除,那么左子数高度比右子树高度大2,不平衡,调整(旋转)节点左子树
                Node tempNode = node.left;
                if (height(tempNode.left) > height(tempNode.right)) {
                    // 删除后node的左子树不平衡,并且node左子树的左子树高度比右子树大,LL旋转
                    node = llRotate(node);
                } else {
                    // 删除后node的左子树不平衡,并且node左子树的右子树高度比左子树大,LR旋转
                    node = lrRotate(node);
                }
            }
        } else if (data < node.data) {
            // 删除节点在当前节点的左子树上
            node.left = remove(node.left, data);
            if (height(node.right) - height(node.left) == 2) {
                // 从左侧删除,那么右子树高度比左子树高度大2,不平衡,调整(旋转)节点右子树
                Node tempNode = node.right;
                if (height(tempNode.left) > height(tempNode.right)) {
                    // 删除后node的右子树不平衡,并且node右子树的左子树高度比右子树大,RL旋转
                    node = rlRotate(node);
                } else {
                    // 删除后node的右子树不平衡,并且node右子树的右子树高度比左子树大,RR旋转
                    node = rrRotate(node);
                }
            }
        } else {
            // 相等,找到要删除的元素
            if (node.left == null && node.right == null) {
                // 删除的节点为叶子节点
                node = null;
            } else if (node.left != null && node.right == null) {
                // 删除节点有且只有左子节点,左子节点直接上移成为新的node节点
                node = node.left;
                node.height = Math.max(height(node.left), height(node.left)) + 1;
            } else if (node.left == null && node.right != null) {
                // 删除节点有且只有右子节点,右子节点直接上移成为新的node节点
                node = node.right;
                node.height = Math.max(height(node.left), height(node.left)) + 1;
            } else {
                // 删除节点有左子节点,还有右子节点,这里找出删除左子树最大节点替换,或者右子树最小节点替换,这里选用左子树最大节点
                Node temp = node.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                // 将最大值赋给node节点
                node.data = temp.data;
                // 删除最大值节点
                node.left = remove(node.left, temp.data);
                // 调整删除后的高度
                node.height = Math.max(height(node.left), height(node.left)) + 1;
            }
        }
        size--;
        return node;
    }

    // 前序遍历
    public void preOrder(Node node) {
        if (node != null) {
            // 根节点
            System.out.print(node.data + " ");
            // 左子树遍历
            preOrder(node.left);
            // 右子树遍历
            preOrder(node.right);
        }
    }

    // 中序遍历
    public void infixOrder(Node node) {
        if (node != null) {
            // 左子树遍历
            infixOrder(node.left);
            // 根节点
            System.out.print(node.data + " ");
            // 右子树遍历
            infixOrder(node.right);
        }
    }

    // 后序遍历
    public void postOrder(Node node) {
        if (node != null) {
            // 左子树遍历
            postOrder(node.left);
            // 右子树遍历
            postOrder(node.right);
            // 根节点
            System.out.print(node.data + " ");
        }
    }
}
