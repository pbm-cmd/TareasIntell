package prioridad;

public class Elemento {
    int id;
    int prioridad;

    public Elemento(int id, int prioridad) {
        this.id = id;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Prioridad: " + prioridad;
    }
}