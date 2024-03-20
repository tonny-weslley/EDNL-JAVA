package com.mycompany.forest.AVL;
import com.mycompany.commun.nodes.AVLNode;
import com.mycompany.forest.BST.BinarySearchTree;

public class AVLTree extends BinarySearchTree {

    private AVLNode root;

    public AVLTree() {
        super();
    }

    @Override
    public void insert(int key, Object value) {
        AVLNode newNode = new AVLNode(key, value);

        if (root == null) {
            root = newNode;
        } else {
            AVLNode current = root;
            AVLNode parent;
            while (true) {
                parent = current;
                if (key < current.getKey()) {
                    current = (AVLNode) current.getLeft();
                    if (current == null) {
                        newNode.setParent(parent);
                        parent.setLeft(newNode);
                        break;
                    }
                } else {
                    current = (AVLNode) current.getRight();
                    if (current == null) {
                        newNode.setParent(parent);
                        parent.setRight(newNode);
                        break;
                    }
                }
            }
            updateBF(newNode);
        }
    }

    @Override
    public void delete(int key) {
        AVLNode current = (AVLNode) search(key);

        if (current == null) return;

        if (current.isLeaf()) {
            if (current == root) {
                root = null;
            } else {
                if (current.getParent().getLeft() == current) {
                    current.getParent().setLeft(null);
                } else {
                    current.getParent().setRight(null);
                }
            }
        } else {
            if (current.hasLeft() && current.hasRight()) {
                AVLNode sucessor = (AVLNode) getMin(current.getRight());
                current.setKey(sucessor.getKey());
                current.setValue(sucessor.getValue());
                if (sucessor.getParent().getLeft() == sucessor) {
                    sucessor.getParent().setLeft(sucessor.getRight());
                } else {
                    sucessor.getParent().setRight(sucessor.getRight());
                }
                if (sucessor.getRight() != null) {
                    ((AVLNode) sucessor.getRight()).setParent(sucessor.getParent());
                }
                updateBF(sucessor);
            } else {
                if (current.hasLeft()) {
                    if (current == root) {
                        root = (AVLNode) current.getLeft();
                    } else {
                        if (current.getParent().getLeft() == current) {
                            current.getParent().setLeft(current.getLeft());
                        } else {
                            current.getParent().setRight(current.getLeft());
                        }
                        ((AVLNode) current.getLeft()).setParent(current.getParent());
                    }
                    updateBF(current);
                } else {
                    if (current == root) {
                        root = (AVLNode) current.getRight();
                    } else {
                        if (current.getParent().getLeft() == current) {
                            current.getParent().setLeft(current.getRight());
                        } else {
                            current.getParent().setRight(current.getRight());
                        }
                        ((AVLNode) current.getRight()).setParent(current.getParent());
                    }
                    updateBF(current);
                }
            }
        }
    }

    private void updateBF(AVLNode node) {
        while(true){
            AVLNode parent = (AVLNode) node.getParent();
            if(parent == null) return;
            if(node == parent.getLeft()){
                parent.setBF(parent.getBF() + 1);
            }else{
                parent.setBF(parent.getBF() - 1);
            }
            if(parent.getBF() == 0) return;
            if(parent.getBF() == 1 || parent.getBF() == -1){
                node = parent;
            }else{
                if(parent.getBF() == 2 || parent.getBF() == -2){
                    balance(parent);
                    return;
                }
            }
        }
    }

    private void balance(AVLNode node){
        if(node.getBF() == 2){
            if(((AVLNode) node.getRight()).getBF() == 1){
                rotateLeft(node);
            }else{
                rotateRight((AVLNode) node.getRight());
                rotateLeft(node);
            }
        }else{
            if(((AVLNode) node.getLeft()).getBF() == -1){
                rotateRight(node);
            }else{
                rotateLeft((AVLNode) node.getLeft());
                rotateRight(node);
            }
        }
    }

    private void rotateLeft(AVLNode node){
        AVLNode parent = (AVLNode) node.getParent();
        AVLNode right = (AVLNode) node.getRight();
        AVLNode rightLeft = (AVLNode) right.getLeft();

        if(parent != null){
            if(parent.getLeft() == node){
                parent.setLeft(right);
            }else{
                parent.setRight(right);
            }
        }else{
            root = right;
        }

        right.setParent(parent);
        right.setLeft(node);
        node.setParent(right);
        node.setRight(rightLeft);
        if(rightLeft != null){
            rightLeft.setParent(node);
        }
    }

    private void rotateRight(AVLNode node){
        AVLNode parent = (AVLNode) node.getParent();
        AVLNode left = (AVLNode) node.getLeft();
        AVLNode leftRight = (AVLNode) left.getRight();

        if(parent != null){
            if(parent.getLeft() == node){
                parent.setLeft(left);
            }else{
                parent.setRight(left);
            }
        }else{
            root = left;
        }

        left.setParent(parent);
        left.setRight(node);
        node.setParent(left);
        node.setLeft(leftRight);
        if(leftRight != null){
            leftRight.setParent(node);
        }
    }

}
