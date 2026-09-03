package nodo;

import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int [] ventas = new int[10];
        capturaVentas(ventas);
        mostrarArreglo(ventas);
        System.out.println();
        ordenarBurbuja(ventas);
        System.out.println();
        System.out.println(ventas[0] + " es la venta más baja");
        System.out.println(ventas[9] + " es la venta más alta");
        calcularPromedio(ventas);
    }

    public static void capturaVentas(int [] ventas) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < ventas.length; i++) {
            System.out.println("Ingrese la venta " + (i + 1) + " / 10 en $: ");
            ventas[i] = sc.nextInt();
        }
    }

    public static void mostrarArreglo(int [] ventas) {
        System.out.println("Ventas capturadas: ");
        for (int i = 0; i < ventas.length; i++) {
            System.out.print(ventas[i] + " ");
        }
    }

    public static void ordenarBurbuja(int[] ventas) {
        for (int i = 0; i < ventas.length - 1; i++) {
            for (int j = 0; j < ventas.length - 1 - i; j++) {
                if (ventas[j] > ventas[j + 1]) {
                    int temp = ventas[j];
                    ventas[j] = ventas[j + 1];
                    ventas[j + 1] = temp;
                }
            }
        }
        System.out.println("Ventas ordenadas: ");
        for (int i = 0; i < ventas.length; i++) {
            System.out.print(ventas[i] + " ");
        }
    }

    public static void calcularPromedio(int[] ventas) {
        double suma = 0;
        double promedio = 0;
        for (int i = 0; i < ventas.length; i++) {
            suma = suma + ventas[i];
            promedio = suma / ventas.length;
        }
        System.out.println("El promedio de ventas es: " + promedio);

    }
}
