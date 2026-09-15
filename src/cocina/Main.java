package cocina;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColaPedidos cola = new ColaPedidos();
        int opcion = 0;
        do {
            System.out.println("--PEDIDOS DE COCINA--");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Preparar siguiente pedido");
            System.out.println("3. Consultar siguiente pedido");
            System.out.println("4. Mostrar pedidos pendientes");
            System.out.println("5. Buscar pedido por número");
            System.out.println("6. Mostrar tiempo total pendiente");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Núero inválido, ingrese un número válido");
                continue;
            }

                switch (opcion) {
                    case 1:
                        System.out.print("Número de pedido: ");
                        int num = Integer.parseInt(scanner.nextLine());
                        System.out.print("Cliente: ");
                        String cliente = scanner.nextLine();
                        System.out.print("Platillo: ");
                        String platillo = scanner.nextLine();
                        System.out.print("Cantidad: ");
                        int cant = Integer.parseInt(scanner.nextLine());
                        System.out.print("Tiempo estimado (mins): ");
                        int tiempo = Integer.parseInt(scanner.nextLine());

                        cola.enqueue(new Pedido(num, cliente, platillo, cant, tiempo));
                        break;

                    case 2:
                        Pedido atendido = cola.dequeue();
                        if (atendido != null) {
                            System.out.println("Preparando pedido " + atendido.getNumero());
                            System.out.println("Cliente: " + atendido.getCliente());
                            System.out.println("Platillo: " + atendido.getPlatillo());
                        }
                        break;

                    case 3:
                        Pedido siguiente = cola.peek();
                        if (siguiente != null) {
                            System.out.println("Siguiente pedido para entregar: ");
                            System.out.println(siguiente);
                        }
                        break;

                    case 4:
                        cola.mostrar();
                        break;

                    case 5:
                        System.out.print("Ingrese el número de pedido a buscar");
                        int numBuscar = Integer.parseInt(scanner.nextLine());
                        Pedido encontrado = cola.buscarPedido(numBuscar);
                        if (encontrado != null) {
                            System.out.println("Pedido encontrado: " + encontrado);
                        } else {
                            System.out.println("El pedido #" + numBuscar + " no existe");
                        }
                        break;

                    case 6:
                        System.out.println("Tiempo total pendiente: " + cola.calcularTiempoTotal() + " mins");
                        break;

                    case 7:
                        System.out.println("Saliendo del sistema");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            }
            while (opcion != 7) ;
            scanner.close();
        }
    }
