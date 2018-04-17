package fr.ecole.eni.lokacar.bean;

import java.util.Date;

public class ChiffreAffaire {
    private Date Date;
    private Float ChiffreAffaire;
    private Agence agence;

    public ChiffreAffaire() {
    }

    public ChiffreAffaire(java.util.Date date, Float chiffreAffaire, Agence agence) {
        Date = date;
        ChiffreAffaire = chiffreAffaire;
        this.agence = agence;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public Float getChiffreAffaire() {
        return ChiffreAffaire;
    }

    public void setChiffreAffaire(Float chiffreAffaire) {
        ChiffreAffaire = chiffreAffaire;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}
