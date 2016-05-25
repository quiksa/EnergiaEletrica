package com.example.m89889.energiaeletrica;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addActivity extends AppCompatActivity {


    private DatabaseHelper helper;
    private EditText codigo, end, numero, leitura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        codigo = (EditText) findViewById(R.id.txtcodigo);
        end = (EditText) findViewById(R.id.txtendereco);
        numero = (EditText) findViewById(R.id.txtnumero);
        leitura = (EditText) findViewById(R.id.txtleitura);

        helper = new DatabaseHelper(this);

    }

    public void gravarleitura(View view) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("codcli", Integer.parseInt(codigo.getText().toString()));
        values.put("endereco", end.getText().toString());
        values.put("numero", Integer.parseInt(numero.getText().toString()));
        values.put("leitura", Integer.parseInt(leitura.getText().toString()));

        long resultado = db.insert("energia", null, values);

        if (resultado != -1) {
            Toast.makeText(this, "Registro salvo com sucesso!", Toast.LENGTH_SHORT).show();
            limpar();
        } else {
            Toast.makeText(this, "Erro ao salvar!", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpar() {
        codigo.setText("");
        end.setText("");
        numero.setText("");
        leitura.setText("");
    }

    public void volar(View v){
        Intent i = new Intent(v.getContext(),MainActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        helper.close();
        super.onDestroy();
    }




}
