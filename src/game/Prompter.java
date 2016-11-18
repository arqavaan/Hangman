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
    public void playGame(){

    }


    /**
     *  get char from user and check if is hit or miss
     */
    public boolean promptForGuess() {

        System.out.print("Enter a letter : ");
        Scanner scanner = new Scanner(System.in);
        char guess = scanner.next().charAt(0);
        return mGame.applyGuess(guess);

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
