package com.mycompany.interfaces;
import com.mycompany.commun.nodes.AVLNode;

public interface IAVLTree {
    public void insert(int key, Object value);
    public void delete(int key);
    public AVLNode search(int key);
    public void inOrder();
    public void preOrder();
    public void postOrder();
}
