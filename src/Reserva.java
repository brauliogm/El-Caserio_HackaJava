import java.util.Date;

public class Reserva {
    private Long id;
    private Cliente cliente;
    private Mesa mesa;
    private Date fechaReserva;
    private int cantidadPersonas;

    public Reserva(Long id, Cliente cliente, Mesa mesa, int cantidadPersonas) {
        this.id = id;
        this.cliente = cliente;
        this.mesa = mesa;
        this.fechaReserva = new Date(); // Fecha actual
        this.cantidadPersonas = cantidadPersonas;
        // Marcar la mesa como reservada al momento de crear la reserva
        this.mesa.setEstado(Mesa.EstadoMesa.RESERVADA);
    }

    // Método para realizar la reserva
    public void realizarReserva() {
        // Actualizar el estado de la mesa a RESERVADA
        mesa.setEstado(Mesa.EstadoMesa.RESERVADA);
        // Otros pasos necesarios para realizar la reserva, como almacenarla en la base de datos, etc.
    }

    // Otros métodos getters y setters
}

