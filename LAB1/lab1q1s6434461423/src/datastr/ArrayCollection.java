package datastr;
/* Modification from
* http://www.cp.eng.chula.ac.th/~somchai/books
 */

import java.lang.Object;

public class ArrayCollection implements Collection {
    private Object[] elementData;
    private int      size;

    public ArrayCollection(int c) {
        elementData = new Object[c];
        size = 0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    private int indexOf(Object e) {
        for (int i=0; i<size; i++)
            if (elementData[i].equals(e)) return i;
        return -1;
    }
    public boolean contains(Object e) {
        return indexOf(e) != -1;
    }
    public void remove(Object e) {
        int i = indexOf(e);
        if (i != -1) {
            elementData[i] = elementData[--size];
            elementData[size] = null;
        }
    }
    public void add(Object e) {
        if(e == null) throw new IllegalArgumentException();
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }
    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2*elementData.length);
            Object[] arr = new Object[s];
            for(int i = 0; i < size; i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }
    public Object[] toArray() {
        Object[] a = new Object[size];
        for (int i=0; i<size; i++)
            a[i] = elementData[i];
        return a;
    }

}
