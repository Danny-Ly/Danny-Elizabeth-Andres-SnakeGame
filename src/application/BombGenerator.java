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
	//private int limiter;
	//private MazeItems Object;
	//private ObjectGenerator Bomb;
	
	/**
	 * Generates random bombs through the maze
	 * 
	 * @param maze2 is the 2 dimensional array that we will add bombs to .
	 */
	// Override was used to allow us to use  inhertince, with the help of TA Parisa.
	//@Override
	public void random(MazeItems[][] maze2) {
		int limiter = 2;
		//setLimiter(2);
		setLimiter(limiter);
		MazeItems Bomb = new Bombs();
		setObject(Bomb);
		// generates random position in maze passed in until wanted
		// number of bombs is reached
	}
}
