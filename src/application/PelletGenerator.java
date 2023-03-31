package application;

/**
 * This class is randomly generating pellets within the maze
 * @author Written by Andres and Elizabeth , assisted and co-written by Danny.
 *
 */
public class PelletGenerator extends ObjectGenerator{
	// Initializing/declaring variables that will be used in the class
	private int numberOfPellets;
	//private ObjectGenerator Pellet;
	
	/**
	 * Generates random pellets through the maze
	 * 
	 * @param maze2 is the 2 dimensional array that we will add pellets to .
	 */
	public void generateObject(MazeItems[][] maze2) {
		setLimiter(1 + getIncremental());
		setObject(new Pellets());
		randomCoordinate(maze2);
	}
	public int getIncremental() {
		return numberOfPellets;
	}

	public void setIncremental(int incremental) {
		this.numberOfPellets = numberOfPellets +incremental;
	}
}