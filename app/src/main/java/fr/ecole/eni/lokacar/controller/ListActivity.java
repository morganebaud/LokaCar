package fr.ecole.eni.lokacar.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fr.ecole.eni.lokacar.R;
import fr.ecole.eni.lokacar.adapter.RecycledListAdapter;
import fr.ecole.eni.lokacar.bean.Marque;
import fr.ecole.eni.lokacar.bean.Voiture;

public class ListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Voiture> dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dataSource = new ArrayList<Voiture>();
        dataSource.add(new Voiture(1,"Peugeot",null, null,null,null,null,null,false,null));
        dataSource.add(new Voiture(2,"Citroen",null, null,null,null,null,null,false,null));

        mRecyclerView = (RecyclerView) findViewById(R.id.activityList_modeles);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new RecycledListAdapter(dataSource);
        mRecyclerView.setAdapter(mAdapter);
    }
}
