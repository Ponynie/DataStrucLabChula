package lab;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int numV = r.nextInt(5, 11);

        int[][] adjacencyMatrix = new int[numV][numV];
        for (int i = 0; i < numV; i++) {
            for (int j = 0; j < numV; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }

        for (int i = 0; i < r.nextInt(10, 30); i++) {
            adjacencyMatrix[r.nextInt(0, numV)][r.nextInt(0, numV)] = r.nextInt(1, 5);
        }

        printMatrix(adjacencyMatrix);

        System.out.println("Hash table of edges");

        Graph g = new Graph(adjacencyMatrix);
        System.out.println(g.getWeight().toString());
    }


    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
