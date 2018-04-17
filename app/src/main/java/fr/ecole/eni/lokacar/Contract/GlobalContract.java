package fr.ecole.eni.lokacar.Contract;

public abstract class GlobalContract {

    public final static String DATABASE_NAME = "LokaCar.db";
    public final static int DATABASE_VERSION = 1;

//AGENCES
    public final static String AGENCES_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "AGENCES ("
            + "ID INTEGER PRIMARY KEY , "
            + "CODEAGENCE INTEGER, "
            + "NOM TEXT, "
            + "VILLE TEXT, "
            + "CODEPOSTAL TEXT"
            + ")";
//MODELE_DETAIL
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
//MODELS
    public final static String MODELS_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "MODELS ("
            + "ID INTEGER PRIMARY KEY , "
            + "DESIGNATION TEXT,"
            + "MODELE_COMMERCIAL TEXT,"
            + "CNIT TEXT,"
            + "MARQUE TEXT,"
            + "MODELE_DOSSIER TEXT)";
//VOITURES
    public final static String VOITURES_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "VOITURES ("
            + "ID INTEGER PRIMARY KEY , "
            + "CNIT TEXT , "
            + "PRIX DOUBLE , "
            + "PLAQUE TEXT , "
            + "PHOTOPATH TEXT , "
            + "ISDISPO INTEGER "
            + "MARQUE TEXT "
            + "CODEAGENCE INTEGER "
            + ")";
}
