/**
 * Name : Claudeon Susanto
 * Matric. No : A0239079R
 */


public class SquaringArray {
  public static void main(String args[]) {
	  Kattio io = new Kattio(System.in, System.out);
	  int n = io.getInt();
	  int[] arr = new int[n*n];
	  for (int i=0; i<n; i++) {
		  arr[i] = io.getInt();
	  }
	  int incr = 1; int currIdx = n-1;
	  for (int i=n; i<n*n; i++) {
		  currIdx += incr;
		  if (currIdx >= n || currIdx < 0) {
			  incr = -incr;
			  currIdx += incr;
		  }
		  arr[i] = arr[currIdx]*((int)i/n + 1);
	  }
	  for (int i=0; i<n*n-1; i++) {
		  // bruh moment
		  io.print(arr[i]);
		  io.print(" ");
	  }
	  io.print(arr[n*n-1]);
	  io.println();
	  io.close();
  }
}
