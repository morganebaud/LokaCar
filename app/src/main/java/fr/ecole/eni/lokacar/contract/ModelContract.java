package fr.ecole.eni.lokacar.contract;

public abstract class ModelContract {

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
            +")";


    public final static String QUERY_DELETE_TABLE_MODELS = "DROP TABLE IF EXISTS MODELS";
    public final static String TABLE_MODELS_NAME = "MODELS";

    public final static String _MODEL_ID = "ID";
    public final static String _DESIGNATION = "DESIGNATION";
    public final static String _MODELE_COMMERCIAL = "MODELE_COMMERCIAL";
    public final static String _CNIT = "CNIT";
    public final static String _MARQUE = "MARQUE";
    public final static String _CARROSSERIE = "CARROSSERIE";
    public final static String _CARBURANT = "CARBURANT";
    public final static String _BOITEDEVITESSE = "BOITEDEVITESSE";
    public final static String _PUISSANCEADMINISTRATIVE = "PUISSANCEADMINISTRATIVE";
    public final static String _CONSOMMATIONURBAINE = "CONSOMMATIONURBAINE";
    public final static String _CONSOMMATIONEXTRAURBAINE = "CONSOMMATIONEXTRAURBAINE";
    public final static String _CONSOMMATIONMIXTE = "CONSOMMATIONMIXTE";
}