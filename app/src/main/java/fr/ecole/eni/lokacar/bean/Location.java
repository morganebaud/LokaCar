package fr.ecole.eni.lokacar.bean;

import java.util.Date;

public class Location {
    private int Id;
    private int NumFiche;
    private Client Client;
    private Vehicule vehicule;
    private Date DateDebut;
    private Date DateFin;

    public Location() {
    }

    public Location(int id, int numFiche, fr.ecole.eni.lokacar.bean.Client client, Vehicule vehicule, Date dateDebut, Date dateFin) {
        Id = id;
        NumFiche = numFiche;
        Client = client;
        this.vehicule = vehicule;
        DateDebut = dateDebut;
        DateFin = dateFin;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNumFiche() {
        return NumFiche;
    }

    public void setNumFiche(int numFiche) {
        NumFiche = numFiche;
    }

    public fr.ecole.eni.lokacar.bean.Client getClient() {
        return Client;
    }

    public void setClient(fr.ecole.eni.lokacar.bean.Client client) {
        Client = client;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public void setVehicule(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Date getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        DateDebut = dateDebut;
    }

    public Date getDateFin() {
        return DateFin;
    }

    public void setDateFin(Date dateFin) {
        DateFin = dateFin;
    }
}
