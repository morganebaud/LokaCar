package fr.ecole.eni.lokacar.Contract;

public abstract class ModelContract {

    public final static String MODELS_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "MODELS ("
            + "ID INTEGER PRIMARY KEY , "
            + "DESIGNATION TEXT,"
            + "MODELE_COMMERCIAL TEXT,"
            + "CNIT TEXT,"
            + "MARQUE TEXT,"
            + "MODELE_DOSSIER TEXT)";


    public final static String QUERY_DELETE_TABLE_MODELS = "DROP TABLE IF EXISTS MODELS";
    public final static String TABLE_MODELS_NAME = "MODELS";

    public final static String _MODEL_ID = "ID";
    public final static String _DESIGNATION = "DESIGNATION";
    public final static String _MODELE_COMMERCIAL = "MODELE_COMMERCIAL";
    public final static String _CNIT = "CNIT";
    public final static String _MARQUE = "MARQUE";
    public final static String _MODELE_DOSSIER = "MODELE_DOSSIER";
}
