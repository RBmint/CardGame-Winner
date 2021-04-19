package Tests;

import Card.Card;
import Game.Game;
import Game.SinglePlay;

import GameInterface.CardConstants;
import Player.Player;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit tests for Game class
 */
class GameTest implements CardConstants {

    /**
     * testing dealCardsToPlayers()
     */
    @Test
    void dealCardsToPlayers() {
        Game g = new Game();
        assertEquals(18, g.getCurrentPlayingPlayer().getNumCardInHand());
    }

    /**
     * testing addToLastPlay()
     */
    @Test
    void addToLastPlay() {
        Game g = new Game();
        SinglePlay testPlay = new SinglePlay(STARTING_CARD, "TEST player");
        g.addToLastPlay(testPlay);
        assertEquals(testPlay, g.getLastPlay());
    }

    /**
     * testing getLastPlay()
     */
    @Test
    void getLastPlay() {
        Game g = new Game();
        SinglePlay test_player = new SinglePlay(STARTING_CARD, "TEST player");
        g.addToLastPlay(test_player);
        assertEquals(test_player, g.getLastPlay());
    }

    /**
     * testing printCurrentPlayingPlayer()
     */
    @Test
    void printCurrentPlayingPlayer() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Game g = new Game();
        g.printCurrentPlayingPlayer();
        String curPlayerName = g.getCurrentPlayingPlayer().getPlayerName();
        String expectedOutput = curPlayerName + "'s Turn\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    /**
     * testing getCurrentPlayingPlayer()
     */
    @Test
    void getCurrentPlayingPlayer() {
        Game g = new Game();
        assertNotNull(g.getCurrentPlayingPlayer().getPlayerName());
    }

    /**
     * testing removeMultipleFromPlayer()
     */
    @Test
    void removeMultipleFromPlayer() {
        Game g = new Game();
        Player currentPlayer = g.getCurrentPlayingPlayer();
        Card first = currentPlayer.getCardByIndex(1);
        Card second = currentPlayer.getCardByIndex(2);
        Card[] toRemove = new Card[]{first, second};
        g.removeMultipleFromPlayer(toRemove);
        assertEquals(16, currentPlayer.getAllCards().size());
    }

    /**
     * testing removeSingleFromPlayer()
     */
    @Test
    void removeSingleFromPlayer() {
        Game g = new Game();
        Player currentPlayer = g.getCurrentPlayingPlayer();
        Card toRemove = currentPlayer.getAllCards().peek();
        g.removeSingleFromPlayer(toRemove);
        assertEquals(17, currentPlayer.getAllCards().size());
    }

    /**
     * testing skipCurrentPlayerTurn()
     */
    @Test
    void skipCurrentPlayerTurn() {
        Game g = new Game();
        Player nextPlayer = g.getNextPlayer();
        g.skipCurrentPlayerTurn();
        Player skippedTo = g.getCurrentPlayingPlayer();
        assertSame(nextPlayer, skippedTo);
    }

    /**
     * testing getNextPlayer()
     */
    @Test
    void getNextPlayer() {
        Game g = new Game();
        assertNotNull(g.getNextPlayer());
        Player nextPlayer = g.getNextPlayer();
        g.skipCurrentPlayerTurn();
        assertSame(nextPlayer, g.getCurrentPlayingPlayer());
    }

    /**
     * testing isOver()
     */
    @Test
    void isOver() {
        Game g = new Game();
        assertFalse(g.isOver());
    }
}