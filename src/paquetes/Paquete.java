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

        public Paquete peek() {
            if (isEmpty()) {
                System.out.println("El almacén está vacío");
                return null;
            }
            return tope.paquete;
        }

        public void mostrar() {
            if (isEmpty()) {
                System.out.println("El almacén no tiene paquetes registrados.");
                return;
            }
            System.out.println("---CONTENIDO DEL ALMACÉN---");
            PaqueteNodo actual = tope;
            while (actual != null) {
                System.out.println(actual.paquete + " | ");
                actual = actual.siguiente;
            }
        }

        public void buscar(int id) {
            if (isEmpty()) {
                System.out.println("No existe un paquete con el ID señalado");
                return;
            }
            PaqueteNodo actual = tope;
            while (actual != null) {
                if (actual.paquete.id == id) {
                    System.out.println("Paquete encontrado:");
                    System.out.println("ID: " + actual.paquete.id);
                    System.out.println("Descripción: " + actual.paquete.descripcion);
                    System.out.println("Peso: " + actual.paquete.peso + " kg");
                    return;
                }
                actual = actual.siguiente;
            }
            System.out.println("No existe un paquete con el ID señalado");
        }
    }

    }
}

