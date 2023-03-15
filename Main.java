import java.util.*;

public class Main {
  public static void main(String[] args) {
    start();  
  }
  public static void madlibs(){
    Scanner in = new Scanner(System.in);
    String[] partsOfSpeech = { "noun", "adjective", "adjective", "adjective", "adjective", "name", "verb ending in -ing", "verb in past tense", "verb in past tense", "verb in past tense"};
    String[] userwords = new String[10];
    for (int count = 0; count < 10; count++) {
      System.out.print(partsOfSpeech[count] + ": ");
      userwords[count] = in.nextLine();
    }

    String theStory = "I woke up in my " + userwords[0] + " and " + userwords[1] + " my car. It was a " + userwords[2] + " morning. I took my dog, " + userwords[3] + " , on a walk and met some friends on the way. A " + userwords[4] + " breeze went through my fingers as my dog was sniffing the " + userwords[5] + " grass. It was really a " + userwords[6] + " time. As we went back home, we saw other families " + userwords[7] + ". When we " + userwords[8] + " home, my dog went to " + userwords[9] + ".";

    System.out.println(theStory);
    return;
  }

  public static void NumberGuesser() {
    Scanner in = new Scanner(System.in);

    System.out.println("Type a number for the minimum value of the range.");
    int low = in.nextInt();
    System.out.println("Type a number for the maximum value of the range.");
    int high = in.nextInt();

    int numToGuess = (int)(Math.random()* ((high + 1) - low)) +low;
    getNumber(in, numToGuess, low, high);
  }

  public static void displayMenu() {
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to GameTime!");
    System.out.println("Press 1 for MadLibs");
    System.out.println("Press 2 for NumberGuesser");
    System.out.println("Press 3 for WordGuesser");
    System.out.println("Press 4 to exit");

  }

  public static void getNumber(Scanner in, int numToGuess, int low, int high){
    //int theGuess = in.nextInt();
    //System.out.printf("You guessed %d\n", theGuess);
    boolean b = false;
    int counter = 0;
    while(b == false){
      System.out.println("Guess a number bewteen " + low + " and " + high + ".");
      if (in.hasNextInt()== false){
        String word = in.nextLine();
        System.out.printf("%s is not a number!\n", word);
        getNumber(in, numToGuess, low, high);
      }
      int guess = in.nextInt();
      counter++;
      if(numToGuess == guess){
          System.out.println("You won, you tried " + counter + " times!");
          break;
      }if(numToGuess > guess){
        System.out.println("Your answer is too low. You've made " + counter + " tries");
      }
      if (numToGuess < guess){
        System.out.println("Your answer is too high. You've made " + counter + " tries");
      }
    }
  }
  
  public static void WordGuesser() {
    
    Scanner in = new Scanner(System.in);
    String[] words = {"forehand","backhand", "ball", "court", "net", "Federer", "Racket", "Wimbledon", "grandslam", "Serve"};
    String targetWord = words[(int)(Math.random() * 10)].toUpperCase();
    //System.out.println(targetWord);
    String [] target = new String[targetWord.length()];
    for(int i = 0; i < target.length; i++){
      target[i] = targetWord.substring(i, i+1);
    }
    String [] visibleWord = new String[targetWord.length()];
    for(int i = 0; i < visibleWord.length; i++){
      visibleWord[i] = "?";
    }
    while(true){
      int questionMarkCount = visibleWord.length;
      System.out.println(Arrays.toString(visibleWord));
      System.out.println("Guess a letter:");
      String guess = in.nextLine().toUpperCase();
      for(int i = 0; i < target.length; i++){
        if (guess.equals(target[i])){
          visibleWord[i] = target[i];
        }
      }
      
      for(int i = 0 ; i < visibleWord.length; i++){
        if (!visibleWord[i].equals("?")){
          questionMarkCount--;
        }
      }
      if(questionMarkCount == 0){
        System.out.println("You win!");
        System.out.println(Arrays.toString(visibleWord));
        break;
      }
    }
  }

  public static void start(){
    Scanner in = new Scanner(System.in);
    int choice = 0;
    while (true){
      displayMenu();    
      System.out.println("What's your choice?");

      if (in.hasNextInt()){
        choice = in.nextInt();
        in.nextLine();

        if (choice == 1){
          madlibs();
        } else if (choice == 2){
          NumberGuesser();         
        } else if (choice == 3){
          WordGuesser();
        } else if (choice == 4){
          break;
        }
        else {
         System.out.println(in.nextLine()  + " is not a valid entry!");
        }
      }
    }
  }
}