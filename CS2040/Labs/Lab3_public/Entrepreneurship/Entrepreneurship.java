/*
 * Name:Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.util.*;
import java.io.*;

public class Entrepreneurship {

    class Batch {
        long pizzaUsed=0;
        double revenue=0;
        long numOfOrders;
        // store orders (always read from left to right)
        long[] avgAmount;
        double[] avgPrices;

        Batch(long[] amountArr, double[] pricesArr) {
            avgAmount = amountArr;
            avgPrices = pricesArr;
            numOfOrders=amountArr.length;
        }

        public long prepare(long maxPizza) {
            long q;
            double p;
            for (int i=0; i<numOfOrders; i++) {
                q = avgAmount[i];
                p = avgPrices[i];
                if (q > maxPizza) {
                    continue;
                } else {
                    this.pizzaUsed += q;
                    this.revenue += p*q;
                    maxPizza -= q;
                }
            }
            return maxPizza;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] init = br.readLine().split(" ");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        // number of commands
        long n = Long.parseLong(init[0]);

        // pizza available
        long maxPizza = Long.parseLong(init[1]);
        
        // storing batches
        Stack<Batch> batches = new Stack<>();

        // total revenue
        double totalRevenue=0;


        Entrepreneurship shop = new Entrepreneurship();
        String[] command;
        for (int i=0; i<n; i++) {
            command = br.readLine().split(" ");
            if (command[0].equals("ADD")) {
                int numOfOrders = Integer.parseInt(command[1]);
                String[] orders = br.readLine().split(" ");

                // initialize arrays for constructor
                long[] amountArr = new long[numOfOrders];
                double[] pricesArr = new double[numOfOrders];
                if (command[2].equals("L")) {
                    for (int j=0; j<numOfOrders*2; j++) {
                        if (j%2==0) {
                            amountArr[(int)j/2] = Long.parseLong(orders[j]);
                        } else {
                            pricesArr[(int)j/2] = Double.parseDouble(orders[j]);
                        }
                    }
                } else if (command[2].equals("R")) {
                    for (int j=numOfOrders*2-1; j>=0; j--) {
                        if (j%2 == 0) {
                            amountArr[(int) numOfOrders-1-(j/2)] = Long.parseLong(orders[j]);
                        } else {
                            pricesArr[(int) numOfOrders-1-(j/2)] = Double.parseDouble(orders[j]);
                        }
                    }
                }
                Batch batch = shop.new Batch(amountArr, pricesArr);
                batches.push(batch);
                batch.prepare(maxPizza);
                maxPizza -= batch.pizzaUsed;
                //maxPizza -= batch.prepare(maxPizza);
                //pw.println(Arrays.toString(batch.avgAmount));
                //pw.println(Arrays.toString(batch.avgPrices));
                //pw.println(batch.revenue);
                //pw.println(batch.pizzaUsed);
                //pw.println("Pizza Left: "+maxPizza);
            } else if (command[0].equals("CANCEL")) {
                int batchesCancelled = Integer.parseInt(command[1]);
                for (int j=0; j<batchesCancelled; j++) {
                    Batch batch = batches.pop();
                    maxPizza += batch.pizzaUsed;
                    //pw.println("Pizza Left: "+maxPizza);
                } 
            }
        }

        while (batches.size() > 0) {
            totalRevenue += batches.pop().revenue;
        }
        pw.println(String.format("%.1f", totalRevenue));
        pw.close();
    }
}
