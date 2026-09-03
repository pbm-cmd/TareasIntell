package paquetes;

public class PaqueteNodo {
    Paquete paquete;
    PaqueteNodo siguiente;

    public PaqueteNodo(Paquete paquete) {
        this.paquete = paquete;
        this.siguiente = null;
    }
}
