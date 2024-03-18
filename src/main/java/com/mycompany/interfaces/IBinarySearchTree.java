package com.mycompany.interfaces;
import com.mycompany.commun.nodes.BSTNode;

public interface IBinarySearchTree {
    public void insert(int key, Object value);
    public void delete(int key);
    public BSTNode search(int key);
    public void inOrder();
    public void preOrder();
    public void postOrder();
}
