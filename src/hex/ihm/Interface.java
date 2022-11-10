package hex.ihm;

import hex.jeu.IPlateau;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Interface implements IIhm{

    public void afficherPlateau(IPlateau p) {
        System.out.println(p);
    }

    public int[] jouerTour(IPlateau p) {
        int[] i = new int[2];
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            i[0] = sc.nextInt();
            i[1] = sc.nextInt();
        }
        sc.close();
        return i;
    }
}
