
//Alexander Vuu
//CSE 142
//TA:Mitchell

//program will print a space needle. 
//User is able to change the size by changing the SIZE constant.
public class Assignment_2 {
   
   public static final int SIZE = 4;//defualt size
   public static void main(String[] args) {
      needleAndBase();
      
      headerAndBase();

      headerBottom();
      
      needleAndBase();

      body();

      headerAndBase();
   }  

   //method to create the needle and top part of the body
   public static void needleAndBase(){
      for(int i = 1; i <= SIZE; i++){//for loop that create spaces based on SIZE
         for(int j = 1; j <= 3*SIZE; j++){//for loop, expression of  3*SIZE
            System.out.print(" ");
         }
         System.out.println("||");//prints needle.
      }
   }

   //method to create top head
   public static void headerAndBase(){
      for(int i = 1; i<=SIZE; i++){//for loop to run as many times according to the SIZE 
         for(int j = SIZE; j >= i + 1; j--){//for loop to make spaces to center the space needle
            System.out.print("   ");
         }
         System.out.print("__/");

         for(int j = (SIZE + 2) - i; j <= SIZE; j++){//for loop to make :::
            System.out.print(":::");
         }
         System.out.print("||");

         for(int j = (SIZE + 2) - i; j <= SIZE; j++){//for loop to make :::
            System.out.print(":::");
         }
         System.out.println("\\__");
      }
      System.out.print("|");
      for(int i = 1; i <= 6*SIZE; i++){//for loop expression of 6*SIZE
         System.out.print("\"");
      }
      System.out.println("|");
   }

   //method to create head of the bottom.
   public static void headerBottom(){
      for(int i = 1; i <= SIZE; i++){
         for(int j = 1; j <= (i-1); j++ ){//prints right number of spaces based on SIZE
            System.out.print("  ");
         }
         System.out.print("\\_");
         for(int j = 1; j <= (-2*i) + (3*SIZE) + 1; j++){//for loop uses an expression to create /\
            System.out.print("/\\");
         }
         System.out.println("_/");
      }
   }

   //creates bottom body of the needle
   public static void body(){
      for(int i = 1; i <= (SIZE*SIZE); i++){//for loop creates number of new lines based on SIZE
         for(int j = 1; j <= (SIZE * 2 + 1); j++){//for loop creates spaces to center the body.
            System.out.print(" ");         
         }
         System.out.print("|");
         for(int j = 1; j <= (SIZE-2); j++){//for loop creates number of % based on size.
            System.out.print("%");         
         }
         System.out.print("||");
         for(int j = 1; j <= (SIZE-2); j++){//for loop creates number of % based on size.
            System.out.print("%");         
         }
         System.out.println("|");

      }  
   }
}
         