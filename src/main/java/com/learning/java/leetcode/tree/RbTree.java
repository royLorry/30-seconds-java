package com.learning.java.leetcode.tree;

public class RbTree {
    RbTreeNode mRoot;
    static final boolean RED = false;
    static final boolean BLACK = true;

    public RbTree() {
        mRoot = null;
    }

    // 获取某个节点的父节点
    public RbTreeNode parentOf(RbTreeNode node) {
        return node != null ? node.parent : null;
    }

    // 获取某个节点的颜色
    public boolean colorOf(RbTreeNode node) {
        return node != null ? node.color : BLACK;
    }

    // 判断是否为红色
    private boolean isRed(RbTreeNode node) {
        return (node != null) && (node.color == RED);
    }

    // 判断是否为黑色
    private boolean isBlack(RbTreeNode node) {
        return !isRed(node);
    }

    private void setRed(RbTreeNode node) {
        node.color = RED;
    }

    private void setBlack(RbTreeNode node) {
        node.color = BLACK;
    }

    private void serParent(RbTreeNode node, RbTreeNode parent) {
        if (node != null) {
            node.parent = parent;
        }
    }

    private void setColor(RbTreeNode node, boolean color) {
        if (node != null) {
            node.color = color;
        }
    }

    // 左旋
    private void leftRoate(RbTreeNode pNode) {
        RbTreeNode vNode = pNode.right;
        RbTreeNode rNode = vNode.left;

        pNode.right = rNode;

        if (rNode != null) {
            rNode.parent = pNode;
        }

        vNode.parent = pNode.parent;

        if (pNode.parent == null) {
            // 本身无父节点，其为根节点
            this.mRoot = vNode;
        } else {
            if (pNode.parent.left == pNode) {
                pNode.parent.left = vNode;
            } else {
                pNode.parent.right = vNode;
            }
        }

        vNode.left = pNode;
        pNode.parent = vNode;
    }

    // 右旋
    private void rightRoate(RbTreeNode pNode) {
        RbTreeNode fNode = pNode.left;
        RbTreeNode kNode = fNode.right;

        pNode.left = kNode;

        if (kNode != null) {
            kNode.parent = pNode;
        }

        fNode.parent = pNode.parent;

        if (pNode.parent == null) {
            // 本身无父节点，其为根节点
            this.mRoot = fNode;
        } else {
            if (pNode.parent.left == pNode) {
                pNode.parent.left = fNode;
            } else {
                pNode.parent.right = fNode;
            }
        }

        fNode.left = pNode;
        pNode.parent = fNode;
    }

    private boolean insertRecursively(RbTreeNode root, RbTreeNode nodeInserted) {
        if (root == null) {
            mRoot = nodeInserted;
            return true;
        }

        if (root.compareTo(nodeInserted) > 0) {
            if (root.left == null) {
                root.left = nodeInserted;
                nodeInserted.parent = root;
                nodeInserted.color = RED;
                // TODO fixup
                return true;
            } else {
                return insertRecursively(root.left, nodeInserted);
            }
        } else if (root.compareTo(nodeInserted) < 0) {
            if (root.right == null) {
                root.right = nodeInserted;
                nodeInserted.parent = root;
                nodeInserted.color = RED;
                // TODO fixup
                return true;
            } else {
                return insertRecursively(root.right, nodeInserted);
            }
        } else {
            return false;
        }
    }

    private void insertFixUp(RbTreeNode currentNode) {
        // <1> 被插入节点是根节点，设为黑色
        if (currentNode == mRoot) {
            setBlack(this.mRoot);
            return;
        }
        // <2> 被插入节点的父节点是黑色，doNothing
        if (currentNode.parent.color == BLACK) {
            return;
        }
        // <3> 被插入节点的父节点是红色
        RbTreeNode parent = parentOf(currentNode);
        RbTreeNode gParent = parentOf(parent);
        if (parent == gParent.left) {
            // <3.1> 父节点是祖父节点的左子节点
            RbTreeNode uncle = gParent.right;
            if (gParent.right != null && isRed(gParent.right)) {
                // <3.1.1> 叔叔结点存在并且为红结点
                /*将P和S设置为黑色（当前插入结点I）将gra设置为红色 把gra设置为当前插入结点*/
                setBlack(parent);
                setBlack(uncle);
                setRed(gParent);
                insertFixUp(gParent);
            } else {
                // <3.1.2> 叔结点不存在或为黑结点，并且插入结点的父亲结点是祖父结点的左子结点
                if (currentNode == parent.left) {
                    // <3.1.2.1> 插入结点是其父结点的左子结点
                    /*将P设为黑色 将gra设为红色 对gra进行右旋*/
                    setBlack(parent);
                    setRed(gParent);
                    rightRoate(gParent);
                } else {
                    // <3.1.2.2> 插入结点是其父结点的右子结点
                    /*对P进行左旋 把P设置为插入结点，得到情景<3.1.2> 进行情景<3.1.2> 的处理*/
                    leftRoate(parent);
                    insertFixUp(parent);
                }

            }
        } else {
            // <3.2> 父节点是祖父节点的右子节点
            RbTreeNode uncle = gParent.left;
            if (gParent.left != null && isRed(gParent.left)) {
                // <3.2.1> 叔叔结点存在并且为红结点+
                /*将P和S设置为黑色（当前插入结点I）将gra设置为红色 把gra设置为当前插入结点*/
                setBlack(parent);
                setBlack(uncle);
                setRed(gParent);
                insertFixUp(gParent);
            } else {
                // <3.2.2> 叔叔结点不存在或为黑结点，并且插入结点的父亲结点是祖父结点的左子结点
                if (currentNode == parent.right) {
                    // <3.2.2.1> 插入结点是其父结点的右子结点
                    /*将P设为黑色 将gra设为红色 对PP进行左旋*/
                    setBlack(parent);
                    setRed(gParent);
                    leftRoate(gParent);
                } else {
                    // <3.2.2.2> 插入结点是其父结点的右子结点
                    /*对P进行右旋 把P设置为插入结点，得到情景<3.2.2> 进行情景<3.2.2>的处理*/
                    rightRoate(parent);
                    insertFixUp(parent);
                }
            }
        }
    }

}
