package com.mycompany.commun.node;

public class RBNode extends BSTNode {
    private boolean red;

    public RBNode(int key, Object value) {
        super(key, value);
        this.red = true;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }
}
