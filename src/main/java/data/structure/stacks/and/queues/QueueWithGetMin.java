package data.structure.stacks.and.queues;

import java.util.Deque;
import java.util.LinkedList;

public class QueueWithGetMin {
	
	private Deque<Integer> nums = new LinkedList<>();
	private Deque<Integer> min = new LinkedList<>();
	
	public void offer(int t) {
		nums.offerLast(t);
		// keep removing till it is placed after a smaller or equal element
		while( min.size() > 0 && min.peekLast() > t) min.pollLast();
		min.offerLast(t);
	}
	
	public int peek() {
		return nums.peekFirst();
	}
	
	public int poll() {
		int t = nums.pollFirst();
		if(min.peekFirst() == t) min.pollFirst();
		return t;
	}
	
	public int peekMin() {
		return min.peekFirst();
	}

}
