package advance.data.structure.Heap;

public class MinHeapRunner {
	
	public static void main(String[] args) {
		MinHeap heap = new MinHeap();
		heap.insert(5);
		heap.insert(7);
		heap.insert(3);
		heap.insert(2);
		
		System.out.println(heap.toString());
		System.out.println( heap.extractMin() +" "+  heap.extractMin() +" "+ heap.extractMin() +" "+ heap.extractMin() +" ");
		
		
		for(int i=32; i>=1; i--) heap.insert(i);
		
		System.out.println(heap.toString());
		for(int i=32; i>=1; i--) System.out.print(heap.extractMin()+ " ");
		
	}
}
