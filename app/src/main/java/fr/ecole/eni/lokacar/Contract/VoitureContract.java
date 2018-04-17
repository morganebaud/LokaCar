package fr.ecole.eni.lokacar.Contract;

public abstract class VoitureContract {


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


    public final static String QUERY_DELETE_TABLE_VOITURES = "DROP TABLE IF EXISTS VOITURES";
    public final static String TABLE_VOITURES_NAME = "VOITURES";

    public final static String _VOITURE_ID = "ID";
    public final static String _CNIT = "CNIT ";
    public final static String _PRIX = "PRIX ";
    public final static String _PLAQUE = "PLAQUE ";
    public final static String _PHOTOPATH = "PHOTOPATH ";
    public final static String _ISDISPO = "ISDISPO ";
    public final static String _MARQUE  = "MARQUE ";
    public final static String _CODEAGENCE  = "CODEAGENCE ";
}
