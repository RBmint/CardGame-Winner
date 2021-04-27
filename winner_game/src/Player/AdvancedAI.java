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

    /**
     * The main function designed for an advanced AI. The AI will search his hand from the
     * smallest card (skipping ACE and BIG TWOs) and try to play a straight first. If failed,
     * he will try play a consecutive pairs if the smallest card can make a pair and has
     * consecutive pairs. If not, he will search if the smallest card have three of a kind
     * and play a full house. If those combinations cannot be played, he will try three of
     * a kind, pair, and just play a single at last.
     * @return the play the advanced AI will make
     */
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

    /**
     * The advanced AI will try to play a straight consist of 5 cards when
     * over 4 of them are singles e.g. 344567 valid, 3445567 not valid. He
     * will also skip if he has a bomb e.g. 3*4444*567.
     * @return the straight play made by the advanced AI, null if not possible
     */
    public SinglePlay checkForPossibleStraight() {
        for (int i = 0; i < getAllCards().size(); i++) {
            /*Do not involve ACE and BIG TWO in a straight. Also, facial value > 10 means no possible straight */
            if (getAllCards().get(i).getFacialValue() <= 2 || getAllCards().get(i).getFacialValue() >= 10) {
                continue;
            }
            /*The rest of cards cannot make a straight since it need at least 5 cards */
            if (i + 4 >= getAllCards().size()) {
                return null;
            }
            int straightCount = 1;
            int brokenPairCount = 0;
            for (int j = i; j < getAllCards().size() - 1; j++) {
                /*If the smallest card cannot be included in the straight */
                if (getAllCards().get(j + 1).getFacialValue() - getAllCards().get(j).getFacialValue() >= 2) {
                    break;
                }
                if (getAllCards().get(j).getFacialValue() + 1 == getAllCards().get(j + 1).getFacialValue()) {
                    straightCount++;
                } else if (getNumberOfCardByValue(getAllCards().get(j).getFacialValue()) == 2) {
                    brokenPairCount++;
                } else if (getNumberOfCardByValue(getAllCards().get(j).getFacialValue()) == 4) {
                    /*We are going to break a bomb! Not good. */
                    brokenPairCount+=10;
                }
                if (straightCount == 5) {
                    break;
                }
            }
            /*The AI will break one pair at most. */
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
                        System.out.println("The Advanced AI has a good straight in hand and choose to play it first.");
                        return new SinglePlay(straight, getPlayerName());
                    }
                }
            }
        }
        return null;
    }

    /**
     * Helper function to get the number of cards given a facial value of the card.
     * @param facialValue the number of cards to get
     * @return the number of cards in hand
     */
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

    /**
     * The advanced AI will try to play consecutive pairs only if the smallest card
     * and all later cards exist in form of pairs e.g. 334455.
     * @return the consecutive pairs play that the advanced AI made, null if not possible
     */
    public SinglePlay checkForPossibleConsecutivePairs() {
        /*Do not include ACE and BIG TWO in consecutive pairs */
        int initialCardIndex = 0;
        while (initialCardIndex < getAllCards().size() &&
                getAllCards().get(initialCardIndex).getFacialValue() <= 2) {
            initialCardIndex++;
        }
        int pairsCount = 0;
        /*The pairs need to be consecutive and be pure pairs e.g. not have a three of a kind in between */
        while (initialCardIndex < getAllCards().size() &&
                getNumberOfCardByValue(getAllCards().get(initialCardIndex).getFacialValue()) == 2) {
            pairsCount++;
            initialCardIndex++;
        }
        /*We find at least two pairs that are consecutive */
        if (pairsCount >= 4) {
            initialCardIndex -= pairsCount;
            Card[] pairs = new Card[pairsCount];
            for (int i = initialCardIndex; i < initialCardIndex + pairsCount; i++) {
                pairs[i - initialCardIndex] = getAllCards().get(i);
            }
            System.out.println("The Advanced AI has a good consecutive pairs in hand and choose to play it first.");
            return new SinglePlay(pairs, getPlayerName());
        }
        return null;
    }

    /**
     * The advanced AI will try to play a full house if the smallest card is in form of
     * a three of a kind and he has another unique pair.
     * @return the full house play made by the AI, null if not possible
     */
    public SinglePlay checkForPossibleFullHouse() {
        /*Do not include ACE and BIG TWO in full house */
        int initialCardIndex = 0;
        while (initialCardIndex < getAllCards().size() &&
                getAllCards().get(initialCardIndex).getFacialValue() <= 2) {
            initialCardIndex++;
        }
        Card[] fullHouse = new Card[5];
        /*Find a three of a kind first */
        if (getNumberOfCardByValue(getAllCards().get(initialCardIndex).getFacialValue()) == 3) {
            fullHouse[0] = getAllCards().get(initialCardIndex);
            fullHouse[1] = getAllCards().get(initialCardIndex + 1);
            fullHouse[2] = getAllCards().get(initialCardIndex + 2);
            boolean hasAPair = false;
            for (int i = initialCardIndex + 3; i < getAllCards().size(); i++) {
                /*Then find a unique pair */
                if (getNumberOfCardByValue(getAllCards().get(i).getFacialValue()) == 2) {
                    fullHouse[3] = getAllCards().get(i);
                    fullHouse[4] = getAllCards().get(i + 1);
                    hasAPair = true;
                    break;
                }
            }
            if (hasAPair) {
                System.out.println("The Advanced AI has a full house in hand and choose to play it first.");
                return new SinglePlay(fullHouse, getPlayerName());
            }
        }
        return null;
    }

    /**
     * The advanced AI will try to play a three of a kind if the smallest card is in form of
     * a three of a kind.
     * @return the three of a kind play made by the AI, null if not possible
     */
    public SinglePlay checkForPossibleThreeOfAKind() {
        /*Do not include ACE and BIG TWO in three of a kind */
        int initialCardIndex = 0;
        while (initialCardIndex < getAllCards().size() &&
                getAllCards().get(initialCardIndex).getFacialValue() <= 2) {
            initialCardIndex++;
        }
        Card[] threeOfAKind = new Card[3];
        if (getNumberOfCardByValue(getAllCards().get(initialCardIndex).getFacialValue()) == 3) {
            threeOfAKind[0] = getAllCards().get(initialCardIndex);
            threeOfAKind[1] = getAllCards().get(initialCardIndex + 1);
            threeOfAKind[2] = getAllCards().get(initialCardIndex + 2);
            System.out.println("The Advanced AI has a three of a kind but no pairs in hand.");
            return new SinglePlay(threeOfAKind, getPlayerName());
        }
        return null;
    }

    /**
     * The advanced AI will try to play a pair if the smallest card is in form of a pair.
     * @return the pair play made by the AI, null if not possible
     */
    public SinglePlay checkForPossiblePair() {
        /*Do not include ACE and BIG TWO in a pair */
        int initialCardIndex = 0;
        while (initialCardIndex < getAllCards().size() &&
                getAllCards().get(initialCardIndex).getFacialValue() <= 2) {
            initialCardIndex++;
        }
        Card[] pair = new Card[2];
        if (getNumberOfCardByValue(getAllCards().get(initialCardIndex).getFacialValue()) == 2) {
            pair[0] = getAllCards().get(initialCardIndex);
            pair[1] = getAllCards().get(initialCardIndex + 1);
            System.out.println("The Advanced AI has a small pair in his hand and cannot make other combinations.");
            return new SinglePlay(pair, getPlayerName());
        }
        return null;
    }

    /**
     * The advanced AI will try to play a single if all other combinations failed.
     * @return the single played by the AI
     */
    public SinglePlay checkForSmallestSingle() {
        /*Skip ACE and BIG TWO initially */
        int initialCardIndex = 0;
        while (initialCardIndex < getAllCards().size() &&
                getAllCards().get(initialCardIndex).getFacialValue() <= 2) {
            initialCardIndex++;
        }
        /*If the AI has only ACE/BIG TWO in hand, play it */
        if (initialCardIndex >= getAllCards().size()) {
            System.out.println("The Advanced AI played his smallest card in hand. Warning!");
            return new SinglePlay(new Card[]{getAllCards().get(0)}, getPlayerName());
        }
        Card[] single = new Card[1];
        single[0] = getAllCards().get(initialCardIndex);
        System.out.println("The Advanced AI has nothing but a small single card to play.");
        return new SinglePlay(single, getPlayerName());
    }
}

