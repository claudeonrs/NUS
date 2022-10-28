/**
 * Name         : Claudeon
 * Matric. No   : A0239079R
*/

import java.util.*;
import java.io.*;

public class Bracketflips {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int numQueries = Integer.parseInt(br.readLine());
        LinkedList<String> list = new LinkedList<>();
        boolean isReversed = false;
        String[] words;

        HashMap<String, String> reverseMap = new HashMap<>();
        reverseMap.put("{", "}");
        reverseMap.put("}", "{");
        reverseMap.put("(", ")");
        reverseMap.put(")", "(");
        reverseMap.put("[", "]");
        reverseMap.put("]", "[");


        for (int i=0; i<numQueries; i++) {
            words = br.readLine().split(" ");
            if (words[0].equals("FRONT")) {
                if (isReversed) {
                    list.addLast(reverseMap.get(words[1]));
                } else {
                    list.addFirst(words[1]);
                }
            } else if (words[0].equals("BACK")) {
                if (isReversed) {
                    list.addFirst(reverseMap.get(words[1]));
                } else {
                    list.addLast(words[1]);
                }
            } else if (words[0].equals("ROTATE")) {
                isReversed = !isReversed;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (isReversed) {
            sb.append(reverseMap.get(list.pollLast()));
        } else {
            while (list.size() > 0) {
                sb.append(list.pollFirst());
            }
        }

        String out = sb.toString();
        pw.println(out);

        pw.close();
        br.close();

    }
}
