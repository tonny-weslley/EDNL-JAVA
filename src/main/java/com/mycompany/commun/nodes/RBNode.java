package com.mycompany.commun.nodes;

public class RBNode extends BSTNode{
    private boolean red;


    public RBNode(int key, Object value) {
        super(key, value);
        red = true;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public void flipColor() {
        red = !red;
    }

}
