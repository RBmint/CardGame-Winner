package Player;

import Game.SinglePlay;
import Card.Card;

import java.util.Collections;
import java.util.LinkedList;

public class MediumAI extends BasicAI {

    /**
     * The constructor is the same as in class Player.
     * @param newName the name of the AI player
     * @param isAI usually set to true because it is an AI player.
     */
    public MediumAI(String newName, boolean isAI) {
        super(newName, isAI);
    }

    /**
     * The AI will search his hand and play a valid set of cards based on
     * last play. The medium AI will respond to most card combinations except
     * consecutive pairs and straight flush. For those combinations,
     * the AI will simply choose to skip a turn.
     * @param lastPlay last set of cards played
     * @return a SinglePlay object representing the play he tries to make
     */
    @Override
    public SinglePlay playAHand(SinglePlay lastPlay) {
        SinglePlay bestPlay = super.playAHand(lastPlay);
        if (bestPlay != null) {
            return bestPlay;
        }
        if (lastPlay.getComboType().getType().equals(STRAIGHT)) {
            if (hasStraight()) {
                return playStraight(lastPlay);
            }
        }
        if (lastPlay.getComboType().getType().equals(FULL_HOUSE)) {
            if (hasFullHouse()) {
                return playFullHouse(lastPlay);
            }
        }
        if (hasABomb()) {
            playABomb(lastPlay);
        }
        System.out.println("The Medium AI does not have any card combination that is playable");
        return null;
    }

    /**
     * Compare if this play, while beating the last play, is being the best play.
     * If the best play would beat this play, then this play is the best play.
     * @param bestPlay the best play
     * @param thisPlay current play
     * @param lastPlay last play
     * @return the best play
     */
    public SinglePlay compareBestPlay(SinglePlay bestPlay, SinglePlay thisPlay, SinglePlay lastPlay) {
        if (thisPlay.compareCanBePlayed(lastPlay)) {
            if (bestPlay == null || bestPlay.compareCanBePlayed(thisPlay)) {
                return thisPlay;
            }
        }
        return bestPlay;
    }

