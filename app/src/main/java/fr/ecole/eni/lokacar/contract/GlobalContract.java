package fr.ecole.eni.lokacar.contract;

public abstract class GlobalContract {

    public final static String DATABASE_NAME = "LokaCar.db";
    public final static int DATABASE_VERSION = 1;

    //SALARIE
    public final static String SALARIES_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "SALARIES ("
            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "NOM TEXT, "
            + "PRENOM TEXT, "
            + "MAIL TEXT, "
            + "MDP TEXT ,"
            + "ISGERANT INTEGER ,"
            + "CODEAGENCE INTEGER"
            + ")";

    //AGENCES
    public final static String AGENCES_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "AGENCES ("
            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "CODEAGENCE INTEGER, "
            + "NOM TEXT, "
            + "VILLE TEXT, "
            + "CODEPOSTAL TEXT"
            + ")";
    //MODELE_DETAIL
    public final static String MODELE_DETAIL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "MODELE_DETAILS ("
            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
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
            + "DATE_MISE_A_JOUR TEXT"
            + ")";
    //MODELS
    public final static String MODELS_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "MODELS ("
            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "DESIGNATION TEXT,"
            + "MODELE_COMMERCIAL TEXT,"
            + "CNIT TEXT,"
            + "MARQUE TEXT,"
            + "CARROSSERIE TEXT,"
            + "CARBURANT TEXT,"
            + "BOITEDEVITESSE TEXT,"
            + "PUISSANCEADMINISTRATIVE INTEGER,"
            + "CONSOMMATIONURBAINE DOUBLE,"
            + "CONSOMMATIONEXTRAURBAINE DOUBLE,"
            + "CONSOMMATIONMIXTE DOUBLE"
            + ")";
    //VEHICULES
    public final static String VEHICULES_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "VEHICULES ("
            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "CNIT TEXT, "
            + "PRIX DOUBLE, "
            + "PLAQUE TEXT, "
            + "PHOTOPATH TEXT, "
            + "ISDISPO INTEGER, "
            + "MARQUE TEXT, "
            + "CODEAGENCE INTEGER "
            + ")";

    public final static String MARQUES_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "MARQUES ("
            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "NOM TEXT"
            + ")";

}
