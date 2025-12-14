import java.util.*;
class Grafo {
    private Map<String, List<String>> adjVertices;
    public Grafo() {
        adjVertices = new HashMap<>();
    }
    // Añadir vértice
    public void addVertex(String label) {
        adjVertices.putIfAbsent(label, new ArrayList<>());
    }
    // Añadir arista
    public void addEdge(String label1, String label2) {
        adjVertices.get(label1).add(label2);
        //adjVertices.get(label2).add(label1); // Para grafos no dirigidos
    }
    // Obtener lista de adyacencia
    public List<String> getAdjVertices(String label) {
        return adjVertices.get(label);
    }

    // Método para imprimir el grafo
    public void printGraph() {
        for (String vertex : adjVertices.keySet()) {
            System.out.print(vertex + " -> ");
            for (String adjVertex : adjVertices.get(vertex)) {
                System.out.print(adjVertex + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Grafo graph = new Grafo();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");
        graph.addEdge("D", "E");
        graph.addEdge("D", "F");
        graph.addEdge("E", "F");
        graph.addEdge("F", "G");
        graph.addEdge("G", "H");
        graph.addEdge("H", "I");
        graph.printGraph();
    }
}