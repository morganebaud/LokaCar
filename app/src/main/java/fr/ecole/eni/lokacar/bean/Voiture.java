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
    private Marque Marque;

    public Voiture() {
    }

    public Voiture(int id, Marque marque, Model model, DetailsModel detailsModel, String CNIT, Float prix, String plaque, Agence agence, boolean isDispo, String photoPath) {
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

    public Marque getMarque() {
        return Marque;
    }

    public void setMarque(Marque marque) {
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
