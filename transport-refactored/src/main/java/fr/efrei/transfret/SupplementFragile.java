package fr.efrei.transfret;

import java.util.List;

public class SupplementFragile extends DecorateurPrix {

    public static final double COEF = 1.15;

    public SupplementFragile(Prix prix) {
        super(prix);
    }

    public double calculer(List<Colis> colis, int distance) {
        double resultat = prix.calculer(colis, distance);
        for (Colis c : colis) {
            if (c.getType() == TypeMarchandise.FRAGILE) {
                return resultat * COEF;
            }
        }
        return resultat;
    }
}
