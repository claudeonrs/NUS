/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class Friends {

    class Cafe {
        String name;
        int numVisitors;
        Visitor[] visitors;
        int maxFriends=0;

        Cafe(String name, int numVisitors) {
            this.name = name;
            this.numVisitors = numVisitors;
            this.visitors = new Visitor[numVisitors];
            //for (int i=0; i<numVisitors; i++) {
            //    visitors[i] = new Visitor(0,0);
            //}
        }

        // sort visitors based on leave (earliest to latest)
        public void sortVisitors() {
            VisitorComparator comp = new VisitorComparator();
            Arrays.sort(visitors, comp);
        }

        // precondition: visitors array is sorted according to comp
        public void findMaxFriends(long visitTime) {

            long tomEnter;
            long tomLeave;
            long maxTime = 864 * (long) Math.pow(10,10);

            int friendsMade = 0;
            int lastVisitor = 0;
            
            for (int i=0; i<visitors.length; i++) {
                if (i>=1) {
                    friendsMade--;
                }

                tomEnter = visitors[i].leave;

                // set max leave to maxTime
                tomLeave = (tomEnter+visitTime <= maxTime) ? (tomEnter+visitTime): maxTime;

                int isFriend;
                for (int j=lastVisitor; j<visitors.length; j++) {
                    isFriend = visitors[j].befriend(tomEnter, tomLeave);
                    if (isFriend==0) {
                        break;
                    }
                    friendsMade++;
                    lastVisitor++;
                }
                this.maxFriends = (friendsMade > maxFriends) ? friendsMade : maxFriends;
                if (tomLeave == maxTime) {
                    break;
                }

            }


        }


    }

    class Visitor {
        long enter, leave;

        Visitor(long enter, long leave) {
            this.enter = enter;
            this.leave = leave;
        }

        // return 1 or 0
        public int befriend(long tomEnter, long tomLeave) {
            // if Tom enters after Visitor leaves
            // or if Tom leaves before Visitor enters
            // return 0
            if (tomEnter > this.leave || tomLeave < this.enter) {
                return 0;
            }
            return 1;
        }
    }

    class VisitorComparator implements Comparator<Visitor> {

        // try to sort ascending (from lowest leave to highest leave)
        public int compare(Visitor v1, Visitor v2) {
            if (v1.leave < v2.leave) {
                return -1;
            } else if (v1.leave > v2.leave) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    class CafeNameComparator implements Comparator<Cafe> {
        public int compare(Cafe c1, Cafe c2) {
            return c1.name.compareTo(c2.name);
        }
    }
    class CafeFriendsComparator implements Comparator<Cafe> {
        public int compare(Cafe c1, Cafe c2) {
            if (c1.maxFriends > c2.maxFriends) {
                return -1;
            } else if (c1.maxFriends < c2.maxFriends) {
                return 1;
            } else {
                return 0;
            }
        }
    }




    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String[] arr = br.readLine().split(" ");
        int numCafes = Integer.parseInt(arr[0]);
        long visitTime = Long.parseLong(arr[1]);

        // stores max number of friends for each cafe
        //int[] maxFriends = new int[numCafes];


        
        Cafe[] cafes = new Cafe[numCafes];
        Friends gv = new Friends();

        String[] command;
        for (int i=0; i<numCafes; i++) {
            command = br.readLine().split(" ");
            String name = command[0];
            int numVisitors = Integer.parseInt(command[1]);
            Cafe currCafe = gv.new Cafe(name, numVisitors);
            cafes[i] = currCafe;
            for (int v=0; v<numVisitors; v++) {
                command = br.readLine().split(" ");
                long enter = Long.parseLong(command[0]);
                long leave = Long.parseLong(command[1]);

                //pw.println(Arrays.toString(currCafe.visitors));
                //pw.flush();
                currCafe.visitors[v] = gv.new Visitor(enter, leave);
                //currCafe.visitors[v].enter = enter;
                //currCafe.visitors[v].leave = leave;
            }
            currCafe.sortVisitors();

            // calculate max friend at the specified cafe
            currCafe.findMaxFriends(visitTime);
        }

        CafeNameComparator nameComp = gv.new CafeNameComparator();
        CafeFriendsComparator friendsComp = gv.new CafeFriendsComparator();

        Arrays.sort(cafes, nameComp);
        Arrays.sort(cafes, friendsComp);
        int maxFriends = cafes[0].maxFriends;
        pw.println(maxFriends);
        for (int i=0; i<cafes.length; i++) {
            if (cafes[i].maxFriends < maxFriends) {
                break;
            }
            pw.println(cafes[i].name);
        }
        // DEBUGGING
        //pw.println(Arrays.toString(maxFriends));
        pw.flush();




    }
}
