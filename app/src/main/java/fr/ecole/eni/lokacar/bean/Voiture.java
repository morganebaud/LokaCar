package fr.ecole.eni.lokacar.bean;

public class Voiture {
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
