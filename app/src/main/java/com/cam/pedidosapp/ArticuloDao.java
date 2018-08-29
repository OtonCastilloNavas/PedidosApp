package com.cam.pedidosapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ArticuloDao {

    @Insert
    void insertar(Articulo articulo);

    @Delete
    void borrar(Articulo articulo);

    @Update
    void actualizar(Articulo articulo);

    @Query("SELECT * FROM articulo_table")
    List<Articulo> obtenerTodo();

    @Query("SELECT * FROM articulo_table where id_articulo=:id")
    Articulo obtenerPorId(int id);

    @Query("SELECT * FROM articulo_table where nombre like '%'||:nombre||'%'")
    Articulo obtenerPorNombre(String nombre);
}


