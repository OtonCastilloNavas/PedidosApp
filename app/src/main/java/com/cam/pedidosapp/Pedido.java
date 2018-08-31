package com.cam.pedidosapp;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;
import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Cliente.class,
parentColumns = "id_cliente",
childColumns = "cliente_id_cliente",
onDelete = CASCADE,
onUpdate = CASCADE), indices = {@Index("cliente_id_cliente")})
public class Pedido {

    @PrimaryKey(autoGenerate = true)
    private int id_pedido;
    private String fecha;
    private float total;
    private String cliente_id_cliente;

    @Ignore
    private Cliente cliente;

    @Ignore
    private List<DetallePedido> pedidoList;

    public Pedido() {

    }

    public Pedido(int id_pedido, String fecha, float total, Cliente cliente, List<DetallePedido> pedidoList) {
        this.id_pedido = id_pedido;
        this.fecha = fecha;
        this.total = total;
        this.cliente = cliente;
        this.pedidoList = pedidoList;
    }

    public String getCliente_id_cliente() {
        return cliente_id_cliente;
    }

    public void setCliente_id_cliente(String cliente_id_cliente) {
        this.cliente_id_cliente = cliente_id_cliente;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
