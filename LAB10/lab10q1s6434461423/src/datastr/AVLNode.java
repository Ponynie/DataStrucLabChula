package datastr;

public class AVLNode extends BTNode{
    private int balanceFactor = 0;

    public AVLNode(int element, AVLNode left, AVLNode right) {
        super(element, left, right);
    }

    public void setBF(int bf) {
        balanceFactor = bf;
    }
    public int getBF() {
        return balanceFactor;
    }
    
}
