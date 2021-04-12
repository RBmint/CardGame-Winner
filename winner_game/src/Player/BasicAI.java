package Player;

import Card.Card;
import Game.SinglePlay;

public class BasicAI extends Player {
    /**
     * The constructor will initiate a player instance with name.
     *
     * @param newName the name to be assigned
     */
    public BasicAI(String newName, boolean isAI) {
        super(newName, isAI);
    }

    @Override
    public int[] playAHand() {

        if (hasValidCombo()) {
//            getIndexOfCardsToPlay();
        }
        return new int[]{0};
    }

    public boolean hasValidCombo() {
        return false;
    }


    public boolean hasAPair() {
        return false;
    }

    public boolean hasThreeOfAKind() {
        return false;

    }

    public boolean hasFullHouse() {
        return false;
    }

}

