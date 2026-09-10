package polaca;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CALCULADORA RPN =====");
        System.out.println("Ingresa una expresión:");
        String infija = sc.nextLine();

        try {
            String postfija = Conversor.infijaAPostfija(infija);
            double resultado = Conversor.evaluarPostfija(postfija);

            System.out.println("Expresión infija:");
            System.out.println(infija);

            System.out.println("Expresión postfija:");
            System.out.println(postfija);

            System.out.println("Resultado:");
            if (resultado == (long) resultado) {
                System.out.println((long) resultado);
            } else {
                System.out.println(resultado);
            }
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
        sc.close();
    }
}
