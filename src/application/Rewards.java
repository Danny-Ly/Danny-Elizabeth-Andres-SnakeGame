package application;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used in randomly generating pellets into the maze.
 * @author Written by Elizabeth, assisted and co-written by Andres and Danny.
 *
 */
public class Rewards {
	Random randomvalue = new Random();
	// Declaring constant values.
	public static final char WALL = 30000;
	public static final int SNAKE = 1; 
	public static final char PELLET = 10000;
	//private ArrayList<int[]> arrayofPellets = new ArrayList<int[]>();
	
	int numberOfPellets;
	int[][] tempMaze;

	//constructor takes the number of pellets
	public Rewards (int pelletsCount) {
		numberOfPellets = pelletsCount;
	}
	/**
	 * Randomly places pellets into the maze
	 * @param maze2 is the maze we want to randomly add pellets to.
	 */
	public void randomPellet(int[][]maze2) {
		// generates random posstion in maze passed in until wanted 
		// number of pellets is reached
		while (numberOfPellets <5) {
			// randomly generate cordinates in parameter
			int x = randomvalue.nextInt(10) ;
			int y = randomvalue.nextInt(16)+2 ;
			// checks if cordinate generated has an existing value 
			if (maze2[x][y]!= WALL & maze2[x][y]!= SNAKE & maze2[x][y] != PELLET) {
				maze2[x][y]= PELLET;
				// incremetly increasing by 1
				numberOfPellets++;
			}
			tempMaze = new int[10][20];
			//https://stackoverflow.com/questions/5617016/how-do-i-copy-a-2-dimensional-array-in-java
			// short code on how to duplicate the 2D array
			for(int i=0; i<maze2.length; i++) {
				for(int j=0; j <maze2[i].length; j++) {
					tempMaze[i][j] = maze2[i][j];
				}
			} 	
				// incremetly increasing by 1 
				//numberOfPellets++;
		}
	}
}