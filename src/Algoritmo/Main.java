package Algoritmo;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] datos = {35, 12, 89, 5, 2, 74, 43, 19};
    }

    public static int[] ordenarInsercion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int clave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = clave;
        }
        return arr;
    }

    public static int[] ordenarSeleccion(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static void quickSort(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int pivote = arr[alto];
            int i = bajo - 1;
            for (int j = bajo; j < alto; j++) {
                if (arr[j] <= pivote) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[alto];
            arr[alto] = temp;

            int p = i + 1;
            quickSort(arr, bajo, p - 1);
            quickSort(arr, p + 1, alto);
        }
    }

    public static int[] ordenarShell(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
        return arr;
    }
}