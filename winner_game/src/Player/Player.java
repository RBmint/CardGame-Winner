package Player;

import Card.Card;
import GameInterface.CardConstants;
import Card.CardDeck;
import java.util.LinkedList;

/**
 * The class that are in charge of the players activities.
 * The class is built with simple get/check methods.
 */
public class Player implements CardConstants {
    private String playerName;
    private boolean isTurnToPlay = false;
    private LinkedList<Card> myCards;

    /**
     * The constructor will initiate a player instance with name.
     * @param newName the name to be assigned
     */
    public Player(String newName) {
        playerName = newName;
        myCards = new LinkedList<>();
    }

    /**
     * Switch the player's turn to play (or not).
     */
    public void switchTurn() {
        isTurnToPlay = !isTurnToPlay;
    }

    /**
     * Check if it is the current player's turn to play.
     * @return True if it is, false otherwise.
     */
    public boolean isTurnToPlay() {
        return isTurnToPlay;
    }

    /**
     * Check if player has this particular card in his hand.
     * @param thisCard the card to be checked
     * @return True if the player has it, false otherwise.
     */
    public boolean hasThisCard(Card thisCard) {
        return myCards.contains(thisCard);
    }

    /**
     * Remove a particular card from the player's hand.
     * @param thisCard the card to be removed.
     */
    public void removeCardFromHand(Card thisCard) {
        myCards.remove(thisCard);
    }

    /**
     * Get the name of the player.
     * @return name of the player.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Add a particular card to the player's hand.
     * @param card the card to be added.
     */
    public void addCardToHand(Card card) {
        myCards.add(card);
    }

    /**
     * Get the number of cards a player currently holds.
     * @return The number of cards in hand.
     */
    public int getNumCardInHand() {
        return myCards.size();
    }

    /**
     * Check if a player has any cards in hand at all.
     * @return True if he has, false otherwise.
     */
    public boolean hasCardInHand() {
        return !myCards.isEmpty();
    }

    /**
     * Get one card by the input index.
     * @param index the index of card to find.
     * @return The card that has the corresponding index.
     */
    public Card getCardByIndex(int index) {
        return myCards.get(index - 1);
    }

    /**
     * Get all cards in a player's hand.
     * @return The list of cards in a player's hand.
     */
    public LinkedList<Card> getAllCards() {
        return myCards;
    }

    /**
     * Sort the player's hand based on facial value of the card for
     * better readability and user experience.
     */
    public void sortCurrentHand() {
        LinkedList<Card> newHand = new LinkedList<>();
        CardDeck compareDeck = new CardDeck(true);
        for (Card card : compareDeck.getCardDeck()) {
            for (Card myCard : myCards) {
                if (myCard.getFacialValue() == card.getFacialValue() && myCard.getSuit() == card.getSuit()) {
                    newHand.add(myCard);
                }
            }
        }
        myCards = newHand;
    }
}
