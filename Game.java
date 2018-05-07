
import java.util.*;

class Game {

int guessesAllowed = 0;
ArrayList<String> guessesMade;
Movie inputMovie;
Scanner letterScanner;
String inputChar;
ArrayList<String> wrongGuessesMade;


        public Game(int guessesAllowed, Movie inputMovie){
            this.guessesAllowed = guessesAllowed;
            this.inputMovie = inputMovie;
            this.letterScanner = new Scanner(System.in);
            this.guessesMade = new ArrayList<>();
            this.wrongGuessesMade = new ArrayList<>();
        }
        public void runGame(){
            printIntro();
            
            while(true){
    	        acceptGuess();
    	        //endTurn returns if game should end, if it should end
    	        //break from while loop and program exits
    	        if(endTurn()){
    	            break;
    	        }
    	    }
        }
        private void printIntro(){
            System.out.println("\nWelcome, to Movie Hangman!");
    	    System.out.println("A movie has been randomly picked, it has "
    	    +inputMovie.lengthOfMovie+" letters.");
    	    System.out.println(inputMovie.dashClone);
    	    System.out.println("Enter a letter to get started");
    	    System.out.println("Cheat Mode: "+inputMovie.pickedMovie);
        }
        //accepts guess and updates guessesMade arraylist
        //also, updates characters in the dash string
        private void acceptGuess(){
            
            inputChar = letterScanner.next();
            if(errorCheckGuess(inputChar)){
                int searchIndex = inputMovie.pickedMovie.indexOf(inputChar);
                if(searchIndex > -1){
                inputMovie.updateDashClone(inputChar);
                }
                else{
                    wrongGuessesMade.add(inputChar);
                }
                
                    guessesMade.add(inputChar);
                
            }
            else{
                System.out.println("Invalid guess, please try again.");
            }
        }
        //checks to see if guess is a single letter
        private boolean errorCheckGuess(String input){
            boolean inputValid = true;
            //Don't let users guess the same letter more than once
            if(guessesMade.contains(input)){
                System.out.println("You've already guessed that letter");
                inputValid = false;
            }
            //Only allow single letters
            if(input.matches("[a-zA-Z]") == false){
                System.out.println("Error: Only enter 1 letter, a-z.");
                inputValid = false;
            }
            
            
            
            
            return inputValid;
        }
        //Prints out wrong guesses made, guesses remaining, and checks
        //and returns if game should end
        private boolean endTurn(){
            boolean endGame = false;
            System.out.println(inputMovie.dashClone);
            System.out.println("Wrong Guesses Made: "+wrongGuessesMade);
            System.out.println("Guesses Remaining: " + (guessesAllowed
            - wrongGuessesMade.size()));
            if(wrongGuessesMade.size()==guessesAllowed){
                System.out.println("Maximum Number of Attemps Reached");
                System.out.println(inputMovie.pickedMovie);
                endGame = true;
            }
            if(inputMovie.dashCloneEmpty()){
                System.out.println("Congratulations, you won!");
                endGame = true;
            }
            
            return endGame;
            
            
        }



}