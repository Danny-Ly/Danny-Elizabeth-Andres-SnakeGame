package application;

public class PelletGenerator extends RandomNumberGenerator {
	private int numberOfPellets;
	public void randomPellet(MazeItems[][] maze2) {
		// generates random position in maze passed in until wanted
		// number of pellets is reached
		while (numberOfPellets < 5) {
			// randomly generate coordinates in parameter
			int x = RandomNumberGeneratorXcord();
			int y = RandomNumberGeneratorYcord();
			// checks if coordinate generated has an existing value
			if (maze2[x][y] == null) {
				maze2[x][y] = new Pellets();
				// increment increasing by 1
				numberOfPellets++;
			}
		}
	}
	
	//public int getPelletamount() {
	//	return numberOfPellets;
		
	//}
	//public int setPelletamount(int pelletinital) {
	//	numberOfPellets = pelletinital;
	//	return numberOfPellets;
	//}
}
