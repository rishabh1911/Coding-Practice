package algo;

public class SeiveOfErasthones {
	
	boolean[] arr;
	int n;
	SeiveOfErasthones(int n) {
		this.n = n;
		arr = new boolean[n+1];
		generatePrimes(n);
	}
	
	private void generatePrimes(int n) {
		arr[0] = arr[1] = false;
		for(int i=2; i<=n; i++) arr[i] = true;
		for(int i = 2; i*i <= n; i++) {
			if(arr[i] == true) { // if number is prime 
				for(int j= i*i ; j <= n; j = j+i) arr[j] = false;
			}
		}
	}
	
	public boolean isPrime(int num) { return arr[num]; }
	
	public void printPrimes(int limit) {
		if( limit > n ) throw new IllegalArgumentException("limit cannot be grater than n: "+ n );
		System.out.println("**********************************************");
		for(int i=0; i<limit; i++ ) 
			if( arr[i] ) 
				System.out.println(i);
	}
	
	public static void main(String[] args) {
		SeiveOfErasthones seive = new SeiveOfErasthones(10000);
		System.out.println(seive.isPrime(121));
		System.out.println(seive.isPrime(11));
		seive.printPrimes(100);
	}

}
