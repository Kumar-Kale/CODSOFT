import java.util.Scanner;
import java.util.Random;

public class GuessNumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        boolean playAgain = true;
        int totalScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int rangeStart = 1;
            int rangeEnd = 100;
            int maxAttempts = 5;
            int randomNumber = random.nextInt(rangeEnd - rangeStart + 1) + rangeStart;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.printf("\nI have chosen a number between %d and %d. You have %d attempts to guess it.\n", rangeStart, rangeEnd, maxAttempts);

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number correctly.");
                    totalScore += (maxAttempts - attempts + 1); // Higher score for fewer attempts
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.printf("Sorry, you've used all your attempts. The correct number was %d.\n", randomNumber);
            }

            System.out.printf("Your current score is: %d\n", totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.printf("\nThank you for playing! Your final score is: %d\n", totalScore);
        scanner.close();
    }
}
