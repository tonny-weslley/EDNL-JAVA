/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import com.mycompany.BST.BinarySearchTree;

public class App {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(50, "50");
        bst.insert(30, "30");
        bst.insert(20, "20");
        bst.insert(40, "40");
        bst.insert(70, "70");
        bst.insert(60, "60");
        bst.insert(80, "80");
        System.out.println("Inorder traversal");
        bst.inOrder();
        System.out.println("Preorder traversal");
        bst.preOrder();
        System.out.println("Postorder traversal");
        bst.postOrder();
        System.out.println("Search 60");
        System.out.println(bst.search(60).getValue());
        System.out.println("Delete 20");
        bst.delete(20);
    }
}
