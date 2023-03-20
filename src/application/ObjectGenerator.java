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
	private int limiter;
	// private int limiter= 3;
	private MazeItems Object;
	// private MazeItems Object= new Bombs();
	private BombGenerator Bomb;
	private NinjaStarGenerator Ninja;
	private PelletGenerator Pellet;
	//private MazeItems[][] maze;
	//private int limiter;
	//private MazeItems Object;
	
	
	public void randomCoordinate(MazeItems[][] maze, int object) {
//		if (object == (0)) {
//			Bomb.random(maze);
//		}
//		else if (object == 1) {
//			Pellet.random(maze);
//		}
//		else if (object == 2) {
//			Ninja.random(maze);		
//		}
	
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
		setLimiter(0);
		setObject(null);
		numberOfObjects = 0;
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