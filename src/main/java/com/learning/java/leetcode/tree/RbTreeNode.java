package com.learning.java.leetcode.tree;

public class RbTreeNode {
    // 颜色 黑-true 红-false
    boolean color;

    int nodeValue;

    RbTreeNode left;
    RbTreeNode right;

    RbTreeNode parent;

    public RbTreeNode(boolean color, int nodeValue, RbTreeNode left, RbTreeNode right, RbTreeNode parent) {
        this.color = color;
        this.nodeValue = nodeValue;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return String.valueOf(nodeValue);
    }

    public int compareTo(RbTreeNode rbTreeNode) {
        return this.nodeValue - rbTreeNode.nodeValue;
    }
}
