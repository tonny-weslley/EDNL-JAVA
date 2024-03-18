package com.mycompany.commun.nodes;

public class RBNode {
    private int key;
    private Object value;
    private RBNode left;
    private RBNode right;
    private boolean red;

    public RBNode(int key, Object value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.red = true;
    }

    // Getters and setters

    public int getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public RBNode getLeft() {
        return left;
    }

    public void setLeft(RBNode left) {
        this.left = left;
    }

    public RBNode getRight() {
        return right;
    }

    public void setRight(RBNode right) {
        this.right = right;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean isBlack() {
        return !red;
    }

    public void makeRed() {
        red = true;
    }

    public void makeBlack() {
        red = false;
    }


}
