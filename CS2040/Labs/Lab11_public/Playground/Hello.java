import java.io.*;
import java.util.*;

public class Hello {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        b = b+ 11111;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(1);
        pq.offer(1);
        pq.offer(2);
        while(!pq.isEmpty()) {
            pw.println(pq.poll());
        }

        pw.close();
        br.close();
    }
}
