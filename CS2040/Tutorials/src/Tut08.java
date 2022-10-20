
import java.util.*;
import java.io.*;

public class Tut08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int heapSize = Integer.parseInt(br.readLine());
        String[] deckString = br.readLine().split(" "); 
        int deckSize = deckString.length;
        int[] deck = new int[deckSize];

        for (int i=0; i<deckSize; i++) {
            deck[i] = Integer.parseInt(deckString[i]);
        } 

        // max heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i<heapSize && i<deckSize; i++) {
            heap.offer(deck[i]);
        }
        int maxSum = 0;
        int curSum = 0;
        for (int i=0; i<deckSize; i++) {
            int maxInt = heap.poll();
            curSum += maxInt;
            if (maxSum < curSum) {
                maxSum = curSum;
            }
            if (i+heapSize < deckSize) {
                heap.offer(deck[i+heapSize]);
            }
        }

        // 肏你
        pw.println(maxSum);
        

        br.close();
        pw.close();
    }
}