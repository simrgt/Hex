package hex.jeu.partie;

import hex.ihm.Graphique;
import hex.ihm.IIhm;
import hex.ihm.Interface;
import hex.jeu.IPlateau;
import hex.jeu.Plateau.Coordonnée;
import hex.jeu.Plateau.PlateauClassique;


public class PartieClassique implements IPartie {
    private IIhm ihm;
    private IPlateau plateau;

    public PartieClassique(int i) {
        System.out.println(i);
        if (i == 1) ihm = new Interface();
        else if (i == 2) ihm = new Graphique();
        int c = ihm.choixTaille();
        plateau = new PlateauClassique(c);
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
        ihm.afficherJoueur(j);
        Coordonnée jeuTour;
        jeuTour = ihm.jouerTour(plateau);
        plateau.jouerTour(jeuTour, j);
    }
}
