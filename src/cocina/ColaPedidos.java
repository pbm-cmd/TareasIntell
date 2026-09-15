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

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("No hay pedidos pendientes");
            return;
        }
        System.out.println("--PEDIDOS PENDIENTES--");
        Nodo actual = frente;
        while (actual != null) {
            Pedido p = actual.getPedido();
            System.out.println(p.getNumero() + " - " + p.getPlatillo() + " (" + p.getCliente() + ")");
            actual = actual.getSiguiente();
        }
    }

    public Pedido buscarPedido(int numero) {
        Nodo actual = frente;
        while (actual != null) {
            if (actual.getPedido().getNumero() == numero) {
                return actual.getPedido();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public int calcularTiempoTotal() {
        int tiempoTotal = 0;
        Nodo actual = frente;
        while (actual != null) {
            tiempoTotal += actual.getPedido().getTiempoEstimado();
            actual = actual.getSiguiente();
        }
        return tiempoTotal;
    }
}
