package com.cam.pedidosapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ClienteDao {

    @Insert
    void insertar(Cliente cliente);

    @Delete
    void borrar(Cliente cliente);

    @Update
    void actualizar(Cliente cliente);

    @Query("SELECT * FROM Cliente")
    List<Cliente> obtenerTodo();

    @Query("SELECT * FROM Cliente where id_cliente=:id")
    Cliente obtenerPorId(String id);

    @Query("SELECT * FROM Cliente where id_cliente=:id")
    ClienteAPedido obtenerClientePedidoPorId(String id);


}



