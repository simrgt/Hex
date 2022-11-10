package hex;

public class Plateau {
    private final static int BLANC = 0;
    private final static int NOIR = 1;
    private final static int VIDE = -1;
    private int plateau[][];
    public Plateau(int largeur, int hauteur) {
        plateau = new int[largeur][hauteur];
        for (int i = 0 ; i < largeur; i++)
            for (int j = 0; j < hauteur; j++)
                plateau[i][j] = VIDE;
    }

    @Override
    public String toString() {
        String s = "  A B C D\n";
        System.out.println(s);

        for(int i = 0; i < plateau.length; i++) {
            s += i+1;
            for (int k=0; k<i; k++){
                s+= " ";
            }
            for(int j = 0; j < plateau[i].length; j++) {
                s+= " *";
            }
            s+= "\n";
        }
        System.out.println(s);
        return s;
    }
}
