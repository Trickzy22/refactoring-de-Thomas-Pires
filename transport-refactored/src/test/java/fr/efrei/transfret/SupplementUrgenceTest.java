package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplementUrgenceTest {

    private Prix base = new PrixDeBase(new TarifRoute());

    @Test
    void majoration_de_50_pourcent() {
        List<Colis> colis = List.of(new Colis("test", 50, 10, 10, 10, TypeMarchandise.STANDARD, 100));
        assertEquals(187.5, new SupplementUrgence(base).calculer(colis, 100), 0.001);
    }
}
