package fr.efrei.transfret;

import java.util.List;

public class SupplementRefrigere extends DecorateurPrix {

    public static final double COEF = 1.20;

    public SupplementRefrigere(Prix prix) {
        super(prix);
    }

    public double calculer(List<Colis> colis, int distance) {
        double resultat = prix.calculer(colis, distance);
        for (Colis c : colis) {
            if (c.getType() == TypeMarchandise.REFRIGERE) {
                return resultat * COEF;
            }
        }
        return resultat;
    }
}
