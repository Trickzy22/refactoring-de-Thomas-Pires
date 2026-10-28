package fr.efrei.transfret;

public abstract class DecorateurPrix implements Prix {

    protected Prix prix;

    public DecorateurPrix(Prix prix) {
        this.prix = prix;
    }
}
