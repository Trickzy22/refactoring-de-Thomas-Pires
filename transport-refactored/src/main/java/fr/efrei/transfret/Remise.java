package fr.efrei.transfret;

import java.util.List;

public class Remise extends DecorateurPrix {

    private PolitiqueRemise politique;

    public Remise(Prix prix, PolitiqueRemise politique) {
        super(prix);
        this.politique = politique;
    }

    public double calculer(List<Colis> colis, int distance) {
        return politique.appliquer(prix.calculer(colis, distance));
    }
}
