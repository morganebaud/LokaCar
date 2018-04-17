package fr.ecole.eni.lokacar.bddHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.ecole.eni.lokacar.contract.DetailsModelContract;
import fr.ecole.eni.lokacar.contract.GlobalContract;

public class DetailsModelHelper extends SQLiteOpenHelper {

    public DetailsModelHelper(Context context) {
        super(context, GlobalContract.DATABASE_NAME,null,GlobalContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DetailsModelContract.MODELE_DETAIL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DetailsModelContract.QUERY_DELETE_TABLE_MODELE_DETAIL);
        onCreate(db);
    }
}
