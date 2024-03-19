/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

package com.mycompany.app;

import com.mycompany.forest.AVL.AVLTree;

public class App {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10, "A");
        tree.insert(20, "B");
        tree.insert(30, "C");
        tree.insert(40, "D");
        tree.insert(50, "E");
        tree.insert(25, "F");
        tree.delete(30);
        System.out.println("Preorder traversal" + " of constructed tree is : ");
        tree.preOrder();

    }
}
