package com.xxliao.datastructure.tree.read_black_tree;

/**
 * @author xxliao
 * @description: 红黑树实现类
 * @date 2024/5/29 0:43
 */
public class RedBlackTree {

    // 根节点
    public Node root;
    // 元素个数
    public int size;

    // 构造方法
    public RedBlackTree() {
        root = null;
        size = 0;
    }

    // 判断是否为空
    public boolean isEmpty() {
        return (root == null);
    }
    // 获取元素个数
    public int size() {
        return size;
    }
    // 获取根节点
    public Node getRoot() {
        return root;
    }
    // 获取节点颜色
    private static boolean colorOf(Node p) {
        return (p == null ? Node.BLACK : p.color);
    }
    // 获取节点父节点
    private static Node parentOf(Node p) {
        return (p == null ? null : p.parent);
    }
    // 设置节点颜色
    private static void setColor(Node p, boolean c) {
        if (p != null)
            p.color = c;
    }
    // 获取节点左子节点
    private static Node leftOf(Node p) {
        return (p == null) ? null : p.left;
    }
    // 获取节点右子节点
    private static Node rightOf(Node p) {
        return (p == null) ? null : p.right;
    }

    // 添加操作
    public boolean put(int data) {
        // 定义当前节点,初始等于root
        Node current = root;
        if (root == null) {
            // 新增节点作为根节点,新节点都是红色节点
            root = new Node(data, null);
            root.color = Node.BLACK;
            size++;
            return true;
        }
        // 定义父节点,初始等于current
        Node parent = current;
        while (current != null) {
            if (data < current.data) {
                // 小于,继续左子树查找
                parent = current;
                current = leftOf(current);
            } else if (data > current.data) {
                // 大于,继续右子树查找
                parent = current;
                current = rightOf(current);
            } else {
                // 数据在树中已经存在
                System.out.println(data + "已经存在,无需重复添加!");
            }
        }
        // 创建新节点,新节点与父节点关联
        Node newNode = new Node(data, parent);
        // 父节点与新节点关联
        if (data < parent.data) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
        // 调整树平衡
        fixAfterInsertion(newNode);
        size++;
        return true;
    }

    // 新增后调整红黑树平衡
    private void fixAfterInsertion(Node newNode) {
        // 新增节点颜色默认为红色
        // 新增时,只有新增节点的父节点为红色,才需要调整,并且新增节点不是根节点
        while (newNode != null && newNode != root && colorOf(parentOf(newNode)) == Node.RED) {
            if (parentOf(newNode) == leftOf(parentOf(parentOf(newNode)))) {
                // 新增节点的父节点是祖父节点的左子节点
                // 获取叔叔节点
                Node s = rightOf(parentOf(parentOf(newNode)));
                if (colorOf(s) == Node.RED) {
                    // 叔叔节点为红色,满足父节点红色,叔叔节点红色,祖父节点黑色情况,
                    // 将父节点以及兄弟节点变为黑色,祖父节点变为红色
                    setColor(parentOf(newNode), Node.BLACK);
                    setColor(s, Node.BLACK);
                    setColor(parentOf(parentOf(newNode)), Node.RED);
                    // 祖父节点作为新增节点,继续向上回溯
                    newNode = parentOf(parentOf(newNode));
                } else {
                    // 叔叔节点为黑色
                    if (newNode == rightOf(parentOf(newNode))) {
                        // 新增节点是父节点的右子节点,也就是LR情况,需要先旋转为LL情况
                        newNode = parentOf(newNode);
                        // 注意这里是新增节点的父节点左旋,然后newNode变量就会变成LL情况下的新增节点
                        rotateLeft(newNode);
                    }
                    // 新增节点是父节点的左子节点,也就是LL情况,右旋祖父节点,父节点和祖父节点颜色交换
                    setColor(parentOf(newNode), Node.BLACK);
                    setColor(parentOf(parentOf(newNode)), Node.RED);
                    rotateRight(parentOf(parentOf(newNode)));
                }
            } else {
                // 新增节点的父节点是祖父节点的右子节点
                // 获取叔叔节点
                Node s = rightOf(parentOf(parentOf(newNode)));
                if (colorOf(s) == Node.RED) {
                    // 叔叔节点是红色,父节点是红色,新增节点是红色
                    setColor(parentOf(newNode), Node.BLACK);
                    setColor(s, Node.BLACK);
                    setColor(parentOf(parentOf(newNode)), Node.RED);
                    // 祖父节点作为新增节点,继续向上回溯
                    newNode = parentOf(parentOf(newNode));
                } else {
                    // 叔叔节点是黑色
                    if (newNode == leftOf(parentOf(newNode))) {
                        // 新增节点为父节点的左子节点.满足RL情况,先旋转为RR情况
                        newNode = parentOf(newNode);
                        // 注意这里是新增节点的父节点左旋,然后newNode变量就会变成RR情况下的新增节点
                        rotateRight(newNode);
                    }
                    // 满足RR情况,将父节点设置为黑色,祖父节点设置为红色,然后祖父节点左旋
                    setColor(parentOf(newNode), Node.BLACK);
                    setColor(parentOf(parentOf(newNode)), Node.RED);
                    rotateLeft(parentOf(parentOf(newNode)));
                }
            }
        }
        root.color = Node.BLACK;
    }

