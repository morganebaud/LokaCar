package fr.ecole.eni.lokacar.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class DetailsModel {

    private int Id;
    private double ConsommationExtraUrbaine;
    private String BoiteDeVitesse;
    private int MasseMini;
    private int PuissanceAdministrative;
    private int EmissionCo2;
    private String Carrosserie;
    private String Hybride;
    private String Carburant;
    private double ConsommationUrbaine;
    private double ConsommationMixte;
    private String CodeNationalIdentificationType;
    private String DateMiseAjour;
    private String Designation;

    public DetailsModel() {
    }

    /**
     *
     * @param id
     * @param consommationExtraUrbaine
     * @param boiteDeVitesse
     * @param masseMini
     * @param puissanceAdministrative
     * @param emissionCo2
     * @param carrosserie
     * @param hybride
     * @param carburant
     * @param consommationUrbaine
     * @param consommationMixte
     * @param codeNationalIdentificationType
     * @param dateMiseAjour
     * @param designation
     */
    public DetailsModel(int id,
                        double consommationExtraUrbaine,
                        String boiteDeVitesse,
                        int masseMini,
                        int puissanceAdministrative,
                        int emissionCo2,
                        String carrosserie,
                        String hybride,
                        String carburant,
                        double consommationUrbaine,
                        double consommationMixte,
                        String codeNationalIdentificationType,
                        String dateMiseAjour,
                        String designation
    ) {
        Id = id;
        ConsommationExtraUrbaine = consommationExtraUrbaine;
        BoiteDeVitesse = boiteDeVitesse;
        MasseMini = masseMini;
        PuissanceAdministrative = puissanceAdministrative;
        EmissionCo2 = emissionCo2;
        Carrosserie = carrosserie;
        Hybride = hybride;
        Carburant = carburant;
        ConsommationUrbaine = consommationUrbaine;
        ConsommationMixte = consommationMixte;
        CodeNationalIdentificationType = codeNationalIdentificationType;
        DateMiseAjour = dateMiseAjour;
        Designation = designation;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getConsommationExtraUrbaine() {
        return ConsommationExtraUrbaine;
    }

    public void setConsommationExtraUrbaine(double consommationExtraUrbaine) {
        ConsommationExtraUrbaine = consommationExtraUrbaine;
    }

    public String getBoiteDeVitesse() {
        return BoiteDeVitesse;
    }

    public void setBoiteDeVitesse(String boiteDeVitesse) {
        BoiteDeVitesse = boiteDeVitesse;
    }

    public int getMasseMini() {
        return MasseMini;
    }

    public void setMasseMini(int masseMini) {
        MasseMini = masseMini;
    }

    public int getPuissanceAdministrative() {
        return PuissanceAdministrative;
    }

    public void setPuissanceAdministrative(int puissanceAdministrative) {
        PuissanceAdministrative = puissanceAdministrative;
    }

    public int getEmissionCo2() {
        return EmissionCo2;
    }

    public void setEmissionCo2(int emissionCo2) {
        EmissionCo2 = emissionCo2;
    }

    public String getCarrosserie() {
        return Carrosserie;
    }

    public void setCarrosserie(String carrosserie) {
        Carrosserie = carrosserie;
    }

    public String getHybride() {
        return Hybride;
    }

    public void setHybride(String hybride) {
        Hybride = hybride;
    }

    public String getCarburant() {
        return Carburant;
    }

    public void setCarburant(String carburant) {
        Carburant = carburant;
    }

    public double getConsommationUrbaine() {
        return ConsommationUrbaine;
    }

    public void setConsommationUrbaine(double consommationUrbaine) {
        ConsommationUrbaine = consommationUrbaine;
    }

    public double getConsommationMixte() {
        return ConsommationMixte;
    }

    public void setConsommationMixte(double consommationMixte) {
        ConsommationMixte = consommationMixte;
    }

    public String getCodeNationalIdentificationType() {
        return CodeNationalIdentificationType;
    }

    public void setCodeNationalIdentificationType(String codeNationalIdentificationType) {
        CodeNationalIdentificationType = codeNationalIdentificationType;
    }

    public String getDateMiseAjour() {
        return DateMiseAjour;
    }

    public void setDateMiseAjour(String dateMiseAjour) {
        DateMiseAjour = dateMiseAjour;
    }

}
