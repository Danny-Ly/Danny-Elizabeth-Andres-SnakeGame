package application;


/**
 * This class is randomly generating NinjaStars within the maze
 * 
 * @author Written by Andres and Elizabeth , assisted and co-written by Danny.
 *
 */
public class NinjaStarGenerator extends ObjectGenerator {

	/**
	 * Generates random pellets through the maze
	 * 
	 * @param maze2 is the 2 dimensional array that we will add pellets to .
	 */
	public void generateObject(MazeItems[][] maze2) {
		setLimiter(2);
		setObject(new Ninjastars());
		randomCoordinate(maze2);
	}
}

