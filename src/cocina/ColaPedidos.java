package cocina;

public class ColaPedidos {
    private Nodo frente;
    private Nodo finalCola;

    public ColaPedidos() {
        this.frente = null;
        this.finalCola = null;
    }

    public boolean isEmpty() {
        return frente == null;
    }

    public void enqueue(Pedido pedido) {
        Nodo nuevoNodo = new Nodo(pedido);
        if (isEmpty()) {
            frente = nuevoNodo;
            finalCola = nuevoNodo;
        } else {
            finalCola.setSiguiente(nuevoNodo);
            finalCola = nuevoNodo;
        }
        System.out.println("Pedido " + pedido.getNumero() + " registrado con éxito.");
    }

}
