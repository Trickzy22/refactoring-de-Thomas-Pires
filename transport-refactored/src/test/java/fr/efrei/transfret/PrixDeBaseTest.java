package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrixDeBaseTest {

    @Test
    void utilise_le_tarif_du_mode() {
        List<Colis> colis = List.of(new Colis("test", 50, 10, 10, 10, TypeMarchandise.STANDARD, 100));
        assertEquals(125, new PrixDeBase(new TarifRoute()).calculer(colis, 100), 0.001);
    }
}
