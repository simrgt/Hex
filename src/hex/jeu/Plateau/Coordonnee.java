package hex.jeu.Plateau;

public class Coordonnee {
    private int x;
    private int y;

    public Coordonnee(int a, int b) {
        x = a;
        y = b;
    }

    public boolean estBonne(int taille) {
        if (x < taille && y < taille && x >= 0 && y >= 0) return true;
        return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
