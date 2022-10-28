/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.io.*;
import java.util.*;

public class Deliveries {

  class Order {
      long deadline;
      long earnings;

      Order(long deadline, long earnings) {
          this.deadline = deadline;
          this.earnings = earnings;
      }
  }

  // arrange Order in ascending order mainly using deadline
  // if obj1.deadline < obj2.deadline => obj1 < obj2
  // else 
  //    if obj1.earnings > obj2.earnings => obj1 < obj2
  class OrderDeadlineComparator implements Comparator<Order> {
      public int compare(Order o1, Order o2) {
          if (o1.deadline < o2.deadline) {
              return -1;
          } else if (o1.deadline > o2.deadline) {
              return 1;
          }
          if (o1.earnings < o2.earnings) {
              return 1;
          } else if (o1.earnings > o2.earnings) {
              return -1;
          }

          return 0;
      }
  }
  
  // orderList is an
  public static long commitFraud(PriorityQueue<Order> orderList) {

      long extraIncome = 0;
      long currTime = 0;

      PriorityQueue<Long> fulfilledEarnings = new PriorityQueue<>();

      while (orderList.size() > 0) {
          Order order = orderList.poll();
          // if previous order fulfilled has the same deadline
          if (order.deadline == currTime) {
              // delete a fulfilled order if it has less earnings
              // then replace w this order
              long minFulfilledEarnings = fulfilledEarnings.peek();
              if (minFulfilledEarnings < order.earnings) {
                  fulfilledEarnings.poll();
                  fulfilledEarnings.offer(order.earnings);
                  extraIncome -= minFulfilledEarnings;
                  extraIncome += order.earnings;
              }
          }
          // if 
          if (order.deadline >= currTime+1) {
              currTime++;
              extraIncome += order.earnings;
              fulfilledEarnings.offer(order.earnings);
          }
      }
      return extraIncome;
  }

  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
      Deliveries deliveries = new Deliveries();
      OrderDeadlineComparator comp = deliveries.new OrderDeadlineComparator();

      long numOrders = Long.parseLong(br.readLine());

      // min heap according to OrderComparator
      PriorityQueue<Order> heap = new PriorityQueue<>(comp);

      String[] words;

      // insert orders into min heap
      for (long i=0; i<numOrders; i++) {
          words = br.readLine().split(" ");
          long deadline = Long.parseLong(words[0]);
          long earnings = Long.parseLong(words[1]);
          Order order = deliveries.new Order(deadline, earnings);
          heap.offer(order);
      }

      long extraIncome = commitFraud(heap);

      pw.println(extraIncome);
      pw.close();
      br.close();
  }
}
