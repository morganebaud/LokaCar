package fr.ecole.eni.lokacar.contract;

public class ClientContract {
    public final static String CLIENT_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "CLIENT ("
            + "ID INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "NOM TEXT, "
            + "PRENOM TEXT, "
            + "MAIL TEXT, "
            + "CP TEXT ,"
            + "VILLE TEXT ,"
            + "TEL TEXT"
            + ")";

    public final static String QUERY_DELETE_TABLE_CLIENT= "DROP TABLE IF EXISTS CLIENT";
    public final static String TABLE_CLIENT_NAME = "CLIENT";

    public final static String _CLIENT_ID = "ID";
    public final static String _NOM = "NOM";
    public final static String _PRENOM = "PRENOM";
    public final static String _MAIL = "MAIL";
    public final static String _CP = "CP";
    public final static String _VILLE = "VILLE";
    public final static String _TEL = "TEL";
}
