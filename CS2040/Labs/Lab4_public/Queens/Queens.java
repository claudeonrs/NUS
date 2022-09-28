/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.io.*;
import java.util.*;

public class Queens {
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
      String[] sizes = br.readLine().split(" ");
      int n = Integer.parseInt(sizes[0]);
      int m = Integer.parseInt(sizes[1]);
      int[][] board = new int[n][n];

      String row;
      for (int i=0; i<n; i++) {
          row = br.readLine();
          for (int j=0; j<n; j++) {
              switch (row.charAt(j)) {
                  case 'Q':
                  board[i][j]=1;
                  break;
                  case '.':
                  board[i][j]=0;
                  break;
              }
          }
      }
      // int[][] board
      //pw.println(Arrays.toString(board));
      
      pw.close();
  }
}
