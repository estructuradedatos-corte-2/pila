// Clase Pila implementada manualmente (NO se usa java.util.Stack)
public class Pila {

    private Nodo cima;  // Referencia al nodo que está en la cima de la pila

    // Constructor que inicializa la pila vacía
    public Pila() {
        cima = null; // La pila inicia sin elementos
    }

    // Método push: apilar un elemento
    public void push(char simbolo, int linea, int columna) {

        Nodo nuevo = new Nodo(simbolo, linea, columna); // Se crea un nuevo nodo

        nuevo.siguiente = cima; // El nuevo nodo apunta al nodo que estaba en la cima

        cima = nuevo; // La cima ahora es el nuevo nodo
    }

    // Método pop: desapilar un elemento
    public Nodo pop() {

        if (isEmpty()) { // Verifica si la pila está vacía
            throw new RuntimeException("Error: Pila vacía"); // Lanza error si no hay elementos
        }

        Nodo temp = cima; // Guarda el nodo actual de la cima

        cima = cima.siguiente; // La cima pasa a ser el siguiente nodo

        return temp; // Retorna el nodo eliminado
    }

    // Método peek: ver el elemento en la cima sin eliminarlo
    public Nodo peek() {

        if (isEmpty()) { // Verifica si está vacía
            throw new RuntimeException("Error: Pila vacía"); // Lanza error si no hay elementos
        }

        return cima; // Retorna la cima
    }

    // Método isEmpty: verifica si la pila está vacía
    public boolean isEmpty() {
        return cima == null; // Retorna true si no hay elementos
    }
}