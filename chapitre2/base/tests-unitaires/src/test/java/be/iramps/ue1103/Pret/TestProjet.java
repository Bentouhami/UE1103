package be.iramps.ue1103.Pret;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestProjet {
    private static Projet projet;

    @BeforeAll
    public static void setup() {
        projet = new Projet();
    }

    @Test
    public void calculTvaFraisTransformationValeurPositif() {

        Assertions.assertAll(

                () -> {
                    projet.setFraisTransformation(90_000.00);
                    Assertions.assertEquals(5_400.00, projet.calculTVAFraisTransformation());
                },

                () -> {
                    projet.setFraisTransformation(0.00);
                    Assertions.assertEquals(0.00, projet.calculTVAFraisTransformation());
                },

                () -> {
                    projet.setFraisTransformation(100_000.00);
                    Assertions.assertEquals(6_000.00, projet.calculTVAFraisTransformation());
                },

                () -> {
                    projet.setFraisTransformation(59_595.00);
                    Assertions.assertEquals(3_575.70, projet.calculTVAFraisTransformation());
                },

                () -> {
                    projet.setFraisTransformation(1.00);
                    Assertions.assertEquals(0.06, projet.calculTVAFraisTransformation());
                });

    }

    @Disabled
    @Test
    public void calculTvaFraisTransformationValeurNegatif() {

        Assertions.assertThrows(Exception.class, () -> {
            projet.setFraisTransformation(-1.00);
            projet.calculTVAFraisTransformation();

        });
    }

}
