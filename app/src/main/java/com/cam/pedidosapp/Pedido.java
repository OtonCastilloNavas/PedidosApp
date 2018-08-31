package com.cam.pedidosapp;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Cliente.class,
parentColumns = "id_cliente",
childColumns = "id_cliente",
onDelete = CASCADE,
onUpdate = CASCADE))
public class Pedido {

    @PrimaryKey(autoGenerate = true)
    private int id_pedido;
    private Date fecha;
    private float total;

    private String id_cliente;
    private Cliente cliente;
    private List<DetallePedido> pedidoList;

    public Pedido() {

    }

    public Pedido(int id_pedido, Date fecha, float total, Cliente cliente, List<DetallePedido> pedidoList) {
        this.id_pedido = id_pedido;
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.pedidoList = pedidoList;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallePedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<DetallePedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
}
