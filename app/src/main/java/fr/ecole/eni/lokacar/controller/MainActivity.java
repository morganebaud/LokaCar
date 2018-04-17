package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.adapter.AgenceAdapter;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.Salarie;
import fr.ecole.eni.lokacar.dao.AgenceDao;
import fr.ecole.eni.lokacar.dao.SalarieDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        Button btnTst = (Button) findViewById(R.id.test);
        btnTst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });
        */
        AgenceDao agenceDao = new AgenceDao(MainActivity.this);
        List<Agence> agences = agenceDao.getAll();


        ArrayAdapter<Agence> dataAdapter = new ArrayAdapter<Agence>(this, R.layout.support_simple_spinner_dropdown_item, agences);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.activity_main_spinner);

        spinner.setAdapter(dataAdapter);

/*
        ArrayAdapter<Agence> adapter = new AgenceAdapter(MainActivity.this,R.layout.agence_item,agences);
        spinner.setAdapter(adapter);
        */
    }

    public void ConectionClick(View view) {
        Agence agenceSelected = (Agence) ((Spinner) findViewById(R.id.activity_main_spinner)).getSelectedItem();
        String mail = ((TextView) findViewById(R.id.activity_main_et_mail)).getText().toString();
        String mdp = ((TextView) findViewById(R.id.activity_main_et_mdp)).getText().toString();
        SalarieDao salarieDao = new SalarieDao(MainActivity.this);

        Salarie salarie = salarieDao.getByMail(mail);
        if (salarie != null && salarie.isGerant()) {
            if (salarie.getCodeAgence() == agenceSelected.getCodeAgence() && salarie.getMdp() == mdp) {
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                //intent.putExtra("agenceSelected",agenceSelected);
                startActivity(intent);
            }
        }
    }
}
