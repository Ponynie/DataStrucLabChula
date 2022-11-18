package datastr;

public interface Matrix {
    public int numRows();
    public int numCols();
    public double get(int r, int c);
    public void set(int r, int c, double v);
    public Matrix add(Matrix v);
    public Matrix multiply(Matrix v);
}
