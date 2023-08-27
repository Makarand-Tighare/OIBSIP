import java.util.Scanner;

public class GuessGame {

  private int secretNumber;
  private int maxTrials = 5;
  
  public GuessGame() {
    // Generate random number on startup
    secretNumber = generateSecretNumber(); 
  }
  
  private int generateSecretNumber() {
    return 1 + (int)(100 * Math.random());
  }

  public void startGame() {

    Scanner scanner = new Scanner(System.in);
    int trials = 0;
    
    while (trials < maxTrials) {
      trials++;
      
      System.out.print("Enter a guess between 1 and 100: ");
      int guess = getValidGuess(scanner);
      
      if (checkGuess(guess)) {
        System.out.println("You guessed the number!");
        break;  
      } else {
        giveHint(guess);
      }
    }
    
    if (trials == maxTrials) {
      System.out.println("Sorry, you didn't guess the number in 5 tries. It was " + secretNumber); 
    }
    
  }
  
  private int getValidGuess(Scanner scanner) {
    // Loop until valid integer entered
    while (true) {
      if (scanner.hasNextInt()) {
        return scanner.nextInt();
      } else {
        // Invalid input, discard and prompt again
        scanner.next(); 
        System.out.print("Invalid input. Enter an integer between 1 and 100: ");
      }
    }
  }

  private boolean checkGuess(int guess) {
    return guess == secretNumber;
  }
  
  private void giveHint(int guess) {
    if (guess < secretNumber) {
      System.out.println("Your guess is too low!"); 
    } else {
      System.out.println("Your guess is too high!");
    }
  }

  public static void main(String[] args) {
    GuessGame game = new GuessGame();
    game.startGame();
  }
  
}
