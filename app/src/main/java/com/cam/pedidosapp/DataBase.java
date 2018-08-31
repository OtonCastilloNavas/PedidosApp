package com.cam.pedidosapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(version = 2, entities = {Articulo.class, Cliente.class, Pedido.class})
public abstract class DataBase extends RoomDatabase {
    public  abstract ArticuloDao articuloDao();
    public  abstract ClienteDao clienteDao();
}
