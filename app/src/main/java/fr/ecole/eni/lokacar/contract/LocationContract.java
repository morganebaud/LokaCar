package fr.ecole.eni.lokacar.contract;

public class LocationContract {
    public final static String LOCATION_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "LOCATION ("
            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "ID_CLIENT INTEGER, "
            + "ID_VEHICULE INTEGER, "
            + "DATE_DEBUT DATETIME, "
            + "DATE_FIN DATETIME, "
            + "IS_VEHICULE_RENDU INTEGER, "
            + ")";

    public final static String TABLE_LOCATION_NAME = "LOCATION";
    public final static String QUERY_DELETE_TABLE_LOCATION= "DROP TABLE IF EXISTS " + TABLE_LOCATION_NAME;

    public final static String _LOCATION_ID = "ID";
    public final static String _ID_CLIENT = "ID_CLIENT";
    public final static String _ID_VEHICULE = "ID_VEHICULE";
    public final static String _DATE_DEBUT = "DATE_DEBUT";
    public final static String _DATE_FIN = "DATE_FIN";
    public final static String _IS_VEHICULE_RENDU = "IS_VEHICULE_RENDU";
}
