package hex.ihm;

import hex.jeu.IPlateau;
import hex.jeu.Plateau.Coordonnée;

public interface IIhm {
    void afficherPlateau(IPlateau p);

    Coordonnée jouerTour(IPlateau p);

    void finPartie();
    int choixTaille();

    void afficherJoueur(int j);
}
