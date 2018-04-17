package fr.ecole.eni.lokacar.bean;

public class Marque {
    private String Nom;

    public Marque(String nom) {
        Nom = nom;
    }

    public Marque() {
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}
