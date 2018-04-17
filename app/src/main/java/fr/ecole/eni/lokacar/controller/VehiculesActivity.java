package fr.ecole.eni.lokacar.controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.adapter.VehiculesRecyclerViewAdapter;
import fr.ecole.eni.lokacar.bean.DetailsModel;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.bean.Voiture;
import fr.ecole.eni.lokacar.fragment.DetailFragment;
import fr.ecole.eni.lokacar.fragment.VehiculesFragment;

public class VehiculesActivity extends AppCompatActivity
        implements /*ActivityMessage,*/
        VehiculesFragment.OnListFragmentInteractionListener,
        DetailFragment.OnFragmentInteractionListener{

    private List<Voiture> mVehicules;
    private VehiculesFragment mVehiculesFragment;
    private DetailFragment mDetailFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicules);

        mVehiculesFragment = (VehiculesFragment) getSupportFragmentManager().findFragmentById(R.id.vehiculesFragment);
        mDetailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentDetail);

        mVehicules = new ArrayList<Voiture>();
        mVehicules.add(new Voiture("Peugeot", new Model("308","Peugeot 308",null,null,null),null,null, 15.6f,null,null,false,null));
        mVehicules.add(new Voiture("Citroen",  new Model("C3","Citroen C3",null,null,null),null,null, 8.30f,null,null,false,null));

        if(mVehiculesFragment != null && mVehiculesFragment.isInLayout()){
            setAdapterListe();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onListFragmentInteraction(Voiture item) {
        //DetailsModel detail = item.getDetailsModel();
        DetailsModel detail = new DetailsModel(0,"manuelle", 0, 0,0, "bleue", null,"essence", 0, 0,null,null,null);

        if(detail == null){
            Toast.makeText(VehiculesActivity.this, "Erreur dans le chargement du détail", Toast.LENGTH_LONG).show();
        }
        else {
            chargeDetail(detail);
        }
    }

    /*
     * affiche le détail ou l'activité
     */
    private void chargeDetail(DetailsModel detail){
        if (mDetailFragment != null && mDetailFragment.isInLayout()) {
            mDetailFragment.chargeDetail(detail);
        } else {
            Intent intent = new Intent(VehiculesActivity.this, DetailActivity.class);
            intent.putExtra("detail", detail);
            startActivity(intent);
        }
    }

    //Renseigne la liste au fr&agment contenant le RecyclerView
    private void setAdapterListe(){
        mVehiculesFragment.setAdapter(new VehiculesRecyclerViewAdapter(mVehicules, VehiculesActivity.this));
    }
}
