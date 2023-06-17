
package TareaEDA;



public class PriorityQueueHeap<T extends Comparable<T>> {
    
    private MaxHeap<Node<T>> heap;
    private int count;

    public PriorityQueueHeap() {
        heap = new MaxHeap<>(); //Inicializamos el arreglo de datos MaxHeao implementada
        count = 0;
    }

    public void enqueue(T element, int priority) {
        Node<T> node = new Node<>(element, priority);//Creacion del nodo
        heap.insert(node); //Insercion del nodo, segun el metodo insert implementada en la clase MaxHeap
        count++;
    }

    public T dequeue() {
        if (isEmpty()) {  // Si la estructura de datos esta vacia
            throw new IllegalStateException("Error, no hay elementos...");
        }

        Node<T> node = heap.removeMax();
        //Eliminamos el maximo intem, segun el metodo removeMax implementada en la clase MaxHeap
        count--;
        return node.getDato(); 
    }

    public T front() {
        if (isEmpty()) { // Si la estructura de datos esta vacia
            throw new IllegalStateException("Error, lista vacia...");
        }

       
        return heap.primero().getDato();
    }

    public T back() {
        if (isEmpty()) {
            throw new IllegalStateException("Error, lista vacia...");
        }

        return heap.ultimo().getDato();
    }

    public boolean isEmpty() {
        return count == 0;
    }
    
    
}

