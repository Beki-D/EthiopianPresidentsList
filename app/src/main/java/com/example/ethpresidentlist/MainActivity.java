package com.example.ethpresidentlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Presidents APP";
    Button btn_add;

    MyApp myApp = (MyApp) this.getApplication();

    List<President> presidentList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presidentList = myApp.getPresidentList();

        Log.d(TAG, "onCreate meth: " + presidentList.toString());
        Toast.makeText(this, "Presidents count: " + presidentList.size(), Toast.LENGTH_SHORT).show();

        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(v -> {
            Intent intent = new Intent( MainActivity.this, AddEdit.class);
            startActivity(intent);
        });

        recyclerView = findViewById(R.id.rv_presidentList);

        recyclerView.setHasFixedSize(true);
        //use linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //specify an adapter
        mAdapter = new RecyclerViewAdapter(presidentList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }



}