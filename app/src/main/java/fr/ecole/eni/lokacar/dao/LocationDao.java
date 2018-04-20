package fr.ecole.eni.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.ecole.eni.lokacar.bddHelper.LocationHelper;
import fr.ecole.eni.lokacar.bean.Location;
import fr.ecole.eni.lokacar.contract.LocationContract;

public class LocationDao {
    private LocationHelper dbHelper;

    public LocationDao(Context context) {
        this.dbHelper = new LocationHelper(context);
    }

    private ContentValues constructValuesDB(Location location) {
        ContentValues values = new ContentValues();
        values.put(LocationContract._ID_CLIENT, location.getIdClient());
        values.put(LocationContract._ID_VEHICULE, location.getIdVehicule());
        values.put(LocationContract._DATE_DEBUT, location.getDateDebut().toString());
        values.put(LocationContract._DATE_FIN, location.getDateFin().toString());
        values.put(LocationContract._IS_VEHICULE_RENDU, location.getVehiculeRendu());
        return values;
    }

    public void Insert(Location location) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(LocationContract.TABLE_LOCATION_NAME, null, constructValuesDB(location));

        db.close();
    }

    public Location getById(int id) throws ParseException {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                LocationContract.TABLE_LOCATION_NAME, null,
                LocationContract._LOCATION_ID + "=?",
                new String[]{String.valueOf(id)},
                null,
                null,
                null);

        Location object = null;

        if (cursor != null && cursor.moveToFirst()) {
            int idClient = cursor.getInt(cursor.getColumnIndex(LocationContract._ID_CLIENT));
            int idVehicule = cursor.getInt(cursor.getColumnIndex(LocationContract._ID_VEHICULE));
            String dateDebut = cursor.getString(cursor.getColumnIndex(LocationContract._DATE_DEBUT));
            String dateFin = cursor.getString(cursor.getColumnIndex(LocationContract._DATE_FIN));
            Boolean isVehiculeRendu = cursor.getInt(cursor.getColumnIndex(LocationContract._IS_VEHICULE_RENDU)) == 1;

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dDebut = df.parse(dateDebut);
            Date dFin = df.parse(dateFin);

            object = new Location(id, idClient, idVehicule, dDebut, dFin, isVehiculeRendu);
            cursor.close();
        }
        return object;
    }

    public Location getByIdVehicule(int idVehicule) throws ParseException {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                LocationContract.TABLE_LOCATION_NAME, null,
                LocationContract._ID_VEHICULE + "=?",
                new String[]{String.valueOf(idVehicule)},
                null,
                null,
                null);

        Location object = null;

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndex(LocationContract._LOCATION_ID));
            int idClient = cursor.getInt(cursor.getColumnIndex(LocationContract._ID_CLIENT));
            String dateDebut = cursor.getString(cursor.getColumnIndex(LocationContract._DATE_DEBUT));
            String dateFin = cursor.getString(cursor.getColumnIndex(LocationContract._DATE_FIN));
            Boolean isVehiculeRendu = cursor.getInt(cursor.getColumnIndex(LocationContract._IS_VEHICULE_RENDU)) == 1;

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dDebut = df.parse(dateDebut);
            Date dFin = df.parse(dateFin);

            object = new Location(id, idClient, idVehicule, dDebut, dFin, isVehiculeRendu);
            cursor.close();
        }
        return object;
    }

}
