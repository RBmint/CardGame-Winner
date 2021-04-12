package Player;

import Card.Card;
import Game.SinglePlay;

public class BasicAI extends Player {
    /**
     * The constructor is the same as in class Player.
     * @param newName the name of the AI player
     * @param isAI usually set to true because it is an AI player.
     */
    public BasicAI(String newName, boolean isAI) {
        super(newName, isAI);
    }

    /**
     * The AI will search his hand and play a valid set of cards based on
     * last play. The basic AI will only respond to single, pair, and three
     * of a kind. For other combinations, the AI will simply choose to skip
     * a turn.
     * @param lastPlay last set of cards played
     * @return an array of integer representing the card's index
     */
    @Override
    public int[] playAHand(SinglePlay lastPlay) {
        if (lastPlay.getPlayerName().equals(STARTING_PLAYER) || lastPlay.getPlayerName().equals(getPlayerName())) {
            return playFreely();
        }
        if (lastPlay.getComboType().getType().equals(SINGLE)) {
            return playSingle(lastPlay);
        }
        if (lastPlay.getComboType().getType().equals(PAIR)) {
            if (hasAPair()) {
                return playAPair(lastPlay);
            }
            return SKIP_TURN;
        }
        if (lastPlay.getComboType().getType().equals(THREE_OF_A_KIND)) {
            if (hasThreeOfAKind()) {
                return playThreeOfAKind(lastPlay);
            }
            return SKIP_TURN;
        }
        return SKIP_TURN;
    }

    /**
     * If the AI is the first player in the game to play or if
     * both opponents choose to skip and the AI can play freely.
     * The basic AI will simply choose to play his first card
     * as a single.
     * @return
     */
    public int[] playFreely() {
        return new int[]{1};
    }

    /**
     * The AI searches his hand and always try to play a card when possible.
     * @param lastPlay the last set of cards played
     * @return an array of integer representing a single card, or skip turn.
     */
    public int[] playSingle(SinglePlay lastPlay) {
        for(int i = 0; i < getAllCards().size(); i++) {
            SinglePlay thisPlay = new SinglePlay(new Card[]{getAllCards().get(i)}, getPlayerName());
            if (thisPlay.compareSingle(lastPlay)) {
                /*Index start from 0, but 0 means to skip turn in the game */
                return new int[]{i + 1};
            };
        }
        return SKIP_TURN;
    }

    /**
     * The AI searches his hand for a valid pair.
     * @return true if he has a pair, false otherwise
     */
    public boolean hasAPair() {
        if (getAllCards().size() >= 2) {
            for (int i = 0; i < getAllCards().size() - 1; i++) {
                if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * The AI searches his hand for a valid three of a kind.
     * @return true if he has three of a kind, false otherwise
     */
    public boolean hasThreeOfAKind() {
        if (getAllCards().size() >= 3) {
            for (int i = 0; i < getAllCards().size() - 2; i++) {
                if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue() &&
                        getAllCards().get(i).getFacialValue() == getAllCards().get(i + 2).getFacialValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * The AI will always try to play a pair if it is possible.
     * @param lastPlay the last set of cards played
     * @return an array of integer representing a pair, or skip turn.
     */
    public int[] playAPair(SinglePlay lastPlay) {
        for (int i = 0; i < getAllCards().size() - 1; i++) {
            if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue()) {
                SinglePlay thisPlay = new SinglePlay(
                        new Card[]{getAllCards().get(i), getAllCards().get(i + 1)}, getPlayerName());
                if (thisPlay.compareCanBePlayed(lastPlay)) {
                    return new int[]{i + 1, i + 2};
                };
            }
        }
        return SKIP_TURN;
    }

    /**
     * The AI will always try to play three of a kind if it is possible.
     * @param lastPlay the last set of cards played
     * @return an array of integer representing three of a kind, or skip turn.
     */
    public int[] playThreeOfAKind(SinglePlay lastPlay) {
        for (int i = 0; i < getAllCards().size() - 2; i++) {
            if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue() &&
                    getAllCards().get(i).getFacialValue() == getAllCards().get(i + 2).getFacialValue()) {
                SinglePlay thisPlay = new SinglePlay(
                        new Card[]{getAllCards().get(i), getAllCards().get(i + 1), getAllCards().get(i + 2)},
                        getPlayerName());
                if (thisPlay.compareCanBePlayed(lastPlay)) {
                    return new int[]{i + 1, i + 2, i + 3};
                }
            }
        }
        return SKIP_TURN;
    }
}

