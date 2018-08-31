package com.cam.pedidosapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ClienteActivity extends AppCompatActivity {
    private ListView lvCliente;
    private List<Cliente> clientes= new ArrayList<>();
    private int posicion=-1;
    private DataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_list);
        setTitle("Cliente");
        db= Room.databaseBuilder(this,
                DataBase.class,
                "Data")
                .allowMainThreadQueries()
                .build();
        clientes.addAll(db.clienteDao().obtenerTodo());
        lvCliente=(ListView) findViewById(R.id.lvCliente);
        ClienteAdapter adapter =  new ClienteAdapter(this,
                R.layout.listview_cliente_layout,
                clientes);
        lvCliente.setAdapter(adapter);
        registerForContextMenu(lvCliente);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu_cliente,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this,FormClienteActivity.class);
        startActivityForResult(intent,1234);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_contexto,menu);
        menu.setHeaderTitle("OPCIONES");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId()==R.id.mnEditar)
        {
            Intent intent = new Intent(this,FormClienteActivity.class);
            intent.putExtra("cliente",clientes.get(info.position));
            posicion=info.position;
            startActivityForResult(intent,5678);
        }
        else
        {
            db.clienteDao().borrar(clientes.get(info.position));
            clientes.remove(info.position);
            ((ClienteAdapter)lvCliente.getAdapter()).notifyDataSetChanged();
        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK)
        {
            Cliente cliente= (Cliente) data.getExtras().get("cliente");
            if(requestCode==1234) {
                db.clienteDao().insertar(cliente);
                clientes.add(cliente);
            }
            else
            {
                db.clienteDao().actualizar(cliente);
                clientes.set(posicion,cliente);
            }
            ((ClienteAdapter)lvCliente.getAdapter()).notifyDataSetChanged();
        }
        posicion=-1;
        super.onActivityResult(requestCode, resultCode, data);
    }
}