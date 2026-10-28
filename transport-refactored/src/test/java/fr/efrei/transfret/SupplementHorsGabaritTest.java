package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplementHorsGabaritTest {

    private Prix base = new PrixDeBase(new TarifRoute());

    @Test
    void supplement_si_un_colis_depasse_200_cm() {
        List<Colis> colis = List.of(new Colis("test", 50, 250, 10, 10, TypeMarchandise.STANDARD, 100));
        assertEquals(137.5, new SupplementHorsGabarit(base).calculer(colis, 100), 0.001);
    }

    @Test
    void pas_de_supplement_sinon() {
        List<Colis> colis = List.of(new Colis("test", 50, 200, 10, 10, TypeMarchandise.STANDARD, 100));
        assertEquals(125, new SupplementHorsGabarit(base).calculer(colis, 100), 0.001);
    }
}
