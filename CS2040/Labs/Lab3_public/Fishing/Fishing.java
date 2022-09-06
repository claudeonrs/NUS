/**
 * Name : Claudeon Reinard Susanto
 * Matric. No : A0239079R
 */

public class Fishing {
  
  public static long simulate(int n, int k, int[] arr) {
      long maxVal = 0;
      long curVal = 0;
      for (int i=0; i<k; i++) {
          curVal +=arr[i];
      }
      if (curVal > maxVal) {
          maxVal = curVal;
      }
      for (int i=0; i<n-k; i++) {
          curVal -= arr[i];
          curVal += arr[i+k];
          if (curVal > maxVal) {
              maxVal = curVal;
          }
      }
      return maxVal;
  }

  public static void main(String args[]) {
      Kattio io = new Kattio(System.in, System.out);
      int n = io.getInt();
      int k = io.getInt();
      int[] arr = new int[n];
      for (int i=0; i<n; i++) {
          arr[i] = io.getInt();
      }
      long out = simulate(n, k, arr);
      io.println(out);
      io.close();
  }
}
