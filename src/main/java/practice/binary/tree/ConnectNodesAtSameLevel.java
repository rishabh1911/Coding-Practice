package practice.binary.tree;
// Question: https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
// Practice: https://www.interviewbit.com/problems/populate-next-right-pointers-tree/
public class ConnectNodesAtSameLevel {

}

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    TreeLinkNode getNextRightChild(TreeLinkNode node)  
    { 
        TreeLinkNode temp = node.next; 
        while (temp != null)  
        { 
            if (temp.left != null) 
                return temp.left; 
            if (temp.right != null) 
                return temp.right; 
            temp = temp.next; 
        }
        // If all the nodes at p's level are leaf nodes then return NULL 
        return null; 
    }
    
    private void connectRight(TreeLinkNode root) {
        if( root == null ) return;
        root.next = null;
        TreeLinkNode node = root;
        while(node != null) {
            TreeLinkNode temp = node;
            /* Connect all nodes at level lower than p */
            while (temp != null)  
            { 
                // Set the nextRight pointer for temp's left child 
                if (temp.left != null)  
                { 
                    if (temp.right != null) 
                        temp.left.next = temp.right; 
                    else
                        temp.left.next = getNextRightChild(temp); 
                } 
                // Set the nextRight pointer for temp's right child 
                if (temp.right != null) 
                    temp.right.next = getNextRightChild(temp); 
                temp = temp.next; 
            }
            // start from the first node of next level 
            if (node.left != null) 
                node = node.left; 
            else if (node.right != null) 
                node = node.right; 
            else
                node = getNextRightChild(node); 
        }
        return;
    }
    
    
    public void connect(TreeLinkNode root) {
        connectRight(root);
    }
}
