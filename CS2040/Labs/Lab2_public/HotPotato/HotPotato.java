/**
 * Name : Claudeon Susanto
 * Matric. No : A0239079R
 */

import java.io.*;
import java.util.*;


public class HotPotato {
  
  class Node {
	  int val;
	  Node next;
	  
	  Node(int val) {
		  this.val=val;
	  }
  }

  class CircularLL {
	  Node head, tail;
	  int size;

	  // add from back
	  CircularLL(int[] arr) {
		  head=new Node(arr[0]);
		  Node curr = head;
		  for (int i=1; i<arr.length; i++) {
			  curr.next=new Node(arr[i]);
			  curr=curr.next;
		  }
		  tail=curr;
		  tail.next=head;
		  size=arr.length;
	  }
  }

  public static void main(String args[]) {
      Kattio io = new Kattio(System.in,System.out);
	  int n = io.getInt();
      int k = io.getInt();
      int m = io.getInt();

  }
}
