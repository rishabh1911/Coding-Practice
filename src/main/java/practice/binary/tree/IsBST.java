package practice.binary.tree;

class Node {
	int data;
	Node left;
	Node right;
	
	Node(int data) {
		this.data = data;
		left = right = null;
	}
}


public class IsBST
{
    private int isBstUtil(Node root, int greaterThan, int smallerThan) {
        if( root == null ) return 1;
        if( root.data < greaterThan || root.data > smallerThan) return 0;
        
        return isBstUtil(root.left, greaterThan, root.data) &
               isBstUtil(root.right, root.data, smallerThan);
    }
    
    int isBST(Node root)  
    {
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
