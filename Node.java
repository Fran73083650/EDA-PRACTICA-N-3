
package TareaEDA;

public class Node<T> implements Comparable<Node<T>> {
    private T dato;
    private int priority;

    public Node(T dato, int priority) {
        this.dato = dato;
        this.priority = priority;
    }

    public T getElement() {
        return dato;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Node<T> x) {
        return Integer.compare(this.priority, x.getPriority());
    }
}

