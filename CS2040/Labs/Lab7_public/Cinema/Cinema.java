/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.util.*;
import java.io.*;


public class Cinema {

  //static Cinema c = new Cinema();

  class Movie implements Comparable<Movie> {
      long price;
      int enjoyment;
      int id;

      Movie(long price, int enjoyment) {
          this.price = price;
          this.enjoyment = enjoyment;
      }

      // compare with other Movie m
      // descending order, from lowest price to 
      public int compareTo(Movie m) {
          if (price > m.price) {
              return 1;
          } else if (price < m.price) {
              return -1;
          }
          if (enjoyment > m.enjoyment) {
              return 1;
          } else if (enjoyment < m.enjoyment) {
              return -1;
          }
          return 0;
      }
  }

  public static long[] query(TreeMap movieTree, long totalSalary) {
      long totalEnjoyment = 0;
      //Cinema c = new Cinema();
      /*
      Movie movie = c.new Movie(totalSalary, Integer.MAX_VALUE);
      Movie floorMovie = movieTree.floorKey(movie);

      while (floorMovie != null) {
          totalSalary -= floorMovie.price;
          totalEnjoyment += floorMovie.enjoyment;
      }
      */
      long[] ret = new long[2];
      ret[0] = totalSalary;
      ret[1] = totalEnjoyment;
      return ret;
  }

  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Cinema c = new Cinema();

    int numCommands = Integer.parseInt(br.readLine());
    TreeMap<Movie, Integer> tree = new TreeMap<>();

    long totalSalary = 0;
    long totalEnjoyment = 0;


    String[] words;
    for (int i=0; i<numCommands; i++) {
        words = br.readLine().split(" ");
        if (words[0].equals("ADD")) { 
            int price = Integer.parseInt(words[1]);
            int enjoyment = Integer.parseInt(words[2]);
            Movie movie = c.new Movie(price, enjoyment);
            Integer movieQuantity = tree.get(movie);
            if (movieQuantity == null) {
                tree.put(movie, 1);
            } else {
                tree.put(movie, movieQuantity+1);
            }
        } else if (words[0].equals("SALARY")) {
            int salary = Integer.parseInt(words[1]);
            totalSalary += salary;
        } else if (words[0].equals("QUERY")) {
            totalEnjoyment = 0;
            Movie floorMovie = tree.floorKey(c.new Movie(totalSalary, Integer.MAX_VALUE));

            while (floorMovie != null) {
                totalEnjoyment += floorMovie.enjoyment;
                totalSalary -= floorMovie.price;
                int num = tree.get(floorMovie)-1;
                tree.put(floorMovie, num);
                if (num == 0) {
                    tree.remove(floorMovie);
                }
                floorMovie = tree.floorKey(c.new Movie(totalSalary, Integer.MAX_VALUE));
            }
            pw.println(totalEnjoyment);
        }
    }
    pw.flush();
  }
}





