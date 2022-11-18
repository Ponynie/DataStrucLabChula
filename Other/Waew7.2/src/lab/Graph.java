package lab;

import datastr.LinearProbingHashMap;

import java.util.HashMap;
import java.util.Random;

public class Graph {

    private Vertex vertex[];
    private Edge edge[];
    private LinearProbingHashMap weight = new LinearProbingHashMap(47);

    public Graph(int[][] matrix){
        int cntE = 0;
        vertex = new Vertex[matrix.length];
        edge = new Edge[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            Vertex v = new Vertex(i);
            vertex[i] = v;
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] != 0){
                    Vertex v2 = new Vertex(j);
                    Edge e = new Edge(v,v2);
                    edge[cntE] = e;
                    weight.put(e,matrix[i][j]);
                }
            }
        }
    }

    public Graph(int numV, int numE){
        Random r = new Random(4);
        vertex = new Vertex[numV];
        edge = new Edge[numE];
        for (int i = 0; i < numV; i++) {
            vertex[i] = new Vertex(i);
        }
        int i = 0;
        while (i < numE) {
            Edge e = new Edge(vertex[r.nextInt(numV)] , vertex[r.nextInt(numV)]);
            for (Edge exist : edge) {
                if (e.equals(exist)) continue;
            }
            edge[i] = e;
            i++;
        }
        for (Edge e : edge) {
            weight.put(e, r.nextInt(1,5));
        }
    }

    public int weight(Edge e) {
        if (weight.containsKey(e)) {
            return (int) weight.get(e);
        }
        return 0;
    }

    public int[][] toMatrix() {
        int[][] matrix = new int[vertex.length][vertex.length];
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[i].length ; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Edge e : edge) {
            if (e != null) matrix[e.getSource()][e.getDest()] = (int) weight.get(e);
        }
        return matrix;
    }

    public LinearProbingHashMap getWeight() {
        return weight;
    }
}

