import java.util.*;

public class Main {

    /**
     * Retourne la liste des voisins d'un sommet dans un graphe représenté par une matrice d'adjacence.
     *
     * @param matriceAdjacence matrice d'adjacence du graphe
     * @param sommet           sommet dont on veut les voisins
     * @return liste des voisins du sommet
     */
    public static List<Integer> getVoisins(int[][] matriceAdjacence, int sommet) {
        List<Integer> voisins = new ArrayList<>();

        // Vérifie si le sommet est valide
        if (sommet < 0 || sommet >= matriceAdjacence.length) {
            throw new IllegalArgumentException("Sommet invalide :" + sommet);
        }

        // Parcourt la ligne correspondant au sommet dans la matrice d'adjacence
        for (int i = 0; i < matriceAdjacence[sommet].length; i++) {
            // Si la valeur est 1, cela signifie qu'il y a une arête entre le sommet et le sommet i
            if (matriceAdjacence[sommet][i] == 1) {
                voisins.add(i);
            }
        }

        return voisins;
    }

    /**
     * Retourne la liste des voisins de chaque sommet dans un graphe représenté par une matrice d'adjacence.
     *
     * @param matriceAdjacence matrice d'adjacence du graphe
     * @return liste des voisins de chaque sommet
     */
    public static List<List<Integer>> getVoisins(int[][] matriceAdjacence) {
        List<List<Integer>> voisins = new ArrayList<>();

        // Parcourt chaque sommet
        for (int i = 0; i < matriceAdjacence.length; i++) {
            voisins.add(getVoisins(matriceAdjacence, i));
        }

        return voisins;
    }

    /**
     * Retourne la liste des voisins d'un sommet donné dans une liste d'adjacence.
     *
     * @param listeAdjacence liste d'adjacence du graphe
     * @param sommet         sommet dont on veut les voisins
     * @return liste des voisins du sommet
     */
    public static List<String> getVoisins(Map<String, List<String>> listeAdjacence, String sommet) {
        List<String> voisins;

        // Vérifie si le sommet est présent dans la liste d'adjacence
        if (!listeAdjacence.containsKey(sommet)) {
            throw new IllegalArgumentException("Sommet invalide : " + sommet);
        }

        // Récupère la liste des voisins du sommet
        voisins = listeAdjacence.get(sommet);

        return voisins;
    }

