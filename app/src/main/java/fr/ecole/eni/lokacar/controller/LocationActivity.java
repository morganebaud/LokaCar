package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.dao.VehiculeDao;

public class LocationActivity extends AppCompatActivity {

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
}
