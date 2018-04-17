package fr.ecole.eni.lokacar.bddHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.ecole.eni.lokacar.contract.VoitureContract;
import fr.ecole.eni.lokacar.contract.GlobalContract;

public class VoitureHelper extends SQLiteOpenHelper {

    public VoitureHelper(Context context) {
        super(context, GlobalContract.DATABASE_NAME,null,GlobalContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VoitureContract.VOITURES_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(VoitureContract.QUERY_DELETE_TABLE_VOITURES);
        onCreate(db);
    }
}