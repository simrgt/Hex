package hex.ihm;

import hex.jeu.IPlateau;

public interface IIhm {
    void afficherPlateau(IPlateau p);

    int[] jouerTour(IPlateau p);
}
