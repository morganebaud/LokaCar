package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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


        ArrayList<Vehicule> resultats = vehiculeDao.getListeBySearch(SearchActivity.this,critereMarque, critereModel,criterePrixMin,criterePrixMax/*,critereDispo*/);


        intent.putParcelableArrayListExtra("resultats",resultats);

        startActivity(intent);
    }
}
