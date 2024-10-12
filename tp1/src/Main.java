import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * Retourne la liste des voisins d'un sommet dans un graphe représenté par une matrice d'adjacence.
     * @param matriceAdjacence matrice d'adjacence du graphe
     * @param sommet sommet dont on veut les voisins
     * @return liste des voisins du sommet
     */
    public static List<Integer> getVoisins(int[][] matriceAdjacence, int sommet) {
        List<Integer> voisins = new ArrayList<>();

        // Vérifie si le sommet est valide
        if (sommet < 0 || sommet >= matriceAdjacence.length) {
            throw new IllegalArgumentException("Sommet invalide.");
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

    public static void main(String[] args) {
        // Matrice d'adjacence
        int[][] matriceAdjacence = {
                {0, 1, 0, 0},
                {1, 0, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0}
        };

        // Sommet dont on veut les voisins
        int sommet0 = 0;
        int sommet1 = 1;
        int sommet2 = 2;
        int sommet3 = 3;

        // Appel de la fonction et affichage des voisins
        List<Integer> voisins0 = getVoisins(matriceAdjacence, sommet0);
        System.out.println("Les voisins du sommet " + sommet0 + " sont : " + voisins0);

        List<Integer> voisins1 = getVoisins(matriceAdjacence, sommet1);
        System.out.println("Les voisins du sommet " + sommet1 + " sont : " + voisins1);

        List<Integer> voisins2 = getVoisins(matriceAdjacence, sommet2);
        System.out.println("Les voisins du sommet " + sommet2 + " sont : " + voisins2);

        List<Integer> voisins3 = getVoisins(matriceAdjacence, sommet3);
        System.out.println("Les voisins du sommet " + sommet3 + " sont : " + voisins3);
    }
}
