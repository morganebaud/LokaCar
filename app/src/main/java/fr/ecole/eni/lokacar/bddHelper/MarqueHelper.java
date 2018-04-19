package fr.ecole.eni.lokacar.bddHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.ecole.eni.lokacar.contract.AgenceContract;
import fr.ecole.eni.lokacar.contract.GlobalContract;
import fr.ecole.eni.lokacar.contract.MarqueContract;

public class MarqueHelper extends SQLiteOpenHelper {
    public MarqueHelper(Context context) {
        super(context, GlobalContract.DATABASE_NAME,null,GlobalContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MarqueContract.MARQUES_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(MarqueContract.QUERY_DELETE_TABLE_MARQUES);
        onCreate(db);
    }
}
