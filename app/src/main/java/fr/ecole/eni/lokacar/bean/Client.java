package fr.ecole.eni.lokacar.bean;

public class Client {
    private int Id;
    private String Nom;
    private String Prenom;
    private String Mail;
    private String Ville;
    private String Telephone;
    private String CodePostal;

    public Client() {
    }

    public Client(String nom, String prenom, String mail, String ville, String telephone, String codePostal) {
        Nom = nom;
        Prenom = prenom;
        Mail = mail;
        Ville = ville;
        Telephone = telephone;
        CodePostal = codePostal;
    }

    public Client(int id, String nom, String prenom, String mail, String ville, String telephone, String codePostal) {
        Id = id;
        Nom = nom;
        Prenom = prenom;
        Mail = mail;
        Ville = ville;
        Telephone = telephone;
        CodePostal = codePostal;
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

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public String getVille() {
        return Ville;
    }

    public void setVille(String ville) {
        Ville = ville;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(String codePostal) {
        CodePostal = codePostal;
    }
}
