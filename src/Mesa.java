public class Mesa {
    private Long id;
    private int numero;
    private int capacidad;
    private EstadoMesa estado;

    public Mesa(Long id, int numero, int capacidad) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.estado = EstadoMesa.DISPONIBLE;
    }

    // Método para reservar la mesa
    public void reservar() {
        estado = EstadoMesa.RESERVADA;
    }

    // Método para liberar la mesa
    public void liberar() {
        estado = EstadoMesa.DISPONIBLE;
    }

    // Método para marcar la mesa como ocupada
    public void ocupar() {
        estado = EstadoMesa.OCUPADA;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public EstadoMesa getEstado() {
        return estado;
    }

    public void setEstado(EstadoMesa estado) {
        this.estado = estado;
    }
    // Enumeración para representar el estado de la mesa
    public enum EstadoMesa {
        DISPONIBLE,
        OCUPADA,
        RESERVADA
    }
}
