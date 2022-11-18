package lab;

public class Edge {
    private Vertex st, end;

    public Edge(Vertex b, Vertex e) {
        st = b;
        end = e;
    }

    public int getSource() {
        return st.getName();
    }

    public int getDest() {
        return end.getName();
    }

    public boolean equals(Object o) {
        if (o instanceof Edge e) return ((this.st.toString() + this.end.toString()).equals(String.valueOf(e.getSource()) + String.valueOf(e.getDest())));
        else return false;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.st.toString() + this.end.toString());
    }

    @Override
    public String toString() {
        return st + " - " + end;
    }
}
