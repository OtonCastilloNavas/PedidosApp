package com.cam.pedidosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FormClienteActivity extends AppCompatActivity {

    private EditText etId;
    private EditText etNombre;
    private TextView tvNegocio;
    private Cliente cliente= new Cliente();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_form);
        setTitle("Cliente");
        etId=(EditText) findViewById(R.id.etId);
        etNombre=(EditText) findViewById(R.id.etNombre);
        tvNegocio= (TextView) findViewById(R.id.tvNegocio);
        Bundle extras = getIntent().getExtras();
        if(extras!=null)
        {
            cliente = (Cliente) extras.get("cliente");
            etId.setText(cliente.getId_cliente());
            etNombre.setText(cliente.getNombre());
            tvNegocio.setText(cliente.getNegocio().getNombre());
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

        cliente.setId_cliente(etId.getText().toString());
        cliente.setNombre(etNombre.getText().toString());
        Intent intent= new Intent();
        intent.putExtra("cliente",cliente);
        setResult(RESULT_OK,intent);
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view)
    {
        Intent intent= new Intent(FormClienteActivity.this, FormNegocioActivity.class);
        startActivityForResult(intent,1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK)
        {
            cliente.setNegocio((Negocio) data.getExtras().get("negocio"));
            tvNegocio.setText(cliente.getNegocio().getNombre());
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
