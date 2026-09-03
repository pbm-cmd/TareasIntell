package paquetes;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Paquete.PaquetePila almacen = new Paquete.PaquetePila();
            int opcion = 0;

            do {
                System.out.print("Selecciona una opción: ");
                System.out.println("-----ALMACÉN-----");
                System.out.println("1. Registrar paquete");
                System.out.println("2. Retirar paquete");
                System.out.println("3. Consultar siguiente paquete");
                System.out.println("4. Mostrar paquetes");
                System.out.println("5. Buscar paquete");
                System.out.println("6. Salir");

                try {
                    opcion = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido");
                    continue;
                }

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese ID: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.print("Ingrese Descripción: ");
                        String desc = sc.nextLine();
                        System.out.print("Ingrese Peso (kg): ");
                        double peso = Double.parseDouble(sc.nextLine());

                        almacen.push(new Paquete(id, desc, peso));
                        break;

                    case 2:
                        Paquete retirado = almacen.pop();
                        if (retirado != null) {
                            System.out.println("Paquete retirado: " + retirado);
                        }
                        break;

                    case 3:
                        Paquete siguiente = almacen.peek();
                        if (siguiente != null) {
                            System.out.println("Siguiente paquete a salir: " + siguiente);
                        }
                        break;

                    case 4:
                        almacen.mostrar();
                        break;

                    case 5:
                        System.out.print("ID a buscar: ");
                        int idBuscar = Integer.parseInt(sc.nextLine());
                        almacen.buscar(idBuscar);
                        break;

                    case 6:
                        System.out.println("Saliendo del programa");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }
            } while (opcion != 6);
            sc.close();
        }
}
