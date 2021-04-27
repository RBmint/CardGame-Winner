package Tests;

import Card.Card;
import GameInterface.CardConstants;
import Player.AdvancedAI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdvancedAITest {

    @Test
    void testGetNumberOfCardsByValue() {
        AdvancedAI testAI = new AdvancedAI("test", true);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card four = new Card(4,4,CardConstants.DIAMONDS);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(four);
        testAI.addCardToHand(four);
        assertEquals(4, testAI.getNumberOfCardByValue(3));
        assertEquals(2, testAI.getNumberOfCardByValue(4));
    }
}
