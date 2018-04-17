package fr.ecole.eni.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import fr.ecole.eni.lokacar.bddHelper.DetailsModelHelper;
import fr.ecole.eni.lokacar.contract.DetailsModelContract;
import fr.ecole.eni.lokacar.bean.DetailsModel;

public class DetailsModelDao {

    private DetailsModelHelper dbHelper;

    public DetailsModelDao(Context context) {
        this.dbHelper = new DetailsModelHelper(context);

    }

    private ContentValues constructValuesDB(DetailsModel detailsModel) {
        ContentValues values = new ContentValues();
        values.put(DetailsModelContract._DETAILSMODEL_ID, detailsModel.getId());
        values.put(DetailsModelContract._CONSOMMATION_EXTRA_URBAINE, detailsModel.getConsommationExtraUrbaine());
        values.put(DetailsModelContract._BOITE_DE_VITESSE, detailsModel.getBoiteDeVitesse());
        values.put(DetailsModelContract._MASSE_MINI,detailsModel.getMasseMini());
        values.put(DetailsModelContract._PUISSANCE_ADMINISTRATIVE, detailsModel.getPuissanceAdministrative());
        values.put(DetailsModelContract._EMISSION_CO2, detailsModel.getEmissionCo2());
        values.put(DetailsModelContract._CARROSSERIE, detailsModel.getCarrosserie());
        values.put(DetailsModelContract._HYBRIDE, detailsModel.getHybride());
        values.put(DetailsModelContract._CARBURANT, detailsModel.getCarburant());
        values.put(DetailsModelContract._CONSOMMATION_URBAINE, detailsModel.getConsommationUrbaine());
        values.put(DetailsModelContract._CONSOMMATION_MIXTE, detailsModel.getConsommationMixte());
        values.put(DetailsModelContract._CODE_NATIONAL_IDENTIFICATION_TYPE, detailsModel.getCodeNationalIdentificationType());
        values.put(DetailsModelContract._DATE_MISE_A_JOUR, detailsModel.getDateMiseAjour());
        values.put(DetailsModelContract._DESIGNATION, detailsModel.getDesignation());
        return values;
    }

    public long insert(DetailsModel modele){

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        long id = db.insert(DetailsModelContract.TABLE_MODELE_DETAIL_NAME, null, constructValuesDB(modele));

        db.close();

        return id;
    }

    public long insertOrUpdate(DetailsModel modele){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = -1;
        Cursor c = db.query(DetailsModelContract.TABLE_MODELE_DETAIL_NAME, null,
                            "ID="+modele.getId(), null,null,null,null);

        if(c.getCount() > 0){
            update(modele);
        }
        else {
            insert(modele);
        }

        db.close();

        return id;
    }

    public DetailsModel getByCnit(String cnit) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DetailsModelContract.TABLE_MODELE_DETAIL_NAME, null,
                DetailsModelContract._CODE_NATIONAL_IDENTIFICATION_TYPE+"=?",
                new String[]{cnit},
                null,
                null,
                null);

        DetailsModel object = null ;

        if(cursor != null && cursor.moveToFirst()){

                Integer id = cursor.getInt(cursor.getColumnIndex(DetailsModelContract._DETAILSMODEL_ID));
                double consommationEU = cursor.getDouble(cursor.getColumnIndex(DetailsModelContract._CONSOMMATION_EXTRA_URBAINE));
                String boiteVitesse = cursor.getString(cursor.getColumnIndex(DetailsModelContract._BOITE_DE_VITESSE));
                int masse = cursor.getInt(cursor.getColumnIndex(DetailsModelContract._MASSE_MINI));
                int puissance = cursor.getInt(cursor.getColumnIndex(DetailsModelContract._PUISSANCE_ADMINISTRATIVE));
                int co2 = cursor.getInt(cursor.getColumnIndex(DetailsModelContract._EMISSION_CO2));
                String carosserie = cursor.getString(cursor.getColumnIndex(DetailsModelContract._CARROSSERIE));
                String hybride = cursor.getString(cursor.getColumnIndex(DetailsModelContract._HYBRIDE));
                String carburant = cursor.getString(cursor.getColumnIndex(DetailsModelContract._CARBURANT));
                double consommationU = cursor.getDouble(cursor.getColumnIndex(DetailsModelContract._CONSOMMATION_URBAINE));
                double consommationM = cursor.getDouble(cursor.getColumnIndex(DetailsModelContract._CONSOMMATION_MIXTE));
                String dateMiseJour = cursor.getString(cursor.getColumnIndex(DetailsModelContract._DATE_MISE_A_JOUR));
                String designation = cursor.getString(cursor.getColumnIndex(DetailsModelContract._DESIGNATION));

                object = new DetailsModel(id,
                        consommationEU,
                        boiteVitesse,
                        masse,
                        puissance,
                        co2,
                        carosserie,
                        hybride,
                        carburant,
                        consommationU,
                        consommationM,
                        cnit,
                        dateMiseJour,
                        designation);

            cursor.close();
        }

        return object;
    }



    public void update(int id, DetailsModel modele) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.update(DetailsModelContract.TABLE_MODELE_DETAIL_NAME, constructValuesDB(modele),
                "ID=" + id,
                null);
        db.close();
    }

    public void update( DetailsModel modele) {
        update(modele.getId(), modele);
    }

}
