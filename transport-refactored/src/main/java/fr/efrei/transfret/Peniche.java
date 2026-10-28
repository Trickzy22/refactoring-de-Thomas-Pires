package fr.efrei.transfret;

import java.util.List;

public class Peniche extends Vehicule {

    public Peniche(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax);
    }

    public boolean peutTransporter(List<Colis> colis, ModeTransport mode) {
        return mode == ModeTransport.FLUVIAL;
    }

    public void partir(int distance) {
        faireLePlein();
        System.out.println("La péniche " + immatriculation + " navigue sur " + distance + " km");
    }
}
