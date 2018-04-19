package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Vehicule;
import fr.ecole.eni.lokacar.dao.VehiculeDao;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            //associe la toolbar
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }

    public void SearchClick(View view) {
        //si la recherche est vide on envoie tout la liste
        Intent intent = new Intent(SearchActivity.this,VehiculesActivity.class);

        VehiculeDao vehiculeDao = new VehiculeDao(SearchActivity.this);

        String critereMarque =  null;//((Marque) ((Spinner) findViewById(R.id.activity_search_spin_marque)).getSelectedItem()).getNom();
        String critereModel = null;//((Model) ((Spinner) findViewById(R.id.activity_search_spin_model)).getSelectedItem()).getModeleCommercial();

        String criterePrixMin = ((TextView) findViewById(R.id.activity_search_etnum_prixmin)).getText().toString();
        criterePrixMin = criterePrixMin.isEmpty() ?  null : criterePrixMin;

        String criterePrixMax = ((TextView) findViewById(R.id.activity_search_etnum_prixmax)).getText().toString();
        criterePrixMax = criterePrixMax.isEmpty() ?  null : criterePrixMax;

        //String critereDispo = ((CheckBox) findViewById(R.id.activity_search_cb_dispo)).isChecked() ? "1" : "0";
        String critereDispo = "";
        if (((RadioButton)findViewById(R.id.activity_search_rb_dispo)).isChecked()) // dispo
        {
            critereDispo = "1";
        }
        else if(((RadioButton)findViewById(R.id.activity_search_rb_nondispo)).isChecked()) // nondispo
        {
            critereDispo = "0";
        }
        else
        {
            critereDispo = null;
        }

        ArrayList<Vehicule> resultats = vehiculeDao.getListeBySearch(SearchActivity.this, critereMarque, critereModel, criterePrixMin, criterePrixMax, critereDispo);

        intent.putParcelableArrayListExtra("resultats",resultats);

        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(SearchActivity.this);

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
                intent = new Intent(SearchActivity.this, NewVehiculeActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_search :
                //intent = new Intent(SearchActivity.this,SearchActivity.class);
                //startActivity(intent);
                break;

            case R.id.menu_listVehicules :
                intent = new Intent(SearchActivity.this,VehiculesActivity.class);
                VehiculeDao vehiculeDao = new VehiculeDao(SearchActivity.this);
                intent.putParcelableArrayListExtra("resultats", vehiculeDao.getListeBySearch(SearchActivity.this,null));
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
