package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifRailTest {

    private TarifRail tarif = new TarifRail();

    @Test
    void prix_au_km_et_au_kg() {
        assertEquals(470, tarif.calculer(500, 1000, 0), 0.001);
    }

    @Test
    void minimum_de_150() {
        assertEquals(150, tarif.calculer(100, 10, 0), 0.001);
    }
}
