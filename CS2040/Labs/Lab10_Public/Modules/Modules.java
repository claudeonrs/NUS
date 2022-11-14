/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.util.*;
import java.io.*;

class Module {
    String name;
    Queue<Module> prereq = new LinkedList<>();

    Module(String name) {
        this.name = name;
    }
}

public class Modules {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] words;
        int numCases = Integer.parseInt(br.readLine());
        for (int c=0; c<numCases; c++) {
            // map name to Module object
            HashMap<String, Module> map = new HashMap<>();
            int numMods = Integer.parseInt(br.readLine());
            for (int i=0; i<numMods; i++) {
                ///fuck
                words = br.readLine().split(" ");
                Module currMod = new Module(words[0]);
                map.put(words[0], currMod);
                for (int j=1; j<words.length; j++) {

                }
            }
        }
    }
}
