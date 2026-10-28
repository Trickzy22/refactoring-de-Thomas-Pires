package fr.efrei.transfret;

public class EstimateurDelai {

    public static final double VITESSE_ROUTE = 70.0;
    public static final int HEURES_CONDUITE_PAR_JOUR = 9;
    public static final int HEURES_CONDUITE_PAR_JOUR_URGENT = 18;
    public static final double KM_PAR_JOUR_RAIL = 1440.0;
    public static final int JOURS_EN_PLUS_RAIL = 1;
    public static final double KM_PAR_JOUR_MER = 720.0;
    public static final int JOURS_EN_PLUS_MER = 2;
    public static final int DELAI_AIR = 1;
    public static final int DELAI_AIR_LONGUE_DISTANCE = 2;
    public static final int DISTANCE_LONGUE_AIR = 3000;
    public static final int DELAI_MINIMUM = 1;

    // retourne le délai de livraison en jours
    public int calculerDelai(int distance, ModeTransport mode, boolean urgent) {
        int jours = 0;
        switch (mode) {
            case ROUTE:
                double heures = distance / VITESSE_ROUTE;
                if (urgent) {
                    jours = (int) Math.ceil(heures / HEURES_CONDUITE_PAR_JOUR_URGENT);
                } else {
                    jours = (int) Math.ceil(heures / HEURES_CONDUITE_PAR_JOUR);
                }
                break;
            case RAIL:
                jours = (int) Math.ceil(distance / KM_PAR_JOUR_RAIL) + JOURS_EN_PLUS_RAIL;
                if (urgent) jours = jours - JOURS_EN_PLUS_RAIL;
                break;
            case MER:
                jours = (int) Math.ceil(distance / KM_PAR_JOUR_MER) + JOURS_EN_PLUS_MER;
                break;
            case AIR:
                jours = DELAI_AIR;
                if (distance > DISTANCE_LONGUE_AIR) jours = DELAI_AIR_LONGUE_DISTANCE;
                if (urgent) jours = DELAI_AIR;
                break;
        }
        if (jours < DELAI_MINIMUM) jours = DELAI_MINIMUM;
        return jours;
    }
}
