package hex.jeu.Plateau;

import hex.jeu.IPlateau;

public abstract class Plateau implements IPlateau {

    public boolean estVide(int i) {
        if (i == VIDE) return true;
        return false;
    }

    public boolean estBlanc(int i) {
        if (i == BLANC) return true;
        return false;
    }

    public boolean estNoir(int i) {
        if (i == NOIR) return true;
        return false;
    }
}
