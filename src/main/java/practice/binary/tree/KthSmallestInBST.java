package practice.binary.tree;

/**
 * Link: https://www.interviewbit.com/problems/kth-smallest-element-in-tree/
 *
 */
public class KthSmallestInBST {

}

/** Solution1: 
 * 				Using Inorder traversal fill an array and return k'th element
 * 				Takes 0(n) extra space and O(n) time
 */
class Solution1 {
    
    int arr[] = new int[100000];
    int i = 0;
    
    private void inOrder(TreeNode A) {
        if(A==null) return;
        inOrder(A.left);
        arr[i++] = A.val;
        inOrder(A.right);
    }
    
    public int kthsmallest(TreeNode A, int k) {
        i = 0; // initialize cursor
        inOrder(A);
        return arr[k-1];
    }
}


/** Solution2: We need to maintain count of left element so far.
 * 				This we can do with single global variable.
 * 				When number of left elements equal k-1 	
 * 				return the node, else return Integer.MAX_VALUE 
 * 			(Best could be return so that even Integer.MAX_VALUE can be in out tree)
 * 				Thus takes only O(1) extra space in O(n) time
 * 				
 */
class Solution2 {
    
    int i = 0;
    
    public int kthsmallest(TreeNode A, int k) {
        if(A == null) return Integer.MAX_VALUE;
        int solFromLeft = kthsmallest(A.left, k);
        if( solFromLeft != Integer.MAX_VALUE ) return solFromLeft;
        i++;  // counting current Node
        if( i == k) return A.val;
        return kthsmallest(A.right, k);
        
    }
}

