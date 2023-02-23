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
	private static final char WALL = 30000;
	private static final int EMPTY = 0;
	private static final int SNAKE = 1; 
	private static final char PELLET = 10000;
	MazeItems[][] maze;
	ItemGenerator pellets;
	int difficulty = 0;
	int numberOfobstactle = 0;
	int numberOfPellets = 0;
	Random randomvalue = new Random();
	// int counter = 0;
	
		/**
		 * Constructor for MazeGenerator class, that creates a new 10 by 20 array 
		 * that behaves as our maze
		 * @param difficuty_paramter an integer that represents the difficulty the maze has
		 */
		public MazeGenerator(int difficuty_paramter){
			
			difficulty = difficuty_paramter;
			// all difficulties generate specific size array
			if (difficulty >= 0) {
				maze = new MazeItems[10][20];
			}
			
			obstacles(); // generates the obstacles the maze needs.
			
		}
		/**
		 * Checks whether there is a wall in the specific location in the array.
		 * @param location an array containing the x and y coordinate of the location we 
		 * want to check.
		 * @return true if there is a wall in location, false otherwise.
		 */
		public boolean wallHere(int[] location){
			if (maze[location[0]][location[1]] != null){
				
				if (maze[location[0]][location[1]].isWall()) {
					return true;
				}
				else {
					return false;
				}
			}
			return false;
			
		}

			
		/**
		 * Altering the created 10 by 20 array into respective values to act like a maze.
		 */
		public void obstacles() {
			

			
			pellets = new ItemGenerator(numberOfPellets);
			pellets.randomWall(maze);
			pellets.randomPellet(maze);

			}
			
			
			/*
			for(int i=0; i<maze.length; i++) {
				for(int j=0; j <maze[i].length; j++) {
					System.out.print(maze[i][j] + " ");
				}
				System.out.println();
				
			}
			*/

		
		
		/**
		 * Changing the numeric values altered into a visual representation of each 
		 * @param rewards generated from rewards class to represent the pellets in array.
		 */
		public void boundary(ItemGenerator rewards){
			// looping through entire array changing each element into 1 of the four possible options.
			for(int i=0; i<maze.length; i++) {
				for(int j=0; j <maze[i].length; j++) {
					int[] locationarray = new int[2];
					locationarray[0]=i;
					locationarray[1]= j;
					
					if (maze [i][j] != null) {
						maze [i][j].printItem();
					}
					else
						System.out.print(" ");
					
					
						
					//else if (maze[i][j]== (int)maze[i][j]) {
						//if (maze [i][j] != 0) {
			
					

			}
				
				System.out.println();
		}
		}
}