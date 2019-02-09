package advance.data.structure.LRU.cache;

import java.util.HashMap;
import java.util.Map;

// Doubly LinkedList Node
class Node {
	// need to store key so that we can remove from map
	// during eviction
	public int key;
	public int val;
	public Node next;
	public Node prev;

	Node(int key, int val) {
		this.key = key;
		this.val = val;
		next = prev = null;
	}

	public String toString() {
		return "Key: "+key+" and Value: "+val;
	}
}

class DoublyLinkedList {
	Node root;
	Node tail;
	int size = 0;

	DoublyLinkedList() {
		root = tail = null;
		size = 0;
	}

	public void addInFront(Node node) {
		if(root == null) {
			tail = node;
			root = node;
			size++;
			return;
		}
		//System.out.println(root);
		Node temp = root;
		temp.prev = node;
		node.next = temp;
		root = node;
		size++;
	}

	public void deleteNode(Node node) {
		Node nextNode = node.next;
		Node prevNode = node.prev;
		node.next = node.prev = null ;
		if(nextNode != null) nextNode.prev = prevNode;
		else tail = prevNode;
		if(prevNode != null) prevNode.next = nextNode;
		else root = nextNode;
		size--;
	}

	public Node removeTail() {
		Node node = tail;
		deleteNode(tail);
		return node;
	}

	public void printList() {
		Node node = root; 
		while(node != null) {
			System.out.print(node+"\t");
			node = node.next;
		}
		System.out.println();
	}
}


public class LRUCache {

	Map<Integer, Node> cacheMap;

	DoublyLinkedList list;    

	int capacity;

	public LRUCache(int capacity) {
		list = new DoublyLinkedList();
		cacheMap = new HashMap<Integer, Node>();
		this.capacity = capacity;
	}

	public int get(int key) {
		if( cacheMap.get(key) == null) return -1;
		Node node = cacheMap.get(key);
		list.deleteNode(node);
		list.addInFront(node);
		return cacheMap.get(key).val;
	}

	public void set(int key, int value) {
		// full capacity and not a update call
		if(capacity == list.size && cacheMap.get(key) == null) { 
			Node prevTail = list.removeTail();
			cacheMap.remove(prevTail.key);
		}
		Node node = null;
		if( cacheMap.get(key) != null) {
			node = cacheMap.get(key);
			list.deleteNode(node);
			node = new Node(key,value);
			cacheMap.put(key, node);
			list.addInFront(node);
		} else {
			node = new Node(key,value);
			cacheMap.put(key, node);
			list.addInFront(node);
		}
	}
}
