package application;

import java.util.Random;

/**
 * Class responsible for generating speed items in the maze.
 * @author Danny and Elizabeth.
 *
 */
public class SpeedGenerator extends ObjectGenerator {
	// Initializing/declaring variables that will be used in the class
	// private int numberOfSpeedPellets;
	
	/**
	 * Generates random pellets through the maze
	 * 
	 * @param maze2 is the 2 dimensional array that we will add pellets to .
	 */
	// Override was used to allow us to use  inhertince, with the help of TA Parisa.
	@Override
	public void random(MazeItems[][] maze2) {
		// generates random position in maze passed in until wanted
		// number of pellets is reached
		while (super.numberOfObjects < 3) {
			Random randomvalue = new Random();
			int xCord;
			int yCord;
			// Using methods from subclass(RandomNumberGenerator) to generate random number
			xCord = randomvalue.nextInt(10);
			yCord = randomvalue.nextInt(16) + 2;
			// checks if coordinate generated has an existing value
			if (maze2[xCord][yCord] == null) {
				maze2[xCord][yCord] = new Speed();
				// increment increasing by 1
					numberOfObjects++;
			}
		}
	}
}
