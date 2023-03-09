package application;

import java.util.Random;

public class RandomNumberGenerator {
	private Random randomvalue = new Random();
	private int xCord;
	private int yCord;
	
	public int RandomNumberGeneratorXcord() {
		 xCord = randomvalue.nextInt(10);
		return xCord;
	}
	public int RandomNumberGeneratorYcord() {
		 yCord = randomvalue.nextInt(16) + 2;
		return yCord;
	}
}
