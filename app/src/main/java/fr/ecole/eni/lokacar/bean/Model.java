package fr.ecole.eni.lokacar.bean;

import android.provider.BaseColumns;

public class Model implements BaseColumns {

    private int Id;
    private String Designation;
    private String ModeleCommercial;
    private String CNIT;
    private String ModeleDossier;
    private String Marque;

    public Model(String designation,
                 String modeleCommercial,
                 String CNIT,
                 String modeleDossier,
                 String marque) {
        Designation = designation;
        ModeleCommercial = modeleCommercial;
        this.CNIT = CNIT;
        ModeleDossier = modeleDossier;
        Marque = marque;
    }

    public Model(int id,
                 String designation,
                 String modeleCommercial,
                 String CNIT,
                 String modeleDossier,
                 String marque) {
        Id = id;
        Designation = designation;
        ModeleCommercial = modeleCommercial;
        this.CNIT = CNIT;
        ModeleDossier = modeleDossier;
        Marque = marque;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getModeleCommercial() {
        return ModeleCommercial;
    }

    public void setModeleCommercial(String modeleCommercial) {
        ModeleCommercial = modeleCommercial;
    }

    public String getCNIT() {
        return CNIT;
    }

    public void setCNIT(String CNIT) {
        this.CNIT = CNIT;
    }

    public String getModeleDossier() {
        return ModeleDossier;
    }

    public void setModeleDossier(String modeleDossier) {
        ModeleDossier = modeleDossier;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }
}
