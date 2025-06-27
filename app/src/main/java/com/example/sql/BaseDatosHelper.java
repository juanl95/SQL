package com.example.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDatosHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "PersonasDB";
    private static final int VERSION = 1;

    public BaseDatosHelper(Context context) {
        super(context, NOMBRE_BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tabla = "CREATE TABLE personas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombres TEXT," +
                "apellidos TEXT," +
                "edad INTEGER," +
                "correo TEXT," +
                "direccion TEXT)";
        db.execSQL(tabla);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS personas");
        onCreate(db);
    }
}

