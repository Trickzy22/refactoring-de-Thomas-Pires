package fr.efrei.transfret;

import java.util.List;

public class Assurance extends DecorateurPrix {

    public static final double TAUX = 0.02;
    public static final double MINIMUM = 15;

    public Assurance(Prix prix) {
        super(prix);
    }

    public double calculer(List<Colis> colis, int distance) {
        double valeur = 0;
        for (Colis c : colis) {
            valeur = valeur + c.getValeurDeclaree();
        }
        double montantAssurance = valeur * TAUX;
        if (montantAssurance < MINIMUM) montantAssurance = MINIMUM;
        return prix.calculer(colis, distance) + montantAssurance;
    }
}
