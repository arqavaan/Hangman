package game;

/**
 * Created by Mehrdad on 11/6/16.
 */
public class Game {

    private int mMaxMisses;

    private String mAnswer;

    private String mMiss;

    private String mHit;


    public Game(String answer, int maxMisses) {
        this.mAnswer = answer.toLowerCase();
        this.mMaxMisses = maxMisses;
        this.mHit = "";
        this.mMiss = "";
    }


    public String getmAnswer() {
        return mAnswer;
    }

    public boolean applyGuess(String letters) {

        if (letters.length() == 0) {
            throw new IllegalArgumentException("Not letter found! ");
        }
        return applyGuess(letters.charAt(0));
    }

    /**
     * if guess be correct add to mHts else add to mMiss
     *
     * @param letter
     * @return boolean that shows guess letter is accepted or not
     */
    private boolean applyGuess(char letter) {
        letter = validateGuess(letter);
        if (mAnswer.indexOf(letter) >= 0) {
            mHit += letter;

            return true;
        } else {
            mMiss += letter;
            return false;
        }

    }


    // TODO check the input is a letter or number
    //  and check char user guess is duplicate or not
    private char validateGuess(char letter) {

        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if (mMiss.indexOf(letter) >= 0 || mHit.indexOf(letter) >= 0) {
            throw new IllegalArgumentException(letter + " has already beed guessd");
        }
        return letter;
    }


    /**
     * @return the progress of the word
     * for first time it shoud be --------
     */
    public String getCurrentPorgress() {


        String progress = "";

        for (char letter : mAnswer.toLowerCase().toCharArray()) {
            char display = '-';
            letter = Character.toLowerCase(letter);
            if (mHit.indexOf(letter) >= 0) {
                display = letter;
            }
            progress += display;
        }

        return progress;

    }


    /**
     * @return number of try user has
     */
    public int getRemainTries() {
        return mMaxMisses - mMiss.length();
    }


    //TODO check game is solve?!
    public boolean isSolved() {

        return getCurrentPorgress().indexOf('-')== -1 ;
    }

}
