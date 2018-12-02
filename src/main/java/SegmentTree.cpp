/**
* This is the solution of Range Maximum Query Question.
* https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/tutorial/
*/


#include <bits/stdc++.h>
using namespace std;
#define dbg(x) {  cout<<#x<<" : "<<x<<endl; }
int arr[1000005];
int st[2000002];

void buildSegmentTree(int node,int start,int end)
{
	if(start==end) {
		st[node]=arr[start];
		return;
	}
	int mid=(start+end)/2;
	buildSegmentTree(2*node+1,start,mid);
	buildSegmentTree(2*node+2,mid+1,end);
	st[node]=min(st[2*node+1],st[2*node+2]);
}

void update(int node,int start,int end,int index,int val) {
	if(start==end) {
		st[node]+=val;
		return;
	}
	int mid=(start+end)/2;
	if(start<=index && index<=mid)
		update(2*node+1,start,mid,index,val);
	else
		update(2*node+2,mid+1,end,index,val);
	st[node]=min(st[2*node+1],st[2*node+2]);
}

int query(int node,int start,int end,int qstart,int qend) {
	if(end<qstart || qend<start)
		return 1000009;
	if(qstart<=start && end<=qend)
		return st[node];
	int mid=(start+end)/2;
	int a=query(2*node+1,start,mid,qstart,qend);
	int b=query(2*node+2,mid+1,end,qstart,qend);
	return min(a,b);
}

int main()
{
    int n,q;
    cin>>n>>q;
    for(int i=0;i<n;i++)
    	cin>>arr[i];
    buildSegmentTree(0,0,n-1);
   // for(int i=1;i<=9;i++)
    //	cout<<st[i]<<" ";
    for(int i=0;i<q;i++) {
    	char c;
    	cin>>c;
    	if(c=='u') {
    		int index;
    		char c;
    		cin>>index>>c;
    		index--;
    		char diff = c-arr[index];
    		arr[index]=c;
    		update(0,0,n-1,index,diff);
    	}
    	else {
    		int l,r;
    		cin>>l>>r;
    		l--;
    		r--;
    		int ans=query(0,0,n-1,l,r);
    		cout<<ans<<endl;
    	}
    }
    return 0;
}
