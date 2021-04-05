package Card;

import Card.Card;
import GameInterface.CardConstants;

import java.util.Collections;
import java.util.LinkedList;

/**
 * This class is responsible for initiating a card deck which consists
 * of a standard poker deck with 52 cards plus 2 jokers.
 */
public class CardDeck implements CardConstants {
    private LinkedList<Card> Cards;

    /**
     * The default constructor will create a new card deck and shuffle it
     * to be used for the game. If it is a deck used for sorting comparisons,
     * it will be initiated in facial value sorted order.
     * @param isSorting whether the deck is used for sorting
     */
    public CardDeck(boolean isSorting) {
        Cards = new LinkedList<>();
        initiateCardDeck(isSorting);
    }

    /**
     * Add number cards and two jokers into the card deck and then shuffles the deck.
     */
    private void initiateCardDeck(boolean isCompare) {
        addNumberCards();
        addJokers();
        if (!isCompare) {
            shuffleCardDeck();
            System.out.println("Deck Initiated");
        }
    }

    /**
     * Add number cards for each suit once.
     */
    public void addNumberCards() {
        for (int facial : FACIAL_VALUE) {
            for(int suit : SUIT_NAME) {
                /*ACE and BIG TWO have a higher actual value in game */
                if (facial == ACE || facial == BIG_TWO) {
                    Cards.add(new Card(facial, facial + ACTUAL_VALUE_DIFF, suit));
                } else {
                    Cards.add(new Card(facial, facial, suit));
                }
            }
        }
    }

    /**
     * Add two jokers into the deck.
     */
    public void addJokers() {
        Cards.add(new Card(JOKER_BLACK, JOKER_BLACK, JOKER));
        Cards.add(new Card(JOKER_RED, JOKER_RED, JOKER));
    }

    /**
     * Shuffle the current deck.
     */
    public void shuffleCardDeck() {
        Collections.shuffle(Cards);
    }

    /**
     * Deal one card to the player, thus remove it from the card deck.
     * @return The card going to be dealt to the player.
     */
    public Card dealOneCard() {
        return Cards.pop();
    }

    public LinkedList<Card> getCardDeck() {
        return Cards;
    }
}
