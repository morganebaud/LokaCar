package fr.ecole.eni.lokacar.bddHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.ecole.eni.lokacar.contract.LocationContract;
import fr.ecole.eni.lokacar.contract.GlobalContract;

public class LocationHelper extends SQLiteOpenHelper {
    public LocationHelper(Context context) {
        super(context, GlobalContract.DATABASE_NAME,null,GlobalContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LocationContract.LOCATION_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(LocationContract.QUERY_DELETE_TABLE_LOCATION);
        onCreate(db);
    }
}
