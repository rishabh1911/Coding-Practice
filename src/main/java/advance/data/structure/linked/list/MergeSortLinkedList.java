package advance.data.structure.linked.list;

class ListNode {
	public int val;
	public ListNode next;
	ListNode(int x) { val = x; next = null; }
}

public class MergeSortLinkedList {

	ListNode ans;

	private ListNode findMiddle(ListNode a) {
		if( a== null) return null;
		ListNode slowPtr = a;
		ListNode fastPtr = a.next;
		while( fastPtr != null && fastPtr.next != null ) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}

	private ListNode mergeSort(ListNode node) {
		if( node == null || node.next == null) return node;
		ListNode mid = findMiddle(node);
		ListNode midNext = mid.next;
		mid.next = null;
		ListNode firstHalf = mergeSort(node);
		ListNode secondHalf = mergeSort(midNext);
		ListNode ans =  merge(firstHalf, secondHalf);
		return ans;
	}

	private ListNode merge(ListNode first, ListNode second) {
		ListNode ans  = new ListNode(-1);
		ListNode curr = ans;
		while( first!= null && second != null) {
			if( first.val < second.val ) {
				curr.next = first;
				first = first.next;
				curr = curr.next;
			} else {
				curr.next = second;
				second = second.next;
				curr = curr.next;
			}
		}
		while( first != null ) {
			curr.next = first;
			first = first.next;
			curr = curr.next;
		}
		while(  second != null ) {
			curr.next = second;
			second = second.next;
			curr = curr.next;
		}
		return ans.next;
	}

	private void printList(ListNode node) {
		while(node != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
		System.out.println();
	}

	public ListNode sortList(ListNode A) {
		ans = mergeSort(A);
		return ans;
	}
}
