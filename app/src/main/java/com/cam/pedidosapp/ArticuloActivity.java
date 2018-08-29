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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.OutputKeys;

public class ArticuloActivity extends AppCompatActivity {

    private List<Articulo> articulos= new ArrayList<>();
    private ListView lvArticulo;
    private DataBase db;
    private int posicion=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulo);
        setTitle("Articulo");
        db= Room.databaseBuilder(this,
                DataBase.class,"Data")
                .allowMainThreadQueries()
                .build();
        articulos.addAll(db.articuloDao().obtenerTodo());
        lvArticulo=(ListView) findViewById(R.id.lvArticulo);
        ArticuloAdapter adapter = new ArticuloAdapter(this,R.layout.listview_articulo_layout,articulos);
        lvArticulo.setAdapter(adapter);
        registerForContextMenu(lvArticulo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cliente,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this,FormArticuloActivity.class);
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
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if(item.getItemId()==R.id.mnBorrar)
        {
            db.articuloDao().borrar(articulos.get(info.position));
            articulos.remove(info.position);
        }
        else
        {
            Intent intent = new Intent(this,FormArticuloActivity.class);
            intent.putExtra("articulo",articulos.get(info.position));
            startActivityForResult(intent,5678);
            posicion=info.position;
        }
        ((ArticuloAdapter)lvArticulo.getAdapter()).notifyDataSetChanged();

        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode== RESULT_OK)
        {

            Articulo articulo = (Articulo) data.getExtras().get("articulo");
            if(requestCode==1234) {
                articulos.add(articulo);
                db.articuloDao().insertar(articulo);
            }
            else  {
                articulos.set(posicion,articulo);
                //actualzar en base de datos
            }

            ((ArticuloAdapter)lvArticulo.getAdapter()).notifyDataSetChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
