package advance.data.structure.Heap;

/**
 * It is a unstable sort -> same key can have their position changed wrt original array.
 * It require O(1) extra space and hence better than Merge sort in this aspect.
 * It is second fastest sorting after Randomized Quick sort but ensures O(nLogn) time complexity.
 * 
 * We use a max Heap heap for ascending sort
 * 
 * Heapifying an Arrays only takes O(n) time if we have whole array from start.
 * 
 * @author Rishabh Agarwal
 */
public class HeapSort {
	
	/**
	 *  MaxHeap is used for ascending order.
	 * 
	 */
	private static void sinkDown(int arr[], int index, int size) {	
		int largestIndex = index;
		int leftChild = 2*index+1;
		int rightChild = 2*index+2;
		
		if (leftChild < size && arr[leftChild] > arr[largestIndex]) 
			largestIndex = leftChild; 
        if (rightChild < size && arr[rightChild] > arr[largestIndex]) 
        	largestIndex = rightChild; 
        if (largestIndex != index) 
        { 
            int swap = arr[index]; 
            arr[index] = arr[largestIndex]; 
            arr[largestIndex] = swap; 
  
            // Recursively heapify the affected sub-tree 
            sinkDown(arr, largestIndex, size); 
        } 
	}
	
	/**
	 * 
	 * REMEMBER: Heapifying array takes only O(n) time
	 */
	private static void heapify(int arr[]) {
		int n =arr.length;
		for (int i = (n-1)/2; i >= 0; i--)  // heapify the array 
            sinkDown(arr, i, n);
	}
	
	public static void heapSort(int arr[]) {
		
		int n = arr.length;
		heapify(arr);
		for (int i=n-1; i>=0; i--) 
        { 
            int temp = arr[0]; 
            arr[0] = arr[i]; 
            arr[i] = temp; 
            
            sinkDown(arr, 0, i); 
        } 
	}
	
	
}
