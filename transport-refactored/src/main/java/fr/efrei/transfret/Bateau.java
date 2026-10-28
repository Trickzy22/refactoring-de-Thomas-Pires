package fr.efrei.transfret;

import java.util.List;

public class Bateau extends Vehicule {

    public static final double KM_PAR_MILLE_NAUTIQUE = 1.852;

    private boolean conteneursRefrigeres;

    public Bateau(String immatriculation, double capaciteMax, boolean conteneursRefrigeres) {
        super(immatriculation, capaciteMax);
        this.conteneursRefrigeres = conteneursRefrigeres;
    }

    public boolean peutTransporter(List<Colis> colis, ModeTransport mode) {
        if (mode != ModeTransport.MER) {
            return false;
        }
        return conteneursRefrigeres || !contient(colis, TypeMarchandise.REFRIGERE);
    }

    public void partir(int distance) {
        faireLePlein();
        System.out.println("Le navire " + immatriculation + " navigue sur " + (int) (distance / KM_PAR_MILLE_NAUTIQUE) + " milles nautiques");
        if (contient(chargement, TypeMarchandise.REFRIGERE)) {
            System.out.println("Conteneurs frigorifiques réglés à " + TEMPERATURE_REFRIGERATION + "°C");
        }
    }
}
