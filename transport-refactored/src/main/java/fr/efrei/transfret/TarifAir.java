package fr.efrei.transfret;

public class TarifAir implements TarifTransport {

    public static final double PRIX_KM = 0.6;
    public static final double PRIX_KG = 4.5;
    public static final double COEF_POIDS_VOLUMETRIQUE = 167;

    public double calculer(int distance, double poids, double volume) {
        double poidsTaxable = poids;
        if (volume * COEF_POIDS_VOLUMETRIQUE > poids) {
            poidsTaxable = volume * COEF_POIDS_VOLUMETRIQUE;
        }
        return distance * PRIX_KM + poidsTaxable * PRIX_KG;
    }
}
