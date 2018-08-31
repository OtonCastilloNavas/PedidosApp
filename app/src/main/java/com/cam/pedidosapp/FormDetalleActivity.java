package com.cam.pedidosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FormDetalleActivity extends AppCompatActivity {

    private List<DetallePedido> detalleList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_detalle);
        setTitle("Detalle pedido");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_negocio,menu);
        setTitle("Detalle pedido");
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent =  new Intent();
        setResult(RESULT_OK,intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(FormDetalleActivity.this,ArticuloActivity.class);
        startActivityForResult(intent,1234);
    }
}
