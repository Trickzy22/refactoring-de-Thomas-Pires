package fr.efrei.transfret;

import java.util.List;

public class Avion extends Vehicule {

    public static final int ALTITUDE = 35000;

    public Avion(String immatriculation, double capaciteMax) {
        super(immatriculation, capaciteMax);
    }

    public boolean peutTransporter(List<Colis> colis, ModeTransport mode) {
        return mode == ModeTransport.AIR;
    }

    public void partir(int distance) {
        faireLePlein();
        System.out.println("L'avion " + immatriculation + " roule sur la piste");
        System.out.println("L'avion " + immatriculation + " vole à " + ALTITUDE + " pieds");
    }
}
