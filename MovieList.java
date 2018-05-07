import java.io.File;
import java.util.Scanner;
import java.util.Random;
class MovieList {
    int movieCounter = 0;
    String fileLocation;
    String[] movieArray;
    
    
    public MovieList(int numberOfMovies, String fileLocation) throws Exception{
        this.fileLocation = fileLocation;
        movieArray = new String[numberOfMovies];
        readMovies();
    }
    
    private void readMovies() throws Exception{
        File file = new File(fileLocation);
    	Scanner sc = new Scanner(file);
    	while(sc.hasNextLine()){
    		String line = sc.nextLine();
    		movieArray[movieCounter] = line;
    		movieCounter++;
    	}
    }
    public String getRandomMovie(){
        Random randomMovie = new Random();
        	return movieArray[randomMovie.nextInt(movieCounter)];
    }
    
    
    
}