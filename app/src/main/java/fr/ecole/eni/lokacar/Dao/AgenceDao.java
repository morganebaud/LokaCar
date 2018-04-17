package fr.ecole.eni.lokacar.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import fr.ecole.eni.lokacar.BDDHelper.AgenceHelper;
import fr.ecole.eni.lokacar.Contract.AgenceContract;
import fr.ecole.eni.lokacar.Contract.ModelContract;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.Model;

public class AgenceDao {

    private AgenceHelper dbHelper;

    public AgenceDao(Context context) {
        this.dbHelper = new AgenceHelper(context);
    }

    private ContentValues constructValuesDB(Agence agence) {
        ContentValues values = new ContentValues();
        //values.put(AgenceContract._AGENCE_ID, agence.getId());
        values.put(AgenceContract._CODEAGENCE  , agence.getCodeAgence());
        values.put(AgenceContract._NOM  , agence.getNom());
        values.put(AgenceContract._VILLE  ,agence.getVille());
        values.put(AgenceContract._CODEPOSTAL  , agence.getCodePostal());
        return values;
    }

    public void Insert(Agence agence)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.insert(AgenceContract.TABLE_AGENCES_NAME, null, constructValuesDB(agence));

        db.close();
    }

    public Agence getByCode(int codeAgence)
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                AgenceContract.TABLE_AGENCES_NAME, null,
                AgenceContract._CODEAGENCE+"=?",
                new String[]{Integer.toString(codeAgence)},
                null,
                null,
                null);

        Agence object = null ;

        if(cursor != null && cursor.moveToFirst()){
            //Integer id = cursor.getInt(cursor.getColumnIndex(AgenceContract._AGENCE_ID));
            //codeAgence = cursor.getInt(cursor.getColumnIndex(AgenceContract._CODEAGENCE));
            String nom = cursor.getString(cursor.getColumnIndex(AgenceContract._NOM));
            String ville = cursor.getString(cursor.getColumnIndex(AgenceContract._VILLE));
            String codePostal = cursor.getString(cursor.getColumnIndex(AgenceContract._CODEPOSTAL));

            object = new Agence(codeAgence,nom,ville,codePostal);
            cursor.close();
        }
        return object;
    }
}
