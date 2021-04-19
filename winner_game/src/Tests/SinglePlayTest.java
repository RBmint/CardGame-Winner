package Tests;

import Card.Card;
import Game.SinglePlay;
import GameInterface.CardConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinglePlayTest implements CardConstants {

    @Test
    void compareCanBePlayed() {
        Card[] consPairs = {
                new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS),
                new Card(5, 5, HEARTS),
                new Card(5, 5, DIAMONDS)
        };
        Card[] consPairsCur = {
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS),
                new Card(5, 5, HEARTS),
                new Card(5, 5, DIAMONDS),
                new Card(6, 6, HEARTS),
                new Card(6, 6, DIAMONDS)
        };
        SinglePlay lastTwo = new SinglePlay(consPairs, "last");
        SinglePlay curOne = new SinglePlay(consPairsCur, "cur");
        assertTrue(curOne.compareCanBePlayed(lastTwo));

//        Card[] pair = {
//                new Card(3, 3, HEARTS),
//                new Card(3, 3, DIAMONDS)
//        };

    }

    @Test
    void compareStraightFlush() {
        Card[] straightFlushLast = {
                new Card(3, 3, HEARTS),
                new Card(4, 4, HEARTS),
                new Card(5, 5, HEARTS),
                new Card(6, 6, HEARTS),
                new Card(7, 7, HEARTS)};
        SinglePlay lastPlay = new SinglePlay(straightFlushLast, "last");
        Card[] straightFlushCur = {
                new Card(4, 4, HEARTS),
                new Card(5, 5, HEARTS),
                new Card(6, 6, HEARTS),
                new Card(7, 7, HEARTS),
                new Card(8, 8, HEARTS)};
        SinglePlay curPlay = new SinglePlay(straightFlushCur, "cur");
        assertTrue(curPlay.compareStraightFlush(lastPlay));
    }

    @Test
    void compareBomb() {
        Card[] bomb = {
                new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(3, 3, SPADES),
                new Card(3, 3, CLUBS)};
        Card[] bombTwo = {
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS),
                new Card(4, 4, SPADES),
                new Card(4, 4, CLUBS)};
        SinglePlay last = new SinglePlay(bomb, "last");
        SinglePlay cur = new SinglePlay(bombTwo, "cur");
        assertTrue(cur.compareBomb(last));
    }

    @Test
    void compareSingle() {
        Card[] singleOne = {new Card(3, 3, HEARTS)};
        Card[] singleTwo = {new Card(3, 3, SPADES)};
        Card[] singleThree = {new Card(4, 4, HEARTS)};
        SinglePlay one = new SinglePlay(singleOne, "one");
        SinglePlay two = new SinglePlay(singleTwo, "two");
        SinglePlay three = new SinglePlay(singleThree, "three");
        assertTrue(two.compareSingle(one));
        assertTrue(three.compareSingle(one));
    }

    @Test
    void getCards() {
        Card[] singleOne = {new Card(3, 3, HEARTS)};
        SinglePlay one = new SinglePlay(singleOne, "one");
        assertEquals(singleOne, one.getCards());
    }

    @Test
    void getPlayerName() {
        Card[] singleOne = {new Card(3, 3, HEARTS)};
        SinglePlay one = new SinglePlay(singleOne, "one");
        assertEquals("one", one.getPlayerName());
    }

    @Test
    void getComboType() {
        Card[] singleOne = {new Card(3, 3, HEARTS)};
        SinglePlay one = new SinglePlay(singleOne, "one");
        assertEquals(SINGLE, one.getComboType().getType());
    }
}