package datastr;
/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
public class LinkedList implements List {
    private static class LinkedNode {
        Object element;
        LinkedNode prev, next;
        LinkedNode(Object e, LinkedNode p, LinkedNode n) {
            this.element = e;
            this.prev = p;
            this.next = n;
        }
    }
    private LinkedNode header;
    private int size;

    public LinkedList() {
        header = new LinkedNode(null, null, null);
        header.prev = header.next = header;
    }
    public boolean isEmpty() {
        return header.next == null;
    }
    public int size() {
        return size;
    }
    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }
    public int indexOf(Object e) {
        LinkedNode q = header.next;
        for (int i=0; i<size; i++) {
            if (q.element.equals(e)) return i;
            q = q.next;
        }
        return -1;
    }
    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) p = p.next;
        return p;
    }
    private void addBefore(LinkedNode q, Object e) {
        LinkedNode p = q.prev;
        LinkedNode x = new LinkedNode(e, p, q);
        p.next = q.prev = x;
        ++size;
    }
    public void add(Object e) {
        addBefore(header, e);
    }
    public void add(int i, Object e) {
        addBefore(nodeAt(i), e);
    }
    private void removeNode(LinkedNode q) {
        LinkedNode p = q.prev;
        LinkedNode x = q.next;
        p.next = x;
        x.prev = p;
        --size;
    }
    public void remove(int i) {
        removeNode(nodeAt(i));
    }
    public void remove(Object e) {
        LinkedNode q = header.next;
        while (q != header) {
            if (q.element.equals(e)) { removeNode(q); break; }
            q = q.next;
        }
    }
    public Object get(int i) {
        return nodeAt(i).element;
    }
    public void set(int i, Object e) {
        nodeAt(i).element = e;
    }
    public Object[] toArray() {
        Object[] a = new Object[size];
        LinkedNode q = header.next;
        for (int k = 0; k < size; k++) {
            a[k] = q.element;
            q = q.next;
        }
        return a;
    }
}