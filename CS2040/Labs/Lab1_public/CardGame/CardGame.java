/**
 * Name : Claudeon Susanto
 * Matric. No : A0239079R
 */

import Kattio.java;

public class CardGame {
  public static void main(String args[]) {
    CardGame game = new CardGame();
	Kattio io = new Kattio(System.in, System.out);

	// n = number of cards
	int n = io.getInt(); 
	// a, b = number of cards in deck 1, 2
	int a = io.getInt(); b = io.getInt(); c = n-a-b;

	int[] deck = new int[n];
	int[] deck1, deck2, deck3;
	deck1 = new int[a];
	deck2 = new int[b];
	deck3 = new int[c];

    game.addDeck();
	int numberOfCommands = io.getInt();
	for (int i=0; i<numberOfCommands; i++) {
		switch (io.getWord()) {
			case "SWAP":
				game.swap(io.getInt());
				break;
			case "REVERSE":
				String arg = io.getWord();
				if (arg.equals("ALL")) {
					game.swap(1,3);
					game.reverse(1); 
					game.reverse(2);
					game.reverse(3);
				} else {
					game.reverse(Integer.valueOf(io.getWord));
				}
			case "INCREMENT":
				String arg = io.getWord();
				if (arg.equals("ALL")) {
					game.increment(io.getWord())
				} else {
					game.increment(arg, Integer.valueOf(io.getWord));
				}		
		}
	}
  }

  public void addDeck() {
	 for (int i=0; i<n; i++) {
		 deck[i] = io.getInt();
	 }
	 deck1 = ;
  }

  public void swap(int x, int y) {
	  if ((x==1 && y==3) || (x==3 && y==1)) {
		  int temp = a;
		  a = b; b = temp;
		  // fuck my life man
	  } else if ((x==1 && y==2) || (x==2 && y==1)) {
		  
	  } else {

	  }
  }

  public void increment(int x, int val) {
	  for (int i: )
	  ;
  }
  // ALL method
  public void increment(int val) {
	  game.increment(1,val);
	  game.increment(2,val);
	  game.increment(3,val);
  }

  public void reverse(int x) {
	  ;
  }
  // ALL method
  public void reverse() {
	  ;
  }

}
