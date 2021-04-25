package Tests;

import Card.Card;
import Game.SinglePlay;
import GameInterface.CardConstants;
import Player.BasicAI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasicAITest implements CardConstants {

    @Test
    void playAHand() {
        BasicAI AI = new BasicAI("AI", true);
        Card[] singleOne = {new Card(10, 10, HEARTS)};
        SinglePlay last = new SinglePlay(singleOne, "AI");
        AI.addCardToHand(singleOne[0]);
        SinglePlay thisPlay = AI.playAHand(last);
        assertEquals(10, thisPlay.getCards()[0].getFacialValue());

        Card[] singleTwo = {new Card(10, 10, SPADES)};
        AI.addCardToHand(singleTwo[0]);
        SinglePlay singlePlay = AI.playSingle(last);
        assertEquals(10, singlePlay.getCards()[0].getFacialValue());

        Card[] pair = {
                new Card(5, 5, HEARTS),
                new Card(5, 5, DIAMONDS)
        };
        BasicAI AIPair = new BasicAI("AIPair", true);
        for (Card card : pair) {
            AIPair.addCardToHand(card);
        }
        Card[] pairTwo = {
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS)
        };
        SinglePlay lastTwo = new SinglePlay(pairTwo, "last");
        assertEquals(5, AIPair.playAHand(lastTwo).getCards()[0].getFacialValue());
        assertEquals(5, AIPair.playAHand(lastTwo).getCards()[1].getFacialValue());

        Card[] three = {
                new Card(5, 5, HEARTS),
                new Card(5, 5, DIAMONDS),
                new Card(5, 5, SPADES)
        };
        BasicAI AIThree = new BasicAI("AIThree", true);
        for (Card card : three) {
            AIThree.addCardToHand(card);
        }
        Card[] threeTwo = {
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS),
                new Card(4, 4, SPADES),
        };
        SinglePlay lastThree = new SinglePlay(threeTwo, "last");
        assertEquals(5, AIThree.playAHand(lastThree).getCards()[0].getFacialValue());
        assertEquals(5, AIThree.playAHand(lastThree).getCards()[1].getFacialValue());
        assertEquals(5, AIThree.playAHand(lastThree).getCards()[2].getFacialValue());


    }

    @Test
    void playFreely() {
        BasicAI AI = new BasicAI("AI", true);
        Card[] singleTwo = {new Card(10, 10, SPADES)};
        AI.addCardToHand(singleTwo[0]);
        SinglePlay freePlay = AI.playFreely();
        assertEquals(10, freePlay.getCards()[0].getFacialValue());
    }

    @Test
    void playSingle() {
        BasicAI AI = new BasicAI("AI", true);
        Card[] singleOne = {new Card(10, 10, HEARTS)};
        Card[] singleTwo = {new Card(10, 10, SPADES)};
        AI.addCardToHand(singleTwo[0]);
        SinglePlay last = new SinglePlay(singleOne, "last");
        assertEquals(10, AI.playSingle(last).getCards()[0].getFacialValue());

        BasicAI AITwo = new BasicAI("AITwo", true);
        Card[] singleThree = {new Card(9, 9, SPADES)};
        AITwo.addCardToHand(singleThree[0]);
        assertNull(AITwo.playSingle(last));

    }

    @Test
    void hasAPair() {
        BasicAI AI = new BasicAI("AI", true);
        Card[] pair = {
                new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS)
        };
        for (Card card : pair) {
            AI.addCardToHand(card);
        }
        assertTrue(AI.hasAPair());

        BasicAI AITwo = new BasicAI("AI", true);
        Card[] singleTwo = {new Card(10, 10, SPADES)};
        AITwo.addCardToHand(singleTwo[0]);
        assertFalse(AITwo.hasAPair());

    }

    @Test
    void hasThreeOfAKind() {
        BasicAI AI = new BasicAI("AI", true);
        Card[] three = {
                new Card(3, 3, HEARTS),
                new Card(3, 3, DIAMONDS),
                new Card(3, 3, SPADES)
        };

        for (Card card : three) {
            AI.addCardToHand(card);
        }
        assertTrue(AI.hasThreeOfAKind());

        BasicAI AITwo = new BasicAI("AI", true);
        Card[] singleTwo = {new Card(10, 10, SPADES)};
        AITwo.addCardToHand(singleTwo[0]);
        assertFalse(AITwo.hasThreeOfAKind());
    }

    @Test
    void playAPair() {
        BasicAI AI = new BasicAI("AI", true);
        Card[] pair = {
                new Card(5, 5, HEARTS),
                new Card(5, 5, DIAMONDS)
        };
        for (Card card : pair) {
            AI.addCardToHand(card);
        }
        Card[] pairTwo = {
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS)
        };
        SinglePlay last = new SinglePlay(pairTwo, "last");
        assertEquals(5, AI.playAPair(last).getCards()[0].getFacialValue());
        assertEquals(5, AI.playAPair(last).getCards()[1].getFacialValue());

        BasicAI AITwo = new BasicAI("AI", true);
        Card[] singleTwo = {new Card(10, 10, SPADES)};
        AITwo.addCardToHand(singleTwo[0]);
        assertNull(AITwo.playAPair(last));

    }

    @Test
    void playThreeOfAKind() {
        BasicAI AI = new BasicAI("AI", true);
        Card[] three = {
                new Card(5, 5, HEARTS),
                new Card(5, 5, DIAMONDS),
                new Card(5, 5, SPADES)
        };

        for (Card card : three) {
            AI.addCardToHand(card);
        }
        Card[] threeTwo = {
                new Card(4, 4, HEARTS),
                new Card(4, 4, DIAMONDS),
                new Card(4, 4, SPADES),
        };
        SinglePlay last = new SinglePlay(threeTwo, "last");
        assertEquals(5, AI.playThreeOfAKind(last).getCards()[0].getFacialValue());
        assertEquals(5, AI.playThreeOfAKind(last).getCards()[1].getFacialValue());
        assertEquals(5, AI.playThreeOfAKind(last).getCards()[2].getFacialValue());

        BasicAI AITwo = new BasicAI("AI", true);
        Card[] singleTwo = {new Card(10, 10, SPADES)};
        AITwo.addCardToHand(singleTwo[0]);
        assertNull(AITwo.playThreeOfAKind(last));
    }
}