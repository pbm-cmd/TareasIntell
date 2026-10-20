package prioridad;

public class Cola {
    Nodo frente, fin;

    public boolean isEmpty() {
        return frente == null;
    }

    public void enqueue(Elemento e) {
        Nodo nuevo = new Nodo(e);
        if (isEmpty()) frente = nuevo;
        else fin.sig = nuevo;
        fin = nuevo;
    }

    public Elemento dequeue() {
        if (isEmpty()) return null;
        Elemento e = frente.dato;
        frente = frente.sig;
        if (frente == null) fin = null;
        return e;
    }

    public void peek() {
        Nodo aux = frente;
        while (aux != null) {
            System.out.println("   " + aux.dato);
            aux = aux.sig;
        }
    }
}
