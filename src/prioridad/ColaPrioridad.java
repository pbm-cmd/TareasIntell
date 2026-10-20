package prioridad;

public class ColaPrioridad {
    Cola c1 = new Cola();
    Cola c2 = new Cola();
    Cola c3 = new Cola();

    public void enqueue(Elemento e) {
        if (e.prioridad == 1) c1.enqueue(e);
        else if (e.prioridad == 2) c2.enqueue(e);
        else if (e.prioridad == 3) c3.enqueue(e);
    }

    public Elemento dequeue() {
        if (!c1.isEmpty()) return c1.dequeue();
        if (!c2.isEmpty()) return c2.dequeue();
        if (!c3.isEmpty()) return c3.dequeue();
        return null;
    }

    public void peek() {
        System.out.println("P1 (Alta): "); c1.peek();
        System.out.println("P2 (Media): "); c2.peek();
        System.out.println("P3 (Baja): "); c3.peek();
    }
}

