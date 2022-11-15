package test.hex;

import hex.jeu.IPlateau;
import hex.jeu.Plateau.PlateauClassique;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PlateauTest {

    @Test
    public void test() {
        final int largeur = 11;
        IPlateau p = new PlateauClassique(largeur);
        assertEquals(
                "  A B C D E F G H I J K\n" +
                        "1 * * * * * * * * * * *\n" +
                        "2  * * * * * * * * * * *\n" +
                        "3   * * * * * * * * * * *\n" +
                        "4    * * * * * * * * * * *\n" +
                        "5     * * * * * * * * * * *\n" +
                        "6      * * * * * * * * * * *\n" +
                        "7       * * * * * * * * * * *\n" +
                        "8        * * * * * * * * * * *\n" +
                        "9         * * * * * * * * * * *\n" +
                        "10         * * * * * * * * * * *\n" +
                        "11          * * * * * * * * * * *\n", p.toString());
    }

}
