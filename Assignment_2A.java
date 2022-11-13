

public class Assignment_2A {

    public static void main(String[] agrs){
        horizontalLine();

        verticalLineP1();

        verticalLineP2();

        verticalLineP3();

        verticalLineP1();

        horizontalLine();
    }

    public static void horizontalLine(){//method to create top and bottom side of the rectangle
        for(int i = 1; i <= 30; i++){//runs a for loop 30 times
            System.out.print("-");
        }
        System.out.println();
    }
    public static void verticalLineP1(){//method to create vertical lines and two lines in the middle
        for(int i = 1; i <= 2; i++){//runs a for loop twice 
            System.out.print("|");
            for(int j = 1; j <= 13; j++){//for loop to position the spaces to center two lines. 
                System.out.print(" ");
            }
            System.out.print("||");
            for(int j = 1; j <= 13; j++){//for loop to position the spaces so that we can add left side of the rectangle
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
    public static void verticalLineP2(){//creates the top half of the circular shape inside rectangle
        for(int i = 1; i <= 6; i++){//for loop that runs following code 6 times
            System.out.print("|");
            for(int j = 1; j <= -i+7; j++){//loop that prints spaces to center the circle 
                System.out.print("  ");
            }
            System.out.print("_|");
            
            for(int j = 1; j <= 2*i-2; j++){//for loop that prints the insides of the circle
                System.out.print("/\\");
            }
            System.out.print("|_");
            for(int j = 1; j <= -i+7; j++){//loop that prints spaces to center the circle 
                System.out.print("  ");
            }
            System.out.println("|");
        }
    }

    public static void verticalLineP3(){
        for(int i = 1; i <= 6; i++){
            System.out.print("|");
            for(int j = 1; j <= 2*i; j++){//loop that prints spaces to center the circle 
                System.out.print(" ");
            }
            System.out.print("▔|");
            
            for(int j = 1; j <= -2*i+12; j++){//for loop that prints the insides of the circle
                System.out.print("\\/");
            }
            System.out.print("|▔");
            
            for(int j = 1; j <= 2*i; j++){//loop that prints spaces to center the circle 
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }

}
