package fr.ecole.eni.lokacar.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Agence;
import fr.ecole.eni.lokacar.bean.Marque;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.bean.Vehicule;
import fr.ecole.eni.lokacar.dao.ModelDao;
import fr.ecole.eni.lokacar.dao.VehiculeDao;

public class NewVehiculeActivity extends AppCompatActivity {
    VehiculeDao vehiculeDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vehicule);

        vehiculeDao = new VehiculeDao(NewVehiculeActivity.this);
    }

    public void newVehiculeClick(View view) {
/*
        String marque, Model model, String cnit, Float prix, String plaque, Agence
        agence, boolean isDispo, String photoPath
*/
        ModelDao modelDao = new ModelDao(NewVehiculeActivity.this);
        String marque = ((Marque)((Spinner) findViewById(R.id.activity_search_spin_marque)).getSelectedItem()).getNom();
        Model model = modelDao.getByCnit(((Model)((Spinner) findViewById(R.id.activity_search_spin_model)).getSelectedItem()).getCnit());
        String cnit = ((TextView) findViewById(R.id.activity_newvehicule_etCnit)).getText().toString();
        Float prix = Float.valueOf(((TextView) findViewById(R.id.activity_newvehicule_etPrix)).getText().toString());
        String plaque = ((TextView) findViewById(R.id.activity_newvehicule_etPlaque)).getText().toString();
        int codeAgence = 1; // a modifier par le code agence de l'agence connecter emmeorisée dans sharedpreferences;
        boolean isDispo = true;
        String photoPath = "";


        Vehicule vehiculeToAdd = new Vehicule(marque,model,cnit,prix,plaque,codeAgence,isDispo,photoPath);
        vehiculeDao.insert(vehiculeToAdd);
    }
}
