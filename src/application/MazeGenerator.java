package application;


/**
 * This class is used in generating, customizing and creating a visual-like maze
 * appearance that user can visually see change according to user input.
 * 
 * @author Written by Andres, assisted and co-written by Elizabeth and Danny.
 *
 */
public class MazeGenerator {
	// Initializing/declaring variables that will be used in the creation,
	// And customization of the maze
	//private static final char WALL = 30000;
	//private static final int EMPTY = 0;
	//private static final int SNAKE = 1;
	//private static final char PELLET = 10000;
	private MazeItems[][] maze;
	private ItemGenerator item;
	private int difficulty;
	private BombGenerator bomb;
	private PelletGenerator pellet;
	//private int numberOfobstactle = 0;
	//private int numberOfPellets = 0;
	//private Random randomvalue = new Random();
	// int counter = 0;
	
	public int getdifficulty() {
		return this.difficulty;
	}
	public int setdifficulty(int value) {
		difficulty = value;
		return this.difficulty;
	}
	
	/**
	 * Constructor for MazeGenerator class, that creates a new 10 by 20 array that
	 * behaves as our maze
	 * 
	 * @param difficuty_paramter an integer that represents the difficulty the maze
	 *                           has
	 */
	public MazeGenerator( int difficulty_parameter) {
		difficulty = difficulty_parameter;
		// all difficulties generate specific size array
		if (difficulty >= 0) {
			maze = new MazeItems[10][20];
		}

		obstacles(); // generates the obstacles the maze needs.

	}

	/**
	 * Checks whether there is a wall in the specific location in the array.
	 * 
	 * @param location an array containing the x and y coordinate of the location we
	 *                 want to check.
	 * @return true if there is a wall in location, false otherwise.
	 */
	public boolean wallHere(int[] location) {
		if (maze[location[0]][location[1]] != null) {

			if (maze[location[0]][location[1]].isWall()) {
				return true;
			} else {
				return false;
			}
		}
		return false;

	}

	/**
	 * Altering the created 10 by 20 array into respective values to act like a
	 * maze.
	 */
	public void regnerateMaze() {
		item = new ItemGenerator();
		item.clearWalls(maze);
		item.randomWall(maze);

	}

	public void obstacles() {

		item = new ItemGenerator();
		item.clearMaze(maze);
		item.randomWall(maze);
		
		bomb = new BombGenerator();
		bomb.randomBomb(maze);
		
		pellet = new PelletGenerator();
		pellet.randomPellet(maze);
	}

	public boolean ifVictory() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {

				if (maze[i][j] instanceof Pellets) {
					return true;

				}
			}
		}
		// bring to main
		return false;
		
	}

	/*
	 * for(int i=0; i<maze.length; i++) { for(int j=0; j <maze[i].length; j++) {
	 * System.out.print(maze[i][j] + " "); } System.out.println();
	 * 
	 * }
	 */

	/**
	 * Changing the numeric values altered into a visual representation of each
	 * 
	 * @param rewards generated from rewards class to represent the pellets in
	 *                array.
	 */
	public void boundary() {
		// looping through entire array changing each element into 1 of the four
		// possible options.
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				int[] locationarray = new int[2];
				locationarray[0] = i;
				locationarray[1] = j;

				if (maze[i][j] != null) {
					maze[i][j].printItem();
				} else
					System.out.print(" ");

				// else if (maze[i][j]== (int)maze[i][j]) {
				// if (maze [i][j] != 0) {

			}

			System.out.println();
		}
	}

	public MazeItems add(SnakeSegment snakeSeg) {
		int[] arrayOfSnakeLocation = snakeSeg.location();
		MazeItems oldItem = maze[arrayOfSnakeLocation[0]][arrayOfSnakeLocation[1]];
		maze[arrayOfSnakeLocation[0]][arrayOfSnakeLocation[1]] = snakeSeg;
		return oldItem;

	}

	public void remove(SnakeSegment oldTail) {
		int[] arrayOfSnakeLocation = oldTail.location();
		maze[arrayOfSnakeLocation[0]][arrayOfSnakeLocation[1]] = null;

		// TODO Auto-generated method stub

	}
}