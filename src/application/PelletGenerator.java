package application;

/**
 * This class is randomly generating pellets within the maze
 * @author Written by Andres and Elizabeth , assisted and co-written by Danny.
 *
 */
public class PelletGenerator extends ObjectGenerator{
	int pelletCount = 5;
	// Initializing/declaring variables that will be used in the class
	//private int numberOfPellets;
	//private ObjectGenerator Pellet;
	
	public void setPelletCount(int pellet) {
		pelletCount=pellet;
	}
	
//	public int getPelletCount() {
//		return pelletCount;
//	}
	
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