    /**
     * If the AI is the first player in the game to play or if
     * both opponents choose to skip and the AI can play freely.
     * The medium AI will choose to play his smallest card in hand
     * in full, that is, if he has a pair, he will play a pair and same
     * for three of a kind. However, he will save the bomb for later.
     * @return the play that the AI will make
     */
    @Override
    public SinglePlay playFreely() {
        for (int i = 0; i < getAllCards().size(); i++) {
            if (getAllCards().get(i).getFacialValue() <= 2) {
                continue;
            }
            if (i + 3 < getAllCards().size()) {
                if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue()
                && getAllCards().get(i).getFacialValue() == getAllCards().get(i + 2).getFacialValue()) {
                    if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 3).getFacialValue()) {
                        i += 3;
                    } else {
                        Card fakeTwo = new Card(2, 2, SPADES);
                        SinglePlay fake = new SinglePlay(new Card[]{fakeTwo, fakeTwo, fakeTwo}, "faker");
                        System.out.println("The Medium AI can play freely and his smallest hand is three of a kind.");
                        return playThreeOfAKind(fake);
                    }
                }
            }
            if (i + 2 < getAllCards().size()) {
                if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue()
                        && getAllCards().get(i).getFacialValue() != getAllCards().get(i + 2).getFacialValue()) {
                    Card fakeTwo = new Card(2,2, SPADES);
                    SinglePlay fake = new SinglePlay(new Card[]{fakeTwo, fakeTwo}, "faker");
                    System.out.println("The Medium AI can play freely and his smallest hand is a pair.");
                    return playAPair(fake);
                }
            }
            System.out.println("The Medium AI can play freely and his smallest hand is a single.");
            return new SinglePlay(new Card[]{getAllCards().get(i + 1)}, getPlayerName());

        }
        System.out.println("The Medium AI can play freely and his smallest hand is an ACE/BIG TWO.");
        return new SinglePlay(new Card[]{getAllCards().get(0)}, getPlayerName());
    }


    /**
     * The AI searches his hand and always try to play a smallest card when possible.
     * @param lastPlay the last set of cards played
     * @return a SinglePlay object representing a single card, null to skip turn.
     */
    @Override
    public SinglePlay playSingle(SinglePlay lastPlay) {
        SinglePlay bestPlay = null;
        for(int i = 0; i < getAllCards().size(); i++) {
            SinglePlay thisPlay = new SinglePlay(new Card[]{getAllCards().get(i)}, getPlayerName());
            bestPlay = compareBestPlay(bestPlay, thisPlay, lastPlay);
        }
        if (bestPlay == null) {
            System.out.println("The Medium AI does not have a bigger hand and choose to skip his turn.");
        } else {
            System.out.println("The Medium AI will find the smallest single in his hand that beats the last play.");
        }
        return bestPlay;
    }

    /**
     * The AI will always try to play a smallest pair if it is possible.
     * @param lastPlay the last set of cards played
     * @return a SinglePlay object representing a pair, or skip turn.
     */
    @Override
    public SinglePlay playAPair(SinglePlay lastPlay) {
        SinglePlay bestPlay = null;
        for (int i = 0; i < getAllCards().size() - 1; i++) {
            if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue()) {
                SinglePlay thisPlay = new SinglePlay(
                        new Card[]{getAllCards().get(i), getAllCards().get(i + 1)}, getPlayerName());
                bestPlay = compareBestPlay(bestPlay, thisPlay, lastPlay);
            }
        }
        if (bestPlay == null) {
            System.out.println("The Medium AI does not have a bigger hand and choose to skip his turn.");
        } else {
            System.out.println("The Medium AI will find the smallest pair in his hand that beats the last play.");
        }
        return bestPlay;
    }

    /**
     * The AI will always try to play a smallest three of a kind if it is possible.
     * @param lastPlay the last set of cards played
     * @return a SinglePlay object representing three of a kind, or skip turn.
     */
    @Override
    public SinglePlay playThreeOfAKind(SinglePlay lastPlay) {
        SinglePlay bestPlay = null;
        for (int i = 0; i < getAllCards().size() - 2; i++) {
            if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue() &&
                    getAllCards().get(i).getFacialValue() == getAllCards().get(i + 2).getFacialValue()) {
                SinglePlay thisPlay = new SinglePlay(
                        new Card[]{getAllCards().get(i), getAllCards().get(i + 1), getAllCards().get(i + 2)},
                        getPlayerName());
                bestPlay = compareBestPlay(bestPlay, thisPlay, lastPlay);
            }
        }
        if (bestPlay == null) {
            System.out.println("The Medium AI does not have a bigger hand and choose to skip his turn.");
        } else {
            System.out.println("The Medium AI will find the smallest " +
                    "three of a kind in his hand that beats the last play.");
        }
        return bestPlay;
    }

    /**
     * The AI searches his hand for a valid straight.
     * @return true if he has a straight, false otherwise
     */
    public boolean hasStraight() {
        LinkedList<Integer> value = getLinkedListFromCards();
        for (int i = 0; i < value.size(); i++) {
            int maxStraightLength = 1;
            for (int j = 0; j < value.size() - i - 1; j++) {
                if (value.get(i + j) + 1 == value.get(i + j + 1)) {
                    maxStraightLength++;
                } else {
                    break;
                }
            }
            if (maxStraightLength >= 5) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper function to convert the card array to a linked list
     * with unique integer values for straight detection.
     * @return the linked list converted
     */
    public LinkedList<Integer> getLinkedListFromCards() {
        LinkedList<Integer> value = new LinkedList<>();
        for (Card card : getAllCards()) {
            if (!value.contains(card.getFacialValue())) {
                value.add(card.getFacialValue());
            }
        }
        if (value.contains(1)) {
            value.add(14);
        }
        Collections.sort(value);
        return value;
    }

    /**
     * The AI will always try to play a smallest straight if it is possible.
     * @param lastPlay the last set of cards played
     * @return a SinglePlay object representing a straight, or skip turn.
     */
    public SinglePlay playStraight(SinglePlay lastPlay) {
        SinglePlay bestPlay = null;
        if (lastPlay.getComboType().getTopCard() == 14) {
            return null;
        }
        int straightLength = lastPlay.getCards().length;
        for (int i = 0; i < getAllCards().size() - straightLength + 1; i++) {
            Card[] straight = new Card[straightLength];
            straight[0] = getAllCards().get(i);
            for (int j = 1; j < straightLength; j++) {
                for (int k = i; k < getAllCards().size() - straightLength + 1; k++) {
                    if (getAllCards().get(j + k).getFacialValue() == straight[j - 1].getFacialValue()) {
                        continue;
                    }
                    straight[j] = getAllCards().get(j + k);
                    break;
                }
            }
            SinglePlay thisPlay = new SinglePlay(straight, getPlayerName());
            bestPlay = compareBestPlay(bestPlay, thisPlay, lastPlay);
        }
        if (bestPlay == null) {
            System.out.println("The Medium AI does not have a bigger hand and choose to skip his turn.");
        } else {
            System.out.println("The Medium AI will find the smallest straight in his hand that beats the last play.");
        }
        return bestPlay;
    }

    /**
     * The AI searches his hand for a valid full house.
     * @return true if he has a full house, false otherwise
     */
    public boolean hasFullHouse() {
        if (hasThreeOfAKind()) {
            for (int i = 0; i < getAllCards().size() - 2; i++) {
                if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue()) {
                    if (getAllCards().get(i + 1) != getAllCards().get(i + 2)) {
                        return true;
                    } else {
                        i+=2;
                    }
                }
            }
        }
        return false;
    }

    /**
     * The AI will always try to play a full house if it is possible.
     * @param lastPlay the last set of cards played
     * @return a SinglePlay object representing a full house, or skip turn.
     */
    public SinglePlay playFullHouse(SinglePlay lastPlay) {
        SinglePlay bestPlay = null;
        for (int i = 0; i < getAllCards().size() - 2; i++) {
            Card[] fullHouse = new Card[5];
            if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue() &&
                    getAllCards().get(i).getFacialValue() == getAllCards().get(i + 2).getFacialValue()) {
                fullHouse[0] = getAllCards().get(i);
                fullHouse[1] = getAllCards().get(i + 1);
                fullHouse[2] = getAllCards().get(i + 2);
                for (int j = 0; j < getAllCards().size() - 2; j++) {
                    if (getAllCards().get(j).getFacialValue() == getAllCards().get(j + 1).getFacialValue()) {
                        if (getAllCards().get(j + 1) != getAllCards().get(j + 2)
                                && getAllCards().get(j + 1).getFacialValue() != 2) {
                            fullHouse[3] = getAllCards().get(j);
                            fullHouse[4] = getAllCards().get(j + 1);
                            break;
                        }
                    }
                }
                SinglePlay thisPlay = new SinglePlay(fullHouse, getPlayerName());
                bestPlay = compareBestPlay(bestPlay, thisPlay, lastPlay);
            }
        }
        if (bestPlay == null) {
            System.out.println("The Medium AI does not have a bigger hand and choose to skip his turn.");
        } else {
            System.out.println("The Medium AI will find the smallest full house in his hand that beats the last play.");
        }
        return bestPlay;
    }

    /**
     * The AI searches his hand for a valid bomb.
     * @return true if he has a bomb, false otherwise
     */
    public boolean hasABomb() {
        for (int i = 0; i < getAllCards().size() - 3; i++) {
            int bombValue = getAllCards().get(i).getFacialValue();
            boolean bombFlag = true;
            for (int j = 0; j < 4; j++) {
                if (getAllCards().get(i + j).getFacialValue() != bombValue) {
                    bombFlag = false;
                }
            }
            if (bombFlag) {
                return true;
            }
        }
        return false;
    }

    /**
     * The AI will always try to play a bomb if it is possible.
     * @param lastPlay the last set of cards played
     * @return a SinglePlay object representing a bomb, or skip turn.
     */
    public SinglePlay playABomb(SinglePlay lastPlay) {
        for (int i = 0; i < getAllCards().size() - 3; i++) {
            Card[] bomb = new Card[4];
            for (int j = 0; j < 4; j++) {
                bomb[j] = getAllCards().get(i + j);
            }
            SinglePlay thisPlay = new SinglePlay(bomb, getPlayerName());
            if (thisPlay.compareCanBePlayed(lastPlay)) {
                System.out.println("The Medium AI does not have a matching combotype, but he has a BOMB!");
                return thisPlay;
            }
        }
        System.out.println("The Medium AI does not have a bigger bomb and chooses to skip his turn.");
        return null;
    }
}
