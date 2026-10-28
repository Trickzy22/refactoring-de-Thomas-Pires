package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemiseTest {

    private Prix base = new PrixDeBase(new TarifRoute());

    @Test
    void applique_la_politique_de_remise() {
        List<Colis> colis = List.of(new Colis("test", 50, 10, 10, 10, TypeMarchandise.STANDARD, 100));
        assertEquals(100, new Remise(base, new RemisePremium()).calculer(colis, 100), 0.001);
    }
}
