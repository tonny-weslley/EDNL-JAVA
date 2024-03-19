package com.mycompany.commun.nodes;

public class AVLNode extends BSTNode{
    private int BF;

    public AVLNode(int key, Object value) {
        super(key, value);
        BF = 0;
    }

    public int getBF() {
        return BF;
    }

    public void setBF(int BF) {
        this.BF = BF;
    }
}
