
package TareaEDA;


public class Tess {
    public static void main(String[] args) {
        PriorityQueueHeap<String> priorityQueue = new PriorityQueueHeap<>();

        priorityQueue.enqueue("Item 1", 1);
        priorityQueue.enqueue("Item 2", 2);
        priorityQueue.enqueue("Item 3", 3);

        System.out.println("Front: " + priorityQueue.front());
        System.out.println("Back: " + priorityQueue.back());
    }
}

