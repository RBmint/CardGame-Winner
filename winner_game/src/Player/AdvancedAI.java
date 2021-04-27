package Player;

import Game.SinglePlay;
import Card.Card;

import java.util.LinkedList;

public class AdvancedAI extends MediumAI {
    /**
     * The constructor is the same as in class Player.
     * @param newName the name of the AI player
     * @param isAI usually set to true because it is an AI player.
     */
    public AdvancedAI(String newName, boolean isAI) {
        super(newName, isAI);
    }

    @Override
    public SinglePlay playAHand(SinglePlay lastPlay) {
        SinglePlay bestPlay = super.playAHand(lastPlay);
        if (bestPlay != null) {
            return bestPlay;
        }
        System.out.println("The Advanced AI cannot make any play and has to skip this turn.");
        return null;
    }

        @Override
        public SinglePlay playFreely() {
            if (checkForPossibleStraight() != null) {
                return checkForPossibleStraight();
            }
            if (checkForPossibleConsecutivePairs() != null) {
                return checkForPossibleConsecutivePairs();
            }
            if (checkForPossibleFullHouse() != null) {
                return checkForPossibleFullHouse();
            }
            if (checkForPossibleThreeOfAKind() != null) {
                return checkForPossibleThreeOfAKind();
            }
            if (checkForPossiblePair() != null) {
                return checkForPossiblePair();
            }
            return checkForSmallestSingle();
    }

    public SinglePlay checkForPossibleStraight() {
        for (int i = 0; i < getAllCards().size(); i++) {
            if (getAllCards().get(i).getFacialValue() <= 2 || getAllCards().get(i).getFacialValue() >= 10) {
                continue;
            }
            if (i + 4 >= getAllCards().size()) {
                return null;
            }
            int straightCount = 1;
            int brokenPairCount = 0;
            for (int j = i; j < getAllCards().size() - 1; j++) {
                if (getAllCards().get(j + 1).getFacialValue() - getAllCards().get(j).getFacialValue() >= 2) {
                    break;
                }
                if (getAllCards().get(j).getFacialValue() + 1 == getAllCards().get(j + 1).getFacialValue()) {
                    straightCount++;
                } else if (getNumberOfCardByValue(getAllCards().get(j).getFacialValue()) == 2) {
                    brokenPairCount++;
                } else if (getNumberOfCardByValue(getAllCards().get(j).getFacialValue()) == 4) {
                    brokenPairCount+=10;
                }
                if (straightCount == 5) {
                    break;
                }
            }
            if (straightCount == 5 && brokenPairCount <= 1) {
                Card[] straight = new Card[5];
                int index = 0;
                straight[index] = getAllCards().get(i);
                index++;
                for (int j = i + 1; j < getAllCards().size(); j++) {
                    if (getAllCards().get(j).getFacialValue() != straight[index - 1].getFacialValue()) {
                        straight[index] = getAllCards().get(j);
                        index++;
                    }
                    if (index == 5) {
                        return new SinglePlay(straight, getPlayerName());
                    }
                }
            }
        }
        return null;

    }

    public int getNumberOfCardByValue(Integer facialValue) {
        LinkedList<Integer> value = new LinkedList<>();
        for (Card card : getAllCards()) {
            value.add(card.getFacialValue());
        }
        int count = 0;
        while (value.contains(facialValue)) {
            count++;
            value.remove(facialValue);
        }
        return count;
    }

    public SinglePlay checkForPossibleConsecutivePairs() {
        int initialCardIndex = 0;
        while (getAllCards().get(initialCardIndex).getFacialValue() <= 2) {
            initialCardIndex++;
        }
        int pairsCount = 0;
        while (initialCardIndex < getAllCards().size() &&
                getNumberOfCardByValue(getAllCards().get(initialCardIndex).getFacialValue()) == 2) {
            pairsCount++;
            initialCardIndex++;
        }
        if (pairsCount >= 4) {
            initialCardIndex -= pairsCount;
            Card[] pairs = new Card[pairsCount];
            for (int i = initialCardIndex; i < initialCardIndex + pairsCount; i++) {
                pairs[i - initialCardIndex] = getAllCards().get(i);
            }
            return new SinglePlay(pairs, getPlayerName());
        }
        return null;
    }

    public SinglePlay checkForPossibleFullHouse() {
        int initialCardIndex = 0;
        while (getAllCards().get(initialCardIndex).getFacialValue() <= 2) {
            initialCardIndex++;
        }
        Card[] fullHouse = new Card[5];
        if (getNumberOfCardByValue(getAllCards().get(initialCardIndex).getFacialValue()) == 3) {
            fullHouse[0] = getAllCards().get(initialCardIndex);
            fullHouse[1] = getAllCards().get(initialCardIndex + 1);
            fullHouse[2] = getAllCards().get(initialCardIndex + 2);
            boolean hasAPair = false;
            for (int i = initialCardIndex + 3; i < getAllCards().size(); i++) {
                if (getNumberOfCardByValue(getAllCards().get(i).getFacialValue()) == 2) {
                    fullHouse[3] = getAllCards().get(i);
                    fullHouse[4] = getAllCards().get(i + 1);
                    hasAPair = true;
                    break;
                }
            }
            if (hasAPair) {
                return new SinglePlay(fullHouse, getPlayerName());
            }
        }
        return null;
    }

    public SinglePlay checkForPossibleThreeOfAKind() {
        int initialCardIndex = 0;
        while (getAllCards().get(initialCardIndex).getFacialValue() <= 2) {
            initialCardIndex++;
            System.out.println("ace = 1");
        }
        Card[] threeOfAKind = new Card[3];
        System.out.println(getAllCards().get(initialCardIndex).getFacialValue());
        if (getNumberOfCardByValue(getAllCards().get(initialCardIndex).getFacialValue()) == 3) {
            threeOfAKind[0] = getAllCards().get(initialCardIndex);
            threeOfAKind[1] = getAllCards().get(initialCardIndex + 1);
            threeOfAKind[2] = getAllCards().get(initialCardIndex + 2);
            return new SinglePlay(threeOfAKind, getPlayerName());
        }
        return null;
    }

    public SinglePlay checkForPossiblePair() {
        int initialCardIndex = 0;
        while (initialCardIndex < getAllCards().size() &&
                getAllCards().get(initialCardIndex).getFacialValue() <= 2) {
            initialCardIndex++;
        }
        Card[] pair = new Card[2];
        if (getNumberOfCardByValue(getAllCards().get(initialCardIndex).getFacialValue()) == 2) {
            pair[0] = getAllCards().get(initialCardIndex);
            pair[1] = getAllCards().get(initialCardIndex + 1);
            return new SinglePlay(pair, getPlayerName());
        }
        return null;
    }

    public SinglePlay checkForSmallestSingle() {
        int initialCardIndex = 0;
        while (initialCardIndex < getAllCards().size() &&
                getAllCards().get(initialCardIndex).getFacialValue() <= 2) {
            initialCardIndex++;
        }
        if (initialCardIndex >= getAllCards().size()) {
            return new SinglePlay(new Card[]{getAllCards().get(0)}, getPlayerName());
        }
        Card[] single = new Card[1];
        single[0] = getAllCards().get(initialCardIndex);
        return new SinglePlay(single, getPlayerName());
    }
}

