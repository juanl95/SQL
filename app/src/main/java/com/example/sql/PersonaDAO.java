package com.example.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PersonaDAO {
    private BaseDatosHelper dbHelper;

    public PersonaDAO(Context context) {
        dbHelper = new BaseDatosHelper(context);
    }

    public long insertarPersona(Persona persona) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombres", persona.getNombres());
        valores.put("apellidos", persona.getApellidos());
        valores.put("edad", persona.getEdad());
        valores.put("correo", persona.getCorreo());
        valores.put("direccion", persona.getDireccion());

        return db.insert("personas", null, valores);
    }

    public Cursor obtenerTodasLasPersonas() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM personas", null);
    }

    public int actualizarPersona(int id, Persona persona) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombres", persona.getNombres());
        valores.put("apellidos", persona.getApellidos());
        valores.put("edad", persona.getEdad());
        valores.put("correo", persona.getCorreo());
        valores.put("direccion", persona.getDireccion());

        return db.update("personas", valores, "id = ?", new String[]{String.valueOf(id)});
    }

    public int eliminarPersona(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete("personas", "id = ?", new String[]{String.valueOf(id)});
    }
}

