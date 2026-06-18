import javax.swing.*;
import java.util.Random;

public class GuessTheNumberGame {

    public static void main(String[] args) {

        Random random = new Random();
        int totalScore = 0;
        int totalRounds = 3;

        JOptionPane.showMessageDialog(
                null,
                "Welcome to Guess The Number Game!\n" +
                        "Guess a number between 1 and 100.\n" +
                        "You have 10 attempts per round.");

        for (int round = 1; round <= totalRounds; round++) {

            int secretNumber = random.nextInt(100) + 1;
            int attemptsLeft = 10;
            boolean guessedCorrectly = false;

            while (attemptsLeft > 0) {

                String input = JOptionPane.showInputDialog(
                        null,
                        "Round: " + round +
                                "\nAttempts Left: " + attemptsLeft +
                                "\nEnter your guess:");

                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Game Closed!");
                    System.exit(0);
                }

                int guess;

                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Please enter a valid number!");
                    continue;
                }

                if (guess == secretNumber) {

                    guessedCorrectly = true;

                    int roundScore = attemptsLeft * 10;
                    totalScore += roundScore;

                    JOptionPane.showMessageDialog(
                            null,
                            "Correct!\n" +
                                    "You guessed the number.\n" +
                                    "Round Score: " + roundScore);

                    break;

                } else if (guess < secretNumber) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Too Low! Try a bigger number.");

                } else {

                    JOptionPane.showMessageDialog(
                            null,
                            "Too High! Try a smaller number.");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                JOptionPane.showMessageDialog(
                        null,
                        "Out of Attempts!\n" +
                                "The correct number was: " + secretNumber);
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Game Over!\n" +
                        "Your Total Score: " + totalScore);
    }
}