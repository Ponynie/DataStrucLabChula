package datastr;

public class SparseMatrix implements Matrix {
    SparseVector[] rows;

    public SparseMatrix(int r, int c) {
        rows = new SparseVector[r];
        for (int i = 0; i < r; i++)
            rows[i] = new SparseVector(c);
    }

    public int numRows() {
        return rows.length;
    }

    public int numCols() {
        return rows[0].length();
    }
    public void set(int r, int c, double v) {
        assertInRange(r, c);
        rows[r].set(c,v);
    }
    public double get(int r, int c) {
        assertInRange(r, c);
        return rows[r].get(c);
    }
    private void assertInRange(int r, int c) {
        if (r < 0 || r >= numRows() || c < 0 || c >= numCols())
            throw new IndexOutOfBoundsException(r + "," + c);
    }
    public Matrix add(Matrix m2) {
        SparseMatrix m1 = this;
        if (m1.numRows()!=m2.numRows() || m1.numCols()!=m2.numCols())
            throw new IllegalArgumentException();
        SparseMatrix m3 = new SparseMatrix(numRows(), numCols());
        for (int i=0; i<m3.numRows(); i++) {
            for (int j=0; j<m3.numCols(); j++) {
                m3.set(i,j,m1.get(i,j) + m2.get(i,j));
            }
        }
        return m3;
    }
    public Vector multiply(Vector v) {
        if (v.length() != numCols())
            throw new IllegalArgumentException();
        SparseVector r = new SparseVector(numRows());
        for(int i=0; i<numRows(); i++) {
            r.set(i, rows[i].dot(v));
        }
        return (Vector) r;
    }
    public Matrix multiply(Matrix m2) { ///****
        SparseMatrix m1 = this; // m3 = m1 x m2
        if (m1.numCols() != m2.numRows())
            throw new IllegalArgumentException();
        SparseMatrix m3 = new SparseMatrix(m1.numRows(),m2.numCols());
        for(int i=0; i<m1.numRows(); i++) {
            m3.rows[i] = m1.rows[i].multiply(m2);
        }
        return m3;
    }
}