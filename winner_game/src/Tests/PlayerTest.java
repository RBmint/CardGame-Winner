package Tests;

import Game.Game;
import Game.SinglePlay;
import org.junit.jupiter.api.Test;
import Card.Card;
import GameInterface.CardConstants;
import Player.Player;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit tests for Player class
 */
class PlayerTest implements CardConstants{

    /**
     * testing switchTurn()
     */
    @Test
    void SwitchTurn() {
        Player bruceLee = new Player("Bruce Lee", false);
        bruceLee.switchTurn();
        assertTrue(bruceLee.isTurnToPlay());
    }

    /**
     * testing isTurnToPlay()
     */
    @Test
    void isTurnToPlay() {
        Player bruceLee = new Player("Bruce Lee", false);
        assertFalse(bruceLee.isTurnToPlay());
    }

    /**
     * testing hasThisCard()
     */
    @Test
    void hasThisCard() {
        Player bruceLee = new Player("Bruce Lee", false);
        Card toAdd = new Card(3, 3, CardConstants.DIAMONDS);
        bruceLee.addCardToHand(toAdd);
        assertTrue(bruceLee.hasThisCard(toAdd));

    }

    /**
     * testing removeCardFromHand()
     */
    @Test
    void removeCardFromHand() {
        Player bruceLee = new Player("Bruce Lee", false);
        bruceLee.addCardToHand(new Card(3, 3, CardConstants.DIAMONDS));
        assertEquals(1, bruceLee.getNumCardInHand());
        bruceLee.removeCardFromHand(bruceLee.getAllCards().getFirst());
        assertEquals(0, bruceLee.getNumCardInHand());
    }

    /**
     * testing getPlayerName()
     */
    @Test
    void getPlayerName() {
        Player bruceLee = new Player("Bruce Lee",false);
        assertEquals("Bruce Lee", bruceLee.getPlayerName());
    }

    /**
     * testing addCardToHand()
     */
    @Test
    void addCardToHand() {
        Player bruceLee = new Player("Bruce Lee", false);
        assertEquals(0, bruceLee.getNumCardInHand());
        assertFalse(bruceLee.hasCardInHand());
        bruceLee.addCardToHand(new Card(3, 3, CardConstants.DIAMONDS));
        assertTrue(bruceLee.hasCardInHand());
        assertEquals(1, bruceLee.getNumCardInHand());
    }

    /**
     * testing getNumCardInHand()
     */
    @Test
    void getNumCardInHand() {
        Player bruceLee = new Player("Bruce Lee", false);
        assertEquals(0, bruceLee.getNumCardInHand());
    }

    /**
     * testing hasCardInHand()
     */
    @Test
    void hasCardInHand() {
        Player bruceLee = new Player("Bruce Lee", false);
        assertFalse(bruceLee.hasCardInHand());
        Card toAdd = new Card(3, 3, CardConstants.DIAMONDS);
        bruceLee.addCardToHand(toAdd);
        assertTrue(bruceLee.hasCardInHand());
    }

    /**
     * testing getCardByIndex()
     */
    @Test
    void getCardByIndex() {
        Player bruceLee = new Player("Bruce Lee", false);
        Card one = new Card(3, 3, CardConstants.DIAMONDS);
        Card two = new Card(4, 4, CardConstants.DIAMONDS);
        bruceLee.addCardToHand(one);
        bruceLee.addCardToHand(two);
        assertEquals(one, bruceLee.getCardByIndex(1));
        assertEquals(two, bruceLee.getCardByIndex(2));
    }

    /**
     * testing getAllCards()
     */
    @Test
    void getAllCards() {
        Player bruceLee = new Player("Bruce Lee", false);
        Card one = new Card(3, 3, CardConstants.DIAMONDS);
        Card two = new Card(4, 4, CardConstants.DIAMONDS);
        bruceLee.addCardToHand(one);
        bruceLee.addCardToHand(two);
        assertEquals(one, bruceLee.getAllCards().getFirst());
        assertEquals(two, bruceLee.getAllCards().getLast());

    }

    /**
     * testing sortCurrentHand()
     */
    @Test
    void sortCurrentHand() {
        Player bruceLee = new Player("Bruce Lee", false);
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

    /**
     * testing isAI()
     */
    @Test
    void isAI() {
        Player testPlayer = new Player("testPlayer", false);
        assertFalse(testPlayer.isAI());
    }

    /**
     * testing playAHand()
     */
    @Test
    void playAHand() {
        Card testCard = new Card(3, 3, HEARTS);
        Card[] testCards = {testCard};
        SinglePlay testSinglePlay = new SinglePlay(testCards, "testPlayer");
        Player testPlayer = new Player("testPlayer", false);
        testPlayer.addCardToHand(testCard);
        String testInput = "1";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);
        SinglePlay actualOutput = testPlayer.playAHand(testSinglePlay);
        assertEquals(actualOutput.getCards()[0], testCard);
    }

}