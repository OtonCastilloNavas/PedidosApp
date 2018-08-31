package com.cam.pedidosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Pedido> pedidoList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnAdd:
                Intent iPedido= new Intent(this, FormPedidoActivity.class);
                startActivityForResult(iPedido,1234);
                break;
            case R.id.mnArticulo:
                Intent iArticulo = new Intent(this,ArticuloActivity.class);
                startActivity(iArticulo);
            break;
            case R.id.mnCliente:
                Intent iCliente=new Intent(this,ClienteActivity.class);
                startActivity(iCliente);
            break;
        }
        return super.onOptionsItemSelected(item);
    }
}
