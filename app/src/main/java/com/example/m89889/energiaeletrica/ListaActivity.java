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

public class ListaActivity extends AppCompatActivity {


    private DatabaseHelper helper;
    private ListView lista;
    List<Map<String, Object>> leituras;
    String[] de = {"codcli", "endereco", "numero", "leitura"};
    int[] para = {R.id.codigo, R.id.rua, R.id.num, R.id.consumo};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        lista = (ListView) findViewById(R.id.list);
        try {
            helper = new DatabaseHelper(this);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        listar();
    }

    public void listar() {

        String query = "";
        query = "SELECT * FROM energia";

        leituras = listarLeituras(query);
        SimpleAdapter adaptador = new SimpleAdapter(this, leituras, R.layout.listagem, de, para);
        lista.setAdapter(adaptador);
    }

    private List<Map<String, Object>> listarLeituras(String query) {
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        leituras = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < cursor.getCount(); i++) {
            Map<String, Object> item = new HashMap<String, Object>();
            int cod = cursor.getInt(0);
            String ender = cursor.getString(1);
            int numero = cursor.getInt(2);
            int leitura = cursor.getInt(3);
            item.put("codcli", "Cod: " + cod);
            item.put("endereco", "Rua: " + ender+",");
            item.put("numero", numero);
            item.put("leitura","Consumo: "+ leitura);
            leituras.add(item);
            cursor.moveToNext();
        }
        cursor.close();
        return leituras;
    }

    @Override
    protected void onDestroy() {
        helper.close();
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        listar();
        super.onRestart();
    }
}
