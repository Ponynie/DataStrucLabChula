package lab;

import java.util.Random;

import datastr.LinearProbingHashMap;

public class Graph {
    //FIELD------------------------------------------------------------------
    private Vertex[] vertices;
    private Edge[] edges;
    private LinearProbingHashMap weights = new LinearProbingHashMap(12);
    //CONSTRCUTOR--------------------------------------------------------------
    public Graph(int numVertices, int numEdges) {
        if (numEdges > numVertices * numVertices) throw new IllegalArgumentException(); 
        Random r = new Random(1); //seed
        vertices = new Vertex[numVertices];
        edges = new Edge[numEdges];
        for (int i = 0; i < numVertices; i++) vertices[i] = new Vertex(i); 
        int i = 0;
        while (i < numEdges) {
            Edge e = new Edge(vertices[r.nextInt(numVertices-1)] , vertices[r.nextInt(numVertices-1)]);
            boolean duplicate = false;
            for (Edge j : edges) if (e.equals(j)) duplicate = true; 
            if (!duplicate) edges[i++] = e;
        }
        for (Edge e : edges) weights.put(e, r.nextInt(1,5)); 
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
        if (weights.containsKey(e)) return (int) weights.get(e);
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
            if (e != null) matrix[e.getSource()][e.getDest()] = (int) weights.get(e);
        }
        return matrix;
    } 
    public LinearProbingHashMap getHashWeights() {
        return weights;
    }
}
