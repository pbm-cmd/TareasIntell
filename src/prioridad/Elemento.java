package prioridad;

public class Elemento {
    int id;
    String descripcion;
    int prioridad;

    public Elemento(int id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Desc: " + descripcion + " | Prioridad: " + prioridad;
    }
}