//Alexander Vuu
//Cse142
//TA: Mttchell Massie

//Code with play a game with the user to guess the correct number.
import java.util.*;
public class Assignment_5 {
    public static final int MAX_VALUE = 100;
    public static void main(String[] agrs){
        Random randDeclare = new Random(100000000);//random seed value
        Scanner console = new Scanner(System.in);
        
        //initializes all values used in main.
        int numOfGuess = 0;
        int numOfTotalGames = 0;
        int numOfTotalGuess = 0;
        double avgGuess = 0;
        int lowestGuess = Integer.MAX_VALUE;
        boolean again = true;
        
        introHaiku();
        
        //While loop will add to the math of the statistics, 
        //everytime the program loops (whem the user says yes)
        while(again){
            numOfGuess = game(console, randDeclare);
            again = again(console);
            numOfTotalGames++;
            numOfTotalGuess = numOfTotalGuess + numOfGuess;

            //if the number of guesses is smaller than the current
            //smallest number it becomes the new lowestGuess.
            if(numOfGuess < lowestGuess){
                lowestGuess = numOfGuess;
            }
        }

        //Average guess is the number of total guesses divided by number of games. 
        avgGuess = round1(((double)numOfTotalGuess)/numOfTotalGames);
        statisticsFinal(numOfTotalGames, numOfTotalGuess, avgGuess, lowestGuess);
         
    }

    //prints the haiku intro statement
    public static void introHaiku(){
        System.out.println("Welcome to number");
        System.out.println("guessing game. Today we will");
        System.out.println("guess my number. YAY");
        System.out.println();
    }

    //method is the bulk of the guessing game.
    //parameter collects user input
    //random parameter will generate a random number. 
    public static int game(Scanner console, Random randDeclare){
        
        int numOfGuess = 0;
        int guess = 0;
        
        System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE + "...");
        //declares the random number as theRandomNumber
        int theRandomNumber = randDeclare.nextInt(MAX_VALUE)+1;
        numOfGuess = 0;
        
        //loop will loop until the user guesses the random number.
        while(guess != theRandomNumber){
            //System.out.println("The answer is: " + theRandomNumber);
            System.out.print("Your guess? ");
            guess = console.nextInt();
                
            //if the guess is smaller than the random number
            //Response with "Its higher"
            if(guess < theRandomNumber){
                System.out.println("It's higher.");
            }
            //if the guess is bigger than the random number
            //Response with "Its lower"
            else if(guess > theRandomNumber){
                System.out.println("It's lower.");
            }
            //anything else is the user guessing the random number.


            //updates number of guesses
            numOfGuess++;
        }

        //if the user guesses the number in one guess 
        //changes guesses to guess
        if (numOfGuess == 1){
            System.out.println("You got it right in " + numOfGuess + " guess!");
        }
        else{
            System.out.println("You got it right in " + numOfGuess + " guesses!");
        }
        
        //returns the number of guesses it took
        //the user to guess random number
        return numOfGuess;
    }

    //method ask the user if they want to play again
    //parameter ask for user input
    public static boolean again(Scanner console){
        System.out.print("Do you want to play again? ");

        String response  = console.next();
        //System.out.println();
        //if they have a y or Y in their answer code will think they said yes.
        if(response.charAt(0) == 'y' ||response.charAt(0) == 'Y' ){
            System.out.println();
            return true;
        }
        //any other letter code with think user meant to say no.
        else{
            return false;
        }
    }

    //method produces the final statement.
    //parameter calls all info from numOfTotalGames - number of games,
    //numOfTotalGuess - number of guesses, avgGuess - average guess, 
    //lowestGuess - lowest number of guesses
    public static void statisticsFinal(int numOfTotalGames, int numOfTotalGuess, double avgGuess, int lowestGuess){
        System.out.println();
        System.out.println("Overall results:");
        System.out.println("Total games   = " + numOfTotalGames);
        System.out.println("Total guesses = " + numOfTotalGuess);
        System.out.println("Guesses/game  = " + avgGuess);
        System.out.println("Best game     = " + lowestGuess);
    }

    // Rounds the given value to two decimal places and returns the result.
    // double num - the number to round
    public static double round1(double num) {
        return Math.round(num * 10.0) / 10.0;
    }
}