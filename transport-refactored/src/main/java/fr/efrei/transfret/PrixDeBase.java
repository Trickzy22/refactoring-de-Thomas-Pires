package fr.efrei.transfret;

import java.util.List;

public class PrixDeBase implements Prix {

    private TarifTransport tarif;

    public PrixDeBase(TarifTransport tarif) {
        this.tarif = tarif;
    }

    public double calculer(List<Colis> colis, int distance) {
        double poids = 0;
        double volume = 0;
        for (Colis c : colis) {
            poids = poids + c.getPoids();
            volume = volume + c.getVolume();
        }
        return tarif.calculer(distance, poids, volume);
    }
}
