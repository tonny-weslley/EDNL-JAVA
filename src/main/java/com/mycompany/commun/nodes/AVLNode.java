package com.mycompany.commun.nodes;

public class AVLNode extends BSTNode {
    private int height;

    public AVLNode(int key, Object value) {
        super(key, value);
        this.height = 1;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}