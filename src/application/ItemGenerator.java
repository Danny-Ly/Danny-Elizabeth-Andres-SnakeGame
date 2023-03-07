package application;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used in randomly generating pellets into the maze.
 * 
 * @author Written by Elizabeth, assisted and co-written by Andres and Danny.
 *
 */

public class ItemGenerator {
	int numberOfBombs = 0;
	int numberOfobstactle = 0;
	Random randomvalue = new Random();
	// private ArrayList<int[]> arrayofPellets = new ArrayList<int[]>();

	int numberOfPellets;
	int[][] tempMaze;

	// constructor takes the number of pellets
	public ItemGenerator(int pelletsCount) {
		numberOfPellets = pelletsCount;
	}

	public void randomBomb(MazeItems[][] maze2) {
		while (numberOfBombs < 2) {
			int x = randomvalue.nextInt(10);
			int y = randomvalue.nextInt(16) + 2;
			if (maze2[x][y] == null) {
				maze2[x][y] = new Bombs();
				numberOfBombs++;
			}
		}
	}

	/**
	 * Randomly places pellets into the maze
	 * 
	 * @param maze2 is the maze we want to randomly add pellets to.
	 */
	public void randomPellet(MazeItems[][] maze2) {
		// generates random position in maze passed in until wanted
		// number of pellets is reached
		while (numberOfPellets < 5) {
			// randomly generate coordinates in parameter
			int x = randomvalue.nextInt(10);
			int y = randomvalue.nextInt(16) + 2;
			// checks if coordinate generated has an existing value
			if (maze2[x][y] == null) {
				maze2[x][y] = new Pellets();
				// increment increasing by 1
				numberOfPellets++;
			}

		}
	}
	
	public void clearMaze (MazeItems[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				maze[i][j] = null;
			}
		}
	}
	public void clearWalls (MazeItems[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] instanceof Wall)
					maze[i][j] = null;
			}
		}
	}

	public void randomWall(MazeItems[][] maze) {
		/*
		 * Changing all initial values of the maze into empty spots.
		 */
		
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
			int x = randomvalue.nextInt(10);
			int y = randomvalue.nextInt(16) + 2;
			if (maze[x][y] == null || maze[x][y] instanceof Wall) {
				if (x == 2 || x == 5 || x == 7) {
					maze[x][y] = new Wall();
					numberOfobstactle++;
				}
			}
		}

		// adding constant beginning location of snake and Walls of every maze.
		// maze [4][9] = SNAKE;
		maze[5][9] = new Wall();
		maze[5][8] = new Wall();
		maze[5][10] = new Wall();
		maze[4][8] = new Wall();
		maze[4][10] = new Wall();

	}
}
