package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssuranceTest {

    private Prix base = new PrixDeBase(new TarifRoute());

    @Test
    void ajoute_2_pourcent_de_la_valeur() {
        List<Colis> colis = List.of(new Colis("test", 50, 10, 10, 10, TypeMarchandise.STANDARD, 10000));
        assertEquals(325, new Assurance(base).calculer(colis, 100), 0.001);
    }

    @Test
    void minimum_de_15() {
        List<Colis> colis = List.of(new Colis("test", 50, 10, 10, 10, TypeMarchandise.STANDARD, 100));
        assertEquals(140, new Assurance(base).calculer(colis, 100), 0.001);
    }
}
