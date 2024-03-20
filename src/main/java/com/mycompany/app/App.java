/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import com.mycompany.forest.BST.BinarySearchTree;;

public class App {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(10, "A");
        tree.insert(20, "B");
        tree.insert(30, "C");
        tree.insert(40, "D");
        tree.insert(25, "F");
        tree.insert(5, "G");
        tree.insert(50, "U");
        tree.insert(60, "V");
        tree.delete(40);
        System.out.println("Preorder traversal" + " of constructed tree is : ");
        tree.inOrder();
        System.out.println("=======================");
        tree.printTree();
    }
}
