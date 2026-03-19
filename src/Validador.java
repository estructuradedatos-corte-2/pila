public class Validador {

    // Método principal que valida el texto
    public static void validar(String texto) {

        // Creamos la pila manual
        Pila pila = new Pila();

        // Variables para llevar control de posición
        int linea = 1;
        int columna = 1;

        // Recorremos el texto carácter por carácter
        for (int i = 0; i < texto.length(); i++) {

            char c = texto.charAt(i);

            // Si hay salto de línea, aumentamos línea y reiniciamos columna
            if (c == '\n') {
                linea++;
                columna = 1;
                continue;
            }

            
            // VALIDACIÓN DE HTML
            
            if (c == '<') {

                // Buscamos el cierre de la etiqueta
                int cierre = texto.indexOf('>', i);

                // Si no hay '>' → error
                if (cierre == -1) {
                    System.out.println("Error: etiqueta no cerrada en línea " + linea);
                    return;
                }

                // Extraemos el contenido de la etiqueta
                String etiqueta = texto.substring(i + 1, cierre);

                // Si empieza con '/' es una etiqueta de cierre
                if (etiqueta.startsWith("/")) {

                    String nombre = etiqueta.substring(1);

                    // Si la pila está vacía → cierre sin apertura
                    if (pila.isEmpty()) {
                        System.out.println("Error: cierre sin apertura </" + nombre + ">");
                        return;
                    }

                    // Sacamos el elemento de la pila
                    Nodo cima = pila.pop();

                    // Verificamos si coincide
                    if (!cima.simbolo.equals(nombre)) {
                        System.out.println("Error de jerarquía en línea " + linea);
                        System.out.println("Se esperaba </" + cima.simbolo + "> pero se encontró </" + nombre + ">");
                        return;
                    }

                } else {
                    // Es etiqueta de apertura → se guarda en la pila
                    pila.push(etiqueta, linea, columna);
                }

                // Saltamos hasta el cierre de la etiqueta
                i = cierre;
                columna++;
                continue;
            }

            
            // VALIDACIÓN MATEMÁTICA
            

            // Si es apertura → se apila
            if (c == '(' || c == '[' || c == '{') {
                pila.push(String.valueOf(c), linea, columna);
            }

            // Si es cierre → se valida
            if (c == ')' || c == ']' || c == '}') {

                // Si la pila está vacía → error
                if (pila.isEmpty()) {
                    System.out.println("Error: cierre sin apertura '" + c +
                                       "' en línea " + linea + ", columna " + columna);
                    return;
                }

                Nodo cima = pila.pop();

                // Verificamos si coincide
                if (!coinciden(cima.simbolo, c)) {
                    System.out.println("Error de jerarquía en línea " + linea +
                                       ", columna " + columna);
                    System.out.println("Se esperaba cerrar '" + cima.simbolo +
                                       "' pero se encontró '" + c + "'");
                    return;
                }
            }

            // Avanzamos columna
            columna++;
        }

        
        // VERIFICACIÓN FINAL
        

        // Si quedan elementos → no se cerraron
        if (!pila.isEmpty()) {
            System.out.println("Error: elementos sin cerrar:");

            while (!pila.isEmpty()) {
                Nodo n = pila.pop();
                System.out.println("Símbolo '" + n.simbolo +
                                   "' en línea " + n.linea +
                                   ", columna " + n.columna);
            }

        } else {
            // Todo correcto
            System.out.println("Expresión válida");
        }
    }

    // Método auxiliar para validar coincidencias
    private static boolean coinciden(String apertura, char cierre) {

        // Verifica si los símbolos corresponden correctamente
        return (apertura.equals("(") && cierre == ')') ||
               (apertura.equals("[") && cierre == ']') ||
               (apertura.equals("{") && cierre == '}');
    }
}