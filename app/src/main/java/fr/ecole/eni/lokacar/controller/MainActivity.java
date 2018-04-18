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
import android.widget.Toast;

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


        AgenceDao agenceDao = new AgenceDao(MainActivity.this);
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
}
