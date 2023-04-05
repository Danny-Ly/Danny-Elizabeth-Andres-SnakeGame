package application;

import java.util.Random;

/**
 * This class is used randomly generating obstacles within the maze, and clearing them.
 * 
 * @author Written by Elizabeth, assisted and co-written by Andres and Danny.
 *
 */
public class ItemGenerator{
	// Initializing/declaring variables that will be used in the class
	private int numberOfobstactle = 0;
	//private int[][] tempMaze;

	// constructor 
	public ItemGenerator() {
	}
	
	/**
	 * Clears the maze from all Mazeitems and changes to null space
	 * 
	 * @param maze is the 2 dimensional array we want to clear .
	 */
	public void clearMaze (MazeItems[][] maze) {
		// looping through entire maze array changing each Mazeitem into null
		// possible options.
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				maze[i][j] = null;
			}
		}
	}
	
	/**
	 * Clears the maze from all Mazeitems that is an instance of "Wall" and changes
	 * to null space
	 * 
	 * @param maze is the 2 dimensional array we want to clear Wall from.
	 */
	public void clearWalls (MazeItems[][] maze) {
		// looping through entire maze array changing each Mazeitem Wall into null
		// possible options.
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] instanceof Wall)
					maze[i][j] = null;
			}
		}
	}
	
	/**
	 * Generates random walls through the maze
	 * 
	 * @param maze is the 2 dimensional array that we will add walls to .
	 */
	public void randomWall(MazeItems[][] maze) {
		// changes top row,and bottom row of maze into walls
		for (int y_axis = 0; y_axis < 20; y_axis++) {
			maze[0][y_axis] = new Wall();
			maze[9][y_axis] = new Wall();
		}
		// changes first column, and last column of maze into walls
		for (int x_axis = 0; x_axis < 10; x_axis++) {
			maze[x_axis][0] = new Wall();
			maze[x_axis][19] = new Wall();
		}
		
		/*
		 * Randomly creating 20 or less obstacle within maze
		 */
		while (numberOfobstactle < 20) {
			Random randomvalue = new Random();
			int xCord;
			int yCord;
			// Using methods from subclass(RandomNumberGenerator) to generate random number
			xCord = randomvalue.nextInt(10);
			yCord = randomvalue.nextInt(16) + 2;
			if (maze[xCord][yCord] == null || maze[xCord][yCord] instanceof Wall) {
				if (xCord == 2 || xCord == 5 || xCord == 7) {
					maze[xCord][yCord] = new Wall();
					numberOfobstactle++;
				}
			}
		}
		// adding constant beginning location of snake and Walls of every maze.
		// maze [4][9] = SNAKE;
		maze[5][9] = new Wall();
		maze[5][8] = new Wall();
		maze[5][10] = new Wall();
		//maze[4][8] = new Wall();
		//maze[4][10] = new Wall();
	}
}