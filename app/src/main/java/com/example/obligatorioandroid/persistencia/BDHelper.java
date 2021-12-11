package com.example.obligatorioandroid.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class BDHelper extends SQLiteOpenHelper {

    public BDHelper(Context contexto){

        super(contexto, "", null, 0);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
