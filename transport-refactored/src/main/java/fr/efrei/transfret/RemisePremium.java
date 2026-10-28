package fr.efrei.transfret;

public class RemisePremium implements PolitiqueRemise {

    public static final double REMISE = 0.80;

    public double appliquer(double prix) {
        return prix * REMISE;
    }
}
