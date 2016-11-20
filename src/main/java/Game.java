import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
      
      Scanner scanner = new Scanner(System.in);
      System.out.println("ADMINISTRATOR SETUP\n");
      System.out.println("====================");
      System.out.print("Name of the item in the jar: ");
      String name = scanner.next();
      System.out.print("Maximum number of " + name +" in the jar: ");
      int maxNoOfItems = scanner.nextInt();
      System.out.println("PLAYER");
      System.out.println("====================");
            
      Random random = new Random();
      int randomGuess = random.nextInt(maxNoOfItems)+1;
      
      System.out.printf("Your Goal is to guess how many %s are in the jar.Your guess should be between 1 and %d.Start Guessing..%n",name,maxNoOfItems);

      int noOfGuesses=0;
      Jar jar =  new Jar(randomGuess,name,maxNoOfItems);
      boolean notGuessed = true;
      while(notGuessed)
      {
       System.out.print("Guess: ");
       int guessNo = scanner.nextInt();
       boolean guessed = false;
       try{
            guessed=jar.guess(guessNo);
            noOfGuesses++;
       }
      catch(IllegalArgumentException iae){
         System.out.printf("%s.Please try again.%n",iae.getMessage());
         noOfGuesses++;
      }
           if(guessed == true)
         { 
             notGuessed = false;
          }
      }
       System.out.printf("Congratulations-You guessed that there are %d %s in the jar.It took you %d guess(es) to get it right.%n",
                                                          jar.guessRandom(),name, noOfGuesses);
                         
    }
}
