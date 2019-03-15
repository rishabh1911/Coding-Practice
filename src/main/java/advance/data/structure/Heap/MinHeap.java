package advance.data.structure.heap;

import java.util.Arrays;

/**
 * Heap is implemented using array to save memory of pointers 
 * in node implementation
 *
 * This heap starts with zero index.
 */
public class MinHeap {

	private int capacity = 10; // same is in arrayList
	private int size;
	int arr[];

	MinHeap() {
		arr = new int[capacity];
		size = 0;
	}

	public int getParentIndex(int index) { 
		if(index == 0) return -1;
		return (index-1)/2 ;
	} 

	public int getLeftChildIndex(int index) { 
		if(2*index + 1 < size)
			return 2*index + 1;
		return -1;
	}

	public int getRightChildIndex(int index) { 
		if(2*index + 2 < size)
			return 2*index + 2;
		return -1;
	}


	public int getParent(int index) { 
		if(index == 0) return Integer.MIN_VALUE; // or throw exception
		return arr[ (index-1)/2 ];
	} 

	public int getLeftChild(int index) { 
		if(2*index + 1 < size)
			return arr[ 2*index + 1 ];
		return Integer.MIN_VALUE;   // or throw exception
	}

	public int getRightChild(int index) { 
		if(2*index + 2 < size)
			return arr[ 2*index + 2 ];
		return Integer.MIN_VALUE;   // or throw exception

	}

	private void ensureCapacity() {
		if(size == capacity) {
			arr = Arrays.copyOf(arr, capacity*2);
			capacity *= 2; 
		}
	}

	public void insert(int val) {
		ensureCapacity ();
		arr[size] = val;
		size++;
		bubbleUp(size-1);
	}

	public int peek() {
		if(size==0)
			return Integer.MIN_VALUE;
		return arr[0];
	} 

	public int extractMin() {
		if(size==0)
			return Integer.MIN_VALUE;
		int min = arr[0];
		arr[0] = arr[size-1]; // put leaf element in root
		size--;               // decrease size;
		sinkDown(0);          // use sinkDown
		return min;
	}

	public void bubbleUp(int index) {
		if(index<=0) return;
		if(arr[index] < getParent(index) ) {
			swap(index, getParentIndex(index));
			bubbleUp(getParentIndex(index));
		}
	}

	/**
	 * Also called Heapify.
	 */
	public void sinkDown(int index) {

		if(getRightChild(index) != Integer.MIN_VALUE) {
			if(getLeftChild(index) < getRightChild(index) &&  
					getLeftChild(index) < arr[index]) {
				swap( index, getLeftChildIndex(index) );
				sinkDown( getLeftChildIndex(index) );
			} else if(getRightChild(index) <= getLeftChild(index) &&  
					getRightChild(index) < arr[index]) {
				swap( index, getRightChildIndex(index) );
				sinkDown( getRightChildIndex (index) );
			}

		}else if(getLeftChild(index) != Integer.MIN_VALUE) {
			if(getLeftChild(index) < arr[index]) {
				swap( index, getLeftChildIndex(index) );
				sinkDown( getLeftChildIndex(index) );
			}
		}
	}

	private void swap(int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MinHeap [arr=");
		builder.append(Arrays.toString(arr));
		builder.append("]");
		return builder.toString();
	}

}
