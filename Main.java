import java.util.*;
class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }
}





public class Edge<Vertex> {
    private Vertex source;
    private Vertex dest;
    private Double weight;
    public Edge(Vertex source,Vertex dest,Double weight){
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }
}

private Map<Vertex,List<Edge<Vertex>>> map = new HashMap<>();

public class Vertex<V>{
    private V data;
    private Map<Vertex<V>,Double>  adjacentVertices; 
    public void addAdjacentVertices(Vertex<V> destination,double weight){
       
    }
}
