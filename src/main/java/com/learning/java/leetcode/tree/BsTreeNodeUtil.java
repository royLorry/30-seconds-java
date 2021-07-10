package com.learning.java.leetcode.tree;

import javax.validation.constraints.NotNull;

public class BsTreeNodeUtil {

    public void inOrderPrint(BsTreeNode root) {
        if (root == null) {
            return;
        }

        inOrderPrint(root.left);
        System.out.println(root.toString());
        inOrderPrint(root.right);
    }

    public BsTreeNode searchRecursively(@NotNull BsTreeNode root, int key) {
        if (root.nodeValue > key) {
            return searchRecursively(root.left, key);
        } else if (root.nodeValue < key) {
            return searchRecursively(root.right, key);
        } else {
            return root;
        }
    }

    public boolean insertRecursively(@NotNull BsTreeNode root, @NotNull BsTreeNode nodeInserted) {
        if (root == null) {
            root = nodeInserted;
            return true;
        }

        if (root.compareTo(nodeInserted) > 0) {
            if (root.left == null) {
                root.left = nodeInserted;
                nodeInserted.parent = root;
                return true;
            } else {
                return insertRecursively(root.left, nodeInserted);
            }
        } else if (root.compareTo(nodeInserted) < 0) {
            if (root.right == null) {
                root.right = nodeInserted;
                nodeInserted.parent = root;
                return true;
            } else {
                return insertRecursively(root.right, nodeInserted);
            }
        } else {
            return false;
        }
    }

    public void deleteRecursively(@NotNull BsTreeNode root, int key) {
        if (root.nodeValue > key) {
            deleteRecursively(root.left, key);
        } else if (root.nodeValue < key) {
            deleteRecursively(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                // 左右均为null，直接删除
                if (root.parent != null) {
                    BsTreeNode patent = root.parent;
                    if (patent.left == root) {
                        patent.left = null;
                    }
                    if (patent.right == root) {
                        patent.right = null;
                    }
                }
            } else if (root.right == null) {
                // 只有左子树，左子树直接替换
                BsTreeNode leftNode = root.left;
                root.left = null;
                leftNode.parent = root.parent;
                if (leftNode.parent != null) {
                    if (leftNode.parent.left == root) {
                        leftNode.parent.left = leftNode;
                    }
                    if (leftNode.parent.right == root) {
                        leftNode.parent.right = leftNode;
                    }
                    root.parent = null;
                }
            } else if (root.left == null) {
                // 只有右子树，左子树直接替换
                BsTreeNode rightNode = root.right;
                root.right = null;
                rightNode.parent = root.parent;
                if (rightNode.parent != null) {
                    if (rightNode.parent.left == root) {
                        rightNode.parent.left = rightNode;
                    }
                    if (rightNode.parent.right == root) {
                        rightNode.parent.right = rightNode;
                    }
                    root.parent = null;
                }
            } else {
                // 既有左又有右，找到中序后继节点，替换至当前，再将那个节点删除
                BsTreeNode node = root.left;
                while (node.right != null) {
                    node = node.right;
                }
                root.nodeValue = node.nodeValue;
                deleteRecursively(node, node.nodeValue);
            }
        }
    }


}
