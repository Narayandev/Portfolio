public class Jar{
  private int mRandomGuess;
  public String mName;
  public int mmaxNoOfItems;
  
  public Jar(int randomGuess,String name,int maxNoOfItems){
    mRandomGuess =randomGuess;
    mName = name;
    mmaxNoOfItems = maxNoOfItems;
  }
  
  public int guessRandom(){
     return mRandomGuess;
  }
  
  public int validateGuess(int num){
    if(num > mmaxNoOfItems || num < 1 )
    {
      throw new IllegalArgumentException("The entered number or character is not with in the guess numbers range/invalid.");
    }
    return num;
  }
    
  
  public boolean guess(int Num){
    int number=validateGuess(Num);
    boolean isGuessed=false;
    if(guessRandom() == number ){
      isGuessed = true;
    }
    return isGuessed;
      
}
}