import java.io.File;
import java.util.Scanner;
import java.util.Random;
class Movie{
    
StringBuilder pickedMovie;
StringBuilder dashClone;
int lengthOfMovie;

    public Movie(String pickedMovie){
      this.pickedMovie = new StringBuilder(pickedMovie); 
      createDashClone();  
    }
    
    public void createDashClone(){
        this.dashClone = new StringBuilder(pickedMovie);
        for(int i = 0;i<dashClone.length();i++){
    		if(dashClone.charAt(i) !=  ' '){
    			dashClone.setCharAt(i,'-');
    			lengthOfMovie++;
    		}
    	}
    }
    public boolean dashCloneEmpty(){
        boolean empty = false;
        if(dashClone.indexOf("-")==-1){
    			empty = true;
    		}
    		return empty;
    }
    
    public void updateDashClone(String inputChar){
        int numberOfLettersContained = 0;
    			for(int i = 0;i<dashClone.length();i++){
    				if(pickedMovie.charAt(i)==inputChar.charAt(0)){
    					dashClone.setCharAt(i,inputChar.charAt(0));
    					numberOfLettersContained++;
    				}
    			}
        		
    }
    
}