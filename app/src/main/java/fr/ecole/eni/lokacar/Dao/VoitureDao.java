package fr.ecole.eni.lokacar.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import fr.ecole.eni.lokacar.BDDHelper.VoitureHelper;
import fr.ecole.eni.lokacar.Contract.DetailsModelContract;
import fr.ecole.eni.lokacar.Contract.ModelContract;
import fr.ecole.eni.lokacar.Contract.VoitureContract;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.DetailsModel;
import fr.ecole.eni.lokacar.bean.Marque;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.bean.Voiture;

public class VoitureDao {

    private VoitureHelper dbhelper;

    public VoitureDao(Context context) {
        this.dbhelper = new VoitureHelper(context);
    }

    private ContentValues constructValuesDB(Voiture voiture) {
        ContentValues values = new ContentValues();
         values.put(VoitureContract._VOITURE_ID , voiture.getId());
         values.put(VoitureContract._CNIT , voiture.getCNIT());
         values.put(VoitureContract._PRIX , voiture.getPrix());
         values.put(VoitureContract._PLAQUE , voiture.getPlaque());
         values.put(VoitureContract._PHOTOPATH , voiture.getPhotoPath());
         values.put(VoitureContract._ISDISPO , voiture.isDispo()?1:0);
         values.put(VoitureContract._MARQUE  , voiture.getMarque().getNom());
         values.put(VoitureContract._CODEAGENCE  , voiture.getAgence().getCodeAgence());
        return values;
    }

    public long insert(Voiture voiture){

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
                VoitureContract.TABLE_VOITURES_NAME, null,null,null,
                null,
                null,
                null);

        List<Voiture> objects = new ArrayList<Voiture>() ;

        if(cursor != null && cursor.moveToFirst()){
            do{

                Integer id = cursor.getInt(cursor.getColumnIndex(VoitureContract._VOITURE_ID));
                Marque marque = new Marque(cursor.getString(cursor.getColumnIndex(VoitureContract._MARQUE)));

                String cnit = cursor.getString(cursor.getColumnIndex(VoitureContract._CNIT));
                Model model = modelDao.getByCnit(cnit);
                DetailsModel detailsModel = detailModelDao.getByCnit(cnit);
                Float prix = cursor.getFloat(cursor.getColumnIndex(VoitureContract._PRIX));
                String plaque = cursor.getString(cursor.getColumnIndex(VoitureContract._PLAQUE));
                Agence agence = agenceDao.getByCode(cursor.getInt(cursor.getColumnIndex(VoitureContract._CODEAGENCE)));
                boolean isDispo = cursor.getInt(cursor.getColumnIndex(VoitureContract._ISDISPO)) == 1 ? true : false;
                String photoPath = cursor.getString(cursor.getColumnIndex(VoitureContract._PHOTOPATH));

                objects.add(new Voiture( id,  marque,  model,  detailsModel,  cnit,  prix,  plaque,
                agence,  isDispo,  photoPath));

            }while (cursor.moveToNext());

            cursor.close();
        }

        return objects;
    }

}