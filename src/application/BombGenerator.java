package application;

/**
 * This class is randomly generating bombs within the maze
 * @author Written by Andres, assisted and co-written by Elizabeth and Danny.
 *
 */
public class BombGenerator extends RandomNumberGenerator{
	// Initializing/declaring variables that will be used in the class
	private int numberOfBombs = 0;
	
	/**
	 * Generates random bombs through the maze
	 * 
	 * @param maze2 is the 2 dimensional array that we will add bombs to .
	 */
	public void randomBomb(MazeItems[][] maze2) {
		// generates random position in maze passed in until wanted
		// number of bombs is reached
		while (numberOfBombs < 2) {
			// Using methods from subclass(RandomNumberGenerator) to generate random number
			int x = RandomNumberGeneratorXcord();
			int y = RandomNumberGeneratorYcord();
			// checks if coordinate generated has an existing value
			if (maze2[x][y] == null) {
				maze2[x][y] = new Bombs();
				// increment increasing by 1
				numberOfBombs++;
			}
		}
	}
}
