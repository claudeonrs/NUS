/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.io.*;

public class Macarons {

  // find number of subsequences in arr where sum is divisible by div
  // precondition: arr.length > 0
  // postcondition: long will be returned
  public static long findTotalSubseq(int div, int[] arr) {
      
      // runningTotal[i] = number of subsequences starting from index 0 where running total is i mod div
      int[] runningTotal = new int[div];
      runningTotal[0] = 1;

      // temp variable to store running total from index 0 to arr[length-1]
      int total = 0;

      for (int i=0; i<arr.length; i++) {
          total = (total+(arr[i])%div)%div;
          runningTotal[total]++;
      }


      // total subsequences in which the sum is divisible by div
      long totalSubseq = 0;

      // add up subsequences from running Total
      for (int i=0; i<div; i++) {
          if (runningTotal[i] == 0) {
              continue;
          }
          totalSubseq += (long)runningTotal[i]*(runningTotal[i]-1)/2;
      }
      return totalSubseq;
  }
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

      String[] command;
      command = br.readLine().split(" ");

      int numMacarons = Integer.parseInt(command[0]);
      int divisor = Integer.parseInt(command[1]);

      command = br.readLine().split(" ");
      int[] macarons = new int[numMacarons];

      for (int i=0; i<numMacarons; i++) {
          macarons[i] = Integer.parseInt(command[i]);
      }

      long totalSubseq = findTotalSubseq(divisor, macarons);
      pw.println(totalSubseq);
      pw.flush();
  }
}
