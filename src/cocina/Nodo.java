package cocina;

public class Nodo {
    private Pedido pedido;
    private Nodo siguiente;

    public Nodo(Pedido pedido) {
        this.pedido = pedido;
        this.siguiente = null;
    }

    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
