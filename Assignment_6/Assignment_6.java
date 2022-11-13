//Alexander Vuu
//Cse142
//Mitchell Massie

//This program creates a madlib then sends it to an output file.
import java.util.*;
import java.io.*;

public class Assignment_6 {
    public static void main(String[] agrs)throws FileNotFoundException{
        Scanner console = new Scanner(System.in);

        intro();

        String response = "";
        String outFile = "";
        File preoutput;
        while(!response.equalsIgnoreCase("q")){
            System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
            response = console.nextLine();
            if(response.equalsIgnoreCase("c")){//creating
                File inFile = input(console);
                Scanner input = new Scanner(inFile);
                outFile = output(console);
                preoutput = new File(outFile);
                PrintStream output = new PrintStream(preoutput);
                infoCollect(input, output, console);
            }
            else if(response.equalsIgnoreCase("v")){//viewing
                File viewFile = input(console);
                System.out.println();
                //System.out.println(test);
                Scanner finshedMadlib = new Scanner(viewFile);
                userViewing(finshedMadlib);
            }
            else if (response.equalsIgnoreCase("q")){
                System.out.println();
            }
        }
    }

    //method prints the intro for the program.
    public static void intro(){
        System.out.println("Welcome to the game of Mad Libs.");
        System.out.println("I will ask you to provide various words");
        System.out.println("and phrases to fill in a story.");
        System.out.println("The result will be written to an output file.\n");
    }

    //ask for the input file. If input file cannot be found
    //or doesn't exist program will ask until a valid input file is named.
    //Scanner console parameter collect user input for the file. 
    //Returns an String that will be scaned in main for a for the
    //listed file named. 
    public static File input(Scanner console){
        System.out.print("Input file name: ");
        String userInput = console.nextLine();
        File file = new File(userInput);
        while(!file.exists()){
            System.out.print("File not found. Try again: ");
            userInput = console.nextLine();
            file = new File(userInput);
        }
        return file;
    }
    

    //ask for an output file. then uses a PrintStream to make a new output file.
    //Scanner console parameter collect user input for the file. 
    //Returns an String that has the same file name as user input.
    public static String output(Scanner console ){
        System.out.print("Output file name: ");
        String userOutput = console.nextLine();
        System.out.println();
        return userOutput;
    }


    public static void infoCollect(Scanner input, PrintStream output, Scanner console){
        String consoleInput;
        int end = 0;
        while(input.hasNextLine()){
            String theNextLine = input.nextLine();
            Scanner nextLine = new Scanner(theNextLine);
            while(nextLine.hasNext()){
                String nextToken = nextLine.next();
                if ((nextToken.startsWith("<")) && (nextToken.endsWith(">"))){

                    end = nextToken.length()-1;
                    consoleInput = nextToken.substring(1, end);
                    consoleInput = consoleInput.replace('-', ' ');

                    if((consoleInput.startsWith("a")) 
                        || (consoleInput.startsWith("A")) 
                        || (consoleInput.startsWith("e"))
                        || (consoleInput.startsWith("E")) 
                        || (consoleInput.startsWith("i")) 
                        || (consoleInput.startsWith("I")) 
                        || (consoleInput.startsWith("o")) 
                        || (consoleInput.startsWith("O")) 
                        || (consoleInput.startsWith("u"))  
                        || (consoleInput.startsWith("U"))){
                        System.out.print("Please type an " + consoleInput + ": ");
                    }
                    else{
                        System.out.print("Please type a " + consoleInput + ": ");
                    }

                    nextToken = console.nextLine();
                } 
                output.print(nextToken + " ");
            }
            output.println();
        }
        System.out.println("Your mad-lib has been created!\n");
    }

    //called to view the output file. 
    //Scanner Parameter finishedMadLib will read all lines 
    //in output file and paste them into console.
    public static void userViewing(Scanner finishedMadlib){
        while(finishedMadlib.hasNextLine()){
            String outputReadNextLine = finishedMadlib.nextLine();
            System.out.println(outputReadNextLine);
        }
        System.out.println();
    }

}
//      /Users/HocVuu/Cse142/TakeHomeAssignments/tarzan.txt
//      /Users/HocVuu/Cse142/TakeHomeAssignments/tarzan.txt