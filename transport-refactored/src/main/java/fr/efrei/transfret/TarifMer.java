package fr.efrei.transfret;

public class TarifMer implements TarifTransport {

    public static final double PRIX_KM = 0.5;
    public static final double PRIX_KG = 0.03;
    public static final double MINIMUM = 500;

    public double calculer(int distance, double poids, double volume) {
        double prix = distance * PRIX_KM + poids * PRIX_KG;
        if (prix < MINIMUM) prix = MINIMUM;
        return prix;
    }
}
