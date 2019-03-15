package advance.data.structure.avl.tree;

/**
 * AVL tree node is an augmented data structure.
 * We have extra height stored in each node.
 * 
 * Height is the max length path from that node to leaf.
 * Thus head is concerned with subtree below.
 * ( Depth is concerned with the level from main root )  
 * @author Rishabh Agarwal
 *
 * @param <T> data-type of data in AVL Node
 */
public class AVLNode {
	int data;
	AVLNode left;
	AVLNode right;
	int height;
	
	AVLNode(int data) {
		this.data = data;
		left = right = null;
		height = 0;
	}
	
}
