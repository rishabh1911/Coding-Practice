package algo;

/** Segment tree implementing sum over a range
 * 
 * @author Rishabh Agarwal
 */
public class SegmentTree {
	
	int[] tree;
	int[] arr;
	int n;
	
	/**
	 * Takes an array and creates segment tree for it.
	 */
	SegmentTree(int[] arr) {
		this.arr = arr;
		this.n = arr.length;
		this.tree = new int[ 2*arr.length];
		buildTree(0, 0, n-1);
	}
	
	/**
	 * returns sum of elements between queryStart and queryEnd both inclusive 
	 */
	public int getSum(int queryStart, int queryEnd) {
		return getSum(queryStart, queryEnd, 0, 0, n-1);
	}
	
	/**
	 * add the <b>addval</b> to variable at <b>index</b> location and updates the segment tree
	 */
	public void update(int addVal, int index) {
		update(addVal, index, 0, 0, n-1);
	}
	
	private int buildTree(int node , int start, int end) {
		if(start == end) {
			tree[node] = arr[start];
			return tree[node];
		}
		int mid = (start + end)/2;
		tree[node] = buildTree(2*node+1, start, mid) + buildTree(2*node+2, mid+1, end);
		return tree[node];
	}
	
	private int getSum(int queryStart, int queryEnd, int node, int nodeStart, int nodeEnd) {
		if( nodeEnd < queryStart || queryEnd < nodeStart ) return 0;
		if(queryStart <= nodeStart && nodeEnd <= queryEnd ) return tree[node];
		int mid = ( nodeStart + nodeEnd )/2;
		int sum = getSum(queryStart, queryEnd, 2*node+1, nodeStart, mid) + 
				 getSum(queryStart, queryEnd, 2*node+2, mid+1, nodeEnd);
		return sum;	
	}
	
	private void update(int addVal, int index, int node, int start, int end) {
		if( start == end ) {
			arr[index] += addVal;
			tree[node] += addVal; 
		}
		int mid = (start+end)/2;
		if( start<=index && index<=mid) 
			update(addVal, index, 2*node+1, start, mid);
		else
			update(addVal, index, 2*node+2, mid+1, end);
		
		tree[node] = tree[2*node+1] + tree[2*node+2];
	}
	

}
