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

    @Override
    public int[] playAHand(SinglePlay lastPlay) {
        int[] skipTurn = new int[]{0};
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
            return skipTurn;
        }
        if (lastPlay.getComboType().getType().equals(THREE_OF_A_KIND)) {
            if (hasThreeOfAKind()) {
                return playThreeOfAKind(lastPlay);
            }
            return skipTurn;
        }
        return skipTurn;
    }

    public int[] playFreely() {
        return new int[]{1};
    }

    public int[] playSingle(SinglePlay lastPlay) {
        for(int i = 0; i < getAllCards().size(); i++) {
            SinglePlay thisPlay = new SinglePlay(new Card[]{getAllCards().get(i)}, getPlayerName());
            if (thisPlay.compareSingle(lastPlay)) {
                return new int[]{i + 1};
            };
        }
        return new int[]{0};
    }

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
        return new int[] {0};
    }

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
        return new int[] {0};
    }


}

