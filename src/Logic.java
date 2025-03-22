
import java.util.Random;

public class Logic {
    private static final String[] computerChoices = { "Scissors", "Paper", "Rock" };

    private Random random;
    private String computerChoice;
    private int computerScore, playerScore;

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public Logic() {
        random = new Random();
    }

    public String play(String playerChoice) {
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        String result;

        if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Rock")) {
                result = "Draw";
            } else if (playerChoice.equals("Paper")) {
                result = "Player Wins";
                playerScore++;
            } else {
                result = "Computer Wins";
                computerScore++;
            }
        } else if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Rock")) {
                result = "Computer Wins";
                computerScore++;
            } else if (playerChoice.equals("Paper")) {
                result = "Draw";
                playerScore++;
            } else {
                result = "Player Wins";
            }
        } else {
            if (playerChoice.equals("Rock")) {
                result = "Player Wins";
                playerScore++;
            } else if (playerChoice.equals("Paper")) {
                result = "Computer Wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        }

        return result;
    }

}