package fr.ecole.eni.lokacar.bddHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.ecole.eni.lokacar.contract.VehiculeContract;
import fr.ecole.eni.lokacar.contract.GlobalContract;

public class VehiculeHelper extends SQLiteOpenHelper {

    public VehiculeHelper(Context context) {
        super(context, GlobalContract.DATABASE_NAME,null,GlobalContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(VehiculeContract.VEHICULES_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(VehiculeContract.QUERY_DELETE_TABLE_VEHICULES);
        onCreate(db);
    }
}