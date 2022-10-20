/**
 * Name:
 * Matric. No:
 */

import java.util.*;
import java.io.*;

public class Monsters {

  public long[] simulate(int[] deck) {
      PriorityQueue<Long> heap = new PriorityQueue<>(deck);
      HashMap<Long, Integer> map = new HashMap<>();
      
      for () {

      }
  }
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

      int deckSize = Integer.parseInt(br.readLine());
      String[] deckString = br.readLine().split(" ");
      int[] deck = new int[deckSize];
      for (int i=0; i<deckSize; i++) {
          deck[i] = Integer.parseInt(deckString[i]);
      }

      // end deck after simulation
      long[] endDeck = simulate(deck);
      for (long card: endDeck) {
          pw.print(card);
          pw.print(" ");
      }
      pw.close();
      br.close();
  }
}
