package com.cam.pedidosapp;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String id_cliente;
    private String nombre;
    private Negocio negocio;

    public Cliente(String id_cliente, String nombre ) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
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
