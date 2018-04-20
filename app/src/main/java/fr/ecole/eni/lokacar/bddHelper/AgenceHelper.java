package fr.ecole.eni.lokacar.bddHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.ecole.eni.lokacar.contract.AgenceContract;
import fr.ecole.eni.lokacar.contract.ClientContract;
import fr.ecole.eni.lokacar.contract.GlobalContract;
import fr.ecole.eni.lokacar.contract.LocationContract;

public class AgenceHelper extends SQLiteOpenHelper {

    public AgenceHelper(Context context) {
        super(context, GlobalContract.DATABASE_NAME,null,GlobalContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(GlobalContract.AGENCES_CREATE_TABLE);
        db.execSQL(GlobalContract.SALARIES_CREATE_TABLE);
        db.execSQL(GlobalContract.VEHICULES_CREATE_TABLE);
        db.execSQL(GlobalContract.MODELS_CREATE_TABLE);
        db.execSQL(GlobalContract.MARQUES_CREATE_TABLE);
        db.execSQL(LocationContract.LOCATION_CREATE_TABLE);
        db.execSQL(ClientContract.CLIENT_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(AgenceContract.QUERY_DELETE_TABLE_AGENCES);
        onCreate(db);
    }
}
