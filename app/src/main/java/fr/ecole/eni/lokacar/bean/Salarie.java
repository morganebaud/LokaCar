package fr.ecole.eni.lokacar.bean;

public class Salarie {
    private int Id;
    private String Nom;
    private String Prenom;
    private String Mail;
    private String Mdp;
    private boolean IsGerant;
    private int CodeAgence;

    public Salarie() {
    }

    public Salarie(String nom, String prenom, String mail, String mdp, boolean isGerant, int codeAgence) {
        Nom = nom;
        Prenom = prenom;
        Mail = mail;
        Mdp = mdp;
        IsGerant = isGerant;
        CodeAgence = codeAgence;
    }

    public Salarie(int id, String nom, String prenom, String mail, String mdp, boolean isGerant, int codeAgence) {
        Id = id;
        Nom = nom;
        Prenom = prenom;
        Mail = mail;
        Mdp = mdp;
        IsGerant = isGerant;
        CodeAgence = codeAgence;
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

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String mdp) {
        Mdp = mdp;
    }

    public boolean isGerant() {
        return IsGerant;
    }

    public void setGerant(boolean gerant) {
        IsGerant = gerant;
    }

    public int getCodeAgence() {
        return CodeAgence;
    }

    public void setCodeAgence(int codeAgence) {
        CodeAgence = codeAgence;
    }
}
