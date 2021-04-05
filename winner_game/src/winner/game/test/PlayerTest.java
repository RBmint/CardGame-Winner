package winner.game.test;

import org.junit.jupiter.api.Test;
import winner.game.Card;
import winner.game.CardConstants;
import winner.game.Player;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testSwitchTurn() {
        Player bruceLee = new Player("Bruce Lee");
        bruceLee.switchTurn();
        assertTrue(bruceLee.isTurnToPlay());
    }

    @Test
    void testIsTurnToPlay() {
        Player bruceLee = new Player("Bruce Lee");
        assertFalse(bruceLee.isTurnToPlay());
    }

    @Test
    void testHasThisCard() {
        Player bruceLee = new Player("Bruce Lee");
        Card toAdd = new Card(3, 3, CardConstants.DIAMONDS);
        bruceLee.addCardToHand(toAdd);
        assertTrue(bruceLee.hasThisCard(toAdd));

    }

    @Test
    void testRemoveCardFromHand() {
        Player bruceLee = new Player("Bruce Lee");
        bruceLee.addCardToHand(new Card(3, 3, CardConstants.DIAMONDS));
        assertEquals(1, bruceLee.getNumCardInHand());
        bruceLee.removeCardFromHand(bruceLee.getAllCards().getFirst());
        assertEquals(0, bruceLee.getNumCardInHand());
    }

    @Test
    void testGetPlayerName() {
        Player bruceLee = new Player("Bruce Lee");
        assertEquals("Bruce Lee", bruceLee.getPlayerName());
    }

    @Test
    void addCardToHand() {
        Player bruceLee = new Player("Bruce Lee");
        assertEquals(0, bruceLee.getNumCardInHand());
        assertFalse(bruceLee.hasCardInHand());
        bruceLee.addCardToHand(new Card(3, 3, CardConstants.DIAMONDS));
        assertTrue(bruceLee.hasCardInHand());
        assertEquals(1, bruceLee.getNumCardInHand());
    }

    @Test
    void testGetNumCardInHand() {
        Player bruceLee = new Player("Bruce Lee");
        assertEquals(0, bruceLee.getNumCardInHand());
    }

    @Test
    void testHasCardInHand() {
        Player bruceLee = new Player("Bruce Lee");
        assertFalse(bruceLee.hasCardInHand());
        Card toAdd = new Card(3, 3, CardConstants.DIAMONDS);
        bruceLee.addCardToHand(toAdd);
        assertTrue(bruceLee.hasCardInHand());
    }

    @Test
    void getCardByIndex() {
        Player bruceLee = new Player("Bruce Lee");
        Card one = new Card(3, 3, CardConstants.DIAMONDS);
        Card two = new Card(4, 4, CardConstants.DIAMONDS);
        bruceLee.addCardToHand(one);
        bruceLee.addCardToHand(two);
        assertEquals(one, bruceLee.getCardByIndex(1));
        assertEquals(two, bruceLee.getCardByIndex(2));
    }

    @Test
    void getAllCards() {
        Player bruceLee = new Player("Bruce Lee");
        Card one = new Card(3, 3, CardConstants.DIAMONDS);
        Card two = new Card(4, 4, CardConstants.DIAMONDS);
        bruceLee.addCardToHand(one);
        bruceLee.addCardToHand(two);
        assertEquals(2, bruceLee.getAllCards().size());
    }

    @Test
    void sortCurrentHand() {
        Player bruceLee = new Player("Bruce Lee");
        Card three = new Card(3, 3, CardConstants.DIAMONDS);
        Card four = new Card(4, 4, CardConstants.DIAMONDS);
        Card five = new Card(5, 5, CardConstants.DIAMONDS);
        Card six = new Card(6, 6, CardConstants.DIAMONDS);
        Card seven = new Card(7, 7, CardConstants.DIAMONDS);
        Card eight = new Card(8, 8, CardConstants.DIAMONDS);
        bruceLee.addCardToHand(three);
        bruceLee.addCardToHand(four);
        bruceLee.addCardToHand(five);
        bruceLee.addCardToHand(six);
        bruceLee.addCardToHand(seven);
        bruceLee.addCardToHand(eight);
        Collections.shuffle(bruceLee.getAllCards());
        bruceLee.sortCurrentHand();
        System.out.println(bruceLee.getAllCards().getLast().getFacialValue());
        assertEquals(three, bruceLee.getAllCards().getFirst());
        assertEquals(eight, bruceLee.getAllCards().getLast());
    }
}