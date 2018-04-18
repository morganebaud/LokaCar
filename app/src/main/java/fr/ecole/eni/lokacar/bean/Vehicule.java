package fr.ecole.eni.lokacar.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicule implements Parcelable {
    private int id;
    private String cnit;
    private Float prix;
    private String plaque;
    private String photoPath;
    private boolean isDispo;

    //private DetailsModel DetailsModel;
    private Agence Agence;
    private Model Model;
    private String Marque;

    public Vehicule() {
    }

    public Vehicule(String marque, Model model,/* DetailsModel detailsModel,*/ String cnit, Float prix, String plaque, Agence agence, boolean isDispo, String photoPath) {
        Marque = marque;
        Model = model;
        //DetailsModel = detailsModel;
        this.cnit = cnit;
        this.prix = prix;
        this.plaque = plaque;
        Agence = agence;
        this.isDispo = isDispo;
        this.photoPath = photoPath;
    }

    public Vehicule(int id, String marque, Model model, /*DetailsModel detailsModel,*/ String CNIT, Float prix, String plaque, Agence agence, boolean isDispo, String photoPath) {
        this.id = id;
        Marque = marque;
        Model = model;
        //DetailsModel = detailsModel;
        this.cnit = CNIT;
        this.prix = prix;
        this.plaque = plaque;
        Agence = agence;
        this.isDispo = isDispo;
        this.photoPath = photoPath;
    }

    protected Vehicule(Parcel in) {
        id = in.readInt();
        cnit = in.readString();
        if (in.readByte() == 0) {
            prix = null;
        } else {
            prix = in.readFloat();
        }
        plaque = in.readString();
        photoPath = in.readString();
        isDispo = in.readByte() != 0;
        Marque = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(cnit);
        if (prix == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(prix);
        }
        dest.writeString(plaque);
        dest.writeString(photoPath);
        dest.writeByte((byte) (isDispo ? 1 : 0));
        dest.writeString(Marque);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Vehicule> CREATOR = new Creator<Vehicule>() {
        @Override
        public Vehicule createFromParcel(Parcel in) {
            return new Vehicule(in);
        }

        @Override
        public Vehicule[] newArray(int size) {
            return new Vehicule[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public Model getModel() {
        return Model;
    }

    public void setModel(Model model) {
        Model = model;
    }
    /*
    public DetailsModel getDetailsModel() {
        return DetailsModel;
    }

    public void setDetailsModel(DetailsModel detailsModel) {
        DetailsModel = detailsModel;
    }*/

    public String getCnit() {
        return cnit;
    }

    public void setCnit(String cnit) {
        this.cnit = cnit;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public Agence getAgence() {
        return Agence;
    }

    public void setAgence(Agence agence) {
        Agence = agence;
    }

    public boolean isDispo() {
        return isDispo;
    }

    public void setDispo(boolean dispo) {
        isDispo = dispo;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
}
