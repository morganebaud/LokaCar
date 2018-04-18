package fr.ecole.eni.lokacar.bddHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import fr.ecole.eni.lokacar.contract.GlobalContract;
import fr.ecole.eni.lokacar.contract.ModelContract;
import fr.ecole.eni.lokacar.contract.SalarieContract;

public class SalarieHelper extends SQLiteOpenHelper {
    public SalarieHelper(Context context) {
        super(context, GlobalContract.DATABASE_NAME,null,GlobalContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SalarieContract.SALARIES_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SalarieContract.QUERY_DELETE_TABLE_SALARIES);
        onCreate(db);
    }
}
