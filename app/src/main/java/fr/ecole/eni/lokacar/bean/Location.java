package fr.ecole.eni.lokacar.bean;

import java.util.Date;

public class Location {
    private int id;
    private int idClient;
    private int idVehicule;
    private Date dateDebut;
    private Date dateFin;
    private Boolean isVehiculeRendu;

    public Location() {
    }

    public Location(int idClient, int idVehicule, Date dateDebut, Date dateFin, Boolean isVehiculeRendu) {
        this.idClient = idClient;
        this.idVehicule = idVehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.isVehiculeRendu = isVehiculeRendu;
    }

    public Location(int id, int idClient, int idVehicule, Date dateDebut, Date dateFin, Boolean isVehiculeRendu) {
        this.id = id;
        this.idClient = idClient;
        this.idVehicule = idVehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.isVehiculeRendu = isVehiculeRendu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean getVehiculeRendu() {
        return isVehiculeRendu;
    }

    public void setVehiculeRendu(Boolean vehiculeRendu) {
        isVehiculeRendu = vehiculeRendu;
    }
}
