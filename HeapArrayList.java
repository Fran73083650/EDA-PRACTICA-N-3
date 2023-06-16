package heap;
import java.util.ArrayList;
public class HeapArrayList<E extends Comparable<E>>implements Heap<E>{
	private ArrayList<E> heap;
	
	private int size;
	
	public HeapArrayList() {
		this.heap=new ArrayList<E>();
		this.size=0;
	}
	public void insert(E item) {
	    this.heap.add(item);
	    int n = heap.size();
	    int j = n - 1;
	    E temp;
	    while (j > 0 && this.heap.get(j).compareTo(this.heap.get(j / 2)) > 0) {
	        temp = this.heap.get(j);
	        this.heap.set(j, this.heap.get(j / 2));
	        this.heap.set(j / 2, temp);
	        j /= 2;
	    }
	}
	public void delete() {
		this.heap.set(0, this.heap.remove(this.heap.size() - 1));
	    int j = 0;
	    while (2 * j < heap.size()) {
	        int k = 2 * j;
	        if (k + 1 < this.heap.size() && this.heap.get(k + 1).compareTo(this.heap.get(k)) > 0) {
	            k = k + 1;
	        }
	        if (this.heap.get(j).compareTo(this.heap.get(k)) > 0) {
	            break;
	        }
	        E temp = heap.get(j);
	        this.heap.set(j, this.heap.get(k));
	        this.heap.set(k, temp);
	        j = k;
	    }
	}
	public void print() {
		for(int i=0;i<this.heap.size();i++) {
			System.out.print(this.heap.get(i)+"\t");
		}
	}
	public boolean isEmpty() {
		return this.heap==null;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
