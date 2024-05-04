import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private Long id;
    private List<Producto> productos;
    private Producto producto;

    public Carrito(Long id, ArrayList<Producto> productos) {
        this.id = id;
        this.productos = productos;
    }

    public void agregarProducto(Producto nombreProducto) {
        productos.add(nombreProducto);
    }

    public void eliminarProducto(Producto nombreProducto) {
        productos.remove(nombreProducto);
    }

    public void verProductos() {
        System.out.println(productos);
    }

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

    @Override
    public String toString() {
        return "Carrito{" +
                "productos=" + productos +
                '}';
    }
}
