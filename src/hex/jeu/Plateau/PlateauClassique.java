package hex.jeu.Plateau;

import hex.jeu.Plateau.Plateau;

public class PlateauClassique extends Plateau {
    private int plateau[][];
    private int caseTotal;

    public PlateauClassique(int largeur) {
        assert(largeur == 11 || largeur ==  19 || largeur == 13 || largeur == 14);
        caseTotal = largeur*largeur;
        plateau = new int[largeur][largeur];
        for (int i = 0 ; i < largeur; i++)
            for (int j = 0; j < largeur; j++)
                plateau[i][j] = VIDE;
    }
    @Override
    public String toString() {
        String s = " ";
        for (int i = 65; i < plateau.length+65; i++)
            s+= " " + (char) i;
        s+="\n";

        for(int i = 0; i < plateau.length; i++) {
            s += i+1;
            int k = i;
            while (k > 0) {
                if (k >= 9) k--;
                s+= " ";
                k--;
            }
            for(int j = 0; j < plateau[i].length; j++) {
                if (estVide(plateau[i][j])) s+= " *";
                else if (estBlanc(plateau[i][j])) s+= " X";
                else if (estNoir(plateau[i][j])) s+= " O";
            }
            s+= "\n";
        }
        return s;
    }

    public boolean fini() {
        int rempli = 0;
        for (int i = 0; i < plateau.length; i++)
            for (int j = 0; j < plateau[i].length; j++)
                if (estBlanc(plateau[i][j]) || estNoir(plateau[i][j])) rempli++;

        if (rempli == caseTotal) return true;


        return false;
    }

    public void jouerTour(int[] i, int j) {
        plateau[i[0]][i[1]] = j;
    }
}
