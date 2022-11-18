package datastr;

import java.util.NoSuchElementException;

public class ArrayQueue implements Queue {
    private Object[] elementData;
    private int size;
    private int front;

    public ArrayQueue() {
        elementData = new Object[4];
        size = front = 0;
    }
    public ArrayQueue(int cap) {
        elementData = new Object[cap];
        size = front = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void enqueue(Object e) {
        if (size == elementData.length) {
            Object[] a = new Object[2 * elementData.length];
            for (int i = 0, j = front; i < size;
                i++, j = (j+1)%elementData.length)
                a[i] = elementData[j];
            front = 0; elementData = a;
        }
        int b = (front + size) % elementData.length;
        elementData[b] = e; size++;
    }
    public Object peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return elementData[front];
    }
    public Object dequeue() {
        Object e = peek();
        elementData[front] = null;
        front = (front + 1) % elementData.length;
        size--;
        return e;
    }
}

