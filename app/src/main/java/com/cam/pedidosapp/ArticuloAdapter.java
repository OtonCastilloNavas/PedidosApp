package com.cam.pedidosapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ArticuloAdapter extends ArrayAdapter {
    private List<Articulo> articulos;
    private Context context;
    private int resource;
    public ArticuloAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.context=context;
        this.articulos=objects;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView=LayoutInflater.from(this.context).inflate(this.resource,parent,false);

        TextView tvNombre=(TextView) convertView.findViewById(R.id.tvNombre);
        TextView tvprecio = (TextView) convertView.findViewById(R.id.tvPrecio);

        tvNombre.setText(articulos.get(position).getNombre());
        tvprecio.setText(String.valueOf(articulos.get(position).getCosto()));

        return convertView;
    }
}