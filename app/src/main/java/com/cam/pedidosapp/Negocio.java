package com.cam.pedidosapp;

import java.io.Serializable;

public class Negocio implements Serializable {
    private int id_negocio;
    private String nombre;
    private String direccion;
    private String telefono;

    public Negocio(int id_negocio, String nombre, String direccion, String telefono) {

        this.id_negocio = id_negocio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Negocio( String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Negocio() {
    }

    public int getId_negocio() {
        return id_negocio;
    }

    public void setId_negocio(int id_negocio) {
        this.id_negocio = id_negocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
