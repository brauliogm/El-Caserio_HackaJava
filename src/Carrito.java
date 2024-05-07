import java.util.ArrayList;

public class Carrito extends Pedido {

    public Carrito(Long id, Cliente cliente) {
        super(id, cliente);
    }

    // Método para vaciar el carrito
    public void vaciarCarrito() {
        this.getProductos().clear();
    }

    // Método para mostrar los productos en el carrito
    public void mostrarProductos() {
        for (Producto producto : getProductos()) {
            System.out.println(producto);
        }
    }

    // Método para calcular el precio total del carrito
    public double calcularPrecioTotal() {
        return calcularTotal();
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "id=" + getId() +
                ", productos=" + getProductos() +
                ", cliente=" + getCliente() +
                ", estado=" + getEstado() +
                ", fechaPedido=" + getFechaPedido() +
                '}';
    }
}