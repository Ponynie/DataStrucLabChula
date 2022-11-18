package datastr;

public class LinkedCollectionWithDup implements Collection {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        int cnt = 1;
        LinkedNode(Object e, LinkedNode next) {
            this.element = e;
            this.next = next;
        }
    }
    //Field--------------------------------------------------------------------------------
    private LinkedNode header = new LinkedNode(null, null);
    private int size;
    //Constructor--------------------------------------------------------------------------
    public LinkedCollectionWithDup() {}
    //Method------------------------------------------------------------------------------
    public int size() { //
        return size;
    }
    public boolean isEmpty() { //
        return size == 0;
    }
    public void add(Object e) {
        if (this.contains(e)) {
            LinkedNode node = header.next;
            while (node != null) {
                if (node.element.equals(e)) {
                    node.cnt = node.cnt + 1;
                    ++size;
                }
                node = node.next;
            }
        }
        else {
            header.next = new LinkedNode(e, header.next);
            ++size;
        }
    }
    public boolean contains(Object e) {
        LinkedNode node = header.next;
        while( node != null ) {
            if (node.element.equals(e)) return true;
            node = node.next;
        }
        return false;
    }
    public void remove(Object e) {
        LinkedNode p = header;
        while( p.next != null &&
                ! p.next.element.equals(e)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next; --size;
        }
    }
    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        int k = 0;
        while (p != null) {
            arr[k++] = p.element;
            p = p.next;
        }
        return arr;
    }
}