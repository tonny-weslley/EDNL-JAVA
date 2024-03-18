package com.mycompany.BST;
import com.mycompany.commun.nodes.BSTNode;
import com.mycompany.interfaces.IBinarySearchTree;
import com.mycompany.commun.nodes.BSTNode;


public class BinarySearchTree implements IBinarySearchTree {
    private BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(int key, Object value) {
        BSTNode newNode = new BSTNode(key, value);
        if (root == null) {
            root = newNode;
        } else {
            BSTNode current = root;
            BSTNode parent;
            while (true) {
                parent = current;
                if (key < current.getKey()) {
                    current = current.getLeft();
                    if (current == null) {
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private BSTNode deleteRec(BSTNode root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.getKey()) {
            root.setLeft(deleteRec(root.getLeft(), key));
        } else if (key > root.getKey()) {
            root.setRight(deleteRec(root.getRight(), key));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            root.setKey(minValue(root.getRight()));
            root.setRight(deleteRec(root.getRight(), root.getKey()));
        }
        return root;
    }

    private int minValue(BSTNode root) {
        int minValue = root.getKey();
        while (root.getLeft() != null) {
            minValue = root.getLeft().getKey();
            root = root.getLeft();
        }
        return minValue;
    }

    public BSTNode search(int key) {
        BSTNode current = root;
        while (current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode root) {
        if (root != null) {
            inOrderRec(root.getLeft());
            System.out.println(root.getKey());
            inOrderRec(root.getRight());
        }
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(BSTNode root) {
        if (root != null) {
            System.out.println(root.getKey());
            preOrderRec(root.getLeft());
            preOrderRec(root.getRight());
        }
    }

    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(BSTNode root) {
        if (root != null) {
            postOrderRec(root.getLeft());
            postOrderRec(root.getRight());
            System.out.println(root.getKey());
        }
    }

    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

}
