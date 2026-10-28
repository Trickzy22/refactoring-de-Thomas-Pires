package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifFluvialTest {

    private TarifFluvial tarif = new TarifFluvial();

    @Test
    void prix_au_km_et_au_kg() {
        assertEquals(420, tarif.calculer(1000, 1000, 0), 0.001);
    }

    @Test
    void minimum_de_300() {
        assertEquals(300, tarif.calculer(100, 10, 0), 0.001);
    }
}
