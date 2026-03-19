public class main {

    public static void main(String[] args) {

        // Texto de prueba con HTML y símbolos matemáticos
        String texto = "<html>\n" +
                       "<body>\n" +
                       "<h1>(Hola [mundo])</h1>\n" +
                       "</body>\n" +
                       "</html>";

        // Llamamos al validador
        Validador.validar(texto);
    }
}