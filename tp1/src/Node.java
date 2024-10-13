import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String id;
    private final List<Node> neighbors;
    private Node parent;
    private boolean wall;

    public Node(String id) {
        this.id = id;
        this.neighbors = new ArrayList<>();
        this.parent = null;
        this.wall = false;
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
     * Retourne si le sommet est un mur.
     *
     * @return vrai si le sommet est un mur, faux sinon
     */
    public boolean isWall() {
        return wall;
    }

    /**
     * Définit si le sommet est un mur.
     *
     * @param wall vrai si le sommet est un mur, faux sinon
     */
    public void setWall(boolean wall) {
        this.wall = wall;
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
