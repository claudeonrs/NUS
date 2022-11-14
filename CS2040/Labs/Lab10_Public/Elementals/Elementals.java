/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.io.*;
import java.util.*;

class Octopus {
    int fire;
    int water;
    Octopus(int fire, int water) {
        this.fire = fire;
        this.water= water;
    }
}

class Team {
    int fire;
    int water;
    Team(int fire, int water) {
        this.fire = fire;
        this.water= water;
    }

    public int getSkillSquared() {
        return fire*fire + water*water;
    }
}

public class Elementals {

    public static int minElementals(Octopus[] octopi, int target) {
       // do BFS
       Team start = new Team(0,0);
       Queue<Team> queueBFS = new LinkedList<>();
       queueBFS.offer(start);
       int targetSquared = target*target;
       while(!queueBFS.isEmpty()) {
           Team team = queueBFS.poll();
           for (int i=0; i<octopi.length; i++) {
               Octopus nextOctopus = octopi[i];
               Team newTeam = new Team(team.fire + nextOctopus.fire, team.water + nextOctopus.water);
               int newSkillSquared = newTeam.getSkillSquared();
               if (newSkillSquared == targetSquared) {

               } else if (newSkillSquared > targetSquared) {
                   continue;
               } else { // 

               }
           }
       }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] words;
        int numTestCases = Integer.parseInt(br.readLine());
        for (int t=0; t<numTestCases; t++) {
            words = br.readLine().split(" ");
            // Popo and Pipi's friends
            int typesUnlocked = Integer.parseInt(words[0]);
            Octopus[] octopi = new Octopus[typesUnlocked];
            int target = Integer.parseInt(words[1]);
            for (int i=0; i<typesUnlocked; i++) {
                words = br.readLine().split(" ");
                int fire = Integer.parseInt(words[0]);
                int water = Integer.parseInt(words[1]);
                Octopus octopus = new Octopus(fire, water);
                octopi[i] = octopus;
            }
            // output
            int minOctopi = minElementals(octopi, target);
            pw.println(minOctopi);
            // end of testcase
        }

        pw.close();
        br.close();
    }
}
