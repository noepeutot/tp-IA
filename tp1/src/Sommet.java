import java.util.Arrays;

public class Sommet {
    private int id;
    private Sommet[] voisins;

    public Sommet(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Sommet[] getVoisins() {
        return voisins;
    }

    public void setVoisins(Sommet[] voisins) {
        this.voisins = voisins;
    }

    public String toString() {
        String res = "Sommet " + id + " : ";
        if (voisins != null) {
            for (Sommet voisin : voisins) {
                res += voisin.getId() + " ";
            }
        }
        return res;
    }

    public void addVoisin(Sommet voisin) {
        if (voisins == null) {
            voisins = new Sommet[1];
            voisins[0] = voisin;
        } else {
            voisins = Arrays.copyOf(voisins, voisins.length + 1);
            voisins[voisins.length - 1] = voisin;
        }
    }
}