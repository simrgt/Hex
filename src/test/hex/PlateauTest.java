package test.hex;

import hex.Plateau;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PlateauTest {

    @Test
    public void test() {
        final int largeur = 4;
        final int hauteur = 4;
        Plateau p = new Plateau(largeur,hauteur);
        System.out.println(p.toString());
        assertEquals(
                "  A B C D\n" +
                        "1 * * * *\n" +
                        "2  * * * *\n" +
                        "3   * * * *\n" +
                        "4    * * * *\n", p.toString());
    }

    @Test
    public void test1() {
        final int largeur = 55;
        final int hauteur = 55;
        Plateau p = new Plateau(largeur,hauteur);
        System.out.println(p.toString());
        assertEquals(
                "  A B C D\n" +
                        "1 * * * *\n" +
                        "2  * * * *\n" +
                        "3   * * * *\n" +
                        "4    * * * *\n", p.toString());
    }
}
