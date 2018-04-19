package fr.ecole.eni.lokacar.contract;

public abstract class VehiculeContract {


    public final static String VEHICULES_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "VEHICULES ("
            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "CNIT TEXT , "
            + "PRIX DOUBLE , "
            + "PLAQUE TEXT , "
            + "PHOTOPATH TEXT , "
            + "ISDISPO INTEGER , "
            + "MARQUE TEXT , "
            + "CODEAGENCE INTEGER "
            + ")";


    public final static String QUERY_DELETE_TABLE_VEHICULES = "DROP TABLE IF EXISTS VEHICULES";
    public final static String TABLE_VEHICULES_NAME = "VEHICULES";

    public final static String _VEHICULES_ID = "ID";
    public final static String _CNIT = "CNIT";
    public final static String _PRIX = "PRIX";
    public final static String _PLAQUE = "PLAQUE";
    public final static String _PHOTOPATH = "PHOTOPATH";
    public final static String _ISDISPO = "ISDISPO";
    public final static String _MARQUE  = "MARQUE";
    public final static String _CODEAGENCE  = "CODEAGENCE";
}
