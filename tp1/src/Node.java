import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String id;
    private final List<Node> neighbors;
    private Node parent;

    public Node(String id) {
        this.id = id;
        this.neighbors = new ArrayList<>();
        this.parent = null;
    }

    public String getId() {
        return id;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public Node getParent() {
        return parent;
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void displayNeighbors() {
        System.out.print("Les voisins du sommet " + id + " sont : ");
        for (Node neighbor : neighbors) {
            System.out.print(neighbor.getId() + " ");
        }
        System.out.println();
    }
}
