package data.structure.stacks.and.queues;

public class ImplementQueueUsingStackRunner {

	public static void main(String[] args) {
		ImplementQueueUsingStack<Integer> q = new ImplementQueueUsingStack<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		System.out.println(q.poll() + " " );
		q.offer(4);
		System.out.println(q.poll() + " " +q.peek() + " ");
		System.out.println(q.poll() + " " +q.poll() + " ");

	}

}
