public class Pila {

    // La cima de la pila (último elemento agregado)
    private Nodo cima;

    // Constructor
    public Pila() {
        cima = null; // pila inicia vacía
    }

    // Método para apilar (push)
    public void push(String simbolo, int linea, int columna) {
        Nodo nuevo = new Nodo(simbolo, linea, columna);

        // El nuevo nodo apunta a la antigua cima
        nuevo.siguiente = cima;

        // Ahora el nuevo nodo es la cima
        cima = nuevo;
    }

    // Método para desapilar (pop)
    public Nodo pop() {
        if (isEmpty()) {
            throw new RuntimeException("Error: Pila vacía");
        }

        // Guardamos la cima actual
        Nodo temp = cima;

        // La cima pasa a ser el siguiente nodo
        cima = cima.siguiente;

        return temp;
    }

    // Ver el elemento en la cima sin eliminarlo
    public Nodo peek() {
        if (isEmpty()) {
            throw new RuntimeException("Error: Pila vacía");
        }
        return cima;
    }

    // Verificar si la pila está vacía
    public boolean isEmpty() {
        return cima == null;
    }
}