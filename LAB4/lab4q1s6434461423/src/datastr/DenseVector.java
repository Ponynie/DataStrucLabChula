package datastr;


public class DenseVector implements Vector {
    private int length;
    private double[] elementData;

    public DenseVector(int length) {
        this.length = length;
        elementData = new double[length];
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public double magnitude() {
        double sum = 0;
        for (double i : elementData) {
            sum = sum + (i * i);
        }
        double result = Math.sqrt(sum);
        return result;
    }

    @Override
    public double get(int index) {
        return elementData[index];
    }

    @Override
    public void set(int index, double value) {
        elementData[index] = value;
    }

    @Override
    public Vector add(Vector v) {
        if (this.length() != v.length()) throw new IllegalArgumentException();
        DenseVector v3 = new DenseVector(this.length());
        for (int i=0; i<v3.length(); i++) {
            v3.set(i,this.get(i)+v.get(i));
        }
        return v3;
    }

    @Override
    public Vector subtract(Vector v) {
        if (this.length() != v.length()) throw new IllegalArgumentException();
        DenseVector v3 = new DenseVector(this.length());
        for (int i=0; i<v3.length(); i++) {
            v3.set(i,this.get(i)-v.get(i));
        }
        return v3;
    }

    @Override
    public double dot(Vector v) {
        if (this.length() != v.length()) throw new IllegalArgumentException();
        double sum = 0;
        for (int i=0; i<this.length(); i++) {
            sum = sum + (this.get(i)*v.get(i));
        }
        return sum;
    }

    @Override
    public Vector multiply(double c) {
        DenseVector v3 = new DenseVector(this.length());
        for (int i=0; i<this.length(); i++) {
            v3.set(i,this.get(i) * c);
        }
        return v3;
    }
    
}
