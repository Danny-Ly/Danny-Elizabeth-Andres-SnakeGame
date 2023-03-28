package application;

/**
 * This class is randomly generating bombs within the maze
 * @author Written by Andres and Elizabeth, assisted and co-written by Danny.
 *
 */
public class BombGenerator extends ObjectGenerator{
	/**
	 * Generates random bombs through the maze
	 * 
	 * @param maze2 is the 2 dimensional array that we will add bombs to .
	 */
	public void generateObject(MazeItems[][] maze2) {
		setLimiter(2);
		setObject(new Bombs());
		randomCoordinate(maze2);
	}
}