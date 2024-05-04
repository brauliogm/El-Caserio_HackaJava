public class Cliente {

    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private DireccionCliente direccion;

    public Cliente(Long id, String nombre, String telefono, String email, DireccionCliente direccion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DireccionCliente getDireccion() {
        return direccion;
    }

    public void setDireccion(DireccionCliente direccion) {
        this.direccion = direccion;
    }

}
