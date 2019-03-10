package advance.data.structure.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

class HeapElement implements Comparable<HeapElement> {
	int val;
	int index;
	public HeapElement(int val, int index) {
		super();
		this.val = val;
		this.index = index;
	}
	
	@Override
	public int compareTo(HeapElement ele) {
		return ele.val - this.val;
	}
}

/** Question: find kth Largest element in a heap in O(klogk) time.
 * 
 *   Simplest way is to extract k elements but it will take O(klogn) time. 
 *   Can we do it in O(n) ?
 *   O(n) solution will be faster when k is comparable to n.
 *   
 *   We know that root is the largest element.
 *   After that 2nd largest is one of its children.
 *   Now 3rd largest is the other element of any children of chosen element.
 *   
 *   This can be used to get the element.
 *   Source: Elements of programming Interview: Pg 184
 * @author Rishabh Agarwal
 */
public class Kth_Largest_in_Heap {
	
	// The input heap.
	static int heap[] = {100, 99, 50, 90, 95, 40, 30, 88, 2, 94, 8, 20, 12, 11, 1};
	                   // 0   1    2  3   4    5   6   7   8  9  10  11 12  13  14 
	static int k = 5;
	
	public static void main(String[] args) {
		PriorityQueue< HeapElement > pq = new PriorityQueue<HeapElement>( );
		pq.add(new HeapElement(heap[0], 0));
		HeapElement ele = null;
		int i = 0;
		int n = heap.length;
		while( i < k ) {
			i++;
			ele = pq.poll(); // taken out i'th element.
			int index = ele.index;
			if( 2*index+1 < n) pq.add( new HeapElement( heap[2*index+1], 2*index+1));
			if( 2*index+2 < n) pq.add( new HeapElement( heap[2*index+2], 2*index+2));
		}
		System.out.println("kth largest element: "+ ele.val);
		
		Arrays.sort(heap);
		System.out.println("Sorted heap" + Arrays.toString(heap));
	}
	
	

}
