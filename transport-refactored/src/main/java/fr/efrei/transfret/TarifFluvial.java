package fr.efrei.transfret;

public class TarifFluvial implements TarifTransport {

    public static final double PRIX_KM = 0.40;
    public static final double PRIX_KG = 0.02;
    public static final double MINIMUM = 300;

    public double calculer(int distance, double poids, double volume) {
        double prix = distance * PRIX_KM + poids * PRIX_KG;
        if (prix < MINIMUM) prix = MINIMUM;
        return prix;
    }
}
