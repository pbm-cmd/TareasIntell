package polaca;
import polaca.PilaPolaca;
import polaca.Nodo;

public class Conversor {
    private static int prioridad(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private static boolean esOperador(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static String infijaAPostfija(String expresion) throws Exception {
        PilaPolaca<Character> pilaOperadores = new PilaPolaca<>();
        StringBuilder postfija = new StringBuilder();
        int i = 0;
        int n = expresion.length();

        while (i < n) {
            char c = expresion.charAt(i);

            if (Character.isWhitespace(c)) {
                i++;
                continue;
            }

            if (Character.isDigit(c)) {
                while (i < n && Character.isDigit(expresion.charAt(i))) {
                    postfija.append(expresion.charAt(i));
                    i++;
                }
                postfija.append(" ");
                continue;
            }

            if (c == '(') {
                pilaOperadores.apilar(c);
            } else if (c == ')') {
                boolean encontradoApertura = false;
                while (!pilaOperadores.isEmpty()) {
                    if (pilaOperadores.verTope() == '(') {
                        pilaOperadores.desapilar();
                        encontradoApertura = true;
                        break;
                    }
                    postfija.append(pilaOperadores.desapilar()).append(" ");
                }
                if (!encontradoApertura) {
                    throw new Exception("Error: Paréntesis de cierre ')' sin apertura.");
                }
            } else if (esOperador(c)) {
                while (!pilaOperadores.isEmpty() && prioridad(pilaOperadores.verTope()) >= prioridad(c)) {
                    postfija.append(pilaOperadores.desapilar()).append(" ");
                }
                pilaOperadores.apilar(c);
            } else {
                throw new Exception("Error: Carácter no reconocido '" + c + "'.");
            }
            i++;
        }

        while (!pilaOperadores.isEmpty()) {
            char op = pilaOperadores.desapilar();
            if (op == '(' || op == ')') {
                throw new Exception("Error: Paréntesis de apertura '(' no cerrado.");
            }
            postfija.append(op).append(" ");
        }

        return postfija.toString().trim();
    }

    public static double evaluarPostfija(String expresionPostfija) throws Exception {
        if (expresionPostfija.isEmpty()) {
            throw new Exception("Error: Expresión vacía.");
        }

        PilaPolaca<Double> pilaNumeros = new PilaPolaca<>();
        String[] elementos = expresionPostfija.split("\\s+");

        for (String el : elementos) {
            if (el.isEmpty()) continue;

            if (Character.isDigit(el.charAt(0))) {
                pilaNumeros.apilar(Double.parseDouble(el));
            } else if (el.length() == 1 && esOperador(el.charAt(0))) {
                if (pilaNumeros.getSize() < 2) {
                    throw new Exception("Error: Expresión incompleta u operador sin suficientes operandos.");
                }
                double b = pilaNumeros.desapilar();
                double a = pilaNumeros.desapilar();
                double res = 0;

                switch (el.charAt(0)) {
                    case '+': res = a + b; break;
                    case '-': res = a - b; break;
                    case '*': res = a * b; break;
                    case '/':
                        if (b == 0) {
                            throw new Exception("Error: División entre cero.");
                        }
                        res = a / b;
                        break;
                }
                pilaNumeros.apilar(res);
            } else {
                throw new Exception("Error: Elemento no válido en la expresión postfija.");
            }
        }

        if (pilaNumeros.getSize() != 1) {
            throw new Exception("Error: Expresión incompleta o mal formada.");
        }

        return pilaNumeros.desapilar();
    }
}