    public static void main(String[] args) {
        // Matrice d'adjacence
        int[][] matriceAdjacence = {
                {0, 1, 0, 0},
                {1, 0, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0}
        };

        // Affichage de la matrice d'adjacence
        System.out.println("Matrice d'adjacence : ");
        for (int[] ligne : matriceAdjacence) {
            System.out.println(Arrays.toString(ligne));
        }

        System.out.println(System.lineSeparator() + "===================");
        System.out.println("Exercice 1 : Liste des voisins d'un sommet");
        System.out.println("===================" + System.lineSeparator());

        // Sommet dont on veut les voisins
        int sommet0 = 0;
        int sommet3 = 3;
        int sommetInvalide4 = 4;

        // Appel de la fonction et affichage des voisins
        List<Integer> voisins0 = getVoisins(matriceAdjacence, sommet0);
        System.out.println("Les voisins du sommet " + sommet0 + " sont : " + voisins0);

        List<Integer> voisins3 = getVoisins(matriceAdjacence, sommet3);
        System.out.println("Les voisins du sommet " + sommet3 + " sont : " + voisins3);

        try {
            getVoisins(matriceAdjacence, sommetInvalide4);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(System.lineSeparator() + "===================");
        System.out.println("Exercice 2 : Liste des voisins de chaque sommet");
        System.out.println("===================" + System.lineSeparator());
        // Appel de la fonction et affichage des voisins de chaque sommet
        List<List<Integer>> voisins = getVoisins(matriceAdjacence);
        for (int i = 0; i < voisins.size(); i++) {
            System.out.println("Les voisins du sommet " + i + " sont : " + voisins.get(i));
        }

        System.out.println(System.lineSeparator() + "===================");
        System.out.println("Exercice 3 : Liste des voisins d'un sommet (Hachage)");
        System.out.println("===================" + System.lineSeparator());

        // Exemple de liste d'adjacence
        Map<String, List<String>> listeAdjacence = new HashMap<>();
        listeAdjacence.put("A", List.of("B"));
        listeAdjacence.put("B", Arrays.asList("A", "C", "D"));
        listeAdjacence.put("C", Arrays.asList("B", "D"));
        listeAdjacence.put("D", Arrays.asList("B", "C"));

        // Sommet dont on veut les voisins
        String sommet = "B";

        // Appel de la fonction et affichage des voisins
        List<String> voisinsMap = getVoisins(listeAdjacence, sommet);
        System.out.println("Les voisins du sommet " + sommet + " sont : " + voisinsMap);

        String sommetInvalideE = "E";
        try {
            getVoisins(listeAdjacence, sommetInvalideE);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(System.lineSeparator() + "===================");
        System.out.println("Exercice 4 : Graphe orienté");
        System.out.println("===================" + System.lineSeparator());

        Graph graph = new Graph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");

        graph.addNode(nodeA);
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);

        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeB, nodeC);
        graph.addEdge(nodeB, nodeD);
        graph.addEdge(nodeC, nodeD);
        graph.addEdge(nodeD, nodeE);

        graph.displayGraph();

        System.out.println(System.lineSeparator() + "===================");
        System.out.println("Exercice 5 : BFS et DFS");
        System.out.println("===================" + System.lineSeparator());

        System.out.println("Parcours en largeur (BFS) à partir du noeud A :");
        graph.bfs(nodeA);

        System.out.println("Parcours en profondeur (DFS) à partir du noeud A :");
        graph.dfs(nodeA);

        System.out.println("Parcours en profondeur (DFS) à partir du noeud C :");
        graph.dfs(nodeC);

        System.out.println("Parcours en profondeur (DFS) à partir du noeud C :");
        graph.dfs(nodeC);

        System.out.println(System.lineSeparator() + "===================");
        System.out.println("Exercice 6 : Début et fin chemin + Affichage du chemin");
        System.out.println("===================" + System.lineSeparator());

        Node start = nodeA;
        Node end = nodeD;

        System.out.println("Chemin entre " + start.getId() + " et " + end.getId() + " :");
        List<Node> path = graph.findPath(start, end);
        graph.displayPath(path);

        start = nodeB;
        end = nodeA;

        System.out.println(System.lineSeparator() + "Chemin entre " + start.getId() + " et " + end.getId() + " :");
        path = graph.findPath(start, end);
        graph.displayPath(path);

        System.out.println(System.lineSeparator() + "===================");
        System.out.println("Exercice 7 : GrapheGrid");
        System.out.println("===================" + System.lineSeparator());

        GraphGrid graphGrid = new GraphGrid(5, 5);

        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");
        Node nodeJ = new Node("J");

        graphGrid.addNode(nodeF);
        graphGrid.addNode(nodeG);
        graphGrid.addNode(nodeH);
        graphGrid.addNode(nodeI);
        graphGrid.addNode(nodeJ);

        graphGrid.addEdge(nodeF, nodeG);
        graphGrid.addEdge(nodeG, nodeH);
        graphGrid.addEdge(nodeG, nodeI);
        graphGrid.addEdge(nodeH, nodeI);
        graphGrid.addEdge(nodeI, nodeJ);

        // Ajouter des obstacles
        graphGrid.addWall(1, 1);
        graphGrid.addWall(2, 2);
        graphGrid.addWall(3, 3);

        // Afficher la grille
        System.out.println("Grille avec obstacles :");
        graphGrid.displayGrid();

        // Afficher les voisins des sommets
        for (Node node : graphGrid.getNodes()) {
            System.out.print("Les voisins du sommet " + node.getId() + " sont : ");
            for (Node neighbor : graphGrid.getNeighbors(node)) {
                System.out.print(neighbor.getId() + " ");
            }
            System.out.println();
        }
    }
}
