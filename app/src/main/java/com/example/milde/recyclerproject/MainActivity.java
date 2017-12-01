package com.example.milde.recyclerproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private LinearLayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recyle View holen und konfigurieren
        myRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        myRecyclerView.setHasFixedSize(true);

        // LayoutManager wird gesetzt, hier LinearLayout
        mLayoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(mLayoutManager);

        // Daten definieren
        String[] myDataSet  = {

                "Jan-Torsten", "Rebecca", "Elisabeth", "Antonia", "Jakob",
                "Jan-Torsten", "Rebecca", "Elisabeth", "Antonia", "Jakob"
        };

        // Adapter initialisieren und setzen
        MyAdapter mAdapter = new MyAdapter(myDataSet);
        myRecyclerView.setAdapter(mAdapter);

    }
}
