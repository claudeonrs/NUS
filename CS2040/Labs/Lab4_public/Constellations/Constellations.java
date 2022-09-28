/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.io.*;
import java.util.*;
import java.lang.*;

public class Constellations {

    // choose k out of n objects
    public static long choose(int n, int k) {
        if (k==0) {
            return 1;
        }
        if (k == 1) {
            return n;
        }
        if (n < k) {
            return 0;
        }
        int div =(int) Math.pow(10,9)+7;
        return (choose(n-1,k) + choose(n-1,k-1))%div;

    }

    // precondition: maxSize >= minSize
    //               numStars >= 0
    //               numStars >= minSize
    // calculates number of configurations given number of stars
    // @param minSize: minimum constellation size
    // @param maxSize: max ---------||-----------
    public static long config(int numStars, int minSize, int maxSize) {
        // if min constellation size > number of stars, return 0
        if (numStars < minSize) {
            return 0;
        }

        long totalConfig=0;

        // divisor
        int div = (int) Math.pow(10,9)+7;

        // chooseTable:
        // to store choose(0,0) to choose(numStars,maxSize) 
        // in a square matrix such that retrieval only takes O(1) time
        long[][] chooseTable = new long[numStars+1][maxSize+1];
        for (int i=0; i<=numStars; i++) {
            // choose(i,0) = 1
            chooseTable[i][0] = 1;
            // choose(i,1) = i
            chooseTable[i][1] = i;
        }
        for (int i=0; i<=numStars; i++) {
            for (int j=2; j<=maxSize; j++) {
                if (i < j) {
                    chooseTable[i][j]=0;
                } else {
                    // choose(i,j) = choose(i-1,j-1) + choose(i-1,j)
                    chooseTable[i][j] = chooseTable[i-1][j-1] + chooseTable[i-1][j];
                }
            }
        }


        // array to store config(0,minSize,maxSize) 
        //             to config(numStars,minSize,maxSize)
        long[] configTable = new long[numStars+1];

        // filling up configTable from 0 to numStars
        for (int i=0; i<=numStars; i++) {
            if (i < minSize) { // assuming numStars >= minSize
                configTable[i] = 1;
            } else {
                // temporary variable to store calc results
                //       for config(i, minSize, maxSize)
                int temp=0;
                for (int j=minSize; j<=maxSize; j++) {
                    if (i < j) { // if number of stars < min constellation size
                        break;   // break cuz 
                    }
                    temp += ((chooseTable[i][j]%div)*(configTable[i-j]%div))%div;
                    temp %= div;
                }
                // config(i, minSize, maxSize) = temp
                configTable[i] = temp;
            }
        }

        // return number of config (modulo div)
        return configTable[numStars];
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int a = Integer.parseInt(arr[1]);
        int b = Integer.parseInt(arr[2]);

        pw.println(config(n,a,b));
        pw.close();
    }
}
