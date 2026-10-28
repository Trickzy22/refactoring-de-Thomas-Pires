package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifAirTest {

    private TarifAir tarif = new TarifAir();

    @Test
    void poids_reel_si_plus_grand() {
        assertEquals(645, tarif.calculer(1000, 10, 0.01), 0.001);
    }

    @Test
    void poids_volumetrique_si_plus_grand() {
        assertEquals(1351.5, tarif.calculer(1000, 10, 1), 0.001);
    }
}
