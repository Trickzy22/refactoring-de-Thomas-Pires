package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifMerTest {

    private TarifMer tarif = new TarifMer();

    @Test
    void prix_au_km_et_au_kg() {
        assertEquals(1030, tarif.calculer(2000, 1000, 0), 0.001);
    }

    @Test
    void minimum_de_500() {
        assertEquals(500, tarif.calculer(100, 10, 0), 0.001);
    }
}
