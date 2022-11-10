package hex.main;

import hex.jeu.partie.IPartie;
import hex.jeu.partie.PartieAuto;
import hex.jeu.partie.PartieClassique;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean jouer = true;
        boolean jouer2;
        int choix;
        while(jouer) {
            jouer2 = true;
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez vous un affichage console ou graphique ? (entrez le chiffre de votre choix)\n- 1 : Console\n- 2 : Graphique\n- 3 : Quitter");
            choix = sc.nextInt();
            if (choix == 1) {
                while(jouer2) {
                    System.out.println("Voulez vous jouer une partie à partir d'un script ou vous même ?\n- 1 : Script\n- 2 : Manuelle\n- 3 : Revenir au menu précédent\n- 4 : Quitter");
                    choix = sc.nextInt();
                    if (choix == 1) {
                        IPartie p = new PartieAuto(1);
                        p.lancerPartie();
                    } else if (choix == 2) {
                        IPartie p = new PartieClassique(1);
                        p.lancerPartie();
                        jouer2=false;
                        jouer=false;
                    } else if (choix == 3) {
                        jouer2 = false;
                    } else if (choix == 4) {
                        jouer2=false;
                        jouer=false;
                    }
                }
            } else if (choix == 2) {

            } else if (choix == 3) {
                System.out.println("Fermeture du programme");
                jouer = false;
                sc.close();

            } else {
                System.out.println("Commande invalide, réesayez.");
            }
        }

    }
}
