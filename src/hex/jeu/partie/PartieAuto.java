package hex.jeu.partie;

import hex.ihm.IIhm;
import hex.ihm.Interface;
import hex.jeu.IPlateau;
import hex.jeu.Plateau.Coordonnee;
import hex.jeu.Plateau.PlateauClassique;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartieAuto implements IPartie{
    private final static int NBJOUEUR = 2;
    private String j1;
    private String j2;
    private int coupsJoues = 0;
    private IIhm ihm;
    private IPlateau plateau;

    public PartieAuto(int i) {
        ihm = new Interface();
        plateau = new PlateauClassique(11);
    }

    public void lancerPartie() {
        initialiserJoueur();
        int joueurActif = 0;
        Scanner sc;
        File file = new File("test2.txt");
        try {
            sc = new Scanner(file);
            if (sc.hasNextLine()) {
                while(!this.estFinie()) {
                    Coordonnee i = new Coordonnee(sc.nextInt()-1, (sc.next().charAt(0))-65);
                    while (!i.estBonne(plateau.getTaille())) {
                        System.out.println("Remettre coordonnée");
                        i = new Coordonnee(sc.nextInt()-1, (sc.next().charAt(0))-65);
                    }
                    plateau.jouerTour(i, joueurActif);
                    ihm.afficherPlateau(plateau);
                    if (joueurActif == 0) joueurActif = 1;
                    else joueurActif = 0;
                }
                ihm.finPartie();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.close();
    }

    public boolean estFinie() {
        return plateau.fini();
    }

    public void initialiserJoueur() {

    }
}
