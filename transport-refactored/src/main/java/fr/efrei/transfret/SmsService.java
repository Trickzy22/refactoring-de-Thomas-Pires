package fr.efrei.transfret;

import java.util.ArrayList;
import java.util.List;

public class SmsService implements CanalNotification {

    public static final int TAILLE_MAX_SMS = 160;
    public static final String SUITE_SMS_COUPE = "...";

    // garde une trace des SMS envoyés (facturés par l'opérateur)
    private List<String[]> journal = new ArrayList<String[]>();

    private String apiKey = "sk_live_8f7d6e5c4b3a2918";

    public void envoyer(String numero, String sujet, String message) {
        if (message.length() > TAILLE_MAX_SMS) {
            message = message.substring(0, TAILLE_MAX_SMS - SUITE_SMS_COUPE.length()) + SUITE_SMS_COUPE;
        }
        System.out.println("[SMS] -> " + numero + " : " + message);
        journal.add(new String[]{numero, message});
    }

    public List<String[]> getJournal() {
        return journal;
    }
}
