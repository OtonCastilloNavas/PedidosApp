package com.cam.pedidosapp;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

@Entity(tableName = "articulo_table")
public class Articulo implements Serializable{
    @PrimaryKey(autoGenerate = true)
    private int id_articulo;
    @NonNull
    private String nombre;
    @ColumnInfo(name = "costo_articulo")
    private float costo;

    public Articulo() {
    }

    public Articulo(int id_articulo, String nombre, float costo) {
        this.id_articulo = id_articulo;
        this.nombre = nombre;
        this.costo = costo;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
