package com.example.sql;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editNombres, editApellidos, editEdad, editCorreo, editDireccion;
    Button btnSalvar;
    PersonaDAO personaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNombres = findViewById(R.id.editNombres);
        editApellidos = findViewById(R.id.editApellidos);
        editEdad = findViewById(R.id.editEdad);
        editCorreo = findViewById(R.id.editCorreo);
        editDireccion = findViewById(R.id.editDireccion);
        btnSalvar = findViewById(R.id.btnSalvar);

        personaDAO = new PersonaDAO(this);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombres = editNombres.getText().toString();
                String apellidos = editApellidos.getText().toString();
                int edad = Integer.parseInt(editEdad.getText().toString());
                String correo = editCorreo.getText().toString();
                String direccion = editDireccion.getText().toString();

                Persona persona = new Persona(nombres, apellidos, edad, correo, direccion);
                long resultado = personaDAO.insertarPersona(persona);

                if (resultado != -1) {
                    Toast.makeText(MainActivity.this, "Guardado exitosamente", Toast.LENGTH_SHORT).show();
                    limpiarCampos();
                } else {
                    Toast.makeText(MainActivity.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void limpiarCampos() {
        editNombres.setText("");
        editApellidos.setText("");
        editEdad.setText("");
        editCorreo.setText("");
        editDireccion.setText("");
    }
}
