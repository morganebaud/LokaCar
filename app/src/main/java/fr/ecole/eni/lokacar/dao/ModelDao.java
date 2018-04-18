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
        values.put(ModelContract._CNIT,modele.getCnit());
        values.put(ModelContract._MARQUE, modele.getMarque());
        values.put(ModelContract._MODELE_DOSSIER, modele.getModeleDossier());
        values.put(ModelContract._CARROSSERIE, modele.getCarrosserie());
        values.put(ModelContract._CARBURANT, modele.getCarburant());
        values.put(ModelContract._BOITEDEVITESSE, modele.getBoiteDeVitesse());
        values.put(ModelContract._PUISSANCEADMINISTRATIVE,modele.getPuissanceAdministrative());
        values.put(ModelContract._CONSOMMATIONURBAINE, modele.getConsommationUrbaine());
        values.put(ModelContract._CONSOMMATIONEXTRAURBAINE, modele.getConsommationExtraUrbaine());
        values.put(ModelContract._CONSOMMATIONMIXTE, modele.getConsommationMixte());

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
                String carrosserie = cursor.getString(cursor.getColumnIndex(ModelContract._CARROSSERIE));
                String carburant = cursor.getString(cursor.getColumnIndex(ModelContract._CARBURANT));
                String boiteDeVitesse = cursor.getString(cursor.getColumnIndex(ModelContract._BOITEDEVITESSE));
                int puissanceAdministrative = cursor.getInt(cursor.getColumnIndex(ModelContract._PUISSANCEADMINISTRATIVE));
                Double consommationUrbaine = cursor.getDouble(cursor.getColumnIndex(ModelContract._CONSOMMATIONURBAINE));
                Double consommationExtraUrbaine = cursor.getDouble(cursor.getColumnIndex(ModelContract._CONSOMMATIONEXTRAURBAINE));
                Double consommationMixte = cursor.getDouble(cursor.getColumnIndex(ModelContract._CONSOMMATIONMIXTE));

                objects.add(new Model(id, designation, modeleCommercial, cnit, modeleDossier, marque, carrosserie, carburant, boiteDeVitesse, puissanceAdministrative, consommationUrbaine, consommationExtraUrbaine, consommationMixte));

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
                String carrosserie = cursor.getString(cursor.getColumnIndex(ModelContract._CARROSSERIE));
                String carburant = cursor.getString(cursor.getColumnIndex(ModelContract._CARBURANT));
                String boiteDeVitesse = cursor.getString(cursor.getColumnIndex(ModelContract._BOITEDEVITESSE));
                int puissanceAdministrative = cursor.getInt(cursor.getColumnIndex(ModelContract._PUISSANCEADMINISTRATIVE));
                Double consommationUrbaine = cursor.getDouble(cursor.getColumnIndex(ModelContract._CONSOMMATIONURBAINE));
                Double consommationExtraUrbaine = cursor.getDouble(cursor.getColumnIndex(ModelContract._CONSOMMATIONEXTRAURBAINE));
                Double consommationMixte = cursor.getDouble(cursor.getColumnIndex(ModelContract._CONSOMMATIONMIXTE));

                object = new Model(id, designation, modeleCommercial, cnit, modeleDossier, marque, carrosserie, carburant, boiteDeVitesse, puissanceAdministrative, consommationUrbaine, consommationExtraUrbaine, consommationMixte);

            cursor.close();
        }
        return object;
    }
}
