package dstruc;


public class AvlTree {
    private BTNode root;

    public AvlTree() {
        this.root = null;
    }
    public BTNode getRoot() {
        return root;
    }
    public void setRoot(BTNode root) {
        this.root = root;
    }
    /*
    public void add(int e) {
        setRoot(add(getRoot(), e));
    }
    */
    public void printTree() {
        System.out.println(inOrder(root));
    }
    public void add(int e) {
        // TODO Modified to be an AVL-tree's add Method
        BTNode p = null;
        BTNode c = getRoot();
        while (c != null) {
            p = c;
            if (e < c.getElement()) c = c.getLeftNode();
            else c = c.getRightNode();
        }
        if (p == null) setRoot(new BTNode(e, null, null));
        else if (e < p.getElement()) p.setLeftNode(new BTNode(e, null, null));
        else p.setRightNode(new BTNode(e, null, null));
    }
    public boolean contains(int e) {
        BTNode node = getRoot();
        while (node != null && node.getElement() != e) {
            if (e < node.getElement()) node = node.getLeftNode();
            else node = node.getRightNode();
        }
        if (node == null) return false;
        else return true;
    }
    /*
    public boolean contains(int e) {
        return contains(getRoot(), e);
    }
    */
    //Private Recursive----------------------------------------------------------------
    /*
    private boolean contains(BTNode node , int e) {
        if (node == null) return false;
        else if (node.getElement() == e) return true;
        else if (e < node.getElement()) return contains(node.getLeftNode(), e);
        else return contains(node.getRightNode(), e);
    }
    */
    private String inOrder(BTNode node) {
        if (node == null) return "";
        else {
            String s = inOrder(node.getLeftNode());
            s += node.getElement();
            s += inOrder(node.getRightNode());
            return s;
        }
    }
    /*
    private BTNode add(BTNode node , int e) {
        if (node == null) return new BTNode(e, null, null);
        else if (e < node.getElement()) {
            node.setLeftNode(add(node.getLeftNode(), e));
            return node;
        }
        else {
            node.setRightNode(add(node.getRightNode(), e));
            return node;
        }
    }
    */
}
