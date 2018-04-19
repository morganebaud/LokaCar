package fr.ecole.eni.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import fr.ecole.eni.lokacar.bddHelper.SalarieHelper;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.bean.Salarie;
import fr.ecole.eni.lokacar.contract.AgenceContract;
import fr.ecole.eni.lokacar.contract.ModelContract;
import fr.ecole.eni.lokacar.contract.SalarieContract;

public class SalarieDao {
    private SalarieHelper dbHelper;

    public SalarieDao(Context context) {
        this.dbHelper = new SalarieHelper(context);
    }

    private ContentValues constructValuesDB(Salarie salarie) {
        ContentValues values = new ContentValues();
        values.put(SalarieContract._NOM , salarie.getNom());
        values.put(SalarieContract._PRENOM , salarie.getPrenom());
        values.put(SalarieContract._MAIL ,salarie.getMail());
        values.put(SalarieContract._MDP , salarie.getMdp());
        values.put(SalarieContract._ISGERANT , salarie.isGerant()? 1:0);
        values.put(SalarieContract._CODEAGENCE , salarie.getCodeAgence());
        return values;
    }

    public void Insert(Salarie salarie) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.insert(SalarieContract.TABLE_SALARIES_NAME, null, constructValuesDB(salarie));

        db.close();
    }

    public Salarie getByMail(String mail) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                SalarieContract.TABLE_SALARIES_NAME, null,
                SalarieContract._MAIL + "=?",
                new String[]{mail},
                null,
                null,
                null);

        Salarie object = null;

        if (cursor != null && cursor.moveToFirst()) {
            Integer id = cursor.getInt(cursor.getColumnIndex(SalarieContract._SALARIES_ID));
            String nom = cursor.getString(cursor.getColumnIndex(SalarieContract._NOM));
            String prenom = cursor.getString(cursor.getColumnIndex(SalarieContract._PRENOM));
            mail  = cursor.getString(cursor.getColumnIndex(SalarieContract._MAIL));
            String mdp = cursor.getString(cursor.getColumnIndex(SalarieContract._MDP));
            boolean isGerant = cursor.getInt(cursor.getColumnIndex(SalarieContract._ISGERANT)) == 1 ? true : false;
            int codeagence = cursor.getInt(cursor.getColumnIndex(SalarieContract._CODEAGENCE));

            object = new Salarie(id,nom,prenom,mail,mdp,isGerant,codeagence);
            cursor.close();
        }
        return object;
    }
}
