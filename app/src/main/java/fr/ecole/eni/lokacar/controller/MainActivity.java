package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Date;
import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.Client;
import fr.ecole.eni.lokacar.bean.Location;
import fr.ecole.eni.lokacar.bean.Marque;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.bean.Salarie;
import fr.ecole.eni.lokacar.bean.Vehicule;
import fr.ecole.eni.lokacar.dao.AgenceDao;
import fr.ecole.eni.lokacar.dao.ClientDao;
import fr.ecole.eni.lokacar.dao.LocationDao;
import fr.ecole.eni.lokacar.dao.MarqueDao;
import fr.ecole.eni.lokacar.dao.ModelDao;
import fr.ecole.eni.lokacar.dao.SalarieDao;
import fr.ecole.eni.lokacar.dao.VehiculeDao;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "PrefsFile";
    public SharedPreferences sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefs = getSharedPreferences(PREFS_NAME, 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            //associe la toolbar
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        AgenceDao agenceDao = new AgenceDao(MainActivity.this);



        // --- insertion ----
        if (agenceDao.getAll().size() == 0) {

            agenceDao.Insert(new Agence(1, "LokaCar Nantes", "Nantes", "44000"));
            agenceDao.Insert(new Agence(2, "LokaCar Paris", "Paris", "75000"));
            agenceDao.Insert(new Agence(3, "LokaCar Bordeaux", "Bordeaux", "33000"));

            SalarieDao salarieDao = new SalarieDao((MainActivity.this));//nom, String prenom, String mail, String mdp, boolean isGerant, int codeAgence
            salarieDao.Insert(new Salarie("baud", "morgane", "m.fr", "123", true, 1));
            salarieDao.Insert(new Salarie("aloche", "stephen", "s.fr", "123", true, 2));
            salarieDao.Insert(new Salarie("noob", "noob", "n.fr", "123", false, 2));

            ModelDao modelDao = new ModelDao(MainActivity.this);
            VehiculeDao vehiculeDao = new VehiculeDao(MainActivity.this);
            MarqueDao marqueDao = new MarqueDao(MainActivity.this);
            ClientDao clientDao = new ClientDao(MainActivity.this);
            LocationDao locationDao = new LocationDao(MainActivity.this);

            marqueDao.Insert(new Marque("Renault"));
            marqueDao.Insert(new Marque("Dodge"));
            marqueDao.Insert(new Marque("Ford"));

            modelDao.insert(new Model("MEGANE Berline Akaju EnergydCi (130ch) eco2", "MEGANE", "123", "RENAULT", "BERLINE", "GO", "M6", 7, 5, 3.9, 4.3));
            modelDao.insert(new Model("CLIO sport RCI (230ch)", "CLIO", "789", "RENAULT", "COMPACT", "ES", "M6", 6, 4.6, 3.2, 3.8));

            modelDao.insert(new Model("VIPER SRT-10", "VIPER", "456", "DODGE", "SPORTIVE", "ES", "M6", 506, 34.5, 13.2, 21.1));

            // marque, Model model,/* DetailsModel detailsModel,*/ String cnit, Float prix, String plaque, Agence agence, boolean isDispo, String photoPath
            clientDao.Insert(new Client("Dupont","Dupond","d@d.fr","0299147578","Nantes","44000"));
            clientDao.Insert(new Client("Emmanuel","Marron","e@m.fr","0202020202","Paris","75000"));

            locationDao.Insert(new Location(1,1,new Date(01/02/2018),new Date(04/12/2018),false));
            locationDao.Insert(new Location(2,2,new Date(04/06/2018),new Date(05/07/2018),false));
            // String cnit, Float prix, String plaque, String photoPath, boolean isDispo, int km, int codeAgence, fr.ecole.eni.lokacar.bean.Model model, String marque
            vehiculeDao.insert(new Vehicule("MEGANE", modelDao.getByCnit("123"), "123", 30.61f, "AF-68-RT", 1, true, null, 0));
            vehiculeDao.insert(new Vehicule("VIPER", modelDao.getByCnit("456"), "456", 700f, "JN-54-AZ", 1, false, null, 120));
        }
        // ------------------

        List<Agence> agences = agenceDao.getAll();

        Spinner agenceSpinner = (Spinner) findViewById(R.id.activity_main_spinner);
        agenceSpinner.setSelection(sharedPrefs.getInt("codeAgence",0));
        ((TextView) findViewById(R.id.activity_main_et_mail)).setText(sharedPrefs.getString("mail",""));
        ((TextView) findViewById(R.id.activity_main_et_mdp)).setText(sharedPrefs.getString("mdp",""));
        ((CheckBox) findViewById(R.id.acitivty_main_cb_remember)).setChecked(sharedPrefs.getBoolean("rememberChecked",false));

        ArrayAdapter<Agence> dataAdapter = new ArrayAdapter<Agence>(this, R.layout.support_simple_spinner_dropdown_item, agences);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.activity_main_spinner);
        spinner.setAdapter(dataAdapter);

    }

    public void ConectionClick(View view) {
        Agence agenceSelected = (Agence) ((Spinner) findViewById(R.id.activity_main_spinner)).getSelectedItem();
        String mail = ((TextView) findViewById(R.id.activity_main_et_mail)).getText().toString();
        String mdp = ((TextView) findViewById(R.id.activity_main_et_mdp)).getText().toString();
        SalarieDao salarieDao = new SalarieDao(MainActivity.this);


        Salarie salarie = salarieDao.getByMail(mail);
        if (salarie != null && salarie.isGerant()) {
            if (salarie.getCodeAgence() == agenceSelected.getCodeAgence()) {
                if (salarie.getMdp().equals(mdp)) {  // Connexion reussit

                    if(((CheckBox) findViewById(R.id.acitivty_main_cb_remember)).isChecked())
                    {
                        SharedPreferences.Editor editor = sharedPrefs.edit();
                        editor.clear();
                        editor.putInt("codeAgence", agenceSelected.getCodeAgence());
                        editor.putString("mail", mail);
                        editor.putString("mdp", mdp);
                        editor.putBoolean("rememberChecked",true);
                        editor.commit();
                    }
                    Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                    //intent.putExtra("agenceSelected",agenceSelected);
                    startActivity(intent);


                }
                else{
                    Toast.makeText(this,"le mot de passe n'est pas valide",Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(this,"le salarié n'est pas de cette agence",Toast.LENGTH_LONG).show();
            }
        }
        else{
            Toast.makeText(this,"le salarié n'est pas un gerant",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }
}
