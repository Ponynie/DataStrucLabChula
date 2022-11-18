package lab;

import java.util.Random;

import datastr.DenseMatrix;
import datastr.Matrix;
import datastr.SparseMatrix;

//lab4q2
public class Main {
    public static void main(String[] args) throws Exception {
        Random r = new Random();
        int m = r.nextInt(2,6); int n = r.nextInt(2,11); int k = r.nextInt(2,6);
        DenseMatrix matrix1 = new DenseMatrix(m,n); SparseMatrix matrix2 = new SparseMatrix(n,k);SparseMatrix matrix3 = new SparseMatrix(m,n);
        generateMatrixElement(matrix1); generateMatrixElement(matrix2); generateMatrixElement(matrix3);
        printMatrix(matrix1); printMatrix(matrix2); printMatrix(matrix3);
        printMatrix(matrix1.multiply(matrix2));
        printMatrix(matrix1.add(matrix3));
    }



    public static void printMatrix(Matrix m) {
        for (int i = 0; i < 4*m.numCols(); i++) {
            if (i != 4*m.numCols() - 1) System.out.print("-");
            else System.out.print("\n");
        }
        for (int i = 0; i < m.numRows(); i++) {
            for (int j = 0; j < m.numCols(); j++) {
                if (j != m.numCols() - 1) System.out.print(m.get(i, j) + " ");
                else System.out.print(m.get(i, j) + "\n");
            }
        }
        for (int i = 0; i < 4*m.numCols(); i++) {
            if (i != 4*m.numCols() - 1) System.out.print("-");
            else System.out.print("\n");
        }
    }
    public static void generateMatrixElement(Matrix m) {
        Random r = new Random();
        if (m instanceof DenseMatrix) {
            for (int i = 0; i < m.numRows(); i++) {
                for (int j = 0; j < m.numCols(); j++) {
                    m.set(i, j, r.nextInt(10));
                }
            }
        }
        else if (m instanceof SparseMatrix) {
            int numElement = r.nextInt((int)((m.numRows()*m.numCols())/(3/2)));
            for (int i = 0; i < numElement; i++) {
                m.set(r.nextInt(m.numRows()), r.nextInt(m.numCols()), r.nextInt(10));
            }
        }
    }
}







 