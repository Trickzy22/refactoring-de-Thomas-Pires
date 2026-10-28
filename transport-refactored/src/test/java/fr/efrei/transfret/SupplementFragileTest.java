package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplementFragileTest {

    private Prix base = new PrixDeBase(new TarifRoute());

    @Test
    void supplement_si_un_colis_est_fragile() {
        List<Colis> colis = List.of(new Colis("test", 50, 10, 10, 10, TypeMarchandise.FRAGILE, 100));
        assertEquals(143.75, new SupplementFragile(base).calculer(colis, 100), 0.001);
    }

    @Test
    void pas_de_supplement_sinon() {
        List<Colis> colis = List.of(new Colis("test", 50, 10, 10, 10, TypeMarchandise.STANDARD, 100));
        assertEquals(125, new SupplementFragile(base).calculer(colis, 100), 0.001);
    }
}
