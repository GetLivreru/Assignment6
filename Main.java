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
     public void addVertex(Vertex<V> vertex) {
        map.put(vertex, new ArrayList<>());
        weights.put(vertex, new HashMap<>());
    }

    public void addEdge(Vertex<V> source, Vertex<V> dest, Double weight) {
        map.get(source).add(dest);
        weights.get(source).put(dest, weight);
    }

    public List<Vertex<V>> getAdjacentVertices(Vertex<V> vertex) {
        return map.get(vertex);
    }

    public Double getWeight(Vertex<V> source, Vertex<V> dest) {
        return weights.get(source).get(dest);
    }
}
interface Search<V> {
    void search(Vertex<V> start);
}
