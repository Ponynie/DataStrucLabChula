package lab;
import datastr.*;
//Q1
public class Main {
    public static void main(String[] args) throws Exception {
        BST tree = new BST();
        tree.add(8);
        tree.add(4);
        tree.add(7);
        tree.add(40);
        tree.add(15);
        tree.add(13);
        tree.add(13);
        System.out.println(tree.getMax());
        tree.remove(tree.getMax());
        System.out.println(tree.getMax());
        tree.printTree();
    }
}