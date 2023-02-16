package application;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used in generating, customizing and creating a visual-like maze appearance 
 * that user can visually see change according to user input.
 * @author Written by Elizabeth, assisted and co-written by Andres and Danny.
 *
 */
public class Rewards {
	Random randomvalue = new Random();
	public static final int WALL = 2;
	public static final int SNAKE = 1; 
	public static final int PELLET = 0;
	private ArrayList<int[]> arrayofPellets = new ArrayList<int[]>();
	
	int numberOfPellets = 0;
	/*
	 * Randomly creating 5 or less pellets within maze
	 */
	
	public Rewards(MazeGenerator maze2) {
		while (arrayofPellets.size()<5) { //here constructor
			int[]location = new int[2];
			location[0] = randomvalue.nextInt(8)+1 ;
			location[1] = randomvalue.nextInt(18)+1 ;
			if(!(maze2.wallHere(location))) {
				arrayofPellets.add(location);
				

		}
	}
	}
	public boolean pelletHere(int[] location){
		for (int i=0; i < arrayofPellets.size(); i++) {
			if (Arrays.equals(arrayofPellets.get(i), (location))) {
			
				return true;
			}
		}
		
		
		return false;	
		
	}
	
}


