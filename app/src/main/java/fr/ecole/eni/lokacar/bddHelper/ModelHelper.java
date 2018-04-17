package fr.ecole.eni.lokacar.bddHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.ecole.eni.lokacar.contract.ModelContract;
import fr.ecole.eni.lokacar.contract.GlobalContract;

public class ModelHelper extends SQLiteOpenHelper {

    public ModelHelper(Context context) {
        super(context, GlobalContract.DATABASE_NAME,null,GlobalContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ModelContract.MODELS_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(ModelContract.QUERY_DELETE_TABLE_MODELS);
        onCreate(db);
    }
}
