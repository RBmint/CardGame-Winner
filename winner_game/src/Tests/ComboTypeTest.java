package Tests;

import Card.Card;
import Game.ComboType;
import GameInterface.CardConstants;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ComboTypeTest implements CardConstants{

    @Test
    void isSingle() {
        Card[] single = {new Card(3, 3, HEARTS)};
        assertTrue(ComboType.isSingle(single));
        Card[] multi = {new Card(3, 3, HEARTS), new Card(4, 4, HEARTS)};
        assertFalse(ComboType.isSingle(multi));
    }

    @Test
    void isPair() {
        Card[] single = {new Card(3, 3, HEARTS)};
        assertFalse(ComboType.isPair(single));
        Card[] pairOne = {new Card(3, 3, HEARTS), new Card(4, 4, HEARTS)};
        assertFalse(ComboType.isPair(pairOne));
        Card[] pairTwo = {new Card(3, 3, HEARTS), new Card(3, 3, DIAMONDS)};
        assertTrue(ComboType.isPair(pairTwo));

    }

    @Test
    void isThreeOfAKind() {
        Card[] single = {new Card(3, 3, HEARTS)};
        assertFalse(ComboType.isThreeOfAKind(single));
        Card[] threeOne =
                {new Card(3, 3, HEARTS),
                new Card(4, 4, HEARTS),
                new Card(5, 5, HEARTS)};
        assertFalse(ComboType.isThreeOfAKind(threeOne));
        Card[] threeTwo =
                {new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(3, 3, SPADES)};
        assertTrue(ComboType.isThreeOfAKind(threeTwo));
    }

    @Test
    void isConsecutivePairs() {
        Card[] one = {new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS)};
        assertTrue(ComboType.isConsecutivePairs(one));
        Card[] two = {new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS),
                new Card(5, 5, HEARTS),
                new Card(6, 6, DIAMONDS)};
        assertFalse(ComboType.isConsecutivePairs(two));
        Card[] three = {new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS),
                new Card(5, 5, HEARTS),
                new Card(5, 5, DIAMONDS)};
        assertTrue(ComboType.isConsecutivePairs(three));
        Card[] four = {new Card(11, 11, HEARTS),
                new Card(11, 11, DIAMONDS),
                new Card(12, 12, HEARTS),
                new Card(12, 12, DIAMONDS),
                new Card(13, 13, HEARTS),
                new Card(13, 13, DIAMONDS),
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS)};
        assertTrue(ComboType.isConsecutivePairs(four));
        Card[] five = {new Card(10, 10, HEARTS),
                new Card(10, 10, DIAMONDS),
                new Card(12, 12, HEARTS),
                new Card(12, 12, DIAMONDS),
                new Card(13, 13, HEARTS),
                new Card(13, 13, DIAMONDS),
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS)};
        assertFalse(ComboType.isConsecutivePairs(five));
        Card[] six = {
                new Card(13, 13, HEARTS),
                new Card(13, 13, DIAMONDS),
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS),
                new Card(2, 15, HEARTS),
                new Card(2, 15, DIAMONDS)};
        assertFalse(ComboType.isConsecutivePairs(six));
        Card[] seven = {
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS),
                new Card(2, 15, HEARTS),
                new Card(2, 15, DIAMONDS),
                new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),};
        assertTrue(ComboType.isConsecutivePairs(seven));
        Card[] eight = {
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS),
                new Card(2, 15, HEARTS),
                new Card(2, 15, DIAMONDS),
                new Card(JOKER_BLACK, JOKER_BLACK, JOKER),
                new Card(JOKER_RED, JOKER_RED, JOKER)};
        assertFalse(ComboType.isConsecutivePairs(eight));
    }

    @Test
    void isFullHouse() {
        Card[] one = {
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS),
                new Card(1, 14, SPADES),
                new Card(2, 15, DIAMONDS),
                new Card(2, 15, HEARTS)};
        assertTrue(ComboType.isFullHouse(one));
        Card[] two = {
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS),
                new Card(1, 14, SPADES),
                new Card(3, 3, DIAMONDS),
                new Card(4, 4, HEARTS)};
        assertFalse(ComboType.isFullHouse(two));
        Card[] three = {
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS),
                new Card(1, 14, SPADES),
                new Card(1, 14, CLUBS),
                new Card(4, 4, HEARTS)};
        assertFalse(ComboType.isFullHouse(three));
        Card[] four = {
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS),
                new Card(1, 14, SPADES),
                new Card(4, 4, HEARTS)};
        assertFalse(ComboType.isFullHouse(four));
    }

    @Test
    void isStraight() {
        Card[] one = {
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS),
                new Card(1, 14, SPADES),
                new Card(2, 15, DIAMONDS),
                new Card(2, 15, HEARTS)};
        assertFalse(ComboType.isStraight(one));
        Card[] two = {
                new Card(3, 3, HEARTS),
                new Card(4, 4, HEARTS),
                new Card(5, 5, HEARTS),
                new Card(6, 6, HEARTS)};
        assertFalse(ComboType.isStraight(two));
        Card[] three = {
                new Card(3, 3, HEARTS),
                new Card(4, 4, HEARTS),
                new Card(5, 5, HEARTS),
                new Card(6, 6, HEARTS),
                new Card(7, 7, HEARTS)};
        assertTrue(ComboType.isStraight(three));
        Card[] four = {
                new Card(11, 11, HEARTS),
                new Card(12, 12, HEARTS),
                new Card(13, 13, HEARTS),
                new Card(1, 14, HEARTS),
                new Card(2, 15, HEARTS)};
