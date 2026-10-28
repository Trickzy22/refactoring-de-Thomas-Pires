package fr.efrei.transfret;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemiseEntrepriseTest {

    private RemiseEntreprise remise = new RemiseEntreprise();

    @Test
    void remise_de_10_pourcent() {
        assertEquals(900, remise.appliquer(1000), 0.001);
    }

    @Test
    void remise_de_15_pourcent_au_dessus_de_5000() {
        assertEquals(5100, remise.appliquer(6000), 0.001);
    }
}
