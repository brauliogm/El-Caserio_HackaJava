import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        // Crear algunos objetos necesarios
        DireccionCliente direccionCliente = new DireccionCliente(1L, "Calle 123", 12345, "Ciudad", "Provincia", "País");
        Cliente cliente = new Cliente(1L, "Juan", "123456789", "juan@example.com", direccionCliente);

        Alergeno alergeno1 = new Alergeno(1, "Gluten");
        Alergeno alergeno2 = new Alergeno(2, "Lactosa");

        Producto producto1 = new Producto(1L, "Pizza", "Comida", "Pizza", "Pizza de pepperoni", alergeno1, 10.0);
        Producto producto2 = new Producto(2L, "Ensalada", "Comida", "Ensalada", "Ensalada César", alergeno2, 8.0);

        Mesa mesa1 = new Mesa(1L, 1, 4);
        Mesa mesa2 = new Mesa(2L, 2, 6);

        // Crear una reserva
        Reserva reserva = new Reserva(1L, cliente, mesa1, 4);
        reserva.realizarReserva();

        // Crear un carrito y agregar productos
        Carrito carrito = new Carrito(1L, new ArrayList<>());
        carrito.agregarProducto(producto1);
        carrito.agregarProducto(producto2);

        // Crear un pedido
        Pedido pedido = new Pedido(1L, cliente);
        pedido.agregarProducto(producto1);
        pedido.agregarProducto(producto2);
        pedido.procesarPedido();

        // Mostrar información
        System.out.println("Reserva:");
        System.out.println(reserva);
        System.out.println();

        System.out.println("Carrito:");
        System.out.println(carrito);
        System.out.println("Total: $" + carrito.calcularPrecio());
        System.out.println();

        System.out.println("Pedido:");
        System.out.println(pedido);
        System.out.println("Total: $" + pedido.calcularTotal());
    }
}
