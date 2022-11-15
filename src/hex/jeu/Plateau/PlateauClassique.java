package hex.jeu.Plateau;


import java.util.ArrayList;

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

    public int getTaille() {
        return plateau.length;
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

    private ArrayList<Coordonnee> autourCase(Coordonnee c, Coordonnee origin) {
        int position = plateau[c.getX()][c.getY()];
        ArrayList<Coordonnee> autour = new ArrayList<>();
        if (origin == null || (origin.getX() != c.getX() && origin.getY() != c.getY())) {
            if (c.getX() == 0 && c.getY() == 0) {
                if (plateau[c.getX()][c.getY() + 1] == position && origin.getX() != c.getX() && origin.getY() != 0)
                    autour.add(new Coordonnee(c.getX(), c.getY() + 1));
                if (plateau[c.getX() + 1][c.getY()] == position) autour.add(new Coordonnee(c.getX() + 1, c.getY()));
            } else if (c.getX() == 0 && c.getY() == plateau.length-1) {
                if (plateau[c.getX() + 1][c.getY()] == position) autour.add(new Coordonnee(c.getX() + 1, c.getY()));
                if (plateau[c.getX() + 1][c.getY() - 1] == position)
                    autour.add(new Coordonnee(c.getX() + 1, c.getY() - 1));
                if (plateau[c.getX()][c.getY() - 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() - 1));
            } else if (c.getX() == plateau.length-1 && c.getY() == 0) {
                if (plateau[c.getX() - 1][c.getY()] == position) autour.add(new Coordonnee(c.getX() - 1, c.getY()));
                if (plateau[c.getX() - 1][c.getY() + 1] == position)
                    autour.add(new Coordonnee(c.getX() - 1, c.getY() + 1));
                if (plateau[c.getX()][c.getY() + 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() + 1));
            } else if (c.getX() == plateau.length && c.getY() == plateau.length-1) {
                if (plateau[c.getX() - 1][c.getY()] == position) autour.add(new Coordonnee(c.getX() - 1, c.getY()));
                if (plateau[c.getX()][c.getY() - 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() - 1));
            } else if (c.getX() == 0) {
                if (plateau[c.getX()][c.getY() + 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() + 1));
                if (plateau[c.getX() + 1][c.getY()] == position) autour.add(new Coordonnee(c.getX() + 1, c.getY()));
                if (plateau[c.getX() + 1][c.getY() - 1] == position)
                    autour.add(new Coordonnee(c.getX() + 1, c.getY() - 1));
                if (plateau[c.getX()][c.getY() - 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() - 1));
            } else if (c.getX() == plateau.length-1) {
                if (plateau[c.getX()][c.getY() - 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() - 1));
                if (plateau[c.getX() - 1][c.getY() + 1] == position)
                    autour.add(new Coordonnee(c.getX() - 1, c.getY() + 1));
                if (plateau[c.getX()][c.getY() + 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() + 1));
                if (plateau[c.getX()][c.getY() - 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() - 1));
            } else if (c.getY() == 0) {
                if (plateau[c.getX() - 1][c.getY()] == position) autour.add(new Coordonnee(c.getX() - 1, c.getY()));
                if (plateau[c.getX() - 1][c.getY() + 1] == position)
                    autour.add(new Coordonnee(c.getX() - 1, c.getY() + 1));
                if (plateau[c.getX()][c.getY() + 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() + 1));
                if (plateau[c.getX() + 1][c.getY()] == position) autour.add(new Coordonnee(c.getX() + 1, c.getY()));
            } else if (c.getY() == plateau.length-1) {
                if (plateau[c.getX() - 1][c.getY()] == position) autour.add(new Coordonnee(c.getX() - 1, c.getY()));
                if (plateau[c.getX() + 1][c.getY()] == position) autour.add(new Coordonnee(c.getX() + 1, c.getY()));
                if (plateau[c.getX() + 1][c.getY() - 1] == position)
                    autour.add(new Coordonnee(c.getX() + 1, c.getY() - 1));
                if (plateau[c.getX()][c.getY() - 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() - 1));
            } else {
                if (plateau[c.getX() - 1][c.getY()] == position) autour.add(new Coordonnee(c.getX(), c.getY() - 1));
                if (plateau[c.getX() - 1][c.getY() + 1] == position)
                    autour.add(new Coordonnee(c.getX() - 1, c.getY() + 1));
                if (plateau[c.getX()][c.getY() + 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() + 1));
                if (plateau[c.getX() + 1][c.getY()] == position) autour.add(new Coordonnee(c.getX() + 1, c.getY()));
                if (plateau[c.getX() + 1][c.getY() - 1] == position)
                    autour.add(new Coordonnee(c.getX() + 1, c.getY() - 1));
                if (plateau[c.getX()][c.getY() - 1] == position) autour.add(new Coordonnee(c.getX(), c.getY() - 1));
            }
        }

        return autour;
    }

    private boolean verifCaseBlanc(Coordonnee c, Coordonnee origin) {
        for (Coordonnee coo : autourCase(c,origin)) {
            if (coo.getX() == plateau.length-1) return true;
            else verifCaseBlanc(coo,c);
        }
        return false;
    }

    private boolean verifCaseNoir(Coordonnee c, Coordonnee origin) {
        for (Coordonnee coo : autourCase(c,origin)) {
            if (coo.getY() == plateau.length-1) return true;
            else verifCaseBlanc(coo,c);
        }
        return false;
    }

    public boolean fini() {
        int rempli = 0;
        for (int i = 0; i < plateau.length; i++)
            for (int j = 0; j < plateau[i].length; j++)
                if (estBlanc(plateau[i][j]) || estNoir(plateau[i][j])) rempli++;

        for (int i = 0; i < plateau.length; i++) {
            if (plateau[i][0] == BLANC) {
                Coordonnee c = new Coordonnee(i,0);
                if (verifCaseBlanc(c,null)) return true;
            }
            if (plateau[0][i] == NOIR) {
                Coordonnee c = new Coordonnee(i,0);
                if (verifCaseNoir(c,null)) return true;
            }
        }

        if (rempli == caseTotal) return true;


        return false;
    }

    public void jouerTour(Coordonnee i, int j) {
        plateau[i.getX()][i.getY()] = j;
    }
}
