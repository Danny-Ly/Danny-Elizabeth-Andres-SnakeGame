package application;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used in randomly generating pellets into the array,
 * and storing all pellet location values in a array list.
 * @author Written by Elizabeth, assisted and co-written by Andres and Danny.
 */
public class Rewards {
	Random randomNumber = new Random();
	public static final int WALL = 2;
	public static final int SNAKE = 1; 
	public static final int PELLET = 0;
	private ArrayList<int[]> arrayOfPellets = new ArrayList<int[]>();
	
	int numberOfPellets = 0;
	
	/** Randomly genarating pellets, and storing pellet location values in arraylist 
	 * @param mazeParameter the maze generated in MazeGenerator class.
	 */
	public Rewards(MazeGenerator mazeParameter) {
		while (arrayOfPellets.size()<5) { //here constructor
			int[]location = new int[2];
			location[0] = randomNumber.nextInt(8)+1 ;
			location[1] = randomNumber.nextInt(18)+1 ;
			if(!(mazeParameter.wallHere(location))) {
				arrayOfPellets.add(location);
		}
	}
	}
	/**
	 * Checking if the specific location entered is a location where a pellet is.
	 * @param location  in the 10 by 20 array we want to check if it is a Pellet value.
	 * @return will return TRUE if location is a PELLET, else FALSE.
	 */
	public boolean pelletHere(int[] location){
		for (int i=0; i < arrayOfPellets.size(); i++) {
			if (Arrays.equals(arrayOfPellets.get(i), (location))) {
				return true;
			}
		}
		return false;	
	}
}


