package fr.ecole.eni.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.ecole.eni.lokacar.bddHelper.ModelHelper;
import fr.ecole.eni.lokacar.contract.ModelContract;
import fr.ecole.eni.lokacar.bean.Model;

public class ModelDao {


    private ModelHelper dbHelper;

    public ModelDao(Context context) {
        this.dbHelper = new ModelHelper(context);

    }

    /**
     * Create ContentValues with modele
     * @param modele
     * @return
     */
    private ContentValues constructValuesDB(Model modele) {
        ContentValues values = new ContentValues();
        values.put(ModelContract._MODEL_ID, modele.getId());
        values.put(ModelContract._DESIGNATION, modele.getDesignation());
        values.put(ModelContract._MODELE_COMMERCIAL, modele.getModeleCommercial());
        values.put(ModelContract._CNIT,modele.getCNIT());
        values.put(ModelContract._MODELE_DOSSIER, modele.getModeleDossier());
        values.put(ModelContract._MARQUE, modele.getMarque());
        return values;
    }

    public long insert(Model model){

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        long id = db.insert(ModelContract.TABLE_MODELS_NAME, null, constructValuesDB(model));

        db.close();

        return id;
    }

    public long insertOrUpdate(Model model){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = -1;
        Cursor c = db.query(ModelContract.TABLE_MODELS_NAME, null,
                "ID="+model.getId(), null,null,null,null);

        if(c.getCount() > 0){
            update(model);
        }
        else {
            insert(model);
        }

        db.close();

        return id;
    }

    public List<Model> getListeByMarque(String marqueModele) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                ModelContract.TABLE_MODELS_NAME, null,
                ModelContract._MARQUE+"=?",
                new String[]{marqueModele},
                null,
                null,
                ModelContract._MODELE_COMMERCIAL);

        List<Model> objects = new ArrayList<Model>() ;

        if(cursor != null && cursor.moveToFirst()){
            do{

                Integer id = cursor.getInt(cursor.getColumnIndex(ModelContract._MODEL_ID));
                String designation = cursor.getString(cursor.getColumnIndex(ModelContract._DESIGNATION));
                String modeleCommercial = cursor.getString(cursor.getColumnIndex(ModelContract._MODELE_COMMERCIAL));
                String cnit = cursor.getString(cursor.getColumnIndex(ModelContract._CNIT));
                String modeleDossier = cursor.getString(cursor.getColumnIndex(ModelContract._MODELE_DOSSIER));
                String marque = cursor.getString(cursor.getColumnIndex(ModelContract._MARQUE));

                objects.add(new Model(id, designation, modeleCommercial, cnit, modeleDossier, marque));

            }while (cursor.moveToNext());

            cursor.close();
        }

        return objects;
    }



    public void update(int id, Model model) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.update(ModelContract.TABLE_MODELS_NAME, constructValuesDB(model),
                "ID=" + id,
                null);
        db.close();
    }

    public void update( Model model) {
        update(model.getId(), model);
    }


    public Model getByCnit(String cnit) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                ModelContract.TABLE_MODELS_NAME, null,
                ModelContract._CNIT+"=?",
                new String[]{cnit},
                null,
                null,
                ModelContract._MODELE_COMMERCIAL);

       Model object = null ;

        if(cursor != null && cursor.moveToFirst()){
                Integer id = cursor.getInt(cursor.getColumnIndex(ModelContract._MODEL_ID));
                String designation = cursor.getString(cursor.getColumnIndex(ModelContract._DESIGNATION));
                String modeleCommercial = cursor.getString(cursor.getColumnIndex(ModelContract._MODELE_COMMERCIAL));
                cnit = cursor.getString(cursor.getColumnIndex(ModelContract._CNIT));
                String modeleDossier = cursor.getString(cursor.getColumnIndex(ModelContract._MODELE_DOSSIER));
                String marque = cursor.getString(cursor.getColumnIndex(ModelContract._MARQUE));

                object = new Model(id, designation, modeleCommercial, cnit, modeleDossier, marque);

            cursor.close();
        }
        return object;
    }
}
