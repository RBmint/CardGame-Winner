package Tests;

import Card.Card;
import Game.SinglePlay;
import GameInterface.CardConstants;
import Player.AdvancedAI;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdvancedAITest {

    /**
     * Test if the advanced AI can play the correct cards.
     */
    @Test
    void testPlayAHand() {
        AdvancedAI testAI = new AdvancedAI("test", true);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card four = new Card(4,4,CardConstants.DIAMONDS);
        Card five = new Card(5,5,CardConstants.DIAMONDS);
        SinglePlay lastPlay = new SinglePlay(new Card[] {four}, "t");
        testAI.addCardToHand(three);
        assertNull(testAI.playAHand(lastPlay));
        testAI.addCardToHand(five);
        assertEquals(5, testAI.playAHand(lastPlay).getCards()[0].getFacialValue());
    }

    /**
     * Test if the advanced AI can play the correct card combination when he can play freely.
     */
    @Test
    void testPlayFreely() {
        AdvancedAI testAI = new AdvancedAI("test", true);
        Card ace = new Card(1,1, CardConstants.SPADES);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card four = new Card(4,4,CardConstants.DIAMONDS);
        Card five = new Card(5,5, CardConstants.HEARTS);
        Card six = new Card(6,6, CardConstants.HEARTS);
        Card seven = new Card(7,7, CardConstants.HEARTS);
        Card eight = new Card(8,8, CardConstants.HEARTS);
        testAI.addCardToHand(three);
        testAI.addCardToHand(four);
        testAI.addCardToHand(five);
        testAI.addCardToHand(six);
        testAI.addCardToHand(seven);
        assertEquals(5, testAI.playFreely().getCards().length);
        testAI.addCardToHand(three);
        testAI.addCardToHand(four);
        testAI.addCardToHand(five);
        testAI.addCardToHand(six);
        testAI.addCardToHand(seven);
        testAI.sortCurrentHand();
        assertEquals(10, testAI.playFreely().getCards().length);
        testAI.addCardToHand(three);
        testAI.sortCurrentHand();
        assertEquals(5, testAI.playFreely().getCards().length);
        AdvancedAI testAI2 = new AdvancedAI("test2", true);
        testAI2.addCardToHand(three);
        assertEquals(3, testAI2.playFreely().getCards()[0].getFacialValue());
        testAI.addCardToHand(three);
        assertEquals(3, testAI2.playFreely().getCards()[0].getFacialValue());
        testAI.addCardToHand(three);
        assertEquals(3, testAI2.playFreely().getCards()[0].getFacialValue());
    }

    /**
     * Test if the number of cards returned is correct.
     */
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

    /**
     * Test if the advanced AI can play the correct straight.
     */
    @Test
    void testCheckForPossibleStraight() {
        AdvancedAI testAI = new AdvancedAI("test", true);
        Card ace = new Card(1,1, CardConstants.SPADES);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card four = new Card(4,4,CardConstants.DIAMONDS);
        Card five = new Card(5,5, CardConstants.HEARTS);
        Card six = new Card(6,6, CardConstants.HEARTS);
        Card seven = new Card(7,7, CardConstants.HEARTS);
        Card eight = new Card(8,8, CardConstants.HEARTS);
        testAI.addCardToHand(ace);
        testAI.addCardToHand(three);
        testAI.addCardToHand(five);
        assertNull(testAI.checkForPossibleStraight());
        testAI.addCardToHand(four);
        testAI.addCardToHand(six);
        testAI.addCardToHand(seven);
        testAI.addCardToHand(eight);
        testAI.sortCurrentHand();
        assertEquals(5, testAI.checkForPossibleStraight().getCards().length);
        testAI.addCardToHand(five);
        testAI.sortCurrentHand();
        assertEquals(5, testAI.checkForPossibleStraight().getCards().length);
        testAI.addCardToHand(four);
        testAI.sortCurrentHand();
        assertEquals(4, testAI.checkForPossibleStraight().getCards()[0].getFacialValue());
        testAI.addCardToHand(five);
        testAI.addCardToHand(five);
        testAI.sortCurrentHand();
        assertNull(testAI.checkForPossibleStraight());
    }

    /**
     * Test if the advanced AI can play the correct consecutive pairs.
     */
    @Test
    void testCheckForPossibleConsecutivePairs() {
        AdvancedAI testAI = new AdvancedAI("test", true);
        Card ace = new Card(1,1, CardConstants.SPADES);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card four = new Card(4,4,CardConstants.DIAMONDS);
        Card five = new Card(5,5, CardConstants.HEARTS);
        testAI.addCardToHand(ace);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(four);
        testAI.addCardToHand(four);
        testAI.addCardToHand(five);
        testAI.addCardToHand(five);
        assertEquals(6, testAI.checkForPossibleConsecutivePairs().getCards().length);
    }

    /**
     * Test if the advanced AI can play the correct full house.
     */
    @Test
    void testCheckForPossibleFullHouse() {
        AdvancedAI testAI = new AdvancedAI("test", true);
        Card ace = new Card(1,1, CardConstants.SPADES);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card four = new Card(4,4,CardConstants.DIAMONDS);
        testAI.addCardToHand(ace);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(four);
        testAI.addCardToHand(four);
        assertEquals(5, testAI.checkForPossibleFullHouse().getCards().length);
    }

    /**
     * Test if the advanced AI can play the correct three of a kind.
     */
    @Test
    void testCheckForPossibleThreeOfAKind() {
        AdvancedAI testAI = new AdvancedAI("test", true);
        Card ace = new Card(1,1, CardConstants.SPADES);
        Card three = new Card(3,3, CardConstants.SPADES);
        testAI.addCardToHand(ace);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        assertEquals(3, testAI.checkForPossibleThreeOfAKind().getCards().length);
    }

    /**
     * Test if the advanced AI can play the correct pair.
     */
    @Test
    void testCheckForPossiblePair() {
        AdvancedAI testAI = new AdvancedAI("test", true);
        Card ace = new Card(1,1, CardConstants.SPADES);
        Card three = new Card(3,3, CardConstants.SPADES);
        testAI.addCardToHand(ace);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        assertEquals(2, testAI.checkForPossiblePair().getCards().length);
    }

    /**
     * Test if the advanced AI can play the correct single.
     */
    @Test
    void testCheckForPossibleSingle() {
        AdvancedAI testAI = new AdvancedAI("test", true);
        Card ace = new Card(1,1, CardConstants.SPADES);
        Card three = new Card(3,3, CardConstants.SPADES);
        testAI.addCardToHand(ace);
        assertEquals(1, testAI.checkForSmallestSingle().getCards()[0].getFacialValue());
        testAI.addCardToHand(three);
        assertEquals(3, testAI.checkForSmallestSingle().getCards()[0].getFacialValue());
    }
}
