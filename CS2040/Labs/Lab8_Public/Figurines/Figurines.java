/**
 * Name:
 * Matric. No:
 */

import java.util.*;
import java.io.*;

public class Figurines {

  public static int inspect(PriorityQueue<Integer> leftQueue, PriorityQueue<Integer> rightQueue) {
      // remove one
      int leftSize = leftQueue.size();
      int rightSize = rightQueue.size();
      /*
      if (leftSize > rightSize) {
          return leftQueue.poll();
      } else {
          return rightQueue.poll();
      }
      */
      rightSize--;
      if (rightSize < leftSize) {
          rightQueue.offer(leftQueue.poll());
      }
      return rightQueue.poll();
  }
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

      // max is head
      PriorityQueue<Integer> leftQueue = new PriorityQueue<>(Collections.reverseOrder());
      // min is head
      PriorityQueue<Integer> rightQueue = new PriorityQueue<>();

      String word="hi";
      int leftSize = leftQueue.size();
      int rightSize = rightQueue.size();
      int item;
      
      while (word != null) {
          word = br.readLine();
          if (word == null) {
              break;
          }
          //pw.println(Arrays.toString(leftQueue.toArray())+Arrays.toString(rightQueue.toArray()));
          //`pw.println(Arrays.toString(leftQueue.toArray()));
          switch (word) {
              case "INSPECT":
                  // figurine sent for inspection
                  item = rightQueue.poll();
                  pw.println(item);
                  rightSize--;
                  if (rightSize < leftSize) {
                      rightQueue.offer(leftQueue.poll());
                      rightSize++;
                      leftSize--;
                  }
                  break;
              case "":
                  break;
              default:
                  item = Integer.parseInt(word);
                  if (rightSize == 0) {
                      rightQueue.offer(item);
                      rightSize++;
                      continue;
                  } else if (leftSize == 0) {
                      leftQueue.offer(item);
                      leftSize++;
                      continue;
                  }
                  int leftHead = leftQueue.peek();
                  int rightHead = rightQueue.peek();

                  // maintain leftSize <= rightSize <= leftSize+1
                  if (item > leftHead) {
                      rightQueue.offer(item);
                      rightSize++;
                  } else {
                      leftQueue.offer(item);
                      leftSize++;
                  }

                  if (rightSize > leftSize + 1) {
                      leftQueue.offer(rightQueue.poll());
                      rightSize--;
                      leftSize++;
                  }
                  if (leftSize > rightSize) {
                      rightQueue.offer(leftQueue.poll());
                      rightSize++;
                      leftSize--;
                  }


                  
          }
      }
      pw.close();
      br.close();
  }
}
