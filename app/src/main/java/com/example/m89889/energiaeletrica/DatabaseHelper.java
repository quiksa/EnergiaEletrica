package com.example.m89889.energiaeletrica;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by m89889 on 12/04/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "leituras";
    private static int VERSAO = 1;

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }


    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL("CREATE TABLE  energia ("+"codcli INTEGER PRIMARY KEY NOT NULL, "+"endereco TEXT, "+"numero INTEGER, "+"leitura INTEGER);");
    }

    @Override
    public void  onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS energia");
    }



}
