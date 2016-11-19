import java.util.Random;
import java.io.Console;

public class Game {
    public static void main(String[] args) {
      
      Console console = System.console();
      System.out.println("ADMINISTRATOR SETUP\n");
      System.out.println("====================");
      String name = console.readLine("Name of the item in the jar: ");
      int maxNoOfItems = Integer.parseInt(console.readLine("Maximum number of %s in the jar: ",name));
      System.out.println("PLAYER");
      System.out.println("====================");
      System.out.printf("Your goal is to guess how many %s are in the jar.Your guess should be between 1 and %d %n",name,maxNoOfItems);
      
      Random random = new Random();
      int randomGuess = random.nextInt(maxNoOfItems);
      int noOfGuesses=0;
      Jar jar =  new Jar(randomGuess,name,maxNoOfItems);
      boolean notGuessed = true;
      while(notGuessed)
      {
      int guessNo = Integer.parseInt(console.readLine("Guess: "));
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
