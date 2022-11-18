import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Random rand = new Random(2);
        int numVertices = rand.nextInt(5,11);
        int[][] ajaMatrix = new int[numVertices][numVertices]; //Crete 0 filled matrix
        for (int i = 0; i < numVertices; i++) { //fill matrix with weights
            for (int j = 0; j < numVertices; j++) {
                ajaMatrix[i][j] = rand.nextFloat() < 0.25 ? rand.nextInt(1,6) : 0;
            }
        }
        Graph graph1 = new Graph(ajaMatrix);
        Graph graph2 = new Graph(numVertices, (numVertices * numVertices)/4);
        System.out.println("Random adjacency matrix of graph 1");
        viewMatrix(ajaMatrix);
        System.out.println("Adjacency matrix created from graph 1");
        viewMatrix(graph1.toMatrix());
        
        System.out.println("Adjacency matrix created from graph 2");
        viewMatrix(graph2.toMatrix());
        System.out.println(graph2.weight(new Edge(new Vertex(2), new Vertex(1))));
        
        HashMap<Edge,Integer> weight = new HashMap<Edge, Integer>();
        weight.put(new Edge(new Vertex(0), new Vertex(1)),2);
        System.out.println(weight.get((new Edge(new Vertex(0), new Vertex(1)))));
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