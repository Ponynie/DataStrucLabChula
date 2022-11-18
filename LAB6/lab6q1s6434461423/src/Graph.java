
import java.util.HashMap;
import java.util.Random;

public class Graph {
    //FIELD------------------------------------------------------------------
    private Vertex[] vertices;
    private Edge[] edges;
    private HashMap<Edge,Integer> weights = new HashMap<Edge, Integer>();
    //CONSTRCUTOR--------------------------------------------------------------
    public Graph(int numVertices, int numEdges) {
        if (numEdges > numVertices * numVertices) throw new IllegalArgumentException(); // edges can't exceed vertices**2
        Random r = new Random(1); //seed for debugging
        vertices = new Vertex[numVertices];
        edges = new Edge[numEdges];
        for (int i = 0; i < numVertices; i++) vertices[i] = new Vertex(i); // Crete array of vertices
        int i = 0;
        while (i < numEdges) {
            Edge e = new Edge(vertices[r.nextInt(numVertices-1)] , vertices[r.nextInt(numVertices-1)]); // Crete edge from 2 random vertices
            boolean duplicate = false;
            for (Edge j : edges) if (e.equals(j)) duplicate = true; // check if edge is duplicated 
            if (!duplicate) edges[i++] = e;
        }
        for (Edge e : edges) weights.put(e, r.nextInt(1,5)); // random weights (1-4)
    }
    public Graph(int[][] m) {
        vertices = new Vertex[m.length];
        edges = new Edge[m.length * m.length];
        int cnt = 0;
        for (int i = 0; i < m.length; i++) {
            Vertex v_i = new Vertex(i);
            vertices[i] = v_i;
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != 0) {
                    Vertex v_j = new Vertex(j);
                    Edge e = new Edge(v_i, v_j);
                    edges[cnt++] = e;
                    weights.put(e, m[i][j]);
                }
            }
        }
    }
    //METHOD-------------------------------------------------------------------
    public int weight(Edge e) {
        if (weights.containsKey(e)) return weights.get(e);
        return 0;
    }
    public int[][] toMatrix() {
        int[][] matrix = new int[vertices.length][vertices.length];
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Edge e : edges) {
            if (e != null) matrix[e.getSource()][e.getDest()] = weights.get(e);
        }
        return matrix;
    } 
}
