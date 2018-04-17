package fr.ecole.eni.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fr.ecole.eni.lokacar.bddHelper.VoitureHelper;
import fr.ecole.eni.lokacar.contract.VoitureContract;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.DetailsModel;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.bean.Voiture;

public class VoitureDao {

    private VoitureHelper dbhelper;

    public VoitureDao(Context context) {
        this.dbhelper = new VoitureHelper(context);
    }

    private ContentValues constructValuesDB(Voiture voiture) {
        ContentValues values = new ContentValues();
        values.put(VoitureContract._VOITURE_ID, voiture.getId());
        values.put(VoitureContract._CNIT, voiture.getCNIT());
        values.put(VoitureContract._PRIX, voiture.getPrix());
        values.put(VoitureContract._PLAQUE, voiture.getPlaque());
        values.put(VoitureContract._PHOTOPATH, voiture.getPhotoPath());
        values.put(VoitureContract._ISDISPO, voiture.isDispo() ? 1 : 0);
        values.put(VoitureContract._MARQUE, voiture.getMarque());
        values.put(VoitureContract._CODEAGENCE, voiture.getAgence().getCodeAgence());
        return values;
    }

    public long insert(Voiture voiture) {

        SQLiteDatabase db = dbhelper.getWritableDatabase();

        long id = db.insert(VoitureContract.TABLE_VOITURES_NAME, null, constructValuesDB(voiture));

        db.close();

        return id;
    }

    public List<Voiture> getListe(Context context) {
        ModelDao modelDao = new ModelDao(context);
        DetailsModelDao detailModelDao = new DetailsModelDao(context);
        AgenceDao agenceDao = new AgenceDao(context);

        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor cursor = db.query(
                VoitureContract.TABLE_VOITURES_NAME, null, null, null,
                null,
                null,
                null);

        List<Voiture> objects = new ArrayList<Voiture>();

        if (cursor != null && cursor.moveToFirst()) {
            do {

                Integer id = cursor.getInt(cursor.getColumnIndex(VoitureContract._VOITURE_ID));
                String marque = cursor.getString(cursor.getColumnIndex(VoitureContract._MARQUE));
                String cnit = cursor.getString(cursor.getColumnIndex(VoitureContract._CNIT));
                Model model = modelDao.getByCnit(cnit);
                DetailsModel detailsModel = detailModelDao.getByCnit(cnit);
                Float prix = cursor.getFloat(cursor.getColumnIndex(VoitureContract._PRIX));
                String plaque = cursor.getString(cursor.getColumnIndex(VoitureContract._PLAQUE));
                Agence agence = agenceDao.getByCode(cursor.getInt(cursor.getColumnIndex(VoitureContract._CODEAGENCE)));
                boolean isDispo = cursor.getInt(cursor.getColumnIndex(VoitureContract._ISDISPO)) == 1 ? true : false;
                String photoPath = cursor.getString(cursor.getColumnIndex(VoitureContract._PHOTOPATH));

                objects.add(new Voiture(id, marque, model, detailsModel, cnit, prix, plaque,
                        agence, isDispo, photoPath));

            } while (cursor.moveToNext());

            cursor.close();
        }

        return objects;
    }

    public ArrayList<Voiture> getListeBySearch(Context context, String... critereString) {
        ModelDao modelDao = new ModelDao(context);
        DetailsModelDao detailModelDao = new DetailsModelDao(context);
        AgenceDao agenceDao = new AgenceDao(context);

        SQLiteDatabase db = dbhelper.getReadableDatabase();
        List<String> argsList = new ArrayList<>();

        String selection = "1";

        selection += critereString[0] != null ?  " AND " + VoitureContract._MARQUE + "=?" : ""; //marque

        selection += critereString[1] != null ?  " AND " + VoitureContract._CNIT + "=? " : "";  //model ?

        selection += critereString[2] != null  ?  " AND " + VoitureContract._PRIX + "> ? " : ""; //prix min

        selection += critereString[3] != null ?  " AND " + VoitureContract._PRIX + "< ? " : ""; //prix max

        //selection += critereString[4] != null ?  " AND " + VoitureContract._ISDISPO + "=? " : ""; // dispo
        if(critereString[0] != null){ argsList.add(critereString[0]); }

        if(critereString[1] != null){ argsList.add(critereString[1]); }

        if(critereString[3] != null){ argsList.add(critereString[3]); }

        if(critereString[2] != null){ argsList.add(critereString[2]); }

        String[] args = argsList.toArray(new String[argsList.size()]);

Log.i("RUN",selection);

        Cursor cursor = db.query(
                VoitureContract.TABLE_VOITURES_NAME,
                null,
                selection,
                args,
                null,
                null,
                null);

        ArrayList<Voiture> objects = new ArrayList<Voiture>();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Integer id = cursor.getInt(cursor.getColumnIndex(VoitureContract._VOITURE_ID));
                String marque = cursor.getString(cursor.getColumnIndex(VoitureContract._MARQUE));
                String cnit = cursor.getString(cursor.getColumnIndex(VoitureContract._CNIT));
                Model model = modelDao.getByCnit(cnit);
                DetailsModel detailsModel = detailModelDao.getByCnit(cnit);
                Float prix = cursor.getFloat(cursor.getColumnIndex(VoitureContract._PRIX));
                String plaque = cursor.getString(cursor.getColumnIndex(VoitureContract._PLAQUE));
                Agence agence = agenceDao.getByCode(cursor.getInt(cursor.getColumnIndex(VoitureContract._CODEAGENCE)));
                boolean isDispo = cursor.getInt(cursor.getColumnIndex(VoitureContract._ISDISPO)) == 1 ? true : false;
                String photoPath = cursor.getString(cursor.getColumnIndex(VoitureContract._PHOTOPATH));

                objects.add(new Voiture(id, marque, model, detailsModel, cnit, prix, plaque,
                        agence, isDispo, photoPath));

            } while (cursor.moveToNext());

            cursor.close();
        }

        return objects;
    }

}
