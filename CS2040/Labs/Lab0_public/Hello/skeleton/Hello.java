/**
 * Name :
 * Matric. No :
 */

public class Hello {
  public static void main(String args[]) {
    // Here's some I/O boilerplate to get you started.
    Kattio io = new Kattio(System.in);
    io.print("first output\n");
    io.flush(); /* writes to screen immediately but slows program down */
    io.print("second output\n");
    io.close();
  }
}
