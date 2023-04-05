package application;

/**
 * This class is randomly generating pellets within the maze
 * @author Written by Andres and Elizabeth , assisted and co-written by Danny.
 *
 */
public class PelletGenerator extends ObjectGenerator{
	// Initializing/declaring variables that will be used in the class
	int pelletCount = 5;
	
	/**
	 * sets the pellet count
	 * @param pellet number of pellets from map.
	 */
	// this setter I got from the help of Matthew (TA). 
	public void setPelletCount(int pellet) {
		pelletCount=pellet;
	}
	
	/**
	 * Generates random pellets through the maze
	 * 
	 * @param maze2 is the 2 dimensional array that we will add pellets to .
	 */
	public void generateObject(MazeItems[][] maze2) {
		setLimiter(pelletCount);
		setObject(new Pellets());
		randomCoordinate(maze2);
	}
}