package fr.ecole.eni.lokacar.controller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.bean.Model;
import fr.ecole.eni.lokacar.fragment.DetailFragment;

public class DetailActivity extends AppCompatActivity
        implements DetailFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        DetailFragment detailFragment =  (DetailFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragmentDetail);

        Intent intent = getIntent();
        Model detail = intent.getParcelableExtra("detail");

        //Récupère la toolbar
        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            //associe la toolbar
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(detail.getDesignation());
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }*/


        if(detailFragment != null && detailFragment.isInLayout()){
            detailFragment.chargeDetail(detail);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    */
}
