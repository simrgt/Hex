package hex.jeu.partie;

import hex.ihm.IIhm;
import hex.ihm.Interface;
import hex.jeu.IPlateau;
import hex.jeu.Plateau.PlateauClassique;

import java.util.Scanner;

public class PartieClassique implements IPartie {
    private final static int NBJOUEUR = 2;
    private String j1;
    private String j2;
    private IIhm ihm;
    private IPlateau plateau;

    public PartieClassique() {
        ihm = new Interface();
        plateau = new PlateauClassique(11);
    }

    public void lancerPartie() {
        initialiserJoueur();
        int joueurActif = 0;
        while(!this.estFinie()) {
            lancerTour(joueurActif);
            if (joueurActif == 0) joueurActif = 1;
            else joueurActif = 0;
        }
    }

    public boolean estFinie() {
        return plateau.fini();
    }

    public void initialiserJoueur() {

    }

    public void lancerTour(int j) {
        ihm.afficherPlateau(plateau);
        int[] jeuTour = ihm.jouerTour(plateau);
        plateau.jouerTour(jeuTour, j);
    }
}
