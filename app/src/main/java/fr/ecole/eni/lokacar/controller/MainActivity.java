package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.bean.Salarie;
import fr.ecole.eni.lokacar.bean.Vehicule;
import fr.ecole.eni.lokacar.dao.AgenceDao;
import fr.ecole.eni.lokacar.dao.ModelDao;
import fr.ecole.eni.lokacar.dao.SalarieDao;
import fr.ecole.eni.lokacar.dao.VehiculeDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

            // String designation, String modeleCommercial, String cnit, String marque, String carrosserie, String carburant, String boiteDeVitesse, int puissanceAdministrative, double consommationUrbaine, double consommationExtraUrbaine, double consommationMixte
            modelDao.insert(new Model("MEGANE Berline Akaju EnergydCi (130ch) eco2", "MEGANE", "123", "RENAULT", "BERLINE", "GO", "M6", 7, 5, 3.9, 4.3));
            modelDao.insert(new Model("VIPER SRT-10", "VIPER", "456", "DODGE", "SPORTIVE", "ES", "M6", 506, 34.5, 13.2, 21.1));

            // marque, Model model,/* DetailsModel detailsModel,*/ String cnit, Float prix, String plaque, Agence agence, boolean isDispo, String photoPath
            vehiculeDao.insert(new Vehicule("MEGANE", modelDao.getByCnit("123"), "123", 30.61f, "AF-68-RT", 1, true, null));
            vehiculeDao.insert(new Vehicule("VIPER", modelDao.getByCnit("456"), "456", 700f, "JN-54-AZ", 1, false, null));
        }
        // ------------------

        List<Agence> agences = agenceDao.getAll();

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
                if (salarie.getMdp().equals(mdp)) {
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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case    R.id.menu_locenCours :
                //Intent intent = new Intent(MainActivity.this,);
                //startActivity(intent);
                break;

            case R.id.menu_newLoc :
                //Intent intent = new Intent(MainActivity.this,);
                //startActivity(intent);
                break;

            case R.id.menu_finance :
                //Intent intent = new Intent(MainActivity.this,);
                //startActivity(intent);
                break;

            case R.id.menu_newVehicule :
                //Intent intent = new Intent(MainActivity.this,);
                //startActivity(intent);
                break;

            case R.id.menu_search :
                intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_listVehicules :
                intent = new Intent(MainActivity.this,VehiculesActivity.class);
                VehiculeDao vehiculeDao = new VehiculeDao(MainActivity.this);
                intent.putParcelableArrayListExtra("resultats", vehiculeDao.getListeBySearch(MainActivity.this,null));
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
