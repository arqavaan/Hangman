package game;

import java.util.Scanner;

/**
 * Created by Mehrdad on 11/6/16.
 */
public class Prompter {


    Game mGame;

    public Prompter(Game game) {
        this.mGame = game;
    }


    // TODO write play logic
    // while user has a try can play game
    public void playGame() {

        while (mGame.getRemainTries() > 0 && !mGame.isSolved()) {
            displayProgress();
            promptForGuess();
        }

        if (mGame.isSolved()) {

            System.out.printf("Congratualtions you won with %d tries remaining ", mGame.getRemainTries());
        } else {

            System.out.printf("You lose, the word was %s , \n ", mGame.getmAnswer());
        }
    }


    /**
     * get char from user and check if is hit or miss
     */
    public boolean promptForGuess() {

        System.out.print("Enter a letter : ");

        boolean isHit = false;
        boolean isValidate = false;
        while (!isValidate) {
            Scanner scanner = new Scanner(System.in);
            String guess = scanner.next();
            try {
                isHit = mGame.applyGuess(guess);
                isValidate = true;
            } catch (IllegalArgumentException ill) {
                System.out.printf("%s.  Please try again.\n", ill.getMessage());
            }

        }

        return isHit;

    }


    /**
     * show the current progress of game
     */
    public void displayProgress() {

        System.out.printf("You have %d tries left to solve: %s \n",
                mGame.getRemainTries()
                , mGame.getCurrentPorgress());
    }
}
