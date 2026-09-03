package paquetes;
import java.util.Scanner;

public class Paquete {
    int id;
    String descripcion;
    double peso;

    public Paquete(int id, String descripcion, double peso) {
        this.id = id;
        this.descripcion = descripcion;
        this.peso = peso;
    }

    public class PaquetePila {
        private paquetes.PaqueteNodo tope;

        public PaquetePila() {
            this.tope = null;
        }

        public boolean isEmpty() {
            return tope == null;
        }

        public void push(Paquete paquete) {
            paquetes.PaqueteNodo nuevoNodo = new paquetes.PaqueteNodo(paquete);
            nuevoNodo.siguiente = tope;
            tope = nuevoNodo;
            System.out.println("Paquete registrado exitosamente");
        }

        public Paquete pop() {
            if (isEmpty()) {
                System.out.println("ERROR - No hay paquetes para retirar");
                return null;
            }
            Paquete paqueteRetirado = tope.paquete;
            tope = tope.siguiente;
            return paqueteRetirado;
        }




    }
}

