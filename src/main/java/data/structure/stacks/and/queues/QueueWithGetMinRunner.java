package data.structure.stacks.and.queues;

public class QueueWithGetMinRunner {

	public static void main(String[] args) {
		
		QueueWithGetMin q = new QueueWithGetMin();
		q.offer(4);
		q.offer(1);
		q.offer(9);
		
		System.out.println(q.peekMin()+" "+ q.peek() );
		System.out.println(q.poll()+" "+ q.poll() );
		System.out.println(q.peekMin()+" "+ q.peek() );
		q.offer(12);
		q.offer(2);
		System.out.println(q.peekMin()+" "+ q.peek() );
		System.out.println(q.poll()+" "+ q.poll() );
		System.out.println(q.peekMin()+" "+ q.peek() );
	}

}
