package fr.ecole.eni.lokacar.contract;

public class AgenceContract {

    public final static String AGENCES_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "AGENCES ("
            + "ID INTEGER PRIMARY KEY , "
            + "CODEAGENCE INTEGER, "
            + "NOM TEXT, "
            + "VILLE TEXT, "
            + "CODEPOSTAL TEXT"
            + ")";


    public final static String QUERY_DELETE_TABLE_AGENCES = "DROP TABLE IF EXISTS MODELS";
    public final static String TABLE_AGENCES_NAME = "MODELS";

    public final static String _AGENCE_ID = "ID";
    public final static String _CODEAGENCE  = "CODEAGENCE";
    public final static String _NOM  = "NOM";
    public final static String _VILLE  = "VILLE";
    public final static String _CODEPOSTAL  = "CODEPOSTAL";
}
