
//Alexander Vuu
//7/5/2022
//TA: Mitchell Massie
//CSE 142 AG

//code will write a program that will print out the grandma eating animals poem.
public class Assignment_1 {
   public static void main(String[] args){
      
      eatFly();//calls eatfly method
      
      eatSpider();//calls eatspider method
      
      eatBird();//calls eatbird method
      
      eatCat();//calls eatcat method
      
      eatDog();//calls eatdog method
      
      eatFlea();//calls eatflea method
      
      eatHorse();//calls eatHorse method
   }
   
   //Creates a method for each animal grandma eats,
   //method will print two ending sentaces for each paragrpah.
   public static void lastSentance(){
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println();
   }
   
   //method will combine methods to create the first phrase.
   public static void eatFly(){
      System.out.println("There was an old woman who swallowed a fly.");
      lastSentance();
   }
   
   //method will combine methods to create the second phrase.
   public static void eatSpider(){
      eatSpiderBeg();
      eatSpiderAfter();
      lastSentance();
   }
   
   //method will combine methods to create the third phrase.
   public static void eatBird(){
      eatBirdBeg();
      eatBirdAfter();
      lastSentance();
   }
   
   //method will combine methods to create the fourth phrase.
   public static void eatCat(){
      eatCatBeg();
      eatCatAfter();
      lastSentance();
   }
   
   // method will combine methods to create the fifth phrase.
   public static void eatDog(){
      eatDogBeg();
      eatDogAfter();
      lastSentance();
   }
   
   // method will combine methods to create the sixth phrase.
   public static void eatFlea(){
      eatFleaBeg();
      eatFleaAfter();
      lastSentance();
   }
   
   // method will print out the ending statements for grandma's demise.
   public static void eatHorse(){
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
   }
   
   // each method will be called upon, they will provide the "intro" to the paragraphs 81-106
   
   public static void eatSpiderBeg(){
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
   }
   
   public static void eatBirdBeg(){
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
   }
   
   public static void eatCatBeg(){
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
   }
   
   public static void eatDogBeg(){
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
   }
   
   public static void eatFleaBeg(){
      System.out.println("There was an old woman who swallowed a flea,");
      System.out.println("She said \"Reeeee\" when she swallowed that flea.");
   }
   
   // each method will be called upon, they will provide the "outro" to the paragraphs
   // by combining the previous methods and building onto of them. 110-133
   public static void eatSpiderAfter(){
      System.out.println("She swallowed the spider to catch the fly,");
   }
   
   public static void eatBirdAfter(){
      System.out.println("She swallowed the bird to catch the spider,");
      eatSpiderAfter();
   }
   
   public static void eatCatAfter(){
      System.out.println("She swallowed the cat to catch the bird,");
      eatBirdAfter();
   }
   
   public static void eatDogAfter(){
      System.out.println("She swallowed the dog to catch the cat,");
      eatCatAfter();
   }
   
   public static void eatFleaAfter(){
      System.out.println("She swallowed the flea to itch the dog,");
      eatDogAfter();
   }
}