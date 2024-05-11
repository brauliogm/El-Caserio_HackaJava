package com.elcaserio.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter @Setter
public class Pedido {

    private Long id;
    private List<Producto> productos;
    private Cliente cliente;
    private EstadoPedido estado;
    private Date fechaPedido;
    private double sumaTotal = 0.00;

    public Pedido(Long id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.estado = EstadoPedido.PENDIENTE;
        this.fechaPedido = new Date(); // Fecha actual
    }

    // Método para agregar un producto al pedido
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        sumaTotal = sumaTotal + producto.getPrecio();
    }

    // Método para eliminar un producto del pedido
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
        sumaTotal = sumaTotal - producto.getPrecio();
    }

    // Método para calcular el total del pedido
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    // Método para procesar el pedido (simplemente actualiza el estado)
    public void procesarPedido() {
        estado = EstadoPedido.EN_PREPARACION;
    }

    // Método para marcar el pedido como entregado
    public void marcarEntregado() {
        estado = EstadoPedido.ENTREGADO;
    }

    // Método para cancelar el pedido
    public void cancelarPedido() {
        estado = EstadoPedido.CANCELADO;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", productos=" + productos +
                ", cliente=" + cliente +
                ", estado=" + estado +
                ", fechaPedido=" + fechaPedido +
                '}';
    }

    // Enumeración para representar el estado del pedido
    enum EstadoPedido {
        PENDIENTE,
        EN_PREPARACION,
        ENTREGADO,
        CANCELADO
    }

}
