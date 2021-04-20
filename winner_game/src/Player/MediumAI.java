package Player;

import Game.SinglePlay;
import Card.Card;

import java.util.Collections;
import java.util.LinkedList;

public class MediumAI extends BasicAI {

    public MediumAI(String newName, boolean isAI) {
        super(newName, isAI);
    }

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
        return null;
    }

    public SinglePlay compareBestPlay(SinglePlay bestPlay, SinglePlay thisPlay, SinglePlay lastPlay) {
        if (thisPlay.compareCanBePlayed(lastPlay)) {
            if (bestPlay == null || bestPlay.compareCanBePlayed(thisPlay)) {
                return thisPlay;
            }
        }
        return bestPlay;
    }



    @Override
    public SinglePlay playFreely() {
        for (int i = 0; i < getAllCards().size(); i++) {
            if (getAllCards().get(i).getFacialValue() <= 2) {
                continue;
            }
            if (i + 3 < getAllCards().size()) {
                if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue()
                && getAllCards().get(i).getFacialValue() == getAllCards().get(i + 2).getFacialValue()
                && getAllCards().get(i).getFacialValue() != getAllCards().get(i + 3).getFacialValue()) {
                    Card fakeTwo = new Card(2,2, SPADES);
                    SinglePlay fake = new SinglePlay(new Card[]{fakeTwo, fakeTwo, fakeTwo}, "faker");
                    return playThreeOfAKind(fake);
                }
            }
            if (i + 2 < getAllCards().size()) {
                if (getAllCards().get(i).getFacialValue() == getAllCards().get(i + 1).getFacialValue()
                        && getAllCards().get(i).getFacialValue() != getAllCards().get(i + 2).getFacialValue()) {
                    Card fakeTwo = new Card(2,2, SPADES);
                    SinglePlay fake = new SinglePlay(new Card[]{fakeTwo, fakeTwo}, "faker");
                    return playAPair(fake);
                }
            }
            return new SinglePlay(new Card[]{getAllCards().get(i)}, getPlayerName());
        }
        return new SinglePlay(new Card[]{getAllCards().get(0)}, getPlayerName());
    }



    @Override
    public SinglePlay playSingle(SinglePlay lastPlay) {
        SinglePlay bestPlay = null;
        for(int i = 0; i < getAllCards().size(); i++) {
            SinglePlay thisPlay = new SinglePlay(new Card[]{getAllCards().get(i)}, getPlayerName());
            bestPlay = compareBestPlay(bestPlay, thisPlay, lastPlay);
        }
        return bestPlay;
    }

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
        return bestPlay;
    }

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
        return bestPlay;
    }

    public boolean hasStraight() {
        LinkedList<Integer> value = getLinkedListFromCards();
        for (int i = 0; i < value.size(); i++) {
            int maxStraightLength = 0;
            for (int j = 0; j < value.size() - 1; j++) {
                if (value.get(j) + 1 == value.get(j + 1)) {
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
        return bestPlay;
    }

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
                        if (getAllCards().get(j + 1) != getAllCards().get(j + 2)) {
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
        return bestPlay;
    }

    public boolean hasABomb() {
        for (int i = 0; i < getAllCards().size() - 3; i++) {
            int bombValue = getAllCards().get(i).getFacialValue();
            for (int j = 0; j < 4; j++) {
                if (getAllCards().get(i + j).getFacialValue() != bombValue) {
                    return false;
                }
            }
        }
        return true;
    }

    public SinglePlay playABomb(SinglePlay lastPlay) {
        for (int i = 0; i < getAllCards().size() - 3; i++) {
            Card[] bomb = new Card[4];
            for (int j = 0; j < 4; j++) {
                bomb[j] = getAllCards().get(i + j);
            }
            SinglePlay thisPlay = new SinglePlay(bomb, getPlayerName());
            if (thisPlay.compareCanBePlayed(lastPlay)) {
                return thisPlay;
            }
        }
        return null;
    }
}
