package fr.ecole.eni.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.ecole.eni.lokacar.bddHelper.AgenceHelper;
import fr.ecole.eni.lokacar.contract.AgenceContract;
import fr.ecole.eni.lokacar.bean.Agence;

public class AgenceDao {

    private AgenceHelper dbHelper;

    public AgenceDao(Context context) {
        this.dbHelper = new AgenceHelper(context);
    }

    private ContentValues constructValuesDB(Agence agence) {
        ContentValues values = new ContentValues();
        values.put(AgenceContract._CODEAGENCE, agence.getCodeAgence());
        values.put(AgenceContract._NOM, agence.getNom());
        values.put(AgenceContract._VILLE, agence.getVille());
        values.put(AgenceContract._CODEPOSTAL, agence.getCodePostal());
        return values;
    }

    public void Insert(Agence agence) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.insert(AgenceContract.TABLE_AGENCES_NAME, null, constructValuesDB(agence));

        db.close();
    }

    public Agence getByCode(int codeAgence) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                AgenceContract.TABLE_AGENCES_NAME, null,
                AgenceContract._CODEAGENCE + "=?",
                new String[]{Integer.toString(codeAgence)},
                null,
                null,
                null);

        Agence object = null;

        if (cursor != null && cursor.moveToFirst()) {
            //Integer id = cursor.getInt(cursor.getColumnIndex(AgenceContract._AGENCE_ID));
            //codeAgence = cursor.getInt(cursor.getColumnIndex(AgenceContract._CODEAGENCE));
            String nom = cursor.getString(cursor.getColumnIndex(AgenceContract._NOM));
            String ville = cursor.getString(cursor.getColumnIndex(AgenceContract._VILLE));
            String codePostal = cursor.getString(cursor.getColumnIndex(AgenceContract._CODEPOSTAL));

            object = new Agence(codeAgence, nom, ville, codePostal);
            cursor.close();
        }
        return object;
    }

    public List<Agence> getAll() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                AgenceContract.TABLE_AGENCES_NAME, null, null, null,
                null,
                null,
                null);

        List<Agence> objects = new ArrayList<Agence>();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                //Integer id = cursor.getInt(cursor.getColumnIndex(AgenceContract._AGENCE_ID));
                Integer codeAgence = cursor.getInt(cursor.getColumnIndex(AgenceContract._CODEAGENCE));
                String nom = cursor.getString(cursor.getColumnIndex(AgenceContract._NOM));
                String ville = cursor.getString(cursor.getColumnIndex(AgenceContract._VILLE));
                String codePostal = cursor.getString(cursor.getColumnIndex(AgenceContract._CODEPOSTAL));

                objects.add(new Agence(codeAgence, nom, ville, codePostal));

            } while (cursor.moveToNext());

            cursor.close();
        }
        return objects;
    }
}
