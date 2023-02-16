package application;
import java.util.Random;

/**
 * This class is used in generating, customizing and creating a visual-like maze appearance 
 * that user can visually see change according to user input.
 * @author Written by Andres, assisted and co-written by Elizabeth and Danny.
 *
 */
public class MazeGenerator {
	// Initializing/declaring constant variables that will be used in the creation, 
	// And customization of the maze
	public static final int WALL = 2;
	public static int EMPTY = 3;
	public static int SNAKE = 1; 
	public static int PELLET = 0;
	// Placeholder values are initialized and declared, will be used in code.
	int[][] maze;
	int difficulty = 0;
	int numberOfObstactle = 0;
	int numberOfPellets = 0;
	Random randomValue = new Random();
	
		/**
		 * Creating a new 10 by 20 array that will behave as our maze,
		 * when it is called in the main class while passing a difficulty parameter.
		 * @param difficultyParameter is passed as 0,1,2 
		 * depending on which level user wants to try.
		 */
		public MazeGenerator(int difficultyParameter){
			difficulty = difficultyParameter;
			// all difficulties generate specific size array
			if (difficulty >= 0) {
				maze = new int[10][20];
			}
			// calling a method obstacle to perform its action on newly created maze.
			obstacles();
		}
		
		/**
		 * Checking if the specific location entered is representing a WALL or not.
		 * @param the location in the 10 by 20 array we want to check if it is a WALL value. 
		 * @return will return TRUE if location is a wall, else FALSE.
		 */
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
			for (int yAxis =0; yAxis < 20; yAxis++) {
				maze[0][yAxis]= WALL;
				maze[9][yAxis] = WALL;
			}
			// changes first column, and last column of maze into walls
			for (int xAxis = 0; xAxis < 10; xAxis++) {
				maze[xAxis][0] = WALL;
				maze[xAxis][19] = WALL;
			}
			/*
			 * Randomly creating 20 or less obstacle within maze 
			 */
			while (numberOfObstactle <20) {
				// randomly generating a number between 0-10 and 2-18,
				// storing in their respective values.
				int x = randomValue.nextInt(10) ;
				int y = randomValue.nextInt(16)+2 ;
				if (x==2 || x==5 || x==7) {
					maze[x][y]= WALL;
					numberOfObstactle++;
				}
			}
			// constant structure of every maze.
			maze [4][9] = SNAKE;
			maze [5][9] = WALL;
			maze [5][8] = WALL;
			maze [5][10] = WALL;
			maze [4][8] = WALL;
			maze [4][10] = WALL;
			
			// block below that is commented out used in decoding problems that we ran into.
			/*
			for(int i=0; i<maze.length; i++) {
				for(int j=0; j <maze[i].length; j++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
				
			}
			*/

		}
		
		/**
		 * Changing the numeric values altered into a visual representation of each value 
		 * @param rewards amount of pellets generated in maze.
		 */
		public void boundary(Rewards rewards){
			// looping through entire array changing each element into 1 of the four possible options.
			for(int i=0; i<maze.length; i++) {
				for(int j=0; j <maze[i].length; j++) {
					int[] locationArray = new int[2];
					locationArray[0]=i;
					locationArray[1]= j;
					if (maze [i][j] == WALL) {	
						System.out.print("#");
					}
					else if (rewards.pelletHere(locationArray)){
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