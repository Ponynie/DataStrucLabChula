package lab;

import java.util.Random;

import datastr.DenseVector;
import datastr.SparseVector;
import datastr.Vector;

//lab4q1
public class Main {
    public static void main(String[] args) throws Exception {
        //Initialize the vector----------------------------------------------------------------
        Random r = new Random();
        DenseVector vDense = new DenseVector(10);
        for (int i = 0; i < 10; i++) {
            vDense.set(i, i+1);
        }
        SparseVector vSparse = new SparseVector(10);
        for (int i = 0; i < r.nextInt(2,6); i++) {
            vSparse.set(r.nextInt(10), r.nextInt(11));
        }
        //Print out the vector----------------------------------------------------------------
        printVector(vDense);
        printVector(vDense.multiply(0.5));
        printVector(vSparse);
        printVector(vSparse.multiply(0.5));
        printVector(vSparse.add(vDense));
        printVector(vDense.subtract(vSparse));
        System.out.println(vDense.dot(vSparse));
        System.out.println(vSparse.dot(vDense));
    }

    public static void printVector(Vector v) {
        System.out.print("[ ");
        for (int i = 0; i < v.length(); i++) {
            System.out.print(v.get(i) + " ");
        }
        System.out.print("]\n");
    }

}
