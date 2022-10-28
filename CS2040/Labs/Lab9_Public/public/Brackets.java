/**
 * Name: Claudeon Reinard Susanto
 * Matric. No: A0239079R
 */

import java.util.*;
import java.io.*;
import java.lang.*;

public class Brackets {

  // precondition  : a String array with
  // post condition: long
  public static long compute(String[] tokens) {
      Stack<String> stack = new Stack<>();
      int numTokens = tokens.length;
      long result;

      // current index in tokens
      int idx = 0;
      // is current operation addition?
      // if false, then it's multiplication
      // start from addition, then mult, and so on
      boolean isAdd = true;
      // divisor for modulo
      long div = (long) Math.pow(10,9)+7;

      while (idx < numTokens) {
          String token = tokens[idx];
          //long result;
          if (token.equals(")")) {// if closing bracket, remove everything until "("
              result = Integer.parseInt(stack.pop());
              token = stack.pop();
              while (!token.equals("(")) { // do loop until we see "("
                  if (isAdd) {
                      result += Integer.parseInt(token);
                  } else {
                      result *= Integer.parseInt(token);
                  }
                  result = result%div;
                  token = stack.pop();
              }
              // put the result back to stack
              stack.push(Long.toString(result));
              isAdd = !isAdd; // change operator
          } else {
              stack.push(token);
              if (token.equals("(")) {
                  isAdd = !isAdd; // change operator
              }
          }
          idx++;
      }
      // sum up everythng
      result = 0;
      while (stack.size() > 0) {
          result += Integer.parseInt(stack.pop());
          result = result % div;
      }
      return result;

  }
  public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

      int numTokens = Integer.parseInt(br.readLine());
      String[] tokens = br.readLine().split(" ");

      long result = compute(tokens);
      pw.println(result);
      pw.close();
      br.close();
  }
}
