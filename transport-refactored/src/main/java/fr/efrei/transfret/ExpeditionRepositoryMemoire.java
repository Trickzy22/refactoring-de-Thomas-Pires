package fr.efrei.transfret;

import java.util.HashMap;
import java.util.Map;

public class ExpeditionRepositoryMemoire implements ExpeditionRepository {

    private Map<String, Expedition> expeditions = new HashMap<String, Expedition>();

    public void sauvegarder(Expedition expedition) {
        expeditions.put(expedition.getId(), expedition);
    }

    public void mettreAJourStatut(Expedition expedition) {
        expeditions.put(expedition.getId(), expedition);
    }

    public Expedition trouver(String id) {
        return expeditions.get(id);
    }
}
