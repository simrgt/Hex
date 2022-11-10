package hex.main;

import hex.jeu.partie.IPartie;
import hex.jeu.partie.PartieAuto;
import hex.jeu.partie.PartieClassique;

public class Main {

    public static void main(String[] args) {
        IPartie p = new PartieAuto();
        p.lancerPartie();
    }
}
