package datastr;

public interface Vector {
    public int length();
    public double magnitude();
    public double get(int index);
    public void set(int index, double value);
    public Vector add(Vector v);
    public Vector subtract(Vector v);
    public double dot(Vector v);
    public Vector multiply(double c);
}
