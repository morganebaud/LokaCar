package fr.ecole.eni.lokacar.bean;

public class Agence {
    private int Id;
    private int CodeAgence;
    private String Nom;
    private String Ville;
    private String CodePostal;

    public Agence() {
    }

    public Agence(int codeAgence, String nom, String ville, String codePostal) {
        CodeAgence = codeAgence;
        Nom = nom;
        Ville = ville;
        CodePostal = codePostal;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getCodeAgence() {
        return CodeAgence;
    }

    public void setCodeAgence(int codeAgence) {
        CodeAgence = codeAgence;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(String codePostal) {
        CodePostal = codePostal;
    }
}
