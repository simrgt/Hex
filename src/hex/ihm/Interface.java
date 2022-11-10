package hex.ihm;

import hex.jeu.IPlateau;
import hex.jeu.Plateau.Coordonnée;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Interface implements IIhm{

    public void afficherPlateau(IPlateau p) {
        System.out.println(p);
    }

    public Coordonnée jouerTour(IPlateau p) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Coordonnée i = new Coordonnée(a,b);
        while (!i.estBonne(p.getTaille())) {
            System.out.println("Remettre coordonnée");
            i = new Coordonnée(sc.nextInt(),sc.nextInt());
        }
        return i;
    }

    public void finPartie() {
        System.out.println("Fin de la partie");
    }
}
