package fr.efrei.transfret;

import java.util.List;

public class CalculateurPrix {

    public static final double PRIX_KM_ROUTE = 1.2;
    public static final double PRIX_KG_ROUTE = 0.10;
    public static final double PRIX_KM_RAIL = 0.8;
    public static final double PRIX_KG_RAIL = 0.07;
    public static final double MINIMUM_RAIL = 150;
    public static final double PRIX_KM_MER = 0.5;
    public static final double PRIX_KG_MER = 0.03;
    public static final double MINIMUM_MER = 500;
    public static final double PRIX_KM_AIR = 0.6;
    public static final double PRIX_KG_AIR = 4.5;
    public static final double COEF_POIDS_VOLUMETRIQUE = 167;

    public static final double SUPPLEMENT_FRAGILE = 1.15;
    public static final double SUPPLEMENT_DANGEREUX = 1.30;
    public static final double SUPPLEMENT_REFRIGERE = 1.20;
    public static final double SUPPLEMENT_URGENT = 1.5;

    public static final double SEUIL_REMISE_ENTREPRISE = 5000;
    public static final double REMISE_ENTREPRISE_GROS_MONTANT = 0.85;
    public static final double REMISE_ENTREPRISE = 0.90;
    public static final double REMISE_PREMIUM = 0.80;

    public static final double TAUX_ASSURANCE = 0.02;
    public static final double MINIMUM_ASSURANCE = 15;

    public double calculerPrixHT(List<Colis> colis, int distance, ModeTransport mode, boolean urgent, boolean assurance, TypeClient typeClient) {
        double poids = 0;
        double volume = 0;
        double valeur = 0;
        boolean fragile = false;
        boolean dangereux = false;
        boolean refrigere = false;
        for (Colis c : colis) {
            poids = poids + c.getPoids();
            volume = volume + c.getVolume();
            valeur = valeur + c.getValeurDeclaree();
            if (c.getType() == TypeMarchandise.FRAGILE) fragile = true;
            if (c.getType() == TypeMarchandise.DANGEREUX) dangereux = true;
            if (c.getType() == TypeMarchandise.REFRIGERE) refrigere = true;
        }

        // tarif de base selon le mode
        double prix;
        if (mode == ModeTransport.ROUTE) {
            prix = distance * PRIX_KM_ROUTE + poids * PRIX_KG_ROUTE;
        } else if (mode == ModeTransport.RAIL) {
            prix = distance * PRIX_KM_RAIL + poids * PRIX_KG_RAIL;
            if (prix < MINIMUM_RAIL) prix = MINIMUM_RAIL;
        } else if (mode == ModeTransport.MER) {
            prix = distance * PRIX_KM_MER + poids * PRIX_KG_MER;
            if (prix < MINIMUM_MER) prix = MINIMUM_MER;
        } else if (mode == ModeTransport.AIR) {
            double poidsTaxable = poids;
            if (volume * COEF_POIDS_VOLUMETRIQUE > poids) {
                poidsTaxable = volume * COEF_POIDS_VOLUMETRIQUE;
            }
            prix = distance * PRIX_KM_AIR + poidsTaxable * PRIX_KG_AIR;
        } else {
            throw new IllegalArgumentException("Mode inconnu : " + mode);
        }

        // suppléments
        if (fragile) prix = prix * SUPPLEMENT_FRAGILE;
        if (dangereux) prix = prix * SUPPLEMENT_DANGEREUX;
        if (refrigere) prix = prix * SUPPLEMENT_REFRIGERE;
        if (urgent) prix = prix * SUPPLEMENT_URGENT;

        // remise client
        if (typeClient == TypeClient.ENTREPRISE) {
            if (prix > SEUIL_REMISE_ENTREPRISE) {
                prix = prix * REMISE_ENTREPRISE_GROS_MONTANT;
            } else {
                prix = prix * REMISE_ENTREPRISE;
            }
        } else if (typeClient == TypeClient.PREMIUM) {
            prix = prix * REMISE_PREMIUM;
        }

        // assurance
        if (assurance) {
            double montantAssurance = valeur * TAUX_ASSURANCE;
            if (montantAssurance < MINIMUM_ASSURANCE) montantAssurance = MINIMUM_ASSURANCE;
            prix = prix + montantAssurance;
        }
        return Utils.arrondir(prix);
    }
}
