package hex.ihm;

import hex.jeu.IPlateau;
import hex.jeu.Plateau.Coordonnee;

import java.util.Scanner;

public class Interface implements IIhm{

    public void afficherPlateau(IPlateau p) {
        System.out.println(p);
    }

    public void afficherJoueur(int j) {
        if (j == 0) System.out.println("Vous êtes le joueur Blanc, vos pions sont les X");
        else if (j == 1) System.out.println("Vous êtes le joueur Noir, vos pions sont les O");
    }

    public Coordonnee jouerTour(IPlateau p) {
        System.out.println("Rentrez les coordonnées de votre coups de la manière suivante : Nombre Lettre");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt()-1;
        int b = Character.getNumericValue(sc.next().charAt(0))-10;
        Coordonnee i = new Coordonnee(a,b);
        while (!i.estBonne(p.getTaille())) {
            System.out.println("Remettre coordonnée");
            a = sc.nextInt()-1;
            b = Character.getNumericValue(sc.next().charAt(0))-11;
            i = new Coordonnee(a,b);
        }
        return i;
    }

    public void finPartie() {
        System.out.println("Fin de la partie");
    }

    public int choixTaille() {
        System.out.println("Vous voulez un plateau de taille :\n- 1 : 11x11\n- 2 : 13x13\n- 3 : 14x14\n- 4 : 19x19\n- 5 : Personnalisé");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix) {
            case 1 : return 11;
            case 2 : return 13;
            case 3 : return 14;
            case 4 : return 19;
            default:return 0;
        }
    }
}
