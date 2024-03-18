package com.mycompany.commun.nodes;

public class AVLNode {
    private int key;
    private Object value;
    private AVLNode left;
    private AVLNode right;
    private int height;

    public AVLNode(int key, Object value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    // Getters and setters

    public int getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public AVLNode getLeft() {
        return left;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public AVLNode getRight() {
        return right;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public int balanceFactor() {
        int leftHeight = left != null ? left.getHeight() : 0;
        int rightHeight = right != null ? right.getHeight() : 0;
        return leftHeight - rightHeight;
    }
}
