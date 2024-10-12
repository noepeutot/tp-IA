public class Graphe {
    private Sommet[] sommets;

    public Graphe(Sommet[] sommets) {
        this.sommets = sommets;
    }

    public Sommet[] getSommets() {
        return sommets;
    }

    public void setSommets(Sommet[] sommets) {
        this.sommets = sommets;
    }

    public String toString() {
        String res = "";
        for (Sommet sommet : sommets) {
            res += sommet + "\n";
        }
        return res;
    }
}