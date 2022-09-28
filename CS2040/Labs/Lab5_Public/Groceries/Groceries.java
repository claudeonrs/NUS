/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class Groceries {

  // precondition: sorted array (descending)
  public static long minCost(Integer[] arr, int groupSize, int freeSize) {
      return minCost(arr, groupSize, freeSize, 0);
  }
  public static long minCost(Integer[] arr, int groupSize, int freeSize, int start) {
      if (start >= arr.length) {
          return 0;
      }
      long cost = 0;
      for (int i=0; i<groupSize && start+i< arr.length; i++) {
          if (i > groupSize-freeSize-1 && groupSize+start-1 <= arr.length) {
              break;
          } else {
              cost += arr[start+i];
          }
      }
      return (cost + minCost(arr, groupSize, freeSize, start+groupSize));
  }

  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

      String[] arr = br.readLine().split(" ");
      int n = Integer.parseInt(arr[0]);
      int k = Integer.parseInt(arr[1]);
      int m = Integer.parseInt(arr[2]);

      Integer[] prices = new Integer[n]; 
      for (int i=0; i<n; i++) {
         prices[i] = Integer.parseInt(br.readLine());
      }

      Arrays.sort(prices, Collections.reverseOrder());
      long cost = minCost(prices, k, m);
      pw.println(cost);
      pw.close();
  }
}
