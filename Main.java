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
class BreadthFirstSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public BreadthFirstSearch(WeightedGraph<V> graph) {
        this.graph = graph;
}
    @Override
    public void search(Vertex<V> start) {
        Set<Vertex<V>> visited = new HashSet<>();
        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Vertex<V> currentVertex = queue.poll();
            System.out.println("Visited: " + currentVertex.getData());

            List<Vertex<V>> adjacentVertices = graph.getAdjacentVertices(currentVertex);
            for (Vertex<V> neighbor : adjacentVertices) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}
class DijkstraSearch<V> implements Search<V> {
    private WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph) {
        this.graph = graph;
    }
    @Override
    public void search(Vertex<V> start) {
        PriorityQueue<Vertex<V>> minHeap = new PriorityQueue<>(Comparator.comparingDouble(vertex -> getDistance(start, vertex)));
        Map<Vertex<V>, Double> distance = new HashMap<>();
        Map<Vertex<V>, Vertex<V>> previous = new HashMap<>();

        // Initialize distances to infinity
        for (Vertex<V> vertex : graph.getAdjacentVertices(start)) {
            distance.put(vertex, Double.POSITIVE_INFINITY);
        }

        distance.put(start, 0.0);

        // Add the start vertex to the heap
        minHeap.add(start);

        while (!minHeap.isEmpty()) {
            Vertex<V> currentVertex = minHeap.poll();

            for (Vertex<V> neighbor : graph.getAdjacentVertices(currentVertex)) {
                double newDistance = distance.get(currentVertex) + graph.getWeight(currentVertex, neighbor);

                if (newDistance < distance.get(neighbor)) {
                    distance.put(neighbor, newDistance);
                    previous.put(neighbor, currentVertex);
                    minHeap.add(neighbor);
                }
            }
        }
    }

    private double getDistance(Vertex<V> start, Vertex<V> dest) {
        // Implement your own distance calculation logic here
        // For example, you can use the Euclidean distance between the vertices' coordinates
        return 0.0;
    }
}
