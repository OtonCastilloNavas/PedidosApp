package com.cam.pedidosapp;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class ClienteAPedido {

    @Embedded
    private Cliente cliente;

    @Relation(parentColumn = "id_cliente",
    entityColumn = "cliente_id_cliente")
    List<Pedido> pedidoList;

    public ClienteAPedido(Cliente cliente, List<Pedido> pedidoList) {
        this.cliente = cliente;
        this.pedidoList = pedidoList;
    }

    public ClienteAPedido() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
}