    // 删除操作
    public boolean remove(int data) {
        if (root == null) {
            // 空树
            return false;
        }
        // 查找删除数据节点
        Node deleteNode = root;
        while (deleteNode.data != data) {
            if (data < deleteNode.data) {
                // 小于,继续左子树查找
                deleteNode = deleteNode.left;
            } else if (data > deleteNode.data) {
                // 大于,继续右子树查找
                deleteNode = deleteNode.right;
            }
            if (deleteNode == null) {
                // 不存在删除数据的节点
                return false;
            }
        }
        // 找到节点,开始删除，后面删除的结构就变成了 叶子节点了
        if (deleteNode.left != null && deleteNode.right != null) {
            // 删除节点存在左右子节点,找出替代节点,数据替换,然后删除节点为替换节点
            Node temp = successor(deleteNode);
            deleteNode.data = temp.data;
            deleteNode = temp;
        }
        // 到达这里的删除节点要么为叶子节点,要么为只有一个子节点的节点，两个节点都有的上面if已经替换过了
        if (deleteNode == root) {
            // 删除节点为根节点
            root = null;
            return true;
        }
        // 定义删除后,上移位置的子节点
        Node replaceNode = (deleteNode.left != null ? deleteNode.left : deleteNode.right);
        if (replaceNode == null) {
            // 删除节点为叶子节点
            if (deleteNode.color == Node.BLACK) {
                // 叶子节点为黑色,旋转变换
                fixAfterDeletion(deleteNode);
            }
            if (deleteNode.parent != null) {
                // 删除叶子节点，存在父节点
                if (deleteNode == deleteNode.parent.left) {
                    // 删除节点为父节点的左子节点
                    deleteNode.parent.left = null;
                } else {
                    // 删除节点为父节点的右子节点
                    deleteNode.parent.right = null;
                }
            }
        } else {
            // 删除节点为只有一个子节点的节点，黑+黑，红+黑不存在，只有黑+红存在（因为这里删除的是替换后的叶子节点，根据红黑树特性，只有黑+红），
            // 直接删除黑色节点，然后红色节点上移补充黑色节点位置，然后将颜色变为黑色
            replaceNode.parent = deleteNode.parent;
            if (deleteNode.parent == null) {
                // 是否为根节点判断
                root = replaceNode;
            } else if (deleteNode == deleteNode.parent.left) {
                // 删除节点为父节点的左子节点
                deleteNode.parent.left = replaceNode;
            } else {
                // 删除节点为父节点的右子节点
                deleteNode.parent.right = replaceNode;
            }
            deleteNode.left = deleteNode.right = deleteNode.parent = null;

            /*
             * if (deleteNode.color == Node.BLACK) //黑+
             * 红，红色节点替换黑色节点后，颜色变换,在执行fixAfterDeletion时不会进入while循环，只是设置颜色
             * fixAfterDeletion(replaceNode);
             */
            replaceNode.color = Node.BLACK;
        }
        return true;
    }

