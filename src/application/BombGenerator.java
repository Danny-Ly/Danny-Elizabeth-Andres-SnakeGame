package application;

public class BombGenerator extends RandomNumberGenerator{
	private int numberOfBombs = 0;
	public void randomBomb(MazeItems[][] maze2) {
		while (numberOfBombs < 2) {
			int x = RandomNumberGeneratorXcord();
			int y = RandomNumberGeneratorYcord();
			if (maze2[x][y] == null) {
				maze2[x][y] = new Bombs();
				numberOfBombs++;
			}
		}
	}
}
