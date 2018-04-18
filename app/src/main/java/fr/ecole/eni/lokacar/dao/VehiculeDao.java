package fr.ecole.eni.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import fr.ecole.eni.lokacar.bddHelper.VehiculeHelper;
import fr.ecole.eni.lokacar.bean.Vehicule;
import fr.ecole.eni.lokacar.contract.VehiculeContract;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.Model;

public class VehiculeDao {

    private VehiculeHelper dbhelper;

    public VehiculeDao(Context context) {
        this.dbhelper = new VehiculeHelper(context);
    }

    private ContentValues constructValuesDB(Vehicule vehicule) {
        ContentValues values = new ContentValues();
        values.put(VehiculeContract._VEHICULES_ID, vehicule.getId());
        values.put(VehiculeContract._CNIT, vehicule.getCnit());
        values.put(VehiculeContract._PRIX, vehicule.getPrix());
        values.put(VehiculeContract._PLAQUE, vehicule.getPlaque());
        values.put(VehiculeContract._PHOTOPATH, vehicule.getPhotoPath());
        values.put(VehiculeContract._ISDISPO, vehicule.isDispo() ? 1 : 0);
        values.put(VehiculeContract._MARQUE, vehicule.getMarque());
        values.put(VehiculeContract._CODEAGENCE, vehicule.getAgence().getCodeAgence());
        return values;
    }

    public long insert(Vehicule vehicule) {

        SQLiteDatabase db = dbhelper.getWritableDatabase();

        long id = db.insert(VehiculeContract.TABLE_VEHICULES_NAME, null, constructValuesDB(vehicule));

        db.close();

        return id;
    }

    public List<Vehicule> getListe(Context context) {
        ModelDao modelDao = new ModelDao(context);
        AgenceDao agenceDao = new AgenceDao(context);

        SQLiteDatabase db = dbhelper.getReadableDatabase();
        Cursor cursor = db.query(
                VehiculeContract.TABLE_VEHICULES_NAME, null, null, null,
                null,
                null,
                null);

        List<Vehicule> objects = new ArrayList<Vehicule>();

        if (cursor != null && cursor.moveToFirst()) {
            do {

                Integer id = cursor.getInt(cursor.getColumnIndex(VehiculeContract._VEHICULES_ID));
                String marque = cursor.getString(cursor.getColumnIndex(VehiculeContract._MARQUE));
                String cnit = cursor.getString(cursor.getColumnIndex(VehiculeContract._CNIT));
                Model model = modelDao.getByCnit(cnit);
                //DetailsModel detailsModel = detailModelDao.getByCnit(cnit);
                Float prix = cursor.getFloat(cursor.getColumnIndex(VehiculeContract._PRIX));
                String plaque = cursor.getString(cursor.getColumnIndex(VehiculeContract._PLAQUE));
                Agence agence = agenceDao.getByCode(cursor.getInt(cursor.getColumnIndex(VehiculeContract._CODEAGENCE)));
                boolean isDispo = cursor.getInt(cursor.getColumnIndex(VehiculeContract._ISDISPO)) == 1 ? true : false;
                String photoPath = cursor.getString(cursor.getColumnIndex(VehiculeContract._PHOTOPATH));

                objects.add(new Vehicule(id, marque, model, /*detailsModel,*/ cnit, prix, plaque,
                        agence, isDispo, photoPath));

            } while (cursor.moveToNext());

            cursor.close();
        }

        return objects;
    }

    public ArrayList<Vehicule> getListeBySearch(Context context, String... critereString) {
        ModelDao modelDao = new ModelDao(context);
        AgenceDao agenceDao = new AgenceDao(context);

        SQLiteDatabase db = dbhelper.getReadableDatabase();
        List<String> argsList = new ArrayList<>();

        String selection = "1";
        if (critereString != null) {
            selection += critereString[0] != null ? " AND " + VehiculeContract._MARQUE + "=?" : ""; //marque

            selection += critereString[1] != null ? " AND " + VehiculeContract._CNIT + "=? " : "";  //model ?

            selection += critereString[2] != null ? " AND " + VehiculeContract._PRIX + "> ? " : ""; //prix min

            selection += critereString[3] != null ? " AND " + VehiculeContract._PRIX + "< ? " : ""; //prix max

            selection += critereString[4] != null ? " AND " + VehiculeContract._ISDISPO + "=? " : ""; // dispo

            if (critereString[0] != null) {
                argsList.add(critereString[0]);
            }

            if (critereString[1] != null) {
                argsList.add(critereString[1]);
            }

            if (critereString[2] != null) {
                argsList.add(critereString[2]);
            }

            if (critereString[3] != null) {
                argsList.add(critereString[3]);
            }

            if (critereString[4] != null) {
                argsList.add(critereString[4]);
            }

        }
        String[] args = argsList.toArray(new String[argsList.size()]);
        if (argsList.size() == 0) {
            args = null;
        }

        Log.i("RUN", selection);

        Cursor cursor = db.query(
                VehiculeContract.TABLE_VEHICULES_NAME,
                null,
                selection,
                args,
                null,
                null,
                null);

        ArrayList<Vehicule> objects = new ArrayList<Vehicule>();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Integer id = cursor.getInt(cursor.getColumnIndex(VehiculeContract._VEHICULES_ID));
                String marque = cursor.getString(cursor.getColumnIndex(VehiculeContract._MARQUE));
                String cnit = cursor.getString(cursor.getColumnIndex(VehiculeContract._CNIT));
                Model model = modelDao.getByCnit(cnit);
                //DetailsModel detailsModel = detailModelDao.getByCnit(cnit);
                Float prix = cursor.getFloat(cursor.getColumnIndex(VehiculeContract._PRIX));
                String plaque = cursor.getString(cursor.getColumnIndex(VehiculeContract._PLAQUE));
                Agence agence = agenceDao.getByCode(cursor.getInt(cursor.getColumnIndex(VehiculeContract._CODEAGENCE)));
                boolean isDispo = cursor.getInt(cursor.getColumnIndex(VehiculeContract._ISDISPO)) == 1 ? true : false;
                String photoPath = cursor.getString(cursor.getColumnIndex(VehiculeContract._PHOTOPATH));

                objects.add(new Vehicule(id, marque, model, /*detailsModel,*/ cnit, prix, plaque,
                        agence, isDispo, photoPath));

            } while (cursor.moveToNext());

            cursor.close();
        }

        return objects;
    }

}
