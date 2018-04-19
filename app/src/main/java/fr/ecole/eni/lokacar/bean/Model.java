package fr.ecole.eni.lokacar.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.BaseColumns;

public class Model implements BaseColumns, Parcelable {

    private int id;
    private String designation;
    private String modeleCommercial;
    private String cnit;
    private String marque;
    private String carrosserie;
    private String carburant;
    private String boiteDeVitesse;
    private int puissanceAdministrative;
    private double consommationUrbaine;
    private double consommationExtraUrbaine;
    private double consommationMixte;

    public Model() {
    }

    public Model(String designation, String modeleCommercial, String cnit, String marque, String carrosserie, String carburant, String boiteDeVitesse, int puissanceAdministrative, double consommationUrbaine, double consommationExtraUrbaine, double consommationMixte) {
        this.designation = designation;
        this.modeleCommercial = modeleCommercial;
        this.cnit = cnit;
        this.marque = marque;
        this.carrosserie = carrosserie;
        this.carburant = carburant;
        this.boiteDeVitesse = boiteDeVitesse;
        this.puissanceAdministrative = puissanceAdministrative;
        this.consommationUrbaine = consommationUrbaine;
        this.consommationExtraUrbaine = consommationExtraUrbaine;
        this.consommationMixte = consommationMixte;
    }

    public Model(int id, String designation, String modeleCommercial, String cnit, String marque, String carrosserie, String carburant, String boiteDeVitesse, int puissanceAdministrative, double consommationUrbaine, double consommationExtraUrbaine, double consommationMixte) {
        this.id = id;
        this.designation = designation;
        this.modeleCommercial = modeleCommercial;
        this.cnit = cnit;
        this.marque = marque;
        this.carrosserie = carrosserie;
        this.carburant = carburant;
        this.boiteDeVitesse = boiteDeVitesse;
        this.puissanceAdministrative = puissanceAdministrative;
        this.consommationUrbaine = consommationUrbaine;
        this.consommationExtraUrbaine = consommationExtraUrbaine;
        this.consommationMixte = consommationMixte;
    }

    protected Model(Parcel in) {
        id = in.readInt();
        designation = in.readString();
        modeleCommercial = in.readString();
        cnit = in.readString();
        marque = in.readString();
        carrosserie = in.readString();
        carburant = in.readString();
        boiteDeVitesse = in.readString();
        puissanceAdministrative = in.readInt();
        consommationUrbaine = in.readDouble();
        consommationExtraUrbaine = in.readDouble();
        consommationMixte = in.readDouble();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getModeleCommercial() {
        return modeleCommercial;
    }

    public void setModeleCommercial(String modeleCommercial) {
        this.modeleCommercial = modeleCommercial;
    }

    public String getCnit() {
        return cnit;
    }

    public void setCnit(String cnit) {
        this.cnit = cnit;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getCarrosserie() {
        return carrosserie;
    }

    public void setCarrosserie(String carrosserie) {
        this.carrosserie = carrosserie;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getBoiteDeVitesse() {
        return boiteDeVitesse;
    }

    public void setBoiteDeVitesse(String boiteDeVitesse) {
        this.boiteDeVitesse = boiteDeVitesse;
    }

    public int getPuissanceAdministrative() {
        return puissanceAdministrative;
    }

    public void setPuissanceAdministrative(int puissanceAdministrative) {
        this.puissanceAdministrative = puissanceAdministrative;
    }

    public double getConsommationUrbaine() {
        return consommationUrbaine;
    }

    public void setConsommationUrbaine(double consommationUrbaine) {
        this.consommationUrbaine = consommationUrbaine;
    }

    public double getConsommationExtraUrbaine() {
        return consommationExtraUrbaine;
    }

    public void setConsommationExtraUrbaine(double consommationExtraUrbaine) {
        this.consommationExtraUrbaine = consommationExtraUrbaine;
    }

    public double getConsommationMixte() {
        return consommationMixte;
    }

    public void setConsommationMixte(double consommationMixte) {
        this.consommationMixte = consommationMixte;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(designation);
        dest.writeString(modeleCommercial);
        dest.writeString(cnit);
        dest.writeString(marque);
        dest.writeString(carrosserie);
        dest.writeString(carburant);
        dest.writeString(boiteDeVitesse);
        dest.writeInt(puissanceAdministrative);
        dest.writeDouble(consommationUrbaine);
        dest.writeDouble(consommationExtraUrbaine);
        dest.writeDouble(consommationMixte);
    }
}
