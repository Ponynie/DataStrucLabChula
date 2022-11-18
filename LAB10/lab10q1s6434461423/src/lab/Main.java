package lab;


import datastr.AVLTree;
import datastr.BST;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.add(8);
        tree.add(4);
        tree.add(7);
        tree.add(40);
        tree.add(15);
        tree.add(13);
        tree.add(13);
        tree.printTree();
        tree.remove(40); 
        tree.printTree();
        //----------------------------------------------------------------
        AVLTree treeAVL = new AVLTree();
        BST treeBST = new BST();
        for (int i = 1; i < 8; i++) {
            treeAVL.add(i);
            treeBST.add(i);
        }
        treeAVL.printTreePreOrder();
        treeBST.printTreePreOrder();

    }
}
