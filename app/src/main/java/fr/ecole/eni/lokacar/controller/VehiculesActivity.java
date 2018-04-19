package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.adapter.VehiculesRecyclerViewAdapter;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.bean.Vehicule;
import fr.ecole.eni.lokacar.dao.VehiculeDao;
import fr.ecole.eni.lokacar.fragment.DetailFragment;
import fr.ecole.eni.lokacar.fragment.VehiculesFragment;

public class VehiculesActivity extends AppCompatActivity
        implements
        VehiculesFragment.OnListFragmentInteractionListener,
        DetailFragment.OnFragmentInteractionListener {

    private List<Vehicule> mVehicules;
    private VehiculesFragment mVehiculesFragment;
    private DetailFragment mDetailFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicules);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            //associe la toolbar
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mVehiculesFragment = (VehiculesFragment) getSupportFragmentManager().findFragmentById(R.id.vehiculesFragment);
        mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetail);

        Intent intent = getIntent();
        mVehicules = intent.getParcelableArrayListExtra("resultats");

        if (mVehiculesFragment != null && mVehiculesFragment.isInLayout()) {
            setAdapterListe();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = new MenuInflater(VehiculesActivity.this);
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
                intent = new Intent(VehiculesActivity.this, NewVehiculeActivity.class);
                startActivity(intent);
                break;

            case R.id.menu_search :
                //intent = new Intent(SearchActivity.this,SearchActivity.class);
                //startActivity(intent);
                break;

            case R.id.menu_listVehicules :
                intent = new Intent(VehiculesActivity.this,VehiculesActivity.class);
                VehiculeDao vehiculeDao = new VehiculeDao(VehiculesActivity.this);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(Vehicule item) {
        Model detail = item.getModel();
        //Model detail = new Model(0,"manuelle", 0, 0,0, "bleue", null,"essence", 0, 0,null,null,null);

        if (detail == null) {
            Toast.makeText(VehiculesActivity.this, "Erreur dans le chargement du détail", Toast.LENGTH_LONG).show();
        } else {
            chargeDetail(detail);
        }
    }

    /*
     * Affiche le détail ou l'activité
     */
    private void chargeDetail(Model detail) {
        if (mDetailFragment != null && mDetailFragment.isInLayout()) {
            mDetailFragment.chargeDetail(detail);
        } else {
            Intent intent = new Intent(VehiculesActivity.this, DetailActivity.class);
            intent.putExtra("detail", detail);
            startActivity(intent);
        }
    }

    // Renseigne la liste au fragment contenant le RecyclerView
    private void setAdapterListe() {
        mVehiculesFragment.setAdapter(new VehiculesRecyclerViewAdapter(mVehicules, VehiculesActivity.this));
    }
}
