package fr.ecole.eni.lokacar.bddHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.ecole.eni.lokacar.contract.ClientContract;
import fr.ecole.eni.lokacar.contract.GlobalContract;
import fr.ecole.eni.lokacar.contract.SalarieContract;

public class ClientHelper extends SQLiteOpenHelper {
    public ClientHelper(Context context) {
        super(context, GlobalContract.DATABASE_NAME,null,GlobalContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ClientContract.CLIENT_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ClientContract.QUERY_DELETE_TABLE_CLIENT);
        onCreate(db);
    }
}
