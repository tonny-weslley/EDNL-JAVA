package com.mycompany.forest.BST;
import com.mycompany.commun.nodes.BSTNode;
import com.mycompany.interfaces.IBinarySearchTree;


public class BinarySearchTree implements IBinarySearchTree<BSTNode> {
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
                        newNode.setParent(parent);
                        parent.setLeft(newNode);
                        return;
                    }
                } else {
                    current = current.getRight();
                    if (current == null) {
                        newNode.setParent(parent);
                        parent.setRight(newNode);
                        return;
                    }
                }
            }
        }
    }


    public void delete(int key){
        BSTNode current = search(key);

        if(current == null) return;


        if(current.isLeaf()){
            if (current == root){
                root = null;
            }else{
                if(current.getParent().getLeft() == current){
                    current.getParent().setLeft(null);
                }else{
                    current.getParent().setRight(null);
                }
            }
        }else{
            if(current.hasLeft() && current.hasRight()){
                BSTNode sucessor = this.getMin(current.getRight());

                if(sucessor.hasRight()){
                    sucessor.getParent().setLeft(sucessor.getRight());
                }else{
                    sucessor.getParent().setLeft(null);
                }
            }else{
                if(current.hasLeft()){
                    if(current == root){
                        root = current.getLeft();
                    }else{
                        if(current.getParent().getLeft() == current){
                            current.getParent().setLeft(current.getLeft());
                        }else{
                            current.getParent().setRight(current.getLeft());
                        }
                    }
                }else{
                    if(current == root){
                        root = current.getRight();
                    }else{
                        if(current.getParent().getLeft() == current){
                            current.getParent().setLeft(current.getRight());
                        }else{
                            current.getParent().setRight(current.getRight());
                        }
                    }
                }
            }
        }

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

    protected BSTNode getMin(BSTNode node){
        if(!node.hasLeft()){
            return node;
        }else{
            return getMin(node.getLeft());
        }
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
