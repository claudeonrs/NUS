import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Name:
 * Matric. No:
 */

import java.io.*;
import java.util.*;

public class Pancakes {

  public static boolean swappable(int[] initial, int[] target) {
    boolean isPossible=false;

    return isPossible;
  }
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    int numPancakes = Integer.parseInt(br.readLine());

    int[] initial = new int[numPancakes];
    int[] target = new int[numPancakes];

    String[] initialStr = br.readLine().split(" ");
    String[] targetStr = br.readLine().split(" ");

    for (int i=0; i<numPancakes; i++) {
      initial[i] = Integer.parseInt(initialStr[i]);
      target[i] = Integer.parseInt(targetStr[i]);
    }

    String output = (swappable(initial, target)) ? "Possible" : "Impossible";
    pw.println(output);
    pw.flush();
  }
}
