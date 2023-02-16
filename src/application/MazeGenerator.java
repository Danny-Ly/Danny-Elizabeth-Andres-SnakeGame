package application;
import java.util.Random;

/**
 * This class is used in generating, customizing and creating a visual-like maze appearance 
 * that user can visually see change according to user input.
 * @author Written by Andres, assisted and co-written by Elizabeth and Danny.
 *
 */
public class MazeGenerator {
	// Initializing/declaring variables that will be used in the creation, 
	// And customization of the maze
	public static final int WALL = 2;
	public static int EMPTY = 3;
	public static int SNAKE = 1; 
	public static int PELLET = 0;
	int[][] maze;
	
	int difficulty = 0;
	int numberOfobstactle = 0;
	int numberOfPellets = 0;
	Random randomvalue = new Random();
	
		/**
		 * Creating a new 10 by 20 array that will behave as our maze.
		 */
		public MazeGenerator(int difficuty_paramter){
			
			difficulty = difficuty_paramter;
			// all difficulties generate specific size array
			if (difficulty >= 0) {
				maze = new int[10][20];
			}
			obstacles();
			
		}
		
		public boolean wallHere(int[] location){
			if (maze[location[0]][location[1]] == WALL) {
				return true;
			}
			else {
				return false;
			}	
			
		}
		
		/**
		 * Altering the created 10 by 20 array into respective values to act like a maze.
		 */
		public void obstacles() {
			/*
			 * Changing all initial values of the maze into empty spots.
			 */
			for(int i=0; i<maze.length; i++) {
				for(int j=0; j <maze[i].length; j++) {
					maze[i][j]= EMPTY;
				}
			}
			// changes top row,and bottom row of maze into walls
			for (int y_axis =0; y_axis < 20; y_axis++) {
				maze[0][y_axis]= WALL;
				maze[9][y_axis] = WALL;
			}
			// changes first column, and last column of maze into walls
			for (int x_axis = 0; x_axis < 10; x_axis++) {
				maze[x_axis][0] = WALL;
				maze[x_axis][19] = WALL;
			}
			/*
			 * Randomly creating 20 or less obstacle within maze 
			 */
			while (numberOfobstactle <20) {
				int x = randomvalue.nextInt(10) ;
				int y = randomvalue.nextInt(16)+2 ;
				if (x==2 || x==5 || x==7) {
					maze[x][y]= WALL;
					numberOfobstactle++;
				}
			}
			// constant structure of every maze.
			maze [4][9] = SNAKE;
			maze [5][9] = WALL;
			maze [5][8] = WALL;
			maze [5][10] = WALL;
			maze [4][8] = WALL;
			maze [4][10] = WALL;
			
			
			/*
			for(int i=0; i<maze.length; i++) {
				for(int j=0; j <maze[i].length; j++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
				
			}
			*/

		}
		
		/*
		 * Changing the numeric values altered into a visual representation of each value 
		 */
		public void boundary(Rewards rewards){
			// looping through entire array changing each element into 1 of the four possible options.
			for(int i=0; i<maze.length; i++) {
				for(int j=0; j <maze[i].length; j++) {
					int[] locationarray = new int[2];
					locationarray[0]=i;
					locationarray[1]= j;
					if (maze [i][j] == WALL) {	
						System.out.print("#");
					}
					else if (rewards.pelletHere(locationarray)){
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
		

	}