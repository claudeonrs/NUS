/**
 * Name : Claudeon Reinard Susanto
 * Matric. No : A0239079R
 */

import java.util.*;
import java.io.*;

// precondition: format of commands is exactly the same
//               as stated in the question paper

public class AmusementPark {

  // class to represent rides in one day
  public class Day {
	  int dayNumber;
	  int invalidCommands;
	  LinkedList rides;
	  Day next; // attribute to access next day

	  public Day(int dayNumber) {
	  	  this.dayNumber = dayNumber;
		  rides = new LinkedList<Integer>();
		  invalidCommands=0;
	  }

	  public void addRide(int rideID) {
		  rides.add(rideID);
	  }
	  public boolean deleteRides(String pos, int idx) {
		  // pos = "BACK" or "FRONT"
		  if (idx > rides.size()) {
			  invalidCommands++;
			  return false;
		  }

		  // to handle subcommand
		  if (pos.equals("FRONT")) {
			  for (int i=0; i<idx; i++) {
			      rides.removeFirst();
		      }  
		  } else if (pos.equals("BACK")) {
			  for (int i=0; i<idx; i++) {
				  rides.removeLast();
			  }
	      }
		  return true;
	  }
	  public void changeRides(String pos, int idx, int newRideID) {
		  // if deleteRides is valid, else skip
		  if (deleteRides(pos, idx)) {
			  if (pos.equals("BACK")) {
				  rides.addLast(newRideID);
			  } else if (pos.equals("FRONT")) {
				  rides.addFirst(newRideID);
			  }
		  }
	  }
	  public void nextDay() {
		  next = new Day(dayNumber+1);
	  }
  }

  public static void main(String args[]) throws IOException {
	  Kattio io = new Kattio(System.in, System.out);

	  AmusementPark park = new AmusementPark();

	  Day firstDay = park.new Day(1);
	  Day currDay = firstDay;
	  while (true) {
		  String command = io.getWord();
		  if (command.equals("START")) { 
			  io.getWord();
			  currDay.addRide(io.getInt());
		  } else if (command.equals("DELETE")) {
			  String pos = io.getWord();
			  io.getWord();
			  int idx = io.getInt();
			  currDay.deleteRides(pos, idx);
		  } else if (command.equals("CHANGE")) {
              String pos = io.getWord();
			  io.getWord();
			  int idx = io.getInt();
			  int newRideID = io.getInt();
			  currDay.changeRides(pos, idx, newRideID);
		  } else if (command.equals("NEXT")) {
			  String subcommand = io.getWord();
			  if (subcommand.equals("RIDE:")) {
				  currDay.addRide(io.getInt());
			  } else if (subcommand.equals("DAY")) {
				  currDay.nextDay();
				  currDay = currDay.next;
			  }
		  } else if (command.equals("END")) {
			  break;
		  }

	  }
	  int invalidCommands=0;
      for (Day d=firstDay; d!=null; d=d.next) {
	      invalidCommands += d.invalidCommands;
	  }
	  // print output
	  for (int i=0; i<invalidCommands; i++) {
		  io.println("Invalid command");
	  }
	  for (Day d=firstDay; d!=null; d=d.next) {
	      io.println("Day "+d.dayNumber+": "+d.rides);
	  }
	  io.close();
  }
}
