package datastr;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */

public interface Collection {
    public void add(Object element);
    public void remove(Object element);
    public boolean isEmpty();
    public boolean contains(Object element);
    public int size();
}