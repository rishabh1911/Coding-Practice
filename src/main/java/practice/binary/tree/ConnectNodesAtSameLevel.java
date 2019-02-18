package practice.binary.tree;
// Question: https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
// Practice: https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
public class ConnectNodesAtSameLevel {

}

class GfG
{
    void connect(Node root)
    {
        connect(root, null);
    }
    
    void connect(Node root, Node rightNode) {
        if(root == null) return;
        
        root.nextRight = rightNode;
        Node rightMostNode = null;
        if(root.left != null) {
            if(root.right != null) {
                connect(root.left, root.right);
                rightMostNode = root.right;
            } else {
                rightMostNode = root.left;
            }
        } else {
            rightMostNode = root.right;
        }
        connect(rightMostNode, getLeftMostChild(rightNode));
    }
    
    Node getLeftMostChild(Node root) {
        if(root == null) return null;
        if(root.left != null) return root.left;
        return root.right;
    } 
}

class Node {
	int val;
	Node left;
	Node right;
	Node nextRight;
}
