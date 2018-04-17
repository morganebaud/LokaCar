package fr.ecole.eni.lokacar.contract;

public abstract class DetailsModelContract {
    public final static String MODELE_DETAIL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "MODELE_DETAILS ("
            + "ID INTEGER PRIMARY KEY , "
            + "DESIGNATION TEXT,"
            + "CONSOMMATION_EXTRA_URBAINE REAL,"
            + "BOITE_DE_VITESSE TEXT,"
            + "MASSE_MINI INTEGER,"
            + "PUISSANCE_ADMINISTRATIVE INTEGER,"
            + "EMISSION_CO2 INTEGER,"
            + "CARROSSERIE TEXT,"
            + "HYBRIDE TEXT,"
            + "CARBURANT TEXT,"
            + "CONSOMMATION_URBAINE REAL,"
            + "CONSOMMATION_MIXTE REAL,"
            + "CODE_NATIONAL_IDENTIFICATION_TYPE TEXT,"
            + "DATE_MISE_A_JOUR TEXT)";

    public final static String QUERY_DELETE_TABLE_MODELE_DETAIL = "DROP TABLE IF EXISTS MODELE_DETAILS";
    public final static String TABLE_MODELE_DETAIL_NAME = "MODELE_DETAILS";

    public final static String _DETAILSMODEL_ID = "ID";
    public final static String _DESIGNATION = "DESIGNATION";
    public final static String _CONSOMMATION_EXTRA_URBAINE = "CONSOMMATION_EXTRA_URBAINE";
    public final static String _BOITE_DE_VITESSE = "BOITE_DE_VITESSE";
    public final static String _MASSE_MINI = "MASSE_MINI";
    public final static String _PUISSANCE_ADMINISTRATIVE = "PUISSANCE_ADMINISTRATIVE";
    public final static String _EMISSION_CO2 = "EMISSION_CO2";
    public final static String _CARROSSERIE = "CARROSSERIE";
    public final static String _HYBRIDE = "HYBRIDE";
    public final static String _CARBURANT = "CARBURANT";
    public final static String _CONSOMMATION_URBAINE = "CONSOMMATION_URBAINE";
    public final static String _CONSOMMATION_MIXTE = "CONSOMMATION_MIXTE";
    public final static String _CODE_NATIONAL_IDENTIFICATION_TYPE = "CODE_NATIONAL_IDENTIFICATION_TYPE";
    public final static String _DATE_MISE_A_JOUR = "DATE_MISE_A_JOUR";
}
