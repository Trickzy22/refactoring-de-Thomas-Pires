package fr.efrei.transfret;

import java.util.List;

public class SupplementUrgence extends DecorateurPrix {

    public static final double COEF = 1.5;

    public SupplementUrgence(Prix prix) {
        super(prix);
    }

    public double calculer(List<Colis> colis, int distance) {
        return prix.calculer(colis, distance) * COEF;
    }
}
