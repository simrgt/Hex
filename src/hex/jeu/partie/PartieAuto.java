package hex.jeu.partie;

import hex.ihm.IIhm;
import hex.ihm.Interface;
import hex.jeu.IPlateau;
import hex.jeu.Plateau.PlateauClassique;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartieAuto implements IPartie{
    private final static int NBJOUEUR = 2;
    private String j1;
    private String j2;
    private IIhm ihm;
    private IPlateau plateau;

    public PartieAuto() {
        ihm = new Interface();
        plateau = new PlateauClassique(11);
    }

    public void lancerPartie() {
        initialiserJoueur();
        int joueurActif = 0;
        int[] i = new int[2];
        Scanner sc = new Scanner(System.in);
        File file = new File("test.txt");
        try {
            sc = new Scanner(file);
            while(!this.estFinie()) {
                if (sc.hasNextLine()) {
                    i[0] = sc.nextInt();
                    i[1] = sc.nextInt();
                    plateau.jouerTour(i, joueurActif);
                    ihm.afficherPlateau(plateau);
                    if (joueurActif == 0) joueurActif = 1;
                    else joueurActif = 0;
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ihm.afficherPlateau(plateau);
        sc.close();
    }

    public boolean estFinie() {
        return plateau.fini();
    }

    public void initialiserJoueur() {

    }
}
