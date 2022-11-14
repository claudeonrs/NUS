/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.util.*;
import java.io.*;

class Person {
  String status;
  Queue<Person> entries;
  boolean isVisited;

  Person(String status) {
      this.status = status;
      this.isVisited = false;
      this.entries = new LinkedList<>();
  }
}


public class Students {

  /*
  Preconditions:
  - students: a queue of Person who are all students
  Postconditions:
  - will return a string specifying the results of the contest
  - each person's .entries attributes will be empty after the BFS operation
  - 

  Objective of this method is to do BFS on the queue of students to find
  a path from student to non-student
  */
  public static String doBFS(Queue<Person> students, boolean isUncertain) {
    // Queue to do BFS
    Queue<Person> queueBFS = new LinkedList<>();

    // do BFS starting from head of queue
    while (!students.isEmpty()) {
        queueBFS.clear();
        Person student = students.poll();
        if (student.isVisited) { // if visited already, move on to the next student in the queue
            continue;
        }
        queueBFS.offer(student);

        // do BFS until it traverses every person in 
        //   the connected component they're in
        while (!queueBFS.isEmpty()) {
            Person person = queueBFS.poll();
            if (person.isVisited) { // if visited already, move on to the next entry
                continue;
            }
            person.isVisited = true;
            if (person.status.equals("n")) { // if non-student is found, stop BFS and return VICTORY
                return "VICTORY";
            }
            // move entries of the particular person to queueBFS
            while (!person.entries.isEmpty()) {
                queueBFS.offer(person.entries.poll());
            }
        } 
    }


    if (isUncertain) {
        return "OUTCOME UNCLEAR";
    }
    return "EVERYONE LOSES";
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    String[] words = br.readLine().split(" ");
    int numPersons = Integer.parseInt(words[0]);
    int numEntries = Integer.parseInt(words[1]);

    // mappings for name -> Person object
    HashMap<String, Person> map = new HashMap<>();
    // queue of all students
    Queue<Person> students = new LinkedList<>();
    // is the outcome uncertain?
    boolean isUncertain = false;


    // read input for person status and stores input inside hashmap
    for (int p=0; p<numPersons; p++) {
      words = br.readLine().split(" ");
      String name = words[0];
      String status = words[1];
      Person person = new Person(status);
      map.put(name, person); // put in hashmap
      if (status.equals("s")) {
        students.offer(person); /// put in students queue if person is student
      }
    }

    // initialize connections
    for (int i=0; i<numEntries; i++) {
      words = br.readLine().split(" -> ");
      // src is the person who makes the entry
      // dst is the person in the entry
      Person src = map.get(words[0]);
      Person dst = map.get(words[1]);

      src.entries.offer(dst);
      if (!isUncertain) { // some conditions for an uncertain outcome
                          // assuming it doesn't end in victory
        boolean condition1 = src.status.equals("?") && dst.status.equals("?");
        boolean condition2 = src.status.equals("?") && dst.status.equals("n");
        boolean condition3 = src.status.equals("s") && dst.status.equals("?");
        if (condition1 || condition2 || condition3) {
            isUncertain = true;
        }
      }
    }

    // output
    String output = doBFS(students, isUncertain);
    pw.println(output);
    pw.close();
    br.close();
  }
}
