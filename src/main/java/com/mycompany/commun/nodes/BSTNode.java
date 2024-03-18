package com.mycompany.commun.nodes;

public class BSTNode {
    private int key;
    private Object value;
    private BSTNode left;
    private BSTNode right;

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

    public void setValue(Object value) {
        this.value = value;
    }


}
