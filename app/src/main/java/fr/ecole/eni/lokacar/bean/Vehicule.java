package fr.ecole.eni.lokacar.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicule implements Parcelable {
    private int id;
    private String Marque;
    private Model Model;
    private String cnit;
    private Float prix;
    private String plaque;
    private int codeAgence;
    private boolean isDispo;
    private String photoPath;
    private int km;

    public Vehicule() {
    }

    public Vehicule(String marque, fr.ecole.eni.lokacar.bean.Model model, String cnit, Float prix, String plaque, int codeAgence, boolean isDispo, String photoPath, int km) {
        Marque = marque;
        Model = model;
        this.cnit = cnit;
        this.prix = prix;
        this.plaque = plaque;
        this.codeAgence = codeAgence;
        this.isDispo = isDispo;
        this.photoPath = photoPath;
        this.km = km;
    }

    public Vehicule(int id, String marque, fr.ecole.eni.lokacar.bean.Model model, String cnit, Float prix, String plaque, int codeAgence, boolean isDispo, String photoPath, int km) {
        this.id = id;
        Marque = marque;
        Model = model;
        this.cnit = cnit;
        this.prix = prix;
        this.plaque = plaque;
        this.codeAgence = codeAgence;
        this.isDispo = isDispo;
        this.photoPath = photoPath;
        this.km = km;
    }

    protected Vehicule(Parcel in) {
        id = in.readInt();
        Marque = in.readString();
        Model = in.readParcelable(fr.ecole.eni.lokacar.bean.Model.class.getClassLoader());
        cnit = in.readString();
        if (in.readByte() == 0) {
            prix = null;
        } else {
            prix = in.readFloat();
        }
        plaque = in.readString();
        codeAgence = in.readInt();
        isDispo = in.readByte() != 0;
        photoPath = in.readString();
        km = in.readInt();
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

    public fr.ecole.eni.lokacar.bean.Model getModel() {
        return Model;
    }

    public void setModel(fr.ecole.eni.lokacar.bean.Model model) {
        Model = model;
    }

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

    public int getCodeAgence() {
        return codeAgence;
    }

    public void setCodeAgence(int codeAgence) {
        this.codeAgence = codeAgence;
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

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(Marque);
        dest.writeParcelable(Model, flags);
        dest.writeString(cnit);
        if (prix == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(prix);
        }
        dest.writeString(plaque);
        dest.writeInt(codeAgence);
        dest.writeByte((byte) (isDispo ? 1 : 0));
        dest.writeString(photoPath);
        dest.writeInt(km);
    }
}
