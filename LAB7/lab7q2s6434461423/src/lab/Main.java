package lab;
import java.util.Random;
//Q2
public class Main {
    public static void main(String[] args) throws Exception {
        Random rand = new Random(2);//seed
        int numVertices = rand.nextInt(5,11);
        Graph graph = new Graph(numVertices, (numVertices * numVertices)/4);
        System.out.println("adjacency matrix");
        viewMatrix(graph.toMatrix());
        System.out.println("Hash table of edges ");
        System.out.println(graph.getHashWeights().toString());
    }
    static void viewMatrix(int[][] matrix) {
        System.out.println("-----------------------------------------------------");
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%4d",matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------");
    }
}