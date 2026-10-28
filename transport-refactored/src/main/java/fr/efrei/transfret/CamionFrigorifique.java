package fr.efrei.transfret;

import java.util.List;

public class CamionFrigorifique extends Camion {

    public CamionFrigorifique(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax, false);
    }

    @Override
    public boolean peutTransporter(List<Colis> colis, ModeTransport mode) {
        // un camion frigo ne prend QUE des colis réfrigérés
        for (Colis c : colis) {
            if (c.getType() != TypeMarchandise.REFRIGERE) {
                return false;
            }
        }
        return mode == ModeTransport.ROUTE;
    }

    @Override
    public void partir(int distance) {
        super.partir(distance);
        System.out.println("Réfrigération activée à " + TEMPERATURE_REFRIGERATION + "°C sur " + immatriculation);
    }
}
