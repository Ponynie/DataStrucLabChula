package dstruc;

public class BTNode {
    private int element;
    private BTNode leftNode;
    private BTNode rightNode;

    public BTNode(int element, BTNode leftNode, BTNode rightNode) {
        this.element = element;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getElement() {
        return element;
    }
    public void setElement(int element) {
        this.element = element;
    }
    public BTNode getLeftNode() {
        return leftNode;
    }
    public void setLeftNode(BTNode left) {
        this.leftNode = left;
    }
    public BTNode getRightNode() {
        return rightNode;
    }
    public void setRightNode(BTNode right) {
        this.rightNode = right;
    }
}
