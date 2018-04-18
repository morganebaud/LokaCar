package fr.ecole.eni.lokacar.bean;

public class Marque {
    private int Id;
    private String Nom;

    public Marque(int id, String nom) {
        Id = id;
        Nom = nom;
    }

    public Marque(String nom) {
        Nom = nom;
    }

    public Marque() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }
}
