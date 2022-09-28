import java.util.*;
import java.io.*;

public class Tut03 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = br.readLine();
            String[] arr = line.split(" ");
            br.close();

            // first stack for main line
            Stack<String> stack = new Stack<>();

            for (int i=arr.length-1; i>=0; i--) {
                stack.push(arr[i]);
                switch (stack.peek()) {
                    case "+":
                        stack.pop();
                        float sum = 0;
                        // while not the end of expression
                        while (!stack.peek().equals(")")) {
                            sum += Float.parseFloat(stack.pop());
                        }
                        if (stack.peek().equals(")")) {
                            stack.pop();
                        }
                        stack.push(Float.toString(sum));
                        break;
                    case "*":
                        stack.pop();
                        float prod = 1;
                        // while not the end of expression
                        while (!stack.peek().equals(")")) {
                            prod *= Float.parseFloat(stack.pop());
                        }
                        if (stack.peek().equals(")")) {
                            stack.pop();
                        }
                        stack.push(Float.toString(prod));
                        break;
                    case "-":
                        stack.pop();
                        float sub = 0;
                        int numSub = 0;
                        // while not the end of expression
                        sub += Float.parseFloat(stack.pop());
                        while (!stack.peek().equals(")")) {
                            sub -= Float.parseFloat(stack.pop());
                            numSub += 1;
                        }
                        if (numSub == 0) {
                            sub = -sub;
                        }
                        if (stack.peek().equals(")")) {
                            stack.pop();
                        }
                        stack.push(Float.toString(sub));
                        break;
                    case "/":
                        stack.pop();
                        float div = 0;
                        int numDiv = 0;
                        div *= Float.parseFloat(stack.pop());
                        // while not the end of expression
                        while (!stack.peek().equals(")")) {
                            div /= Float.parseFloat(stack.pop());
                            numDiv += 1;
                        }
                        if (numDiv == 0) {
                            div = 1/div;
                        }
                        if (stack.peek().equals(")")) {
                            stack.pop();
                        }
                        stack.push(Float.toString(div));
                        break;
                    case ")":
                        
                        break;
                    case "(":
                        stack.pop();
                        break;
                }
            }
            PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
            pw.print(stack.peek());
            pw.flush();
        } catch(IOException e) {

        }
        

    }
}
