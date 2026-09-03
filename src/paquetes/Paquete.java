package paquetes;
import java.util.Scanner;
import paquetes.PaqueteNodo;
import paquetes.PaquetePila;

public class Paquete {
    int id;
    String descripcion;
    double peso;

    public Paquete(int id, String descripcion, double peso) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
    }
}
