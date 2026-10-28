package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SupplementDangereuxTest {

    private Prix base = new PrixDeBase(new TarifRoute());

    @Test
    void supplement_si_un_colis_est_dangereux() {
        List<Colis> colis = List.of(new Colis("test", 50, 10, 10, 10, TypeMarchandise.DANGEREUX, 100));
        assertEquals(162.5, new SupplementDangereux(base).calculer(colis, 100), 0.001);
    }

    @Test
    void pas_de_supplement_sinon() {
        List<Colis> colis = List.of(new Colis("test", 50, 10, 10, 10, TypeMarchandise.STANDARD, 100));
        assertEquals(125, new SupplementDangereux(base).calculer(colis, 100), 0.001);
    }
}