//        assertTrue(ComboType.isStraight(four));
        Card[] five = {
                new Card(3, 3, HEARTS),
                new Card(7, 7, HEARTS),
                new Card(8, 8, HEARTS),
                new Card(9, 9, HEARTS),
                new Card(10, 10, HEARTS)};
        assertFalse(ComboType.isStraight(five));
        Card[] six = {
                new Card(3, 3, HEARTS),
                new Card(4, 4, HEARTS),
                new Card(5, 5, HEARTS),
                new Card(6, 6, HEARTS),
                new Card(7, 7, HEARTS),
                new Card(8, 8, HEARTS),
                new Card(10, 10, HEARTS)};
        assertFalse(ComboType.isStraight(six));
        Card[] seven = {
                new Card(3, 3, HEARTS),
                new Card(4, 4, HEARTS),
                new Card(5, 5, HEARTS),
                new Card(6, 6, HEARTS),
                new Card(7, 7, HEARTS),
                new Card(8, 8, HEARTS),
                new Card(9, 9, HEARTS)};
        assertTrue(ComboType.isStraight(seven));
        Card[] special = {
                new Card(10, 10, HEARTS),
                new Card(11, 11, HEARTS),
                new Card(12, 12, HEARTS),
                new Card(13, 13, HEARTS),
                new Card(1, 14, HEARTS)};
        assertTrue(ComboType.isStraight(special));
        Card[] fakeFullStraight = {
                new Card(1, 3, HEARTS),
                new Card(2, 4, HEARTS),
                new Card(3, 5, HEARTS),
                new Card(4, 6, HEARTS),
                new Card(5, 7, HEARTS),
                new Card(6, 8, HEARTS),
                new Card(7, 9, HEARTS),
                new Card(8, 5, HEARTS),
                new Card(9, 6, HEARTS),
                new Card(10, 7, HEARTS),
                new Card(11, 8, HEARTS),
                new Card(12, 9, HEARTS),
                new Card(13, 8, HEARTS)
        };
        assertTrue(ComboType.isStraight(fakeFullStraight));
    }

    @Test
    void isBomb() {
        Card[] one = {
                new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(3, 3, SPADES),
                new Card(3, 3, CLUBS)};
        assertTrue(ComboType.isBomb(one));
        Card[] two = {
                new Card(JOKER_BLACK, JOKER_BLACK, JOKER),
                new Card(JOKER_RED, JOKER_RED, JOKER)};
//        assertTrue(ComboType.isBomb(two));
        Card[] three = {
                new Card(4, 4, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(3, 3, SPADES),
                new Card(3, 3, CLUBS)};
        assertFalse(ComboType.isBomb(three));

    }

    @Test
    void isStraightFlush() {
        /*
        most cases are tested in isStraight()
         */
        Card[] one = {
                new Card(3, 3, HEARTS),
                new Card(4, 4, HEARTS),
                new Card(5, 5, HEARTS),
                new Card(6, 6, HEARTS),
                new Card(7, 7, HEARTS)};
        assertTrue(ComboType.isStraightFlush(one));
        Card[] two = {
                new Card(3, 3, HEARTS),
                new Card(4, 4, HEARTS),
                new Card(5, 5, HEARTS),
                new Card(6, 6, HEARTS),
                new Card(7, 7, HEARTS),
                new Card(8, 8, DIAMONDS)};
        assertFalse(ComboType.isStraightFlush(two));
    }

    @Test
    void checkIfInARow() {
        Integer[] arrayOne = new Integer[]{3, 4, 5, 6, 7};
        LinkedList<Integer> inputOne = new LinkedList<Integer>(Arrays.asList(arrayOne));
        assertTrue(ComboType.checkIfInARow(inputOne));

        Integer[] arrayTwo = new Integer[]{3, 4, 5, 6, 10};
        LinkedList<Integer> inputTwo = new LinkedList<Integer>(Arrays.asList(arrayTwo));
        assertFalse(ComboType.checkIfInARow(inputTwo));
    }

    @Test
    void topCardValue() {
        Card[] single = {new Card(3, 3, HEARTS)};
        assertEquals(3, ComboType.topCardValue(single));
        Card[] pair = {
                new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS)
                };
        assertEquals(3, ComboType.topCardValue(pair));

        Card[] threeOfAKind = {
                new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(3, 3, SPADES)
        };
        assertEquals(3, ComboType.topCardValue(threeOfAKind));

        Card[] consPairs = {
                new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS),
                new Card(5, 5, HEARTS),
                new Card(5, 5, DIAMONDS)
        };
        assertEquals(5, ComboType.topCardValue(consPairs));

        Card[] fullHouse = {
                new Card(1, 14, HEARTS),
                new Card(1, 14, DIAMONDS),
                new Card(1, 14, SPADES),
                new Card(2, 15, DIAMONDS),
                new Card(2, 15, HEARTS)};
        assertEquals(1, ComboType.topCardValue(fullHouse));

        Card[] straight = {
                new Card(3, 3, HEARTS),
                new Card(4, 4, HEARTS),
                new Card(5, 5, DIAMONDS),
                new Card(6, 6, HEARTS),
                new Card(7, 7, HEARTS)};
        assertEquals(7, ComboType.topCardValue(straight));

        Card[] straightFlush = {
                new Card(3, 3, HEARTS),
                new Card(4, 4, HEARTS),
                new Card(5, 5, HEARTS),
                new Card(6, 6, HEARTS),
                new Card(7, 7, HEARTS)};
        assertEquals(7, ComboType.topCardValue(straightFlush));

        Card[] bomb = {
                new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(3, 3, SPADES),
                new Card(3, 3, CLUBS)};
        assertEquals(3, ComboType.topCardValue(bomb));

    }

    @Test
    void getType() {
        Card[] single = {new Card(3, 3, HEARTS)};
        ComboType c = new ComboType(single);
        assertEquals(SINGLE, c.getType());
    }

    @Test
    void isValid() {
        Card[] single = {new Card(3, 3, HEARTS)};
        ComboType c = new ComboType(single);
        assertTrue(c.isValid());
    }

    @Test
    void getTopCard() {
        Card[] single = {new Card(3, 3, HEARTS)};
        ComboType c = new ComboType(single);
        assertEquals(3, c.getTopCard());
    }
}