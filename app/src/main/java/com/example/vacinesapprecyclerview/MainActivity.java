package com.example.vacinesapprecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    // 1- AdapterView = RecyclerView
    RecyclerView recyclerView;
    // 2- data source
    VaccineModel[] myListData;
    // 3- adapter
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        myListData = new VaccineModel[]{
        new VaccineModel("uno", R.drawable.vaccine1),
        new VaccineModel("cuatro", R.drawable.vaccine4),
        new VaccineModel("cinco", R.drawable.vaccine5),
        new VaccineModel("seis", R.drawable.vaccine6),
        new VaccineModel("siete", R.drawable.vaccine7),
        new VaccineModel("ocho", R.drawable.vaccine8),
        new VaccineModel("nueve", R.drawable.vaccine9)
        };
        //Adapter

        adapter = new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

// handling click events

        adapter.setcLickListener(this);
    }

    @Override
    public void onCLick(View view, int pos) {
        Toast.makeText(this, "Vaccine name: " + myListData[pos].getTitle(), Toast.LENGTH_LONG).show();
    }
}