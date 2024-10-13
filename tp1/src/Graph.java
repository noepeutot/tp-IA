import java.util.*;

public class Graph {
    private final List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    /**
     * Ajoute un sommet seul au graphe.
     */
    public void addNode(Node node) {
        nodes.add(node);
    }

    /**
     * Retourne la liste des sommets du graphe.
     *
     * @return liste des sommets du graphe
     */
    public List<Node> getNodes() {
        return nodes;
    }

    /**
     * Ajoute une arête entre deux sommets.
     *
     * @param from sommet de départ
     * @param to   sommet d'arrivée
     */
    public void addEdge(Node from, Node to) {
        from.addNeighbor(to);
        to.setParent(from);
    }

    /**
     * Effectue un parcours en largeur (BFS) à partir d'un sommet donné.
     *
     * @param start le sommet à partir duquel le parcours en largeur commence
     */
    public void bfs(Node start) {
        // Définition des ensembles pour stocker les sommets visités et à visiter
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        // Ajoute le sommet de départ à la file et le marque comme visité
        queue.add(start);
        visited.add(start);

        // Tant que la file n'est pas vide
        // On retire un sommet de la file, on l'affiche et on ajoute ses voisins à la file
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.getId() + " ");

            // Parcourt les voisins du sommet
            // Si un voisin n'a pas été visité, on l'ajoute à la file et on le marque comme visité
            for (Node neighbor : node.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    /**
     * Parcours en profondeur du graphe (DFS).
     *
     * @param start sommet de départ
     */
    public void dfs(Node start) {
        // Définition des ensembles pour stocker les sommets visités et à visiter
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();

        // Ajoute le sommet de départ à la pile et le marque comme visité
        stack.push(start);
        visited.add(start);

        // Tant que la pile n'est pas vide
        // On retire un sommet de la pile, on l'affiche et on ajoute ses voisins à la pile
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.getId() + " ");

            // Parcourt les voisins du sommet
            // Si un voisin n'a pas été visité, on l'ajoute à la pile et on le marque comme visité
            for (Node neighbor : node.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    /**
     * Recherche un chemin entre deux sommets.
     *
     * @param start sommet de départ
     * @param end   sommet d'arrivée
     * @return liste des sommets du chemin trouvé
     */
    public List<Node> findPath(Node start, Node end) {
        // Définition des ensembles pour stocker les sommets visités et à visiter
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        // Ajoute le sommet de départ à la file et le marque comme visité
        queue.add(start);
        visited.add(start);

        // Tant que la file n'est pas vide
        // On retire un sommet de la file, on vérifie s'il s'agit du sommet d'arrivée
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node == end) {
                return buildPath(node);
            }

            // Parcourt les voisins du sommet
            // Si un voisin n'a pas été visité, on l'ajoute à la file et on le marque comme visité
            for (Node neighbor : node.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    neighbor.setParent(node);
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return null; // Pas de chemin trouvé
    }

    /**
     * Construit le chemin à partir du sommet final.
     *
     * @param node sommet final
     * @return chemin trouvé
     */
    private List<Node> buildPath(Node node) {
        List<Node> path = new ArrayList<>();

        // Parcourt les parents des sommets jusqu'au sommet de départ
        while (node != null) {
            path.add(0, node);
            node = node.getParent();
        }

        return path;
    }

    /**
     * Affiche le chemin trouvé
     *
     * @param path chemin trouvé
     */
    public void displayPath(List<Node> path) {
        if (path == null) {
            System.out.println("Pas de chemin trouvé");
        } else {
            for (Node node : path) {
                System.out.print(node.getId() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Affiche les sommets et les arêtes du graphe.
     */
    public void displayGraph() {
        System.out.println("Les sommets et les arêtes du graphe sont :");
        for (Node node : nodes) {
            System.out.print("Sommet " + node.getId() + " -> ");
            node.displayNeighbors();
        }
    }
}
