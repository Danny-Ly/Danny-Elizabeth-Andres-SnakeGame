package application;

import java.util.Random;
/**
 * This class is the basic structure of all three subclass, that overide this class
 * @author Written by Andres, assisted and co-written by Elizabeth and Danny.
 * Credit: helped and assisted by TA Parisa. 
 *
 */
public class ObjectGenerator{
	protected int numberOfObjects;
	public void random(MazeItems[][] maze2) {
		// generates random position in maze passed in until wanted
		// number of pellets is reached
		while (numberOfObjects < 5) {
			Random randomvalue = new Random();
			int xCord;
			int yCord;
			// Using methods from subclass(RandomNumberGenerator) to generate random number
			xCord = randomvalue.nextInt(10);
			yCord = randomvalue.nextInt(16) + 2;
			// checks if coordinate generated has an existing value
			if (maze2[xCord][yCord] == null) {
				maze2[xCord][yCord] = new Pellets();
				// increment increasing by 1
				numberOfObjects++;
			}
		}
	}

}
