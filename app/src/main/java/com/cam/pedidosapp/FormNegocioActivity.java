package com.cam.pedidosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class FormNegocioActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etDireccion;
    private EditText etTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_negocio);
        etDireccion=(EditText) findViewById(R.id.etDireccion);
        etNombre=(EditText) findViewById(R.id.etNombre);
        etTelefono=(EditText) findViewById(R.id.etTelefono);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_negocio,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Negocio negocio =  new Negocio();
        negocio.setDireccion(etDireccion.getText().toString());
        negocio.setNombre(etNombre.getText().toString());
        negocio.setTelefono(etTelefono.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("negocio",negocio);
        setResult(RESULT_OK,intent);
        finish();
        return super.onOptionsItemSelected(item);
    }
}
