package fr.ecole.eni.lokacar.contract;

public class MarqueContract {
    public final static String MARQUES_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "MARQUES ("
            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "NOM TEXT"
            + ")";


    public final static String QUERY_DELETE_TABLE_MARQUES = "DROP TABLE IF EXISTS MARQUES";
    public final static String TABLE_MARQUES_NAME = "MARQUES";

    public final static String _MARQUE_ID = "ID";
    public final static String _NOM  = "NOM";
}
