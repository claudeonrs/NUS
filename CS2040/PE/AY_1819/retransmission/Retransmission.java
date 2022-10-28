/**
 * Name         : Claudeon Reinard Susanto
 * Matric. No   : A0239079R
*/

import java.util.*;
import java.io.*;

public class Retransmission {

    public static void main(String args[]) throws IOException {
        // main idea: store asleep cats in AVL Tree??????
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] words = br.readLine().split(" ");
        // i wanna die
        int numCats = Integer.parseInt(words[0]);
        int numQueries = Integer.parseInt(words[1]);

        TreeMap<Integer, Boolean> map = new TreeMap<>();

        for (int i=0; i<numCats; i++) {
            map.put(i,true);
        }

        for (int i=0; i<numQueries; i++) {
            words = br.readLine().split(" ");
            if (words[0].equals("WAKE")) {
                // it is guaranteed the cat is currently asleep
                int idx = Integer.parseInt(words[1]);
                map.remove(idx);
            } else if (words[0].equals("SLEEP")) {
                // it is guaranteed the cat is currently awake
                int idx = Integer.parseInt(words[1]);
                map.put(idx,true);
            } else if (words[0].equals("TRANSMIT")) {
                int start = Integer.parseInt(words[1]);
                int end = Integer.parseInt(words[2]);
                Integer firstSleep = map.ceilingKey(start);
                if (firstSleep == null) {
                    pw.println("YES");
                } else if (firstSleep > end) {
                    pw.println("YES");
                } else {
                    pw.println("NO");
                }
            }
        }

        pw.close();
        br.close();
    }
}
