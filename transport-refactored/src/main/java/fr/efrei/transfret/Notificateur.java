package fr.efrei.transfret;

public class Notificateur {

    private CanalNotification email;
    private CanalNotification sms;

    public Notificateur(CanalNotification email, CanalNotification sms) {
        this.email = email;
        this.sms = sms;
    }

    public void notifier(Client client, String sujet, String corps, String message) {
        email.envoyer(client.getEmail(), sujet, corps);
        if (client.getType() == TypeClient.PREMIUM) {
            sms.envoyer(client.getTelephone(), sujet, message);
        }
    }
}
