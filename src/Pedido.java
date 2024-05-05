import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Long id;
    private List<Producto> productos;
    private Cliente cliente;
    private EstadoPedido estado;
    private Date fechaPedido;

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
    }

    // Método para eliminar un producto del pedido
    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
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

    // getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
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
}

// Enumeración para representar el estado del pedido
enum EstadoPedido {
    PENDIENTE,
    EN_PREPARACION,
    ENTREGADO,
    CANCELADO
}
