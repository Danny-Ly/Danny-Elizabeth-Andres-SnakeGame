package application;

public class mazeGenarator extends Main{
	
private static final int WALL = 2;
private static int EMPTY = 3;
private static int SNAKE = 1; 
private static int PELLET = 0;
int[][] maze;
int difficulty = 0;
	
	
	/*
	 * Creating maze according to difficulty.
	 */
	public void creation() {
		// easy difficulty generated specific size array
		if (difficulty == 0) {
			maze = new int[10][10];
		}
		// medium difficulty generated specific size array
		else if (difficulty == 1) {
			//maze = new int[][];
		}
		// hard difficulty generated specific size array
		else if (difficulty == 2) {
			//maze = new int[][];
		}
		obstacles();
	}
	
	public void obstacles() {
		// changes top row,and bottom row of desired array into walls
		for (int y_axis =0; y_axis < maze.length; y_axis++) {
			maze[0][y_axis]= WALL;
			maze[maze.length-1][y_axis] = WALL;
		}
		// changes first column, and last column of desired array into walls
		for (int x_axis = 0; x_axis < maze.length-1; x_axis++) {
			maze[x_axis][0] = WALL;
			maze[x_axis][maze.length-1] = WALL;
		}
		
		/*
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j <maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
			
		}
		*/
		boundary();
	}
	
	public void boundary(){
		 
		for(int i=0; i<maze.length; i++) {
			for(int j=0; j <maze[i].length; j++) {
				if (maze [i][j] == WALL) {	
					System.out.print("#");
				}
				else if (maze[i][j]== PELLET) {
					System.out.print(".");
				}
				else if (maze[i][j]== SNAKE) {
					System.out.print("O");
				}
				else if (maze[i][j]== EMPTY) {
					System.out.print(" ");
				}
			}	
			System.out.println();
		}
	}
	
	
	
public static void main(String[] args) {
		
		mazeGenarator maze = new mazeGenarator();
		maze.creation();	
		
}
}

