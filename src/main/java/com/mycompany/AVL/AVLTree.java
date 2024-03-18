package com.mycompany.AVL;
import com.mycompany.commun.nodes.AVLNode;
import com.mycompany.interfaces.IAVLTree;

public class AVLTree implements IAVLTree{
    
    private AVLNode root;
    private int height(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return N.getHeight();
    }
    

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public AVLTree() {
        this.root = null;
    }
    

    public void insert(int key, Object element) {
        this.root = insertRec(this.root, key);
    }

    private AVLNode insertRec(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key, null);
        }
        if (key < node.getKey()) {
            node.setLeft(insertRec(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(insertRec(node.getRight(), key));
        } else {
            return node;
        }
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));
        balance(node);
        return node;
    }

    public void delete(int key) {
        this.root = deleteRec(this.root, key);
    }

    private AVLNode deleteRec(AVLNode node, int key) {
        if (node == null) {
            return node;
        }
        if (key < node.getKey()) {
            node.setLeft(deleteRec(node.getLeft(), key));
        } else if (key > node.getKey()) {
            node.setRight(deleteRec(node.getRight(), key));
        } else {
            if ((node.getLeft() == null) || (node.getRight() == null)) {
                AVLNode temp = null;
                if (temp == node.getLeft()) {
                    temp = node.getRight();
                } else {
                    temp = node.getLeft();
                }
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                AVLNode temp = minValueNode(node.getRight());
                node.setKey(temp.getKey());
                node.setRight(deleteRec(node.getRight(), temp.getKey()));
            }
        }
        if (node == null) {
            return node;
        }
        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        balance(node);
        return node;
    }

    public AVLNode search(int key) {
        return searchRec(this.root, key);
    }

    private AVLNode searchRec(AVLNode node, int key) {
        if (node == null || node.getKey() == key) {
            return node;
        }
        if (key < node.getKey()) {
            return searchRec(node.getLeft(), key);
        }
        return searchRec(node.getRight(), key);
    }


    private AVLNode minValueNode(AVLNode node) {
        AVLNode current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current;
    }

    public void preOrder() {
        preOrderRec(this.root);
    }

    private void preOrderRec(AVLNode node) {
        if (node != null) {
            System.out.print(node.getKey() + " ");
            preOrderRec(node.getLeft());
            preOrderRec(node.getRight());
        }
    }

    public void inOrder() {
        inOrderRec(this.root);
    }

    private void inOrderRec(AVLNode node) {
        if (node != null) {
            inOrderRec(node.getLeft());
            System.out.print(node.getKey() + " ");
            inOrderRec(node.getRight());
        }
    }

    public void postOrder() {
        postOrderRec(this.root);
    }

    private void postOrderRec(AVLNode node) {
        if (node != null) {
            postOrderRec(node.getLeft());
            postOrderRec(node.getRight());
            System.out.print(node.getKey() + " ");
        }
    }

    public AVLNode getRoot() {
        return this.root;
    }


    // rotations
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.getLeft();
        AVLNode T2 = x.getRight();
        
        x.setRight(y);
        y.setLeft(T2);
        
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        
        return x;
    }

    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.getRight();
        AVLNode T2 = y.getLeft();
        
        y.setLeft(x);
        x.setRight(T2);
        
        x.setHeight(max(height(x.getLeft()), height(x.getRight())) + 1);
        y.setHeight(max(height(y.getLeft()), height(y.getRight())) + 1);
        
        return y;
    }


    private int getBalance(AVLNode N) {
        if (N == null) {
            return 0;
        }
        return height(N.getLeft()) - height(N.getRight());
    }

    private void balance (AVLNode node) {
        int balance = getBalance(node);
        if (balance > 1) {
            if (getBalance(node.getLeft()) < 0) {
                node.setLeft(leftRotate(node.getLeft()));
            }
            node = rightRotate(node);
        } else if (balance < -1) {
            if (getBalance(node.getRight()) > 0) {
                node.setRight(rightRotate(node.getRight()));
            }
            node = leftRotate(node);
        }
    }
    



}
