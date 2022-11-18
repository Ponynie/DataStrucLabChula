package datastr;
/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */

public interface List extends Collection {
    public void add(int index, Object e);
    public void remove(int index);
    public Object get(int index);
    public void set(int index, Object e);
    public int indexOf(Object e);
}