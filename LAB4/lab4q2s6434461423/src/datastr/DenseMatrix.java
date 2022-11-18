package datastr;

public class DenseMatrix implements Matrix{
    DenseVector[]  rows;

    public DenseMatrix(int r, int c) {
        rows = new DenseVector[r];
        for (int i = 0; i < r; i++)
            rows[i] = new DenseVector(c);
    }

    @Override
    public int numRows() {
        return rows.length;
    }

    @Override
    public int numCols() {
        return rows[0].length();
    }

    @Override
    public double get(int r, int c) {
        assertInRange(r, c);
        return rows[r].get(c);
    }
    private void assertInRange(int r, int c) {
        if (r < 0 || r >= numRows() || c < 0 || c >= numCols())
            throw new IndexOutOfBoundsException(r + "," + c);
    }
    @Override
    public void set(int r, int c, double v) {
        assertInRange(r, c);
        rows[r].set(c, v);
    }

    @Override
    public Matrix add(Matrix v) {
        if (this.numRows() != v.numRows() || this.numCols() != v.numCols()) throw new IllegalArgumentException();
        int r = this.numRows();
        int c = this.numCols();
        DenseMatrix result = new DenseMatrix(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result.set(i, j, this.get(i, j) + v.get(i, j));
            }
        }
        return result;
    }

    @Override
    public Matrix multiply(Matrix v) {
        if (this.numCols() != v.numRows()) throw new IllegalArgumentException("incomnpatibility for multiplication");
        DenseMatrix resultMatrix = new DenseMatrix(this.numRows(), v.numCols());
        for (int i = 0; i < this.numRows(); i++) {
            DenseVector resultVector = (DenseVector) this.rows[i].multiply(v);
            for (int j = 0; j < resultVector.length(); j++) {
                resultMatrix.set(i, j, resultVector.get(j));
            }
        }
        return resultMatrix;
    }
    
}
