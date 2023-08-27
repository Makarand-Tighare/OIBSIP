import java.util.Scanner;
import java.util.HashMap;

class ExamUser {

  private String username;
  private String password;
  
  public ExamUser(String username, String password) {
    this.username = username; 
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

}

class ExamSystem {

  private HashMap<String, ExamUser> users = new HashMap<>();
  private ExamUser loggedInUser;

  public void registerUser(String username, String password) {
    if(!users.containsKey(username)) {
      ExamUser newUser = new ExamUser(username, password);
      users.put(username, newUser);
      System.out.println("User registered successfully!");
    } else {
      System.out.println("Username already exists!"); 
    }
  }

  public boolean login(String username, String password) {
    if(users.containsKey(username)) {
      ExamUser user = users.get(username);
      if(user.getPassword().equals(password)) {
        loggedInUser = user;
        return true;  
      }
    }
    return false;
  }

  public void startExam() {
    
    int score = 0;
    
    System.out.println("Question 1: What is the capital of France?");
    System.out.println("A) New York");
    System.out.println("B) London"); 
    System.out.println("C) Paris");
    System.out.println("D) Tokyo");

    Scanner scanner = new Scanner(System.in);
    String answer = scanner.nextLine();

    if(answer.equalsIgnoreCase("C")) {
      score++;
      System.out.println("Correct!");
    } else {
      System.out.println("Incorrect!");
    }

    // Add more questions

    System.out.println("You scored " + score + " out of 5");

  }
  
}

public class OnlineExam {

  public static void main(String[] args) {

    ExamSystem examSys = new ExamSystem();
    Scanner scanner = new Scanner(System.in);

    // Registration
    System.out.print("Enter username: ");
    String username = scanner.nextLine();
    System.out.print("Enter password: ");
    String password = scanner.nextLine();

    examSys.registerUser(username, password);

    // Login
    System.out.print("Enter username: ");
    username = scanner.nextLine();
    System.out.print("Enter password: ");
    password = scanner.nextLine();

    if(examSys.login(username, password)) {
      examSys.startExam();
    } else {
      System.out.println("Invalid credentials");
    }

    scanner.close();

  }

}
