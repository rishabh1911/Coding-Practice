package data.structure.stacks.and.queues;

public class CircularQueueUsingArray {
	
	int head = -1;
	int tail = -1;
	int numberOfElements = 0;
	int sizeOfArrInside;
	int arr[];
	int RESIZE_FACTOR = 2;
	
	public CircularQueueUsingArray(int size) {
		arr = new int[size];
		sizeOfArrInside = size;
	}
	
	public CircularQueueUsingArray() {
		arr = new int[2];
		sizeOfArrInside = 2;
	}
	
	public boolean isArrayFull() {
		if( tail == head-1 || (head == 0 && tail == sizeOfArrInside-1) ) 
			return true;
		return false;
	}
	
	public boolean isArrayEmpty() {
		if( tail == -1 && head == -1) 
			return true;
		return false;
	}
	
	public int getTailElement() {
		if( isArrayEmpty() ) 
			 throw new ArrayIndexOutOfBoundsException("No element present.");
		return arr[tail];
	}
	
	public int getHeadElement() {
		if( isArrayEmpty() ) 
			 throw new ArrayIndexOutOfBoundsException("No element present.");
		return arr[head];
	}
	
	public int removeElementFormHead() {
		if( isArrayEmpty() ) 
			 throw new ArrayIndexOutOfBoundsException("No element present.");
		numberOfElements--;
		int element = arr[head];
		head++;
		if( numberOfElements == 0) {
			tail = -1;
			head = -1;
		}
		else if( head == sizeOfArrInside) head = 0;
		return element;
	}
	
	public int removeElementFormTail() {
		if( isArrayEmpty() ) 
			 throw new ArrayIndexOutOfBoundsException("No element present.");
		numberOfElements--;
		int element = arr[tail];
		tail--;
		if( numberOfElements == 0) {
			tail = -1;
			head = -1;
		}
		else if( tail == -1) 
			tail = sizeOfArrInside-1;
		return element;
	}
	
	/** 
     *  increase size by resizeFactor
	 */
	private void resizeArray() {
		int newArr[] = new int[sizeOfArrInside*RESIZE_FACTOR];
		int i = 0;
		if( tail > head) {
			for(int j = head; j<=tail;)
				newArr[i++] = arr[j++];
			
		} else {
			for(int j = head; j<sizeOfArrInside;) 
				newArr[i++] = arr[j++];
			for(int j=0; j<=tail;) 
				newArr[i++] = arr[j++];
		}
		head = 0;
		tail = i-1;
		arr = newArr;
		sizeOfArrInside = sizeOfArrInside*RESIZE_FACTOR;
	}
	
	public void addElementToHead(int t) {
		if( isArrayFull() )
			resizeArray();
		head--;
		if( head < 0) head = sizeOfArrInside-1;
		arr[head] = t;
		numberOfElements++;
	}
	
	public void addElementToTail(int t) {
		if( isArrayFull() )
			resizeArray();
		tail++;
		if( tail == sizeOfArrInside) tail = 0;
		arr[tail] = t;
		numberOfElements++;
	}

}
