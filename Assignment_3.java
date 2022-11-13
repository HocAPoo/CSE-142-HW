//import com.apple.laf.resources.aqua;
//Alexander Vuu
//Cse142
//TA: Mttchell Massie
//Program encrypts a message using a Ceaser Cipher. 
//Ask for a keyword then number of words in the message.
import java.util.*;
public class Assignment_3 {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3;//Shifts the letters in the Alphabet.
    public static void main(String[] agrs){
        Scanner console = new Scanner(System.in);
        
        intro();//prints the intro

        userInput(console);//ask user for the keyword.
        
        words(console);//gets each word in the message.

    }

    //Method that is used whenever a word needs to be encrypted.
    //(uesd in each other method)
    //method has a String perameter which will be taken from userInput
    //and words methods
        public static void encryptingMeth(String message){
        for (int i = 0; i <= message.length()-1; i++){//loop runs for each letter length
            // of the word
            String messageLetters = message.charAt(i)+"";
            int indexOfLetter = ALPHABET.indexOf(messageLetters)+1;
            indexOfLetter = (indexOfLetter+(SHIFT-1))%(ALPHABET.length());//applies the SHIFT
            String afterCipherLetter = ALPHABET.charAt(indexOfLetter) + "";
            
            System.out.print(afterCipherLetter);
        }    
        System.out.println();
    }

    //prints the intro messages.
    public static void intro(){
        System.out.println("Welcome to the CSE142 Encryption Machine!");
        System.out.println("The program lets you encrypt a message");
        System.out.println("with a key so your recipient can decrypt.");
        System.out.println();
    }

    //Gets the user's input, uses encryptingMeth method to scamble the key.
    //Prints both the unscrambled key and the scambled key.
    //method has a scanner perameter which will take input from user
    public static void userInput(Scanner console){
        System.out.println("Encrypted messages use a shared keyword to decrypt.");
        System.out.print("  Enter key: ");
        String message = console.next();//gets user input for the keyword.
        System.out.print("    \"" + message + "\" " + "has been encrypted to: " );
        encryptingMeth(message);
    }

    //method gets the user's number of words inside their messages
    //method has a scanner perameter which will take input from user
    public static void words(Scanner console){
        System.out.println();
        System.out.print("How many words are in your message? ");
        int numWord = console.nextInt();// gets user's for how many words are in the message.
        //System.out.println(numWord);
        for(int i = 1; i<= numWord; i++){//Uses a for loop to ask for each word in the message.
            System.out.print("  Next word: ");
            String wordMsg = console.next();
            System.out.print("    \"" + wordMsg + "\" " + "has been encrypted to: " );

            encryptingMeth(wordMsg);
        }
        System.out.println();
        System.out.println("Message fully encrypted. Happy secret messaging!");
    }    
}