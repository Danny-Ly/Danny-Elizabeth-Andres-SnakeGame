package application;

public class SpeedGenerator extends RandomNumberGenerator {
	// Initializing/declaring variables that will be used in the class
	private int numberOfSpeedPellets;
	
	/**
	 * Generates random pellets through the maze
	 * 
	 * @param maze2 is the 2 dimensional array that we will add pellets to .
	 */
	public void randomSpeed(MazeItems[][] maze2) {
		// generates random position in maze passed in until wanted
		// number of pellets is reached
		while (numberOfSpeedPellets < 3) {
			// Using methods from subclass(RandomNumberGenerator) to generate random number
			int x = RandomNumberGeneratorXcord();
			int y = RandomNumberGeneratorYcord();
			// checks if coordinate generated has an existing value
			if (maze2[x][y] == null) {
				maze2[x][y] = new Speed();
				// increment increasing by 1
					numberOfSpeedPellets++;
			}
		}
	}
}
