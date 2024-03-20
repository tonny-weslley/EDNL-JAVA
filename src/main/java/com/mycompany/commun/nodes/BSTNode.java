package com.mycompany.commun.nodes;

public class BSTNode {
    private int key;
    private Object value;
    private BSTNode left;
    private BSTNode right;
    private BSTNode parent;

    public BSTNode(int key, Object value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Getters and setters

    public int getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public BSTNode getLeft() {
        return left;
    }

    public BSTNode getParent() {
        return parent;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

}
