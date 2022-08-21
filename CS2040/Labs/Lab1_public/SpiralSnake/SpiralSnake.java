/**
 * Name : Claudeon Reinard Susanto
 * Matric. No : A0239079R
 */

import java.util.*;

public class SpiralSnake {
  public static void main(String args[]) {
	  Kattio io = new Kattio(System.in, System.out);
	  // m,n = row,col size
	  int m=io.getInt(); int n=io.getInt();
	  int[][] grid = new int[m][n];
	  for (int i=0; i<m; i++) {
		  String row = io.getWord();
		  for (int j=0; j<n; j++) {
			  if (row.charAt(j) == 'X') {
				  grid[i][j] = 1;
			  }
		  }
	  }
	  //int[][] visitedGrids = new int[m][n];
	  int y=0, x=0, step=0;
	  // specify how X and Y change
	  int[] deltaY={0,1,0,-1}, deltaX={1,0,-1,0};
	  // can take values from 0 to 3
	  int currDirection = 0;
	  while (grid[y][x] != -1) {
		  step++;
		  if (grid[y][x] == 1) {
			  io.printf("Apple at (%d, %d) eaten at step %d\n", x, y, step);
		  }
		  //io.printf("x, y: (%d, %d)\n", x, y);
		  grid[y][x]=-1;
		  // if outside range or next grid is visited, change direction
		  int newY=y+deltaY[currDirection];
		  int newX=x+deltaX[currDirection];
		  //io.printf("newX, newY: (%d, %d)\n", newX, newY);
		  if ((newY<0 || newY>=m) || (newX<0 || newX>=n) || grid[newY][newX] == -1) {
			  currDirection = (currDirection+1)%4;
			  //io.printf("direction change, %d\n", currDirection);
		  }
		  y += deltaY[currDirection];
		  x += deltaX[currDirection];
		  if ((y<0 || y>=m) || (x<0 || x>=n) || grid[y][x] == -1) {
			  break;
		  }
	  }
	  io.close();
  }
}
