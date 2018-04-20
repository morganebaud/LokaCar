package fr.ecole.eni.lokacar.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import fr.ecole.eni.lokacar.bddHelper.ClientHelper;
import fr.ecole.eni.lokacar.bddHelper.SalarieHelper;
import fr.ecole.eni.lokacar.bean.Client;
import fr.ecole.eni.lokacar.bean.Salarie;
import fr.ecole.eni.lokacar.contract.ClientContract;
import fr.ecole.eni.lokacar.contract.ClientContract;

public class ClientDao {
    private ClientHelper dbHelper;

    public ClientDao(Context context) {
        this.dbHelper = new ClientHelper(context);
    }

    private ContentValues constructValuesDB(Client client) {
        ContentValues values = new ContentValues();
        values.put(ClientContract._NOM , client.getNom());
        values.put(ClientContract._PRENOM , client.getPrenom());
        values.put(ClientContract._MAIL ,client.getMail());
        values.put(ClientContract._CP , client.getCodePostal());
        values.put(ClientContract._VILLE , client.getVille());
        values.put(ClientContract._TEL , client.getTelephone());
        return values;
    }

    public void Insert(Client client) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(ClientContract.TABLE_CLIENT_NAME, null, constructValuesDB(client));

        db.close();
    }

    public Client getByMail(String mail) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                ClientContract.TABLE_CLIENT_NAME, null,
                ClientContract._MAIL + "=?",
                new String[]{mail},
                null,
                null,
                null);

        Client object = null;

        if (cursor != null && cursor.moveToFirst()) {
            Integer id = cursor.getInt(cursor.getColumnIndex(ClientContract._CLIENT_ID));
            String nom = cursor.getString(cursor.getColumnIndex(ClientContract._NOM));
            String prenom = cursor.getString(cursor.getColumnIndex(ClientContract._PRENOM));
            String codepostal = cursor.getString(cursor.getColumnIndex(ClientContract._CP));
            String ville = cursor.getString(cursor.getColumnIndex(ClientContract._VILLE));
            String tel = cursor.getString(cursor.getColumnIndex(ClientContract._TEL));

            object = new Client(id,nom,prenom,mail,ville,tel,codepostal);
            cursor.close();
        }
        return object;
    }

    public Client getByNom(String nom) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                ClientContract.TABLE_CLIENT_NAME, null,
                ClientContract._NOM + "=?",
                new String[]{nom},
                null,
                null,
                null);

        Client object = null;

        if (cursor != null && cursor.moveToFirst()) {
            Integer id = cursor.getInt(cursor.getColumnIndex(ClientContract._CLIENT_ID));
            String prenom = cursor.getString(cursor.getColumnIndex(ClientContract._PRENOM));
            String mail  = cursor.getString(cursor.getColumnIndex(ClientContract._MAIL));
            String codepostal = cursor.getString(cursor.getColumnIndex(ClientContract._CP));
            String ville = cursor.getString(cursor.getColumnIndex(ClientContract._VILLE));
            String tel = cursor.getString(cursor.getColumnIndex(ClientContract._TEL));

            object = new Client(id,nom,prenom,mail,ville,tel,codepostal);
            cursor.close();
        }
        return object;
    }
}
