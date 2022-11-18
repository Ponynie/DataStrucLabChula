package datastr;

public class BST {
    private BTNode root;

    public BST(){
        this.root=null;
    }

    /**
     * @return the root
     */
    private BTNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    private void setRoot(BTNode root) {
        this.root = root;
    }

    public void add(int newElement) {
        BTNode r = getRoot();
        BTNode t = null;
        while (r != null) {
            t = r;
            if (newElement < r.getElement()) {
                r = r.getLeft();
            }
            else if (newElement > r.getElement()) {
                r = r.getRight();
            }
            else break;
        }
        if (t == null) {
            setRoot(new BTNode(newElement, null, null));
        }
        else if (newElement < t.getElement()) {
            t.setLeft(new BTNode(newElement, null, null));
        }
        else if (newElement > t.getElement()) {
            t.setRight(new BTNode(newElement, null, null));
        }
    }

    public void printTree(){
        System.out.println(inOrder(getRoot()));
    }
    private String inOrder(BTNode r) {
        if (r == null) return "";
        else {
            String s = inOrder(r.left);
            s = s + r.getElement() + ",";
            s = s + inOrder(r.right);
            return s;
        }
    }

}