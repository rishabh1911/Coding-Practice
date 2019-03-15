package advance.data.structure.avl.tree;

public class AVLTree {
	
	AVLNode root;
	
	/**
	 * The base case is primarily important.</br>
	 * This allows the leaf to have height zero and allows us to caclulate new height easliy as:</br>
	 * <code>node.height = 1+ Math.max( getHeight(node.left), getHeight(node.right) );</code>
	 * @param node
	 * @return
	 */
	public int getHeight(AVLNode node) {
		if( node == null ) return -1;
		return node.height;
	}
	
	private void updateHeight(AVLNode node) {
		if( node != null )
			node.height = 1+ Math.max( getHeight(node.left), getHeight(node.right));
	}
	
	/**
	 * Node can have max difference in heights of subtree as one.
	 * 
	 * @param node
	 * @return
	 */
	private boolean isBalanced(AVLNode node) {
		if( Math.abs(getBalanceFactor(node)) <= 1 ) return true;
		return false;
	}
	
	private int getBalanceFactor(AVLNode node) {
		if( node == null ) return 0;
		return node.left.height - node.right.height;
	}
	
	private AVLNode balanceNode(AVLNode node) {
		if( isBalanced(node) ) return node;
		if( getBalanceFactor(node) < -1 ) { // right tree is heavy, i.e. nodes are on right
			if( getBalanceFactor(node.right) == -1)  { // left rotation
				return rotateLeft(node);
			} else { // Right Left rotation 
				node.right = rotateRight(node.right);
				return rotateLeft(node);
			}
		} else  { // if(getBalanceFactor(node) > 1 ) i.e. left tree is heavy, i.e. nodes are on left
			if( getBalanceFactor(node.left) == 1)  { // right rotation
				return rotateRight(node);
			} else { // Left Right rotation 
				node.left = rotateLeft(node.left);
				return rotateRight(node);
			}
		}
	}
	
	private AVLNode rotateRight(AVLNode node) {
		AVLNode temp = node.left;
		AVLNode temp2 = temp.right;
		
		temp.right = node;
		node.left = temp2;
		
		// First update height of node which went lower.
		updateHeight(node);
		updateHeight(temp);
		
		// return the new root
		return temp;
	}
	
	private AVLNode rotateLeft(AVLNode node) {
		AVLNode temp = node.right;
		AVLNode temp2 = temp.left;
		
		node.right = temp2;
		temp.left = node;
		
		// First update height of node which went lower.
		updateHeight(node);
		updateHeight(temp);
		
		// return the new root
		return temp;
	}
	
	/**
	 * It inserts the  node in the AVL tree. Insertion in AVL Tree has three steps.</br>
	 * 1. Insert the node a appropriate position. (normal BST insertion).</br>
	 * 2. Get the updated height of parent nodes as go up the stack.</br>
	 * 3. Check if they become unbalanced.</br>
	 * 4. If yes, balance them and return new parent after balancing.</br>
	 * 5. if not return the parent.
	 * 
	 * @param parent -> root of the AVL Tree should be sent here.
	 * @param newNode -> new node to be inserted.
	 * @return the updated parent after inserting
	 */
	public AVLNode insert(AVLNode parent, AVLNode newNode) {
		
		// 1. Insert the node a appropriate position. (normal BST insertion).
		if( parent == null ) return newNode;
		else if( newNode.data > parent.data) parent.right = insert(parent.right, newNode);
		else if(newNode.data < parent.data) parent.left = insert(parent.left, newNode);
		
		// 2. Get the updated height of parent nodes as go up the stack.
		updateHeight(parent);
		
		// 3. Check if they become unbalanced.
		if( !isBalanced(parent) ) return balanceNode(parent);
		
		// 4. If yes rotate them to balance them
		return parent;
	}

}
