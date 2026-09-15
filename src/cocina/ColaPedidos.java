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
        System.out.println("Pedido " + pedido.getNumero() + " registrado");
    }

    public Pedido dequeue() {
        if (isEmpty()) {
            System.out.println("No hay pedidos pendientes en la cola");
            return null;
        }
        Pedido pedidoAtendido = frente.getPedido();
        frente = frente.getSiguiente();

        if (frente == null) {
            finalCola = null;
        }
        return pedidoAtendido;
    }

    public Pedido peek() {
        if (isEmpty()) {
            System.out.println("La cola está vacía");
            return null;
        }
        return frente.getPedido();
    }
}


