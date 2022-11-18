package datastr;

public class BST {
    private BTNode root;

    public BST(){
        this.root=null;
    }

    /**
     * @return the root
     */
    protected BTNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    protected void setRoot(BTNode root) {
        this.root = root;
    }
    public void add(int newElement) { //need overide in AVL
        setRoot(add(getRoot(), newElement));
    }

    public void printTree(){
        System.out.println(inOrder(getRoot()));
    }
    public void printTreePreOrder() {
        System.out.println(preOrder(getRoot()));
    }

    public int getMax() {
        if (getRoot() == null) throw new IllegalStateException("tree is not exists");
        return getMax(getRoot());
    }    

    public void remove(int newElement) { //need overide in AVL
        setRoot(remove(getRoot(), newElement));
    }
    public boolean contains(int newElement) {
        return contains(getRoot(), newElement);
    }
    public int height() {
        return height(getRoot());
    }
    //RECURSIVE------------------------------------------------------------------------------------
    protected int height(BTNode node) {
        if (node == null) return -1;
        else return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
    protected int getMax(BTNode node) {
        if (node.getRight() == null) return node.getElement(); //base case
        else return getMax(node.getRight()); //ไล่ต้นไม้ทางขวา
    }
    private BTNode remove(BTNode node , int newElement) {
        if (node == null) return null; // base case ที่ไม่มีอะไรให้ลบ
        else if (newElement < node.getElement()) { //ขยับต้นไม้ทางซ้ายหาตัวที่จะลบ
            node.setLeft(remove(node.getLeft() , newElement)); //รับ node จาก call ชั้นในมาและ setLeft
            return node; // ส่ง node ซึ่งเป็น node.getLeft ของ call ก่อนหน้าออกไป
        }
        else if (newElement > node.getElement()) { //ขยับต้นไม้ทางขวาหาตัวที่จะลบ
            node.setRight(remove(node.getRight(), newElement)); //รับ node จาก call ชั้นในมาและ setRight
            return node; // ส่ง node ซึ่งเป็น node.getRight ของ call ก่อนหน้าออกไป
        }
        else { //เจอ node ที่จะลบ **และจากเมทอดข้างบนอะไรก็ตามที่ return ออกไปจะเป็นการ set ให้ node ที่ทำอยู่ในชั้นนี้กลายเป็นอะไรก็ตามที่ถูก return ออกไปนั้น
            if (node.getLeft() == null && node.getRight() == null) { //ลูก 0 
                return null; //set ให้ตัว node นี้เองเป็น null
            }
            else if (node.getLeft() == null || node.getRight() == null) { //ลูก 1
                if (node.getLeft() == null) return node.getRight(); //ลูกอยู่ขวาก็ set ให้ตัว node นี้เองกลายเป็นลูกฝั่งขวาของตัวเอง
                else return node.getLeft(); //สลับกับบรรทัดบน
            }
            else { //ลูก 2
                int maxValueLeftSubTree = getMax(node.getLeft()); //หาค่ามากสุดของ subTree ฝั่งซ้าย
                node.setElement(maxValueLeftSubTree); //เอา node นี้ที่จะลบ set เป็นค่านั้นทับลงไป
                remove(node.getLeft(), maxValueLeftSubTree); //เรียก method นี้ซ้ำเพื่อลบ node ที่เป็นเจ้าของค่าที่ถูกสลับทื่ไปแล้วทิ้ง
                return node; // set ให้ตัว node นี้เองเป็นตัวเองเพราะมีการสลับค่ากันแล้ว
            }
        }
        
    }
    private BTNode add(BTNode node, int newElement) { //คล้ายๆข้างบน
        if (node == null) return new BTNode(newElement, null, null); // return อะไรคือการ set อันนั้น
        else if (newElement < node.getElement()) {
            node.setLeft(add(node.getLeft(), newElement));
            return node;
        }
        else if (newElement > node.getElement()) {
            node.setRight(add(node.getRight(), newElement));
            return node;
        }
        else return node;
    }
    private String inOrder(BTNode r) {
        if (r == null) return "";
        else {
            String s = inOrder(r.getLeft());
            s = s + r.getElement() + ",";
            s = s + inOrder(r.getRight());
            return s;
        }
    }
    private String preOrder(BTNode r) {
        if (r == null) return "";
        else {
            String s = r.getElement() + ",";
            s = s + preOrder(r.getLeft());
            s = s + preOrder(r.getRight());
            return s;
        }
    }
    private boolean contains(BTNode node , int newElement) {
        if (node == null) return false;
        else if (node.getElement() == newElement) return true;
        else if (newElement < node.getElement()) return contains(node.getLeft(), newElement);
        else return contains(node.getRight(), newElement);
    }
}