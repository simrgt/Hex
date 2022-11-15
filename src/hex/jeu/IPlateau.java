package hex.jeu;

import hex.jeu.Plateau.Coordonnee;

public interface IPlateau {
    int BLANC = 0;
    int NOIR = 1;
    int VIDE = -1;
    int getTaille();
    boolean estVide(int i);

    boolean estBlanc(int i);

    boolean estNoir(int i);

    String toString();

    boolean fini();

    void jouerTour(Coordonnee i, int j);
}
