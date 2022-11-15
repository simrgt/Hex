package hex.ihm;

import hex.jeu.IPlateau;
import hex.jeu.Plateau.Coordonnee;

import javax.swing.*;
import java.util.Scanner;

public class Graphique implements IIhm{

    public void afficherPlateau(IPlateau p) {
        System.out.println(p);
    }

    @Override
    public void afficherJoueur(int j) {

    }

    public Coordonnee jouerTour(IPlateau p) {
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);
        frame.setVisible(true);
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        Coordonnee i = new Coordonnee(a,b);
        while (!i.estBonne(p.getTaille())) {
            System.out.println("Remettre coordonnée");
            i = new Coordonnee(sc.nextInt(),sc.nextInt());
        }
        return i;
    }

    public void finPartie() {
        System.out.println("Fin de la partie");
    }

    @Override
    public int choixTaille() {
        return 0;
    }
}
