public class Edge {
    private Vertex st, end;
    public Edge(Vertex b, Vertex e) {
    st = b;
    end = e; }
    public int getSource() {
        return st.getName();
    }
    public int getDest() {
        return end.getName();
    }
    public int hashCode() {
        return Integer.parseInt(st.toString() + end.toString());
    }
    public boolean equals(Object o) {
        if (o instanceof Edge e) return ((st.toString() + end.toString()).equals(String.valueOf(e.getSource()) + String.valueOf(e.getDest())));
        else return false;
    }
}