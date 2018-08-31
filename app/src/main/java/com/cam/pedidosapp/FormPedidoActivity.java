package com.cam.pedidosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class FormPedidoActivity extends AppCompatActivity {
    private ListView lvDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_pedido);
        setTitle("Pedido");
        lvDetalle=(ListView) findViewById(R.id.lvDetalle);
        registerForContextMenu(lvDetalle);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_negocio,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_contexto,menu);
        menu.setHeaderTitle("OPCIONES");
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    public void onClick(View view)
    {
        //Toast.makeText(this, "Detalle", Toast.LENGTH_SHORT).show();
        if(view.getId()==R.id.btDetalle)
        {
            Intent iDetalle = new Intent(this,FormDetalleActivity.class);
            startActivityForResult(iDetalle,1234);
        }
        else
        {
            Intent iCliente = new Intent(this,ClienteActivity.class);
            startActivityForResult(iCliente,4567);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK)
        {
            if(requestCode==1234)
            {
                //Detalle
                Toast.makeText(this, "Detalle", Toast.LENGTH_SHORT).show();
            }
            else
            {
                //Cliente
                Toast.makeText(this, "Cliente", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
