//Alexander Vuu
//Cse142
//Mitchell Massie

//this prograam reveals a person's personality using 4 letters
import java.util.*;
import java.io.*;
public class Assignment_7 {
    public static final int ARRAY_SIZE = 4;//required class constant; number of dimensions
    public static void main(String[] args)throws FileNotFoundException{
        Scanner console = new Scanner(System.in);

        intro();

        File inFile = input(console);
        Scanner input = new Scanner(inFile);

        String outFile = output(console);
        PrintStream output = new PrintStream(new File(outFile));

        while(input.hasNextLine()){
            String name = input.nextLine();
            //System.out.println(name);
            String personality = input.nextLine();
            int[] indexNumOfB = infoCollect(input, 'b', 'B', personality);//uses b

            //System.out.println(Arrays.toString(indexNumOfB));

            int[] indexNumOfA = infoCollect(input, 'a', 'A', personality);//uses a

            //System.out.println(Arrays.toString(indexNumOfA));

            int[] indexB = maths(indexNumOfB, indexNumOfA);

            String letters = translate(indexB);

            output.println(name + ": " + Arrays.toString(indexB) + " = " + letters);
            
        }       
    }

    //intro for program
    public static void intro(){
        System.out.println("This program processes a file of answers to the");
        System.out.println("Keirsey Temperament Sorter. It converts the");
        System.out.println("various A and B answers for each person into");
        System.out.println("a sequence of B-percentages and then into a");
        System.out.println("four-letter personality type.");
        System.out.println();
    }

    //ask for the input file. If input file cannot be found
    //or doesn't exist program will ask until a valid input file is named.
    //Scanner console parameter collect user input for the file. 
    //Returns an File that will be scaned in main for a for the
    //listed file named. 
    public static File input(Scanner console){
        String userInput = "";
        System.out.print("input file name? ");
        userInput = console.nextLine();
        File file = new File(userInput);
        while(!file.exists()){
            System.out.print("input file name? ");
            userInput = console.nextLine();
            file = new File(userInput);
        }
        return file;
    }

    //ask for an output file. then uses a PrintStream to make a new output file.
    //Parameter: Scanner console parameter collect user input for the file. 
    //Returns an String that has the same file name as user input.
    public static String output(Scanner console){
        System.out.print("output file name? ");
        String outputFile = console.next();
        return outputFile;
    }

    //takes each line token and breaks through each letter by letter
    //and adds increases array coresponding to each b or a question
    //parameters: Scanner Input collects user input, lowCharcter and upCharcter
    //are the charcters that program looks for in string of letters
    //personlity is the string of letters that the method looks at
    //increases each cell of the array based on a 1,2 and 3, 4 and 5, 6 and 7 question
    //returns: integer array for A or B array.
    public static int[] infoCollect(Scanner input, char lowCharcter, 
    char upCharcter, String personality){
        
        int[] numOfAB = new int[ARRAY_SIZE];
        for(int i = 0; i < personality.length(); i++){
            char grade = personality.charAt(i);
            grade = Character.toUpperCase(grade);
            if(grade==upCharcter){
                if((i%7)==0){//Extrovert/Introvert
                    numOfAB[0]++;
                }
                else if((i%7)==1 || (i%7)==2){//Sensation/iNtuition
                    numOfAB[1]++;
                }
                else if((i%7)==3 || (i%7)==4){//Thinking/Feeling
                    numOfAB[2]++;
                }
                else{//Judging/Perceiving
                    numOfAB[3]++;
                }   
            }
        }    
        return numOfAB;
    }

    //adds i cell of A and B questions to produce totalquestions for that cell
    //divides b questions by percentage. Assigns that value to i cell
    //parameters: indexNumOfB is the array we send to the method, indexNumOfA is the array
    //we add with indexNumOfB to find total questions for that cell
    //returns: our manipulated int array zeroOrOne
    public static int[] maths(int[] indexNumOfB, int[]indexNumOfA){
        int[] zeroOrOne = new int[ARRAY_SIZE];
        for(int i = 0; i < indexNumOfB.length; i++){
            int totalQuestions = indexNumOfB[i] + indexNumOfA[i];
            double percentage = Math.round((double)indexNumOfB[i]/totalQuestions*100);
            zeroOrOne[i]=(int)percentage;
        }
        return zeroOrOne;
    }

    //For each cell we got in the array if it is less than 50 we get the 'A' response
    //if its greader than 50 we get the 'B' response. if even we get an 'X'
    //Adds the 'A' or 'B' answers as well as 'X's to finalLetter String
    //parameters: indexAOrB the array we look at to see if each cell is greader
    //that or less than 50
    //returns: the finalLetter which will be the combination of the four letters
    public static String translate(int[] indexAOrB){
        String finalLetter = "";
        String responseA = "ESTJ";
        String responseB = "INFP";
        for(int i = 0; i < indexAOrB.length; i++){
            if((indexAOrB[i]) < 50){//A
                finalLetter += responseA.charAt(i);
            }
            else if((indexAOrB[i]) > 50){//B
                finalLetter += responseB.charAt(i);
            }
            else{
                finalLetter += "X";
            }
        }
        return finalLetter;
    }   
}
//      /Users/HocVuu/Cse142/TakeHomeAssignments/personality.txt
//      /Users/HocVuu/Cse142/TakeHomeAssignments/output.txt