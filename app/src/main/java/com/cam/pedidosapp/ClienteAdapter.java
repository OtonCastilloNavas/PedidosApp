package com.cam.pedidosapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ClienteAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Cliente> clientes= new ArrayList<>();
    public ClienteAdapter(@NonNull Context context, int resource, @NonNull List<Cliente> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.clientes=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(this.context).inflate(this.resource,parent,false);

        TextView tvNombCliente=(TextView) convertView.findViewById(R.id.tvNomCliente);
        TextView tvNombNegocio=(TextView) convertView.findViewById(R.id.tvNombNegocio);
        TextView tvDirNegocio=(TextView) convertView.findViewById(R.id.tvDirNegocio);
        TextView tvTelNegocio=(TextView) convertView.findViewById(R.id.tvTelNegocio);

       tvNombCliente.setText(clientes.get(position).getNombre());
       tvNombNegocio.setText(clientes.get(position).getNegocio().getNombre());
       tvDirNegocio.setText(clientes.get(position).getNegocio().getDireccion());
       tvTelNegocio.setText(clientes.get(position).getNegocio().getTelefono());

        return convertView;
    }
}