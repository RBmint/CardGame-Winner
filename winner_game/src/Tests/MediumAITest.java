package Tests;
import Card.Card;
import Game.SinglePlay;
import GameInterface.CardConstants;
import Player.MediumAI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class MediumAITest {

    @Test
    public void testPlayAHand() {
        MediumAI testAI = new MediumAI("MAI", true);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card four = new Card(4,4, CardConstants.SPADES);
        Card five = new Card(5,5, CardConstants.SPADES);
        Card six = new Card(6,6, CardConstants.SPADES);
        Card seven = new Card(7,7, CardConstants.SPADES);
        Card eight = new Card(8,8, CardConstants.SPADES);
        Card nine = new Card(9,9, CardConstants.SPADES);
        Card ten = new Card(10,10, CardConstants.SPADES);
        Card eleven = new Card(11,11, CardConstants.SPADES);
        Card[] threeToEight = new Card[] {three, four, five, six, seven, eight};

        testAI.addCardToHand(three);
        testAI.addCardToHand(four);
        testAI.addCardToHand(five);
        testAI.addCardToHand(five);
        testAI.addCardToHand(five);
        testAI.addCardToHand(five);
        testAI.addCardToHand(six);
        testAI.addCardToHand(six);
        testAI.addCardToHand(six);
        testAI.addCardToHand(seven);
        testAI.addCardToHand(seven);
        testAI.addCardToHand(eight);
        testAI.addCardToHand(nine);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(eleven);
        Card[] tenBomb = new Card[] {ten, ten, ten, ten};
        Card[] fullHouse = new Card[] {three, three, three, four, four};
        SinglePlay tenBombPlay = new SinglePlay(tenBomb, "test");
        SinglePlay straightPlay = new SinglePlay(threeToEight, "test");
        SinglePlay fullHousePlay = new SinglePlay(fullHouse, "test");
        SinglePlay thisPlay = testAI.playAHand(tenBombPlay);
        assertNull(thisPlay);

//        thisPlay = testAI.playAHand(straightPlay);
//        assertEquals(4, thisPlay.getCards()[0].getFacialValue());

        thisPlay = testAI.playAHand(fullHousePlay);
        assertEquals(6, thisPlay.getCards()[2].getFacialValue());

    }

    @Test
    public void testPlayFreely() {
        MediumAI testAI = new MediumAI("MAI", true);
        Card ace = new Card(1,14, CardConstants.SPADES);
        Card five = new Card(5,5, CardConstants.SPADES);
        Card six = new Card(6,6, CardConstants.SPADES);

        testAI.addCardToHand(ace);
        testAI.addCardToHand(five);
        testAI.addCardToHand(five);
        testAI.addCardToHand(six);
        assertEquals(2, testAI.playFreely().getCards().length);
        assertEquals(5, testAI.playFreely().getCards()[0].getFacialValue());
        testAI.addCardToHand(five);
        testAI.sortCurrentHand();
        assertEquals(3, testAI.playFreely().getCards().length);
        assertEquals(5, testAI.playFreely().getCards()[0].getFacialValue());
        testAI.addCardToHand(five);
        testAI.sortCurrentHand();
        assertEquals(1, testAI.playFreely().getCards().length);
        assertEquals(6, testAI.playFreely().getCards()[0].getFacialValue());

    }

    @Test
    public void testPlaySingle() {
        MediumAI testAI = new MediumAI("MAI", true);
        Card six = new Card(6,6, CardConstants.HEARTS);
        Card eight = new Card(8,8, CardConstants.SPADES);
        Card ten = new Card(10,10, CardConstants.SPADES);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(six);
        testAI.addCardToHand(eight);
        testAI.sortCurrentHand();
        SinglePlay singleSix = new SinglePlay(new Card[]{six}, "test");
        SinglePlay thisPlay = testAI.playSingle(singleSix);
        assertEquals(8, thisPlay.getCards()[0].getFacialValue());
    }

    @Test
    public void testPlayAPair() {
        MediumAI testAI = new MediumAI("MAI", true);
        Card six = new Card(6,6, CardConstants.SPADES);
        Card seven = new Card(7,7, CardConstants.SPADES);
        Card ten = new Card(10,10, CardConstants.SPADES);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(six);
        testAI.addCardToHand(seven);
        testAI.addCardToHand(seven);
        testAI.addCardToHand(six);
        testAI.sortCurrentHand();
        SinglePlay pair = new SinglePlay(new Card[]{six, six}, "test");
        SinglePlay thisPlay = testAI.playAPair(pair);
        assertEquals(seven.getFacialValue(), thisPlay.getCards()[0].getFacialValue());
    }

    @Test
    public void testPlayThreeOfAKind() {
        MediumAI testAI = new MediumAI("MAI", true);
        Card five = new Card(5,5, CardConstants.SPADES);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card ten = new Card(10,10, CardConstants.SPADES);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(five);
        testAI.addCardToHand(five);
        testAI.addCardToHand(five);
        testAI.sortCurrentHand();
        SinglePlay threeOfAKind = new SinglePlay(new Card[]{three, three, three}, "test");
        SinglePlay thisPlay = testAI.playThreeOfAKind(threeOfAKind);
        assertEquals(5, thisPlay.getCards()[0].getFacialValue());
    }

    @Test
    public void testHasStraight() {
        MediumAI testAI = new MediumAI("MAI", true);
        Card ace = new Card(1,14, CardConstants.SPADES);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card four = new Card(4,4, CardConstants.SPADES);
        Card five = new Card(5,5, CardConstants.SPADES);
        Card six = new Card(6,6, CardConstants.SPADES);
        Card seven = new Card(7,7, CardConstants.SPADES);

        testAI.addCardToHand(ace);
        testAI.addCardToHand(three);
        testAI.addCardToHand(four);
        testAI.addCardToHand(five);
        testAI.addCardToHand(six);
        assertFalse(testAI.hasStraight());
        testAI.addCardToHand(seven);
        assertTrue(testAI.hasStraight());
    }
    @Test
    public void testPlayStraight(){
        MediumAI testAI = new MediumAI("MAI", true);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card four = new Card(4,4, CardConstants.SPADES);
        Card five = new Card(5,5, CardConstants.SPADES);
        Card six = new Card(6,6, CardConstants.SPADES);
        Card seven = new Card(7,7, CardConstants.SPADES);
        Card eight = new Card(8,8, CardConstants.SPADES);
        Card nine = new Card(9,9, CardConstants.SPADES);
        Card ten = new Card(10,10, CardConstants.SPADES);
        Card eleven = new Card(11,11, CardConstants.SPADES);
        Card[] threeToEight = new Card[] {three, four, five, six, seven, eight};

        testAI.addCardToHand(three);
        testAI.addCardToHand(five);
        testAI.addCardToHand(six);
        testAI.addCardToHand(seven);
        testAI.addCardToHand(eight);
        testAI.addCardToHand(nine);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(eleven);

        SinglePlay lastPlay = new SinglePlay(threeToEight, "test");

        SinglePlay thisPlay = testAI.playStraight(lastPlay);
        assertEquals(five.getFacialValue(), thisPlay.getCards()[0].getFacialValue());
    }

    @Test
    public void testHasFullHouse() {
        MediumAI testAI = new MediumAI("MAI", true);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card seven = new Card(7,7, CardConstants.SPADES);
        Card ten = new Card(10,10, CardConstants.SPADES);

        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(seven);
        assertFalse(testAI.hasFullHouse());
        testAI.addCardToHand(seven);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(ten);
        assertTrue(testAI.hasFullHouse());
    }

    @Test
    public void testPlayFullHouse() {
        MediumAI testAI = new MediumAI("MAI", true);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card four = new Card(4,4, CardConstants.SPADES);
        Card six = new Card(6,6, CardConstants.SPADES);
        Card seven = new Card(7,7, CardConstants.SPADES);
        Card eight = new Card(8,8, CardConstants.SPADES);
        Card ten = new Card(10,10, CardConstants.SPADES);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(six);
        testAI.addCardToHand(seven);
        testAI.addCardToHand(eight);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(ten);
        testAI.addCardToHand(ten);

        Card[] fullHouse = new Card[] {four, four, four, seven, seven};
        SinglePlay lastPlay = new SinglePlay(fullHouse, "test");
        SinglePlay thisPlay = testAI.playFullHouse(lastPlay);
        assertEquals(10, thisPlay.getCards()[2].getFacialValue());
    }

    @Test
    public void testHasABomb() {
        MediumAI testAI = new MediumAI("MAI", true);
        Card two = new Card(2,15, CardConstants.SPADES);
        Card three = new Card(3,3, CardConstants.SPADES);
        testAI.addCardToHand(two);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        assertFalse(testAI.hasABomb());
        testAI.addCardToHand(three);
        assertTrue(testAI.hasABomb());
    }

    @Test
    public void testPlayABomb() {
        MediumAI testAI = new MediumAI("MAI", true);
        Card three = new Card(3,3, CardConstants.SPADES);
        Card two = new Card(2,15, CardConstants.SPADES);
        SinglePlay pairTwo = new SinglePlay(new Card[]{two, two}, "test");
        SinglePlay thisPlay = testAI.playABomb(pairTwo);

        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        testAI.addCardToHand(three);
        assertNull(thisPlay);
        testAI.addCardToHand(three);
        thisPlay = testAI.playABomb(pairTwo);
        assertEquals(3, thisPlay.getCards()[0].getFacialValue());
    }
}
