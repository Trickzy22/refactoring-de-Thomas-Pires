package fr.efrei.transfret;

public class RemiseEntreprise implements PolitiqueRemise {

    public static final double SEUIL = 5000;
    public static final double REMISE_GROS_MONTANT = 0.85;
    public static final double REMISE = 0.90;

    public double appliquer(double prix) {
        if (prix > SEUIL) {
            return prix * REMISE_GROS_MONTANT;
        }
        return prix * REMISE;
    }
}
