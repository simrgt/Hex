package hex.ihm;

import hex.jeu.IPlateau;
import hex.jeu.Plateau.Coordonnee;

public interface IIhm {
    void afficherPlateau(IPlateau p);

    Coordonnee jouerTour(IPlateau p);

    void finPartie();
    int choixTaille();

    void afficherJoueur(int j);
}
