import java.util.ArrayList;

public class Carrito {

    private Long id;
    private ArrayList<Producto> productos;
    private Producto producto;
    private double sumaTotal = 0.00;

    public Carrito(Long id, ArrayList<Producto> productos) {
        this.id = id;
        this.productos = productos;
    }

    // Método que permite agregar un producto al carrito y sumar su precio al total
    public void agregarProducto(Producto nombreProducto) {
        productos.add(nombreProducto);
        sumaTotal = sumaTotal + nombreProducto.getPrecio();
    }

    // Método que permite eliminar un producto del carrito y restar su precio del total
    public void eliminarProducto(Producto nombreProducto) {
        productos.remove(nombreProducto);
        sumaTotal = sumaTotal - nombreProducto.getPrecio();
    }

    // Método que muestra el total de los productos en la lista del carrito
    public void verProductos() {
        System.out.println(productos);
    }

    // Método que calcula el precio total de los productos de la lista del carrito
    public double calcularPrecio() {
        return sumaTotal;
    }


    // getters, setters y toString
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "productos=" + productos +
                '}';
    }
}
