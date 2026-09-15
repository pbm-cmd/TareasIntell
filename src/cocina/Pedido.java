package cocina;

public class Pedido {
    private int numero;
    private String cliente;
    private String platillo;
    private int cantidad;
    private int tiempoEstimado; // En minutos

    public Pedido(int numero, String cliente, String platillo, int cantidad, int tiempoEstimado) {
        this.numero = numero;
        this.cliente = cliente;
        this.platillo = platillo;
        this.cantidad = cantidad;
        this.tiempoEstimado = tiempoEstimado;
    }

}
