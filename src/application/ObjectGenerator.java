package application;

import java.util.Random;

/**
 * This class is the basic structure of all three subclass, that overide this
 * class
 * 
 * @author Written by Andres, assisted and co-written by Elizabeth and Danny.
 *
 */
public abstract class ObjectGenerator {
	//Initialization
	protected int numberOfObjects;
	private int limiter;
	private MazeItems Object;

	abstract public void generateObject(MazeItems[][] maze2);

	public void randomCoordinate(MazeItems[][] maze) {

		// generates random position in maze passed in until wanted
		// number of pellets is reached
		while (numberOfObjects < getLimiter()) {
			Random randomvalue = new Random();
			int xCord;
			int yCord;
			// Using methods from subclass(RandomNumberGenerator) to generate random number
			xCord = randomvalue.nextInt(10);
			yCord = randomvalue.nextInt(16) + 2;
			// checks if coordinate generated has an existing value
			if (maze[xCord][yCord] == null) {
				maze[xCord][yCord] = getObject();
				// increment increasing by 1
				numberOfObjects++;
			}
		}
	}

	public int getLimiter() {
		return limiter;
	}

	public void setLimiter(int limiter) {
		this.limiter = limiter;
	}

	public MazeItems getObject() {
		return Object;
	}

	public void setObject(MazeItems object) {
		this.Object = object;
	}
}