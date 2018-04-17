package fr.ecole.eni.lokacar.contract;

public class SalarieContract {
    public final static String SALARIES_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "
            + "SALARIES ("
            + "ID INTEGER PRIMARY KEY , "
            + "NOM TEXT, "
            + "PRENOM TEXT, "
            + "MAIL TEXT, "
            + "MDP TEXT ,"
            + "ISGERANT INTEGER ,"
            + "CODEAGENCE INTEGER"
            + ")";

    public final static String QUERY_DELETE_TABLE_SALARIES= "DROP TABLE IF EXISTS SALARIES";
    public final static String TABLE_SALARIES_NAME = "SALARIE";

    public final static String _SALARIES_ID = "ID";
    public final static String _NOM = "NOM ";
    public final static String _PRENOM = "PRENOM ";
    public final static String _MAIL = "MAIL ";
    public final static String _MDP = "MDP ";
    public final static String _ISGERANT = "ISGERANT ";
    public final static String _CODEAGENCE = "CODEAGENCE ";
}
