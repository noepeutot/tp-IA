import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void addEdge(Node from, Node to) {
        from.addNeighbor(to);
        to.setParent(from);
    }

    public void displayGraph() {
        System.out.println("Les sommets et les arêtes du graphe sont :");
        for (Node node : nodes) {
            System.out.print("Sommet " + node.getId() + " -> ");
            node.displayNeighbors();
        }
    }
}
