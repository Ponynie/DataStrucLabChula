package datastr;

public class AVLTree extends BST{
    public void add(int element) {
        setRoot(add((AVLNode) getRoot(), element));
    }
    public void remove(int element) {
        setRoot(remove((AVLNode) getRoot(), element));
    }
    public void printTree(){
        System.out.println(inOrder((AVLNode) getRoot()));
    }
    //Method ช่วย-------------------------------------------------------------------------------
    private AVLNode add(AVLNode node , int element) {
        if (node == null) return new AVLNode(element, null, null); //ส่งโหนดใหม่ให้ parent node
        else if (element < node.getElement()) {  
            node.setLeft(add((AVLNode) node.getLeft() ,element));
            return reBalance(node); //ส่งโหนดที่บาลานซ์แล้วกลับไปให้ parent node
        }
        else if (element > node.getElement()){
            node.setRight(add((AVLNode) node.getRight(), element));
            return reBalance(node); //ส่งโหนดที่บาลานซ์แล้วกลับไปให้ parent node
        }
        else return node;
    }
    private AVLNode remove(AVLNode node , int element) {
        if (element == node.getElement()) { //เจอตัวที่จะลบ
            if (node.getLeft() == null && node.getRight() == null) { //ลูก 0
                return null;
            }
            else if (node.getLeft() == null || node.getRight() == null) { //ลูก 1
                if (node.getLeft() == null) return (AVLNode) node.getRight();
                return (AVLNode) node.getLeft();
            }
            else { //ลูก 2
                int newElement = getMax(node.getLeft());
                node.setElement(newElement);
                node.setLeft(remove((AVLNode) node.getLeft(),newElement));
                return reBalance(node);
            }
        }
        else if (element < node.getElement()) { //ไล่ต้นไม้
            node.setLeft(remove((AVLNode) node.getLeft(),element));
            return reBalance(node); //ส่ง node ที่เป็น root ของ subtree ที่บาลานซ์แล้วไปให้ parent node
        }
        else if (element > node.getElement()) { //ไล่ต้นไม้
            node.setRight(remove((AVLNode) node.getRight(), element));
            return reBalance(node); //ส่ง node ที่เป็น root ของ subtree ที่บาลานซ์แล้วไปให้ parent node
        }
        else { //ไม่เจอตัวที่จะลบ
            return null;
        }
    }
    private String inOrder(AVLNode r) {
        if (r == null) return "";
        else {
            String s = inOrder((AVLNode) r.getLeft());
            s = s + r.getElement() + ",";
            s = s + inOrder((AVLNode) r.getRight());
            return s;
        }
    }
    //Method จัดการ AVL----------------------------------------------------------------------------
    private AVLNode reBalance(AVLNode node) {
        calBalanceFactor(node);
        if (node.getBF() == 2) { //โหนดบนหนักขวา
            AVLNode rightNode = (AVLNode) node.getRight();
            if (rightNode.getBF() >= 0) return rotateLeft(node); //ล่างหนักขวา
            return rotateRightLeft(node); //ล่างหนักซ้าย
        }
        if (node.getBF() == -2) { //โหนดบนหนักซ้าย
            AVLNode leftNode = (AVLNode) node.getLeft();
            if (leftNode.getBF() <= 0) return rotateRight(node); //ล่างหนักซ้าย
            return rotateLeftRight(node); //ล่างหนักขวา
        }
        return node; //trace กลับขึ้นเรื่อยๆกรณีไม่ต้อง rotate
    }
    private AVLNode rotateLeft(AVLNode node) { //หมุนเมื่อหนักขวา
        AVLNode top = node;
        AVLNode downRight = (AVLNode) top.getRight();
        top.setRight(downRight.getLeft());
        downRight.setLeft(top);
        calBalanceFactor(top);
        calBalanceFactor(downRight);
        return downRight;
    }
    private AVLNode rotateRight(AVLNode node) { //หมุนเมื่อหนักซ้าย
        AVLNode top = node;
        AVLNode downLeft = (AVLNode) top.getLeft();
        top.setLeft(downLeft.getRight());
        downLeft.setRight(top);
        calBalanceFactor(top);
        calBalanceFactor(downLeft);
        return downLeft;
    }
    private AVLNode rotateRightLeft(AVLNode node) { //หมุนเมื่อหนักขวาแล้วลูกหนักซ้าย
        //1st Rotation
        AVLNode top = node;
        AVLNode downRight = (AVLNode) top.getRight();
        AVLNode leftChildDownRight = (AVLNode) downRight.getLeft();
        downRight.setLeft(leftChildDownRight.getRight());
        top.setRight(leftChildDownRight);
        leftChildDownRight.setRight(downRight);
        //2nd Rotation
        AVLNode newTop = top;
        AVLNode newDownRight = (AVLNode) top.getRight();
        newTop.setRight(newDownRight.getLeft());
        newDownRight.setLeft(newTop);
        calBalanceFactor(newDownRight);
        calBalanceFactor((AVLNode) newDownRight.getLeft());
        calBalanceFactor((AVLNode) newDownRight.getRight());
        return newDownRight;
    }
    private AVLNode rotateLeftRight(AVLNode node) { //หมุนเมื่อหนักซ้ายแล้วลูกหนักขวา
        //1st Rotation
        AVLNode top = node;
        AVLNode downLeft = (AVLNode) top.getLeft();
        AVLNode rightChildDownLeft = (AVLNode) downLeft.getRight();
        downLeft.setRight(rightChildDownLeft.getLeft());
        top.setLeft(rightChildDownLeft);
        rightChildDownLeft.setLeft(downLeft);
        //2nd Rotation
        AVLNode newTop = top;
        AVLNode newDownLeft = (AVLNode) top.getLeft();
        newTop.setLeft(newDownLeft.getRight());
        newDownLeft.setRight(newTop);
        calBalanceFactor(newDownLeft);
        calBalanceFactor((AVLNode) newDownLeft.getRight());
        calBalanceFactor((AVLNode) newDownLeft.getLeft());
        return newDownLeft;
    }
    private void calBalanceFactor(AVLNode node) { //คำนวณ balance factor และเก็บค่าใส่โหนด
        node.setBF(height(node.getRight()) - height(node.getLeft()));
    }
}
