package application;

import java.util.Random;

/**
 * Class in charge of randomly generating numbers,
 *  for parent classes to call upon it 
 * @author Written by Andres, assisted and co-written by Elizabeth and Danny.
 *
 */
public class RandomNumberGenerator {
	// Initializing/declaring variables that will be used in the class
	private Random randomvalue = new Random();
	private int xCord;
	private int yCord;
	
	/**
	 * using random library, randomly generating a value between 0-10
	 * @return value randomly generated is returned
	 */
	public int RandomNumberGeneratorXcord() {
		 xCord = randomvalue.nextInt(10);
		return xCord;
	}
	
	/**
	 * using random library, randomly generating a value between 2-18
	 * @return value randomly generated is returned
	 */
	public int RandomNumberGeneratorYcord() {
		 yCord = randomvalue.nextInt(16) + 2;
		return yCord;
	}
}