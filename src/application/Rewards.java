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
	public static final char WALL = 30000;
	public static final int SNAKE = 1; 
	public static final char PELLET = 10000;
	private ArrayList<int[]> arrayofPellets = new ArrayList<int[]>();
	
	int numberOfPellets;
	int[][] tempMaze;

	//constructor takes the number of pellets
	public Rewards (int pelletsCount) {
		numberOfPellets = pelletsCount;
	}
	
	public void randomPellet(int[][]maze2) {
		while (numberOfPellets <30) {
			int x = randomvalue.nextInt(10) ;
			int y = randomvalue.nextInt(16)+2 ;
			if (x==2 || x==5 || x==7) {
				maze2[x][y]= PELLET;
			}
			tempMaze = new int[10][20];
			//https://stackoverflow.com/questions/5617016/how-do-i-copy-a-2-dimensional-array-in-java
			for(int i=0; i<maze2.length; i++) {
				for(int j=0; j <maze2[i].length; j++) {
					tempMaze[i][j] = maze2[i][j];
				}
			} 
						
				numberOfPellets++;
			
		}
	}
}

		


