import java.util.Scanner; // Importa Scanner para leer datos del usuario

// Clase principal donde se ejecuta el programa
public class Validador {

    // Método que verifica si los símbolos coinciden correctamente
    public static boolean esPar(char apertura, char cierre) {

        // Retorna true si los símbolos son pares correctos
        return (apertura == '(' && cierre == ')') ||
               (apertura == '{' && cierre == '}') ||
               (apertura == '[' && cierre == ']');
    }

    // Método principal
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Se crea el lector de entrada
        Pila pila = new Pila(); // Se crea la pila

        System.out.println("Ingrese texto línea por línea (escriba FIN para terminar):"); // Mensaje inicial

        int linea = 1; // Contador de líneas

        // Bucle para leer múltiples líneas
        while (true) {

            String texto = sc.nextLine(); // Lee una línea del usuario

            if (texto.equals("FIN")) { // Condición de salida
                break; // Termina el bucle
            }

            // Recorre cada carácter de la línea
            for (int i = 0; i < texto.length(); i++) {

                char c = texto.charAt(i); // Obtiene el carácter actual
                int columna = i + 1; // Calcula la columna (posición)

                // Si es un símbolo de apertura
                if (c == '(' || c == '{' || c == '[') {

                    pila.push(c, linea, columna); // Se apila el símbolo con su posición
                }

                // Si es un símbolo de cierre
                else if (c == ')' || c == '}' || c == ']') {

                    // Si la pila está vacía → error
                    if (pila.isEmpty()) {

                        System.out.println("Error: cierre sin apertura en línea "
                                + linea + ", columna " + columna); // Muestra error

                        return; // Termina el programa
                    }

                    Nodo cima = pila.pop(); // Se desapila el último símbolo

                    // Verifica si coinciden
                    if (!esPar(cima.simbolo, c)) {

                        System.out.println("Error: jerarquía incorrecta en línea "
                                + linea + ", columna " + columna); // Muestra error

                        return; // Termina el programa
                    }
                }
            }

            linea++; // Pasa a la siguiente línea
        }

        // Al terminar, si la pila no está vacía → error
        if (!pila.isEmpty()) {

            Nodo restante = pila.pop(); // Obtiene el símbolo que quedó

            System.out.println("Error: símbolo sin cerrar '" + restante.simbolo +
                    "' en línea " + restante.linea +
                    ", columna " + restante.columna); // Muestra error
        }
        else {

            System.out.println("Expresión correcta ✅"); // Todo está bien
        }
    }
}