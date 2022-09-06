/**
 * Name: Claudeon Susanto
 * Matric. No: A0239079R
 */

import java.util.*;
import java.io.*;

public class RhythmGame {

  //int maxComboSize=0;
  static LinkedList<Integer> combo = new LinkedList<>();
  static LinkedList<Integer> maxCombo = new LinkedList<>();
  static boolean isAlternating=false;
  static boolean isReversed=false;

  private static void turn(int move) {
    if (move==0) {
		if (combo.size() > maxCombo.size()) {
			maxCombo.clear();
			maxCombo.addAll(combo);
		}
		combo.clear();	
	} else if (move==5) {
		isReversed = !isReversed;
		//System.out.println("REVERSED: "+isReversed);
	} else if (move==6) {
		isAlternating = !isAlternating;	
		//System.out.println("ALTERNAT: "+isAlternating);
		if (isAlternating) {
			isReversed = !isReversed;
			//System.out.println("REVERSED: "+isReversed);
		}
	} else {
		if (isReversed) {
			combo.addFirst(move);
		} else {
			combo.addLast(move);
		}

		if (isAlternating) {
			isReversed = !isReversed;
			//System.out.println("REVERSED: "+isReversed);
		}
	}
	

  }

  public static void main(String args[]) throws IOException {
    Kattio io = new Kattio(System.in, System.out);
	int n = io.getInt();

	for (int i=0; i<n; i++) {
		turn(io.getInt());
	}
	if (combo.size() > maxCombo.size()) {
		io.println(combo.size());
		io.println(combo);
	} else {
		io.println(maxCombo.size());
		io.println(maxCombo);
	}
	io.close();
  }
}
