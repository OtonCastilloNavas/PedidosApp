package com.cam.pedidosapp;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity
public class Cliente implements Serializable {
    @PrimaryKey
    @NonNull
    private String id_cliente;
    @NonNull
    private String nombre;

    @Embedded(prefix = "negocio_")
    private Negocio negocio;

    public Cliente(String id_cliente, String nombre ) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
    }
    public Cliente(String id_cliente, String nombre, Negocio negocio ) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.negocio=negocio;
    }
    public Cliente() {

    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Negocio getNegocio() {
        return negocio;
    }

    public void setNegocio(Negocio negocio) {
        this.negocio = negocio;
    }
}
