package application;

public interface MazeItems {
	
	public void printItem();
	
	public void eat(Snake snake, MazeGenerator generator);
	
	public boolean isWall();


	

}

class Bombs implements MazeItems{
	public void printItem(){
		System.out.print("@");
		
	}
	public void eat(Snake snake, MazeGenerator generator){
		// Danny Implement EatBomb Like Eat Pellet
		//snake.eatBomb(generator);
	}
	public boolean isWall(){
		return false;
	}
}
class Pellets implements MazeItems{
	public void printItem(){
		System.out.print(".");	
	}
	public void eat(Snake snake, MazeGenerator generator){
		snake.eatPellet(generator);
	}
	public boolean isWall(){
		return false;
	}
}

class Wall implements MazeItems{
	public boolean isWall(){
		return true;
	}
	public void printItem(){
		System.out.print("#");	
	}
	public void eat(Snake snake, MazeGenerator generator){
		throw new RuntimeException("SNAKES CAN'T EAT WALLS");
	}	
	
}
//segemnt