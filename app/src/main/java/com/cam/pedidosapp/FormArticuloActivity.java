package com.cam.pedidosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class FormArticuloActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etCosto;
    private Articulo articulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo_form);
        setTitle("Articulo");
        etNombre=(EditText) findViewById(R.id.etNombre);
        etCosto=(EditText) findViewById(R.id.etCosto);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            articulo = (Articulo) extras.get("cliente");
            etCosto.setText(String.valueOf(articulo.getCosto()));
            etNombre.setText(articulo.getNombre());

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_negocio,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Articulo articulo = new Articulo();
        articulo.setCosto(Float.valueOf(etCosto.getText().toString()));
        articulo.setNombre(etNombre.getText().toString());
        Intent intent= new Intent();
        intent.putExtra("articulo",articulo);
        setResult(RESULT_OK,intent);
        finish();
        return super.onOptionsItemSelected(item);
    }
}