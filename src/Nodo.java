// Clase Nodo que representa cada elemento dentro de la pila
public class Nodo {

    char simbolo;           // Guarda el símbolo (ej: (, {, [ )
    int linea;              // Guarda la línea donde aparece el símbolo
    int columna;            // Guarda la columna donde aparece el símbolo
    Nodo siguiente;         // Referencia al siguiente nodo (estructura enlazada)

    // Constructor que inicializa los valores del nodo
    public Nodo(char simbolo, int linea, int columna) {
        this.simbolo = simbolo;     // Asigna el símbolo recibido
        this.linea = linea;         // Asigna la línea recibida
        this.columna = columna;     // Asigna la columna recibida
        this.siguiente = null;      // Inicialmente no apunta a ningún nodo
    }
}