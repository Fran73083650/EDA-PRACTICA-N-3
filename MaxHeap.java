package TareaEDA;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<T extends Comparable<T>> {
    private List<T> heap;

    public MaxHeap() {
        heap = new ArrayList<>(); //Inicializando ArrayList
    }

    public void insert(T item) {
        heap.add(item);       //Añadimos el item ingresado al array
        int posActual = heap.size() - 1;   // posicion actual
        int posPadre = getPadreIndex(posActual);  // posicion del padre, mediante el metodo "getPadreIndex"

        while (posActual > 0 && heap.get(posActual).compareTo(heap.get(posPadre)) > 0) { 
            // 1. Si hay mas de un item; 2. si el hijo es mayor que el padre
            swap(posActual, posPadre); //Intercambiamos las posiciones del padre y el hijo
            posActual = posPadre;    
            posPadre = getPadreIndex(posActual);
        }
    }

    public T removeMax() {
        if (isEmpty()) {     // preguntamos si la lista esta vacia
            throw new IllegalStateException("La lista esta vacia...");
        }

        T maxItem = heap.get(0);  //El item con el mayor valor
        T lastItem = heap.remove(heap.size() - 1); // Eliminamos y capturamos el ultimo item

        if (!isEmpty()) {  
            heap.set(0, lastItem); //ingresamos como primer item al ultimo item
            heapify(0); 
        }

        return maxItem;
    }

    private void heapify(int currentIndex) { //Para movernos y comparar valores, segun el indice ingresado
        int leftChildIndex = getLeftChildIndex(currentIndex); //Indice del niño izquierdo
        int rightChildIndex = getRightChildIndex(currentIndex); //Indice del niño derecho
        int nuevoIndex = currentIndex; //

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex).compareTo(heap.get(nuevoIndex)) > 0) {
           //si existe el hijo izquierdo y   si el hijo izquierd es mayor al padre
            nuevoIndex = leftChildIndex; // El hijo izquierdo sera el nuevo padre
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(nuevoIndex)) > 0) {
            //si existe el hijo derecho y  si el hijo derecho es mayor al padre
            nuevoIndex = rightChildIndex; //El hijo derecho sera el nuevo padre
        }

        if (nuevoIndex != currentIndex) { //si se cumplieron alguno de los 2 casos anteriores
            swap(currentIndex, nuevoIndex); // Intercambiamos los indices(posiciones) correspodientes
            heapify(nuevoIndex); //Llamamos de nuevo al metodo "heapify" para seguir iterando y comparando los items
        }
    }

    private int getPadreIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private void swap(int index1, int index2) {//Prara intercambiar los items en el ArrayList
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
