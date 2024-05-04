import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<Producto> lista = new ArrayList<>();

        Alergeno ketchup = new Alergeno(1, "Ketchup");
        Producto burger = new Producto(1L, "Burger", "Burger", "Especial", "La mejor de la casa", ketchup, 5.99);
        Carrito carrito1 = new Carrito(1L, lista);


        carrito1.agregarProducto(burger);
        carrito1.agregarProducto(burger);
        carrito1.agregarProducto(burger);
        carrito1.eliminarProducto(burger);
        carrito1.eliminarProducto(burger);
        System.out.println(carrito1.calcularPrecio());
        carrito1.verProductos();

    }
}