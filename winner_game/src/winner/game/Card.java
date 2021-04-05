package winner.game;

/**
 * This class is in charge of constructing an arbitrary card in standard poker deck.
 */
public class Card implements CardConstants {
    private int facialValue;
    private int actualValue;
    private int suit;

    /**
     * Create a card based on facial value and suit.
     * The actual value is assigned based on facial value.
     * @param facialValue facial value of the card
     * @param actualValue actual value of the card
     * @param suit suit of the card
     */
    public Card(int facialValue, int actualValue, int suit) {
        this.facialValue = facialValue;
        this.actualValue = actualValue;
        this.suit = suit;
    }

    /**
     * Get the actual value of the card.
     * @return actual value of the card.
     */
    public int getActualValue() {
        return actualValue;
    }

    /**
     * Get the suit of the card.
     * @return suit of the card.
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Get the facial value of the card.
     * @return facial value of the card.
     */
    public int getFacialValue() {
        return facialValue;
    }
}
