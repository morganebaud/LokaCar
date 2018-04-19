package fr.ecole.eni.lokacar.controller;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Marque;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.bean.Vehicule;
import fr.ecole.eni.lokacar.dao.MarqueDao;
import fr.ecole.eni.lokacar.dao.ModelDao;
import fr.ecole.eni.lokacar.dao.VehiculeDao;

public class NewVehiculeActivity extends AppCompatActivity {
    VehiculeDao vehiculeDao;
    MarqueDao marqueDao;
    ModelDao modeleDao;
    Marque marqueSelected;
    boolean canTakePhoto = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_vehicule);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            canTakePhoto = false;
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }

        vehiculeDao = new VehiculeDao(NewVehiculeActivity.this);
        marqueDao = new MarqueDao(NewVehiculeActivity.this);
        modeleDao = new ModelDao(NewVehiculeActivity.this);
        List<Marque> marques = marqueDao.getAll();

        final TextView modeleCommercial = (TextView) findViewById(R.id.activity_newvehicule_tvmodeleCommercial);
        final TextView carrosserie = (TextView) findViewById(R.id.activity_newvehicule_tvCarosserie);
        final TextView carburant = (TextView) findViewById(R.id.activity_newvehicule_tvCarburant);
        final TextView boiteDeVitesse = (TextView) findViewById(R.id.activity_newvehicule_tvBoiteDeVitesse);
        final TextView puissanceAdministrative = (TextView) findViewById(R.id.activity_newvehicule_tvPuissance);
        final TextView consommationUrbaine = (TextView) findViewById(R.id.activity_newvehicule_tvConsoUrb);
        final TextView consommationExtraUrbaine = (TextView) findViewById(R.id.activity_newvehicule_tvConsoExU);
        final TextView consommationMixte = (TextView) findViewById(R.id.activity_newvehicule_tvConsoMixte);


        ArrayAdapter<Marque> marqueAdapter = new ArrayAdapter<Marque>(this, R.layout.support_simple_spinner_dropdown_item, marques);
        marqueAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = findViewById(R.id.activity_newvehicule_spinMarque);
        spinner.setAdapter(marqueAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Log.i("SPINNER", "Onitemselected");
                marqueSelected = (Marque) parentView.getItemAtPosition(position);
                if (marqueSelected != null) {
                    Log.i("SPINNER", "marque != null" + marqueSelected);
                    List<Model> modeles = modeleDao.getListeByMarque(marqueSelected.getNom().toUpperCase());
                    if (modeles != null) {


                        ArrayAdapter<Model> modelAdapter = new ArrayAdapter<Model>(NewVehiculeActivity.this, R.layout.support_simple_spinner_dropdown_item, modeles);
                        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        Spinner spinner = findViewById(R.id.activity_newvehicule_spinModele);
                        spinner.setAdapter(modelAdapter);
                        Log.i("SPINNER", spinner.getSelectedItem().toString());
                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                Model modeleSelected = (Model) parent.getItemAtPosition(position);
                                ((TextView) findViewById(R.id.activity_newvehicule_etCnit)).setText(modeleSelected.getCnit());

                                modeleCommercial.setText(modeleSelected.getModeleCommercial());
                                carrosserie.setText(modeleSelected.getCarrosserie());
                                carburant.setText(modeleSelected.getCarburant());
                                boiteDeVitesse.setText(modeleSelected.getBoiteDeVitesse());
                                puissanceAdministrative.setText(String.valueOf(modeleSelected.getPuissanceAdministrative()));
                                consommationUrbaine.setText(String.valueOf(modeleSelected.getConsommationUrbaine()));
                                consommationExtraUrbaine.setText(String.valueOf(modeleSelected.getConsommationExtraUrbaine()));
                                consommationMixte.setText(String.valueOf(modeleSelected.getConsommationMixte()));
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    }
                } else {

                    Log.i("SPINNER", "marqueSelected is null");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }

        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                canTakePhoto = true;
            }
        }
    }

    public void newVehiculeClick(View view) {
/*
        String marque, Model model, String cnit, Float prix, String plaque, Agence
        agence, boolean isDispo, String photoPath
*/
        Spinner spinnerMarque = findViewById(R.id.activity_newvehicule_spinMarque);
        Spinner spinnerModele = findViewById(R.id.activity_newvehicule_spinModele);

        ModelDao modelDao = new ModelDao(NewVehiculeActivity.this);
        String marque = ((Marque) spinnerMarque.getSelectedItem()).getNom();
        Log.i("Ajout", "marque recupérée depuis le spinner");
        Model model = modelDao.getByCnit(((Model) spinnerModele.getSelectedItem()).getCnit());
        Log.i("ajout", "modeldao.getby cnit passé");
        String cnit = model.getCnit(); //  ((TextView) findViewById(R.id.activity_newvehicule_etCnit)).getText().toString();
        Float prix = Float.valueOf(((TextView) findViewById(R.id.activity_newvehicule_etPrix)).getText().toString());
        String plaque = ((TextView) findViewById(R.id.activity_newvehicule_etPlaque)).getText().toString();
        int codeAgence = 1; // a modifier par le code agence de l'agence connecter emmeorisée dans sharedpreferences;
        boolean isDispo = true;
        String photoPath = file != null ? file.getPath() : "";


        Vehicule vehiculeToAdd = new Vehicule(marque, model, cnit, prix, plaque, codeAgence, isDispo, photoPath);
        vehiculeDao.insert(vehiculeToAdd);
        Intent intent = new Intent(NewVehiculeActivity.this, VehiculesActivity.class);
        startActivity(intent);
    }

    File file;
    Uri fileUri;

    public void onImageClick(View view) {
        if (canTakePhoto) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            file = getOutputMediaFile();
            fileUri = Uri.fromFile(file);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

            startActivityForResult(intent, 100);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                ((ImageView) findViewById(R.id.activity_newvehicule_imgVehicule)).setImageURI(fileUri);

            }
        }
    }

    public static File getOutputMediaFile() {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");

        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_" + timeStamp + ".jpg");
    }
}
