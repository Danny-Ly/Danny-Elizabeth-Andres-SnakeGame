package application;
/**
 * This class is used in generating, customizing and creating a visual-like maze
 * appearance that user can visually see change according to user input.
 * 
 * @author Written by Andres, assisted and co-written by Elizabeth and Danny.
 *
 */
public class MazeGenerator {
	// Initializing/declaring variables that will be used in the class
	// And customization of the maze
	private MazeItems[][] maze;
	private ItemGenerator item;
	private int difficulty;
	private BombGenerator bomb;
	private PelletGenerator pellet;
	private SpeedGenerator speedPellet;
	
	/**
	 * gets the current difficulty of the game.
	 * @return the value of difficulty
	 */
	public int getdifficulty() {
		return this.difficulty;
	}
	
	/**
	 * sets the game difficulty.
	 * @param value desired difficulty user wants to play in
	 * @return the value of difficulty
	 */
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
	 * clears walls and regenerates random walls in maze
	 */
	public void regnerateMaze() {
		item = new ItemGenerator();
		item.clearWalls(maze);
		item.randomWall(maze);

	}
	
	/**
	 * clears old maze if it exist and generates random walls, random pellets, and
	 * random bombs.
	 */
	public void obstacles() {

		item = new ItemGenerator();
		item.clearMaze(maze);
		item.randomWall(maze);
		
		bomb = new BombGenerator();
		bomb.random(maze);
		
		pellet = new PelletGenerator();
		pellet.random(maze);
		
		speedPellet = new SpeedGenerator();
		speedPellet.random(maze);
		
		
		
	}
	
	/**
	 * checks to see if pellets are in maze
	 * 
	 * @return true is there is a pellet and false if not
	 */
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

	/**
	 * Creates the initial maze
	 * 
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

			}
			System.out.println();
		}

	}
	
	/**
	 * adds new snake segment to maze
	 * @param snakeSeg the old location of the snake segment
	 * @return the previous/old item location.
	 */
	public MazeItems add(SnakeSegment snakeSeg) {
		int[] arrayOfSnakeLocation = snakeSeg.location();
		// old snake location saved in variable
		MazeItems oldItem = maze[arrayOfSnakeLocation[0]][arrayOfSnakeLocation[1]];
		// update snake position in maze array
		maze[arrayOfSnakeLocation[0]][arrayOfSnakeLocation[1]] = snakeSeg;
		return oldItem;
	}
	
	/**
	 * removes old snake segment from maze 
	 * @param oldTail the old snake segment of the maze
	 */
	public void remove(SnakeSegment oldTail) {
		int[] arrayOfSnakeLocation = oldTail.location();
		maze[arrayOfSnakeLocation[0]][arrayOfSnakeLocation[1]] = null;
	}
}