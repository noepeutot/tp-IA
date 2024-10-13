import java.util.ArrayList;
import java.util.List;


public class GraphGrid extends Graph {
    private final int rows;
    private final int cols;

    public GraphGrid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.generateGrid();
    }

    /**
     * Génère une grille de sommets.
     */
    private void generateGrid() {
        // Crée les sommets de la grille
        Node[][] grid = new Node[this.rows][this.cols];

        // Ajoute chaque sommet à la grille
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                String id = "(" + i + "," + j + ")";
                grid[i][j] = new Node(id);
                this.addNode(grid[i][j]);
            }
        }

        // Parcourt chaque sommet de la grille
        // Ajoute une arête entre le sommet et ses voisins (haut, bas, gauche, droite)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 0) addEdge(grid[i][j], grid[i - 1][j]); // Haut
                if (i < rows - 1) addEdge(grid[i][j], grid[i + 1][j]); // Bas
                if (j > 0) addEdge(grid[i][j], grid[i][j - 1]); // Gauche
                if (j < cols - 1) addEdge(grid[i][j], grid[i][j + 1]); // Droite
            }
        }
    }

    /**
     * Ajoute un mur à la position donnée.
     * @param row ligne
     * @param col colonne
     */
    public void addWall(int row, int col) {
        // Vérifie si les coordonnées sont valides et ajoute un mur au sommet correspondant si c'est le cas
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            int index = row * cols + col;
            if (index < getNodes().size()) {
                Node wallNode = getNodes().get(index);
                wallNode.setWall(true);
            } else {
                System.out.println("Erreur : l'index est hors limite.");
            }
        } else {
            System.out.println("Erreur : les coordonnées sont hors limite.");
        }
    }

    /**
     * Retourne les voisins d'un sommet.
     * @param node sommet dont on veut les voisins
     * @return liste des voisins du sommet
     */
    public List<Node> getNeighbors(Node node) {
        List<Node> validNeighbors = new ArrayList<>();
        for (Node neighbor : node.getNeighbors()) {
            if (!neighbor.isWall()) {
                validNeighbors.add(neighbor);
            }
        }
        return validNeighbors;
    }

    /**
     * Affiche la grille
     */
    public void displayGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Node node = getNodes().get(i * cols + j);
                if (node.isWall()) {
                    System.out.print("[X] "); // Obstacle
                } else {
                    System.out.print("[ ] "); // Sommet accessible
                }
            }
            System.out.println();
        }
    }
}
