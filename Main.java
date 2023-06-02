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

class WeightedGraph<V> {
    private Map<Vertex<V>, List<Vertex<V>>> map;
    private Map<Vertex<V>, Map<Vertex<V>, Double>> weights;

    public WeightedGraph() {
        this.map = new HashMap<>();
        this.weights = new HashMap<>();
    }
