/**
 * Class Untitled
 */
import java.io.File;
import java.util.Scanner;
import java.util.Random;

public class main {
	public static void main(String[] args)throws Exception {
    	String[] movieArray = new String[1000];
    	int lengthOfMovie = 0;
    	int movieCounter = 0;
    	int numberOfWrongGuesses = 10;
    	//Read file into string array
    	File file = new File("movies.txt");
    	Scanner sc = new Scanner(file);
    	while(sc.hasNextLine()){
    		String line = sc.nextLine();
    		movieArray[movieCounter] = line;
    		movieCounter++;
    	}
    	//Randomly pick element and store it in string
    	Random randomMovie = new Random();
    	StringBuilder pickedMovie = new StringBuilder(movieArray[randomMovie.nextInt(movieCounter)]);
    	//create copy of the movie with -- instead of the letter
    	StringBuilder dashClone = new StringBuilder(pickedMovie);
    	for(int i = 0;i<dashClone.length();i++){
    		if(dashClone.charAt(i) !=  ' '){
    			dashClone.setCharAt(i,'-');
    			lengthOfMovie++;
    		}
    	}
    	//Game Intro
    	System.out.println("\nWelcome, to Movie Hangman!");
    	System.out.println("A movie has been randomly picked, it has "+lengthOfMovie+
    	" letters.");
    	System.out.println(dashClone);
    	System.out.println("Enter a letter to get started");
    	
    	Scanner letterScanner = new Scanner(System.in);
    	
    	while(true){
    		int guessesRemaining = 0;
    		String inputChar = letterScanner.next();
    		System.out.println(dashClone);
    		int searchIndex = pickedMovie.indexOf(inputChar);
    		
    		//charAt returns -1 if it isn't present in string
    		
    		//if the letter is in the randomly picked movie this will loop through
    		//the original movie string and replace each "-" with the letter  
    		//that was found
    		if(searchIndex > -1){
    			 guessesRemaining = 0;
    			for(int i = 0;i<dashClone.length();i++){
    				if(pickedMovie.charAt(i)==inputChar.charAt(0)){
    					dashClone.setCharAt(i,inputChar.charAt(0));
    					guessesRemaining++;
    				}
    			}
    		}
    		else{
    			numberOfWrongGuesses--;
    		}
    		System.out.println("There were "+guessesRemaining+" "+inputChar+
    		"'s");
    		System.out.println(dashClone);
    		System.out.println("Wrong Guesses Remaining: "+numberOfWrongGuesses );
    		//Check to see if the game should continue
    		if(numberOfWrongGuesses==0){
    			System.out.println("You have ran out of attempts.");
    			System.out.println("The answer was: "+pickedMovie);
    			break;
    		}
    		if(dashClone.indexOf("-")==-1){
    			System.out.println("Congratulations, you won!");
    			break;
    		}
    	
    	}
    	
    	 
	} 
	//Checks to see if a character is in a string
	
}