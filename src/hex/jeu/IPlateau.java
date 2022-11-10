package hex.jeu;

public interface IPlateau {
    int BLANC = 0;
    int NOIR = 1;
    int VIDE = -1;
    boolean estVide(int i);

    boolean estBlanc(int i);

    boolean estNoir(int i);

    String toString();

    boolean fini();

    void jouerTour(int[] i, int j);
}
