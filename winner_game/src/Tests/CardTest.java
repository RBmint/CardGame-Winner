package Tests;

import GameInterface.CardConstants;
import org.junit.jupiter.api.Test;
import Card.Card;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit tests for Card class
 */
public class CardTest implements CardConstants {
    /**
     * testing getActualValue()
     */
    @Test
    public void testActualValue() {
        Card card = new Card(3, 3, HEARTS);
        assertEquals(3, card.getActualValue());
    }

    /**
     * testing getSuit()
     */
    @org.junit.jupiter.api.Test
    void testSuit() {
        Card card = new Card(3, 3, HEARTS);
        assertEquals(HEARTS, card.getSuit());
    }

    /**
     * testing getFacialValue()
     */
    @org.junit.jupiter.api.Test
    void testFacialValue() {
        Card card = new Card(3, 3, HEARTS);
        assertEquals(3, card.getFacialValue());
    }
}
