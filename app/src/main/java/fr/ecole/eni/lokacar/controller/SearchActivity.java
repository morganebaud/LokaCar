package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.Marque;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.bean.Voiture;
import fr.ecole.eni.lokacar.dao.VoitureDao;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

    }

    public void SearchClick(View view) {
        //si la recherche est vide on envoie tout la liste
        Intent intent = new Intent(SearchActivity.this,ListActivity.class);

        VoitureDao voitureDao = new VoitureDao(SearchActivity.this);

        String critereMarque =  null;//((Marque) ((Spinner) findViewById(R.id.activity_search_spin_marque)).getSelectedItem()).getNom();
        String critereModel = null;//((Model) ((Spinner) findViewById(R.id.activity_search_spin_model)).getSelectedItem()).getModeleCommercial();

        String criterePrixMin = ((TextView) findViewById(R.id.activity_search_etnum_prixmin)).getText().toString();
        criterePrixMin = criterePrixMin.isEmpty() ?  null : criterePrixMin;

        String criterePrixMax = ((TextView) findViewById(R.id.activity_search_etnum_prixmax)).getText().toString();
        criterePrixMax = criterePrixMax.isEmpty() ?  null : criterePrixMax;

        //String critereDispo = ((CheckBox) findViewById(R.id.activity_search_cb_dispo)).isChecked() ? "1" : "0";


        ArrayList<Voiture> resultats = voitureDao.getListeBySearch(SearchActivity.this,critereMarque, critereModel,criterePrixMin,criterePrixMax/*,critereDispo*/);


        intent.putParcelableArrayListExtra("resultats",resultats);

        startActivity(intent);
    }
}
