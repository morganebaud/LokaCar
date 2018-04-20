package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Location;
import fr.ecole.eni.lokacar.bean.Vehicule;
import fr.ecole.eni.lokacar.dao.LocationDao;
import fr.ecole.eni.lokacar.dao.VehiculeDao;

public class LocationActivity extends AppCompatActivity {
    Location locationRecup;
    LocationDao locationDao;
    VehiculeDao vehiculeDao;
    TextView dateDebut;
    TextView dateFin;
    Button btnValiderRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            //associe la toolbar
            setSupportActionBar(toolbar);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        dateDebut = (TextView)findViewById(R.id.activity_location_etDateDebut);
        dateFin = (TextView)findViewById(R.id.activity_location_etDateFin);
        btnValiderRetour = (Button) findViewById(R.id.activity_location_btnValiderRetour);

        Intent intent = getIntent();
        int idVehicule = intent.getIntExtra("idVehicule", 0);
        try {
            locationDao = new LocationDao(LocationActivity.this);
            locationRecup = locationDao.getByIdVehicule(idVehicule);
            if(locationRecup == null) // on recois une nouvelle location pour une creation
            {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDateDebut = formatter.format(date);
                String formattedDateFin = formatter.format(date.getTime() - (7 * (1000 * 60 * 60 * 24))); // la date 7 jours plus tard

                dateDebut.setText(formattedDateDebut);
                dateFin.setText(formattedDateFin);
                btnValiderRetour.setEnabled(false);
            }else{  // on recupere une location existante pour un retour

                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String formattedDateFin = formatter.format(date);
                String formattedDateDebut = formatter.format(locationRecup.getDateDebut());

                dateFin.setText(formattedDateFin);
                dateDebut.setText(formattedDateDebut);
                btnValiderRetour.setEnabled(true);

                ValideRetour(locationRecup.getId());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private void ValideRetour(int locationId) {
        LocationDao locationDao = new LocationDao(LocationActivity.this);

        ((Button)findViewById(R.id.activity_location_btnValiderRetour)).setEnabled(true);;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(LocationActivity.this);
        inflater.inflate(R.menu.main_menu, menu);

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

            case R.id.menu_finance :
                //Intent intent = new Intent(MainActivity.this,);
                //startActivity(intent);
                break;

            case R.id.menu_newVehicule :
                intent = new Intent(LocationActivity.this, NewVehiculeActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_search :
                //intent = new Intent(SearchActivity.this,SearchActivity.class);
                //startActivity(intent);
                break;

            case R.id.menu_listVehicules :
                intent = new Intent(LocationActivity.this,VehiculesActivity.class);
                VehiculeDao vehiculeDao = new VehiculeDao(LocationActivity.this);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onRechercheClientClick(View view) {
    }

    public void onRetourClick(View view) throws ParseException {
        String dtFin = ((TextView)(findViewById(R.id.activity_location_etDateFin))).getText().toString();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date result =  df.parse(dtFin);
        locationRecup.setDateFin(result);
        locationRecup.setVehiculeRendu(true);

        Vehicule v = vehiculeDao.getById(locationRecup.getIdVehicule(), LocationActivity.this);
        v.setDispo(true);
    }
}
