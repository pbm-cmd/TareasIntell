package prioridad;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ColaPrioridad cp = new ColaPrioridad();
        int opt;

        do {
            System.out.print("Selecciona una opción: ");
            System.out.println("\n1- Añadir ID \n2- Quitar siguiente \n3- Mostrar cola \n4- Salir del programa");
            opt = Integer.parseInt(sc.nextLine());

            if (opt == 1) {
                System.out.print("ID: ");
                int id = Integer.parseInt(sc.nextLine());
                System.out.print("Prioridad (1 = Alta, 2 = Media, 3 = Baja): ");
                int p = Integer.parseInt(sc.nextLine());
                cp.enqueue(new Elemento(id, p));
            } else if (opt == 2) {
                Elemento e = cp.dequeue();
                System.out.println(e != null ? "Quitado: " + e : "Cola vacía.");
            } else if (opt == 3) {
                cp.peek();
            }
        } while (opt != 4);
        sc.close();
    }
}
