package datastr;

import java.util.NoSuchElementException;

public class ArrayStack implements Stack {
    private Object[] elementData;
    private int size;

    public ArrayStack() {
        elementData = new Object[4];
    }
    public ArrayStack(int cap) {
        elementData = new Object[cap];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void push(Object e) {
        if (size == elementData.length) {
            Object[] a = new Object[2 * size];
            for (int i = 0; i < size; i++)
                a[i] = elementData[i];
            elementData = a;
        }
        elementData[size++] = e;
    }
    public Object peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return elementData[size-1];
    }
    public Object pop() {
        Object e = peek();
        elementData[--size] = null;
        return e;
    }
    public String toString() {
        String returnString = "";
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                returnString = returnString + "=== BOTTOM OF STACK ===\n" + elementData[i].toString() + "------------------------\n";
            }
            else {
                returnString = returnString + elementData[i].toString() + "-----------------------\n";
            }
        }
        return returnString;
    }
}
