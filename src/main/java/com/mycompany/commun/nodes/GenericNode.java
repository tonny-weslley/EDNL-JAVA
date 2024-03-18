//generic node that will be used to implement BST, AVL and RBTree nodes

package com.mycompany.commun.nodes;

public class GenericNode {
    private int key;
    private Object value;
    private GenericNode left;
    private GenericNode right;
    private GenericNode parent;
    
    public GenericNode(int key, Object value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public int getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    public GenericNode getLeft() {
        return left;
    }

    public void setLeft(GenericNode left) {
        this.left = left;
    }

    public GenericNode getRight() {
        return right;
    }

    public void setRight(GenericNode right) {
        this.right = right;
    }

    public GenericNode getParent() {
        return parent;
    }

    public void setParent(GenericNode parent) {
        this.parent = parent;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public boolean hasChildren() {
        return left != null || right != null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public String toString() {
        return "Key: " + key + " Value: " + value;
    }
}