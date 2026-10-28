package fr.efrei.transfret;

import java.util.List;

public class SupplementHorsGabarit extends DecorateurPrix {

    public static final double COEF = 1.10;
    public static final double DIMENSION_MAX = 200;

    public SupplementHorsGabarit(Prix prix) {
        super(prix);
    }

    public double calculer(List<Colis> colis, int distance) {
        double resultat = prix.calculer(colis, distance);
        for (Colis c : colis) {
            if (c.getLongueur() > DIMENSION_MAX || c.getLargeur() > DIMENSION_MAX || c.getHauteur() > DIMENSION_MAX) {
                return resultat * COEF;
            }
        }
        return resultat;
    }
}
