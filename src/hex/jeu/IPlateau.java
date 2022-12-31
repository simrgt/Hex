package hex.jeu;

import hex.jeu.Plateau.Coordonnee;
import hex.jeu.Plateau.Pion;

public interface IPlateau {
    int BLANC = 0;
    int NOIR = 1;
    int VIDE = -1;
    int NB_Joueurs = 2;
    int getTaille();
    boolean estVide(int i);

    boolean estBlanc(int i);

    boolean estNoir(int i);

    String toString();

    boolean fini();

    void jouerTour(Coordonnee i, int j);

    Pion getCase(String b2);
}
