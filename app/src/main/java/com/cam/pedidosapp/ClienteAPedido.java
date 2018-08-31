package com.cam.pedidosapp;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class ClienteAPedido {
    @Embedded
    private Cliente cliente;

    @Relation(parentColumn = "id_cliente",
    entityColumn = "id_cliente")
    List<Pedido> pedidoList;
}
