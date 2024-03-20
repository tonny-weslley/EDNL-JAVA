package com.mycompany.interfaces;

public interface IBinarySearchTree<T> {
    public void insert(int key, Object value);
    public void delete(int key);
    public T search(int key);
    public void inOrder();
    public void preOrder();
    public void postOrder();
}
