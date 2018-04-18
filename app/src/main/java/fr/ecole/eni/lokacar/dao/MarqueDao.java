package fr.ecole.eni.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import fr.ecole.eni.lokacar.bddHelper.AgenceHelper;
import fr.ecole.eni.lokacar.bddHelper.MarqueHelper;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.Marque;
import fr.ecole.eni.lokacar.contract.AgenceContract;
import fr.ecole.eni.lokacar.contract.MarqueContract;

public class MarqueDao {
    private MarqueHelper dbHelper;

    public MarqueDao(Context context) {
        this.dbHelper = new MarqueHelper(context);
    }

    private ContentValues constructValuesDB(Marque marque) {
        ContentValues values = new ContentValues();
        //values.put(MarqueContract._MARQUE_ID, marque.getId());
        values.put(MarqueContract._NOM, marque.getNom());
        return values;
    }

    public void Insert(Marque marque) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.insert(MarqueContract.TABLE_MARQUES_NAME, null, constructValuesDB(marque));

        db.close();
    }

}
