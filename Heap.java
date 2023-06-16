package heap;


public interface Heap<E extends Comparable<E>> {
	void insert(E x);
	void delete();
}
