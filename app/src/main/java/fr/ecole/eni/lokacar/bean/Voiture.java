package fr.ecole.eni.lokacar.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class Voiture implements Parcelable {
    private int Id;
    private String CNIT;
    private Float Prix;
    private String Plaque;
    private String PhotoPath;
    private boolean IsDispo;

    private DetailsModel DetailsModel;
    private Agence Agence;
    private Model Model;
    private String Marque;

    public Voiture() {
    }

    public Voiture(String marque, Model model, DetailsModel detailsModel, String CNIT, Float prix, String plaque, Agence agence, boolean isDispo, String photoPath) {
        Marque = marque;
        Model = model;
        DetailsModel = detailsModel;
        this.CNIT = CNIT;
        Prix = prix;
        Plaque = plaque;
        Agence = agence;
        IsDispo = isDispo;
        PhotoPath = photoPath;
    }

    public Voiture(int id, String marque, Model model, DetailsModel detailsModel, String CNIT, Float prix, String plaque, Agence agence, boolean isDispo, String photoPath) {
        Id = id;
        Marque = marque;
        Model = model;
        DetailsModel = detailsModel;
        this.CNIT = CNIT;
        Prix = prix;
        Plaque = plaque;
        Agence = agence;
        IsDispo = isDispo;
        PhotoPath = photoPath;
    }

    protected Voiture(Parcel in) {
        Id = in.readInt();
        CNIT = in.readString();
        if (in.readByte() == 0) {
            Prix = null;
        } else {
            Prix = in.readFloat();
        }
        Plaque = in.readString();
        PhotoPath = in.readString();
        IsDispo = in.readByte() != 0;
        Marque = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(Id);
        dest.writeString(CNIT);
        if (Prix == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeFloat(Prix);
        }
        dest.writeString(Plaque);
        dest.writeString(PhotoPath);
        dest.writeByte((byte) (IsDispo ? 1 : 0));
        dest.writeString(Marque);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Voiture> CREATOR = new Creator<Voiture>() {
        @Override
        public Voiture createFromParcel(Parcel in) {
            return new Voiture(in);
        }

        @Override
        public Voiture[] newArray(int size) {
            return new Voiture[size];
        }
    };

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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

    public DetailsModel getDetailsModel() {
        return DetailsModel;
    }

    public void setDetailsModel(DetailsModel detailsModel) {
        DetailsModel = detailsModel;
    }

    public String getCNIT() {
        return CNIT;
    }

    public void setCNIT(String CNIT) {
        this.CNIT = CNIT;
    }

    public Float getPrix() {
        return Prix;
    }

    public void setPrix(Float prix) {
        Prix = prix;
    }

    public String getPlaque() {
        return Plaque;
    }

    public void setPlaque(String plaque) {
        Plaque = plaque;
    }

    public Agence getAgence() {
        return Agence;
    }

    public void setAgence(Agence agence) {
        Agence = agence;
    }

    public boolean isDispo() {
        return IsDispo;
    }

    public void setDispo(boolean dispo) {
        IsDispo = dispo;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }

    public void setPhotoPath(String photoPath) {
        PhotoPath = photoPath;
    }
}
