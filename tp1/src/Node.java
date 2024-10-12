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

    /**
     * Retourne l'identifiant du sommet.
     *
     * @return identifiant du sommet
     */
    public String getId() {
        return id;
    }

    /**
     * Retourne la liste des voisins du sommet.
     *
     * @return liste des voisins du sommet
     */
    public List<Node> getNeighbors() {
        return neighbors;
    }

    /**
     * Retourne le parent du sommet.
     *
     * @return parent du sommet
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Ajoute un voisin au sommet.
     *
     * @param neighbor voisin à ajouter
     */
    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    /**
     * Définit le parent du sommet.
     *
     * @param parent parent du sommet
     */
    public void setParent(Node parent) {
        this.parent = parent;
    }

    /**
     * Affiche les voisins du sommet.
     */
    public void displayNeighbors() {
        System.out.print("Les voisins du sommet " + id + " sont : ");
        for (Node neighbor : neighbors) {
            System.out.print(neighbor.getId() + " ");
        }
        System.out.println();
    }
}
