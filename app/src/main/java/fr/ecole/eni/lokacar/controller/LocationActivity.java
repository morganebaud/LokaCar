package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
import fr.ecole.eni.lokacar.dao.VehiculeDao;

public class LocationActivity extends AppCompatActivity {
    Location locationRecup;
    TextView dateDebut;
    TextView dateFin;
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

        Intent intent = getIntent();
        if(intent.getParcelableExtra("locationId") == null) // on recois une nouvelle location pour une creation
        {
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDateDebut = formatter.format(date);
            String formattedDateFin = formatter.format(date.getTime() - (7 * (1000 * 60 * 60 * 24))); // la date 7 jours plus tard

            dateDebut.setText(formattedDateDebut);
            dateFin.setText(formattedDateFin);

        }else{  // on recupere une location existante pour un retour
            int locationId = intent.getParcelableExtra("locationId");
            locationRecup = locationDao.getLocationById(locationId);

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String formattedDateFin = formatter.format(date);
            String formattedDateDebut = formatter.format(locationRecup.getDateDebut());
            dateFin.setText(formattedDateFin);

            dateDebut.setText(formattedDateDebut);
            ValideRetour(locationId);
        }
    }

    private void ValideRetour(int locationId) {
        LocationDao locationDao = new LocationDao();

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
        locationRecup.isVehiculeRendu() = true;
        locationRecup.getVehicule().setDispo(true);
    }
}
