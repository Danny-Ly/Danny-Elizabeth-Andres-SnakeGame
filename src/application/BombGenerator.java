package application;

import java.util.Random;

/**
 * This class is randomly generating bombs within the maze
 * @author Written by Andres, assisted and co-written by Elizabeth and Danny.
 *
 */
public class BombGenerator extends ObjectGenerator{
	// Initializing/declaring variables that will be used in the class
	//private int numberOfBombs = 0;
	
	/**
	 * Generates random bombs through the maze
	 * 
	 * @param maze2 is the 2 dimensional array that we will add bombs to .
	 */
	// Override was used to allow us to use  inhertince, with the help of TA Parisa.
	@Override
	public void random(MazeItems[][] maze2) {
		// generates random position in maze passed in until wanted
		// number of bombs is reached
		while (super.numberOfObjects < 2) {
			Random randomvalue = new Random();
			int xCord;
			int yCord;
			// Using methods from subclass(RandomNumberGenerator) to generate random number
			xCord = randomvalue.nextInt(10);
			yCord = randomvalue.nextInt(16) + 2;
			// checks if coordinate generated has an existing value
			if (maze2[xCord][yCord] == null) {
				maze2[xCord][yCord] = new Bombs();
				// increment increasing by 1
				numberOfObjects++;
			}
		}
	}
}
