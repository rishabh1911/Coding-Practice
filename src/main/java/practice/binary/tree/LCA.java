package practice.binary.tree;

import java.util.ArrayList;

public class LCA {}

// Question from https://www.interviewbit.com/problems/least-common-ancestor/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
		left=null;
		right=null;
	}
}

 class Solution {

	ArrayList<TreeNode> pathA;
	ArrayList<TreeNode> pathB;


	private void printPath(ArrayList<TreeNode> path) {
		for(int i=0; i<path.size(); i++)
			System.out.print( path.get(i).val+ " " );
		System.out.println( );
	}

	// path are stored from leaf to root
	private boolean findPath(TreeNode root, int A, ArrayList<TreeNode> path) {
		if(root == null) return false;
		if(root.val == A) {
			path.add(root);
			return true;
		}
		boolean b1 = findPath(root.left, A, path);
		boolean b2 = findPath(root.right, A, path);
		if( b1|b2 ) {
			path.add(root);
			return true;
		}
		return false;
	}

	public int lca(TreeNode root, int A, int B) {
		pathA = new ArrayList<>();
		pathB = new ArrayList<>();
		boolean doesAexists = findPath(root, A, pathA );
		boolean doesBexists = findPath(root, B, pathB );
		//printPath(pathA);
		//printPath(pathB);
		if( doesAexists && doesBexists ) {
			if(A == B) return A;
			int pointerA = 0;
			int pointerB = 0;
			if( pathA.size() > pathB.size() ) pointerA = pathA.size() - pathB.size();
			else if( pathB.size() > pathA.size() )  pointerB = pathB.size() - pathA.size();

			while( pathA.get(pointerA) != pathB.get(pointerB) ) {
				pointerA++;
				pointerB++;
			}
			return pathA.get(pointerA).val;

		}
		return -1;  
	}
}

