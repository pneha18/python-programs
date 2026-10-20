import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int userScore = 0;
        int computerScore = 0;

        System.out.println("=== ROCK-PAPER-SCISSORS ===");
        System.out.println("First to 3 points wins!");

        while (userScore < 3 && computerScore < 3) {
            System.out.print("\nChoose rock, paper, or scissors (or type quit): ");
            String user = sc.nextLine().trim().toLowerCase();

            if (user.equals("quit")) break;
            if (!user.equals("rock") && !user.equals("paper") && !user.equals("scissors")) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            String[] options = {"rock", "paper", "scissors"};
            String computer = options[random.nextInt(options.length)];
            System.out.println("Computer chose: " + computer);

            if (user.equals(computer)) {
                System.out.println("It's a draw!");
            } else if ((user.equals("rock") && computer.equals("scissors"))
                    || (user.equals("paper") && computer.equals("rock"))
                    || (user.equals("scissors") && computer.equals("paper"))) {
                System.out.println("You win this round!");
                userScore++;
            } else {
                System.out.println("Computer wins this round.");
                computerScore++;
            }
            System.out.println("Score — You: " + userScore + " | Computer: " + computerScore);
        }

        if (userScore == 3) {
            System.out.println("\nCongratulations! You won the game.");
        } else if (computerScore == 3) {
            System.out.println("\nComputer won the game. Try again!");
        } else {
            System.out.println("\nGame ended.");
        }
        sc.close();
    }
}