    // 删除前调整红黑树
    private void fixAfterDeletion(Node deleteNode) {
        // 删除节点为红色节点时,直接删除,不需要调整平衡
        while (deleteNode != root && deleteNode.color == Node.BLACK) {
            if (deleteNode == leftOf(leftOf(parentOf(deleteNode)))) {
                // 删除节点为父节点的左子节点
                // 获取兄弟节点
                Node s = rightOf(parentOf(deleteNode));
                if (colorOf(s) == Node.RED) {
                    // 兄弟节点是红色，那么父亲节点为黑色，远近侄子节点均为黑色，兄弟节点颜色互换，父节点左旋
                    setColor(s, Node.BLACK);
                    setColor(parentOf(deleteNode), Node.RED);
                    rotateLeft(deleteNode.parent);
                    // 新的兄弟节点变为新父节点的柚子节点
                    s = rightOf(parentOf(deleteNode));
                }
                // 执行到这里代表，删除节点为黑色，兄弟节点为黑色

                if (colorOf(leftOf(s)) == Node.BLACK && colorOf(rightOf(s)) == Node.BLACK) {
                    // 删除节点的两个子节点均为黑色，将兄弟节点设置为红色
                    setColor(s, Node.RED);
                    deleteNode = parentOf(deleteNode);
                } else {
                    if (colorOf(leftOf(s)) == Node.RED) {
                        // 近侄子节点为红色，先将近侄子节点与兄弟节点颜色互换，然后兄弟节点右旋，转化为远子节点为红色情况。
                        setColor(leftOf(s), Node.BLACK);
                        setColor(s, Node.RED);
                        rotateRight(s);
                        // 记录新的兄弟节点
                        s = rightOf(parentOf(deleteNode));
                    }
                    // 执行到这里为远侄子节点为红色情况，父节点颜色与星弟节点互换，远侄子节点变为黑色，然后父节点左旋
                    setColor(s, colorOf(parentOf(deleteNode)));
                    setColor(parentOf(deleteNode), Node.BLACK);
                    setColor(rightOf(s), Node.BLACK);
                    rotateLeft(deleteNode.parent);
                    // 树已经平衡，这里等于root是为了保证root的颜色，因为近远侄子节点为红色时，不为父节点的颜色
                    deleteNode = root;
                }
            } else {
                // 删除节点为父节点的右子节点
                // 获取兄弟节点
                Node s = leftOf(parentOf(deleteNode));
                if (colorOf(s) == Node.RED) {
                    // 兄弟节点为红色，父结点与兄弟节点颜色互换，然后父结点右旋
                    setColor(s, Node.BLACK);
                    setColor(parentOf(deleteNode), Node.RED);
                    rotateRight(deleteNode.parent);
                    // 记录新的兄弟节点
                    s = leftOf(parentOf(deleteNode));
                }

                // 到达这里代表兄弟节点为黑色
                if (colorOf(leftOf(s)) == Node.BLACK && colorOf(rightOf(s)) == Node.BLACK) {
                    // 删除节点的两个子节点均为黑色，将兄弟节点设置为红色
                    setColor(s, Node.RED);
                    deleteNode = parentOf(deleteNode);
                } else {
                    if (colorOf(rightOf(s)) == Node.RED) {
                        // 近侄子节点为红色，兄弟节点与近侄子节点颜色互换，然后兄弟节点左旋，变成远侄子节点为红色情况
                        setColor(s, Node.RED);
                        setColor(rightOf(s), Node.BLACK);
                        rotateLeft(s);
                        // 记录新的兄弟节点
                        s = leftOf(parentOf(deleteNode));
                    }
                    // 到达这里为远侄子节点为红色情况
                    // 父节点与兄弟节点颜色互换，然后远侄子节点变为红色，父节点右旋
                    setColor(s, colorOf(parentOf(deleteNode)));
                    setColor(parentOf(deleteNode), Node.BLACK);
                    setColor(leftOf(s), Node.BLACK);
                    rotateRight(deleteNode.parent);
                    // 树已经平衡，这里等于root是为了保证root的颜色，因为近远侄子节点为红色时，不为父节点的颜色
                    deleteNode = root;
                }
            }
        }
        deleteNode.color = Node.BLACK;
    }

    // 找出删除节点的替代节点
    private Node successor(Node d) {
        if (d == null) {
            return null;
        } else if (d.right != null) {
            // 删除节点存在右子节点,找出右子树中最左侧节点(最小值)代替
            Node p = d.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {
            // 删除节点只有左子节点,找出左子树中最右侧节点(最大值)代替
            Node p = d.parent;
            Node ch = d;
            while (p != null && ch == p.right) {
                ch = p;
                p = p.parent;
            }
            return p;
        }
    }

    // 节点左旋：以节点的右子节点为轴，进行左旋
    private void rotateLeft(Node p) {
        if (p != null) {
            // 记录节点的右子节点
            Node s = p.right;
            // 右子节点的左节点 换到 旋转节点的 右子节点
            p.right = s.left;

            if (s.left != null)// 右子节点有左子节点（不为空，上面已经成p的右子节点了），指定父节点为p节点
                s.left.parent = p;
            // 替换节点 顶替 旋转节点，指定替换节点的新父类
            s.parent = p.parent;
            if (p.parent == null)
                // 旋转节点是否为根节点判断
                root = s;
            else if (p.parent.left == p)
                // 旋转节点为父节点的左子节点,父节点的左子节点绑定为旋转节点的原右子节点
                p.parent.left = s;
            else
                // 旋转节点为父节点的右子节点,父节点的右子节点绑定为旋转节点的原右子节点
                p.parent.right = s;
            // r与P绑定
            s.left = p;
            p.parent = s;
        }
    }

    // 节点右旋 ,以节点的左子节点为轴，进行右旋
    private void rotateRight(Node p) {
        if (p != null) {
            // 记录旋转节点的左子节点，替换节点
            Node l = p.left;
            // 左子节点的右子节点 换到 旋转节点的左子节点
            p.left = l.right;
            if (l.right != null)
                // 旋转节点原左子节点的右子节点存在，与旋转节点绑定
                l.right.parent = p;
            // 旋转节点原左子节点替换旋转节点
            l.parent = p.parent;
            if (p.parent == null)
                // 旋转节点是为根节点判断
                root = l;
            else if (p.parent.right == p)
                // 旋转节点为父节点的右子节点，父节点右子节点指向新的l节点
                p.parent.right = l;
            else
                // 旋转节点为父节点的左子节点，父节点左子节点指向新的l节点
                p.parent.left = l;
            // l和p相互绑定
            l.right = p;
            p.parent = l;
        }
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

