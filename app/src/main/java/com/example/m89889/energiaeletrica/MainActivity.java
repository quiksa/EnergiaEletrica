package com.example.m89889.energiaeletrica;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void listar(View view) {

        Intent i = new Intent(view.getContext(), ListaActivity.class);
        startActivity(i);

    }


    public void novaleitura(View view) {
        startActivity(new Intent(this, addActivity.class));
    }


    public void sair(View view) {
        System.exit(0);
    }
}
