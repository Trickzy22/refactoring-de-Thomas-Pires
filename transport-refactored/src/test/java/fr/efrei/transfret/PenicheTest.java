package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PenicheTest {

    private Peniche peniche = new Peniche("PEN-0001", 2500000);
    private List<Colis> colis = List.of(new Colis("test", 50, 10, 10, 10, TypeMarchandise.STANDARD, 100));

    @Test
    void transporte_en_fluvial() {
        assertTrue(peniche.peutTransporter(colis, ModeTransport.FLUVIAL));
    }

    @Test
    void ne_transporte_pas_par_route() {
        assertFalse(peniche.peutTransporter(colis, ModeTransport.ROUTE));
    }
}
