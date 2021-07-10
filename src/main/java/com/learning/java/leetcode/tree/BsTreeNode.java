package com.learning.java.leetcode.tree;

public class BsTreeNode {
    int nodeValue;

    BsTreeNode left;
    BsTreeNode right;

    BsTreeNode parent;

    public BsTreeNode(int value) {
        this.nodeValue = value;
    }

    public BsTreeNode() {}

    @Override
    public String toString() {
        return String.valueOf(this.nodeValue);
    }

    public int compareTo(BsTreeNode bsTreeNode) {
        return this.nodeValue - bsTreeNode.nodeValue;
    }
}
