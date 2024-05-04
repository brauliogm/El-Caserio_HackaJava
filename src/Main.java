import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Alergeno ketchup = new Alergeno(1, "Ketchup");
        Producto burger = new Producto(1L, "Burger", "Burger", "Especial", "La mejor de la casa", ketchup, 5.99);
        ArrayList<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(burger);
        Carrito carrito1 = new Carrito(1L, listaProductos);

        carrito1.eliminarProducto(burger);
        carrito1.verProductos();
        carrito1.agregarProducto(burger);
        carrito1.verProductos();

    }
}