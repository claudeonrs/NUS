/**
 * Name:
 * Matric. No:
 */

import java.io.*;
import java.util.*;

public class Candyland {
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
      int n = Integer.parseInt(br.readLine());
      int[] arr;
      if (n>=3) {
          arr = new int[n+1];
      } else if (n > 0) {
          arr = new int[4];
      } else {
          pw.println(0);
          pw.close();
          return;
      }
      arr[0] = 1;
      arr[1] = 1;
      arr[2] = 2;
      arr[3] = arr[0] + arr[1] + arr[2];
      for (int i=4; i<=n; i++) {
          arr[i] = arr[i-1] + arr[i-2] + arr[i-3] + arr[i-4];
      }
      pw.println(arr[n]);
      pw.close();

  }
}
