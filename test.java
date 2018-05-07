//Created by Zachary Minnix
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class test {
	public static void main(String[] args)throws Exception {
	MovieList a = new MovieList(300,"movies.txt");
	
	Movie zMovie = new Movie(a.getRandomMovie());
	System.out.println(zMovie.dashClone);
	Game zGame = new Game(10,zMovie);
	zGame.runGame();
	}
	
}
