package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TarifRouteTest {

    private TarifRoute tarif = new TarifRoute();

    @Test
    void prix_au_km_et_au_kg() {
        assertEquals(125, tarif.calculer(100, 50, 0), 0.001);
    }
}
