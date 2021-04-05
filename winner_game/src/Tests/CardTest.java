package Tests;

import org.junit.Test;
import Card.Card;
import GameInterface.CardConstants;

import static org.junit.Assert.assertEquals;

public class CardTest {
    @Test
    public void testActualValue() {
        Card card = new Card(3, 3, CardConstants.HEARTS);
        assertEquals(3, card.getActualValue());
    }

    @org.junit.jupiter.api.Test
    void testSuit() {
        Card card = new Card(3, 3, CardConstants.HEARTS);
        assertEquals(CardConstants.HEARTS, card.getSuit());
    }

    @org.junit.jupiter.api.Test
    void testFacialValue() {
        Card card = new Card(3, 3, CardConstants.HEARTS);
        assertEquals(3, card.getFacialValue());
    }
}
