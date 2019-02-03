package advance.data.structure.Heap;

public class HeapSortRunner {

	public static void main(String[] args) {
        
		int size = 15;
		int arr[] = new int[size];
		for(int i=0; i<size; i++) arr[i] = (int)(Math.random()*1000);
		for(int i=0; i<size; i++) System.out.print(arr[i] + " ");
		System.out.println("\n-----------------------------------After Sorting----------------------------------------");
		HeapSort.heapSort(arr);
		for(int i=0; i<size; i++) System.out.print(arr[i] + " ");

	}

}
