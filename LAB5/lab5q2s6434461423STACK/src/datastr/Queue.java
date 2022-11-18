package datastr;

public interface Queue {
    public boolean isEmpty();
    public int size();
    public void enqueue(Object e);
    public Object peek();
    public Object dequeue();
}

