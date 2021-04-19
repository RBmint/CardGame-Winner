//package Tests;
//
//import Card.Card;
//import Game.SinglePlay;
//import GameInterface.CardConstants;
//import Player.BasicAI;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class BasicAITest implements CardConstants {
//
//    @Test
//    void playAHand() {
//        BasicAI AI = new BasicAI("AI", true);
//        Card[] singleOne = {new Card(10, 10, HEARTS)};
//        SinglePlay last = new SinglePlay(singleOne, "AI");
//        int[] freePlay = AI.playAHand(last);
//        int[] expected = new int[]{1};
//        assertEquals(expected[0], freePlay[0]);
//        assertEquals(1, freePlay.length);
//
//        Card[] singleTwo = {new Card(10, 10, SPADES)};
//        AI.addCardToHand(singleTwo[0]);
//        int[] singlePlay = AI.playSingle(last);
//        assertEquals(1, singlePlay[0]);
//
//        Card[] pair = {
//                new Card(5, 5, HEARTS),
//                new Card(5, 5, DIAMONDS)
//        };
//        BasicAI AIPair = new BasicAI("AIPair", true);
//        for (Card card : pair) {
//            AIPair.addCardToHand(card);
//        }
//        Card[] pairTwo = {
//                new Card(4, 4, HEARTS),
//                new Card(4, 4, DIAMONDS)
//        };
//        SinglePlay lastTwo = new SinglePlay(pairTwo, "last");
//        assertEquals(1, AIPair.playAHand(lastTwo)[0]);
//        assertEquals(2, AIPair.playAHand(lastTwo)[1]);
//
//        Card[] three = {
//                new Card(5, 5, HEARTS),
//                new Card(5, 5, DIAMONDS),
//                new Card(5, 5, SPADES)
//        };
//        BasicAI AIThree = new BasicAI("AIThree", true);
//        for (Card card : three) {
//            AIThree.addCardToHand(card);
//        }
//        Card[] threeTwo = {
//                new Card(4, 4, HEARTS),
//                new Card(4, 4, DIAMONDS),
//                new Card(4, 4, SPADES),
//        };
//        SinglePlay lastThree = new SinglePlay(threeTwo, "last");
//        assertEquals(1, AIThree.playAHand(lastThree)[0]);
//        assertEquals(2, AIThree.playAHand(lastThree)[1]);
//        assertEquals(3, AIThree.playAHand(lastThree)[2]);
//
//
//    }
//
//    @Test
//    void playFreely() {
//        BasicAI AI = new BasicAI("AI", true);
//        Card[] singleTwo = {new Card(10, 10, SPADES)};
//        AI.addCardToHand(singleTwo[0]);
//        int[] freePlay = AI.playFreely();
//        int[] expected = new int[]{1};
//        assertEquals(expected[0], freePlay[0]);
//        assertEquals(1, freePlay.length);
//    }
//
//    @Test
//    void playSingle() {
//        BasicAI AI = new BasicAI("AI", true);
//        Card[] singleOne = {new Card(10, 10, HEARTS)};
//        Card[] singleTwo = {new Card(10, 10, SPADES)};
//        AI.addCardToHand(singleTwo[0]);
//        SinglePlay last = new SinglePlay(singleOne, "last");
//        assertEquals(1, AI.playSingle(last)[0]);
//
//        BasicAI AITwo = new BasicAI("AITwo", true);
//        Card[] singleThree = {new Card(9, 9, SPADES)};
//        AITwo.addCardToHand(singleThree[0]);
//        assertEquals(SKIP_TURN, AITwo.playSingle(last));
//
//    }
//
//    @Test
//    void hasAPair() {
//        BasicAI AI = new BasicAI("AI", true);
//        Card[] pair = {
//                new Card(3, 3, HEARTS),
//                new Card(3, 3, DIAMONDS)
//        };
//        for (Card card : pair) {
//            AI.addCardToHand(card);
//        }
//        assertTrue(AI.hasAPair());
//
//        BasicAI AITwo = new BasicAI("AI", true);
//        Card[] singleTwo = {new Card(10, 10, SPADES)};
//        AITwo.addCardToHand(singleTwo[0]);
//        assertFalse(AITwo.hasAPair());
//
//    }
//
//    @Test
//    void hasThreeOfAKind() {
//        BasicAI AI = new BasicAI("AI", true);
//        Card[] three = {
//                new Card(3, 3, HEARTS),
//                new Card(3, 3, DIAMONDS),
//                new Card(3, 3, SPADES)
//        };
//
//        for (Card card : three) {
//            AI.addCardToHand(card);
//        }
//        assertTrue(AI.hasThreeOfAKind());
//
//        BasicAI AITwo = new BasicAI("AI", true);
//        Card[] singleTwo = {new Card(10, 10, SPADES)};
//        AITwo.addCardToHand(singleTwo[0]);
//        assertFalse(AITwo.hasThreeOfAKind());
//    }
//
//    @Test
//    void playAPair() {
//        BasicAI AI = new BasicAI("AI", true);
//        Card[] pair = {
//                new Card(5, 5, HEARTS),
//                new Card(5, 5, DIAMONDS)
//        };
//        for (Card card : pair) {
//            AI.addCardToHand(card);
//        }
//        Card[] pairTwo = {
//                new Card(4, 4, HEARTS),
//                new Card(4, 4, DIAMONDS)
//        };
//        SinglePlay last = new SinglePlay(pairTwo, "last");
//        assertEquals(1, AI.playAPair(last)[0]);
//        assertEquals(2, AI.playAPair(last)[1]);
//
//        BasicAI AITwo = new BasicAI("AI", true);
//        Card[] singleTwo = {new Card(10, 10, SPADES)};
//        AITwo.addCardToHand(singleTwo[0]);
//        assertEquals(SKIP_TURN, AITwo.playAPair(last));
//
//    }
//
//    @Test
//    void playThreeOfAKind() {
//        BasicAI AI = new BasicAI("AI", true);
//        Card[] three = {
//                new Card(5, 5, HEARTS),
//                new Card(5, 5, DIAMONDS),
//                new Card(5, 5, SPADES)
//        };
//
//        for (Card card : three) {
//            AI.addCardToHand(card);
//        }
//        Card[] threeTwo = {
//                new Card(4, 4, HEARTS),
//                new Card(4, 4, DIAMONDS),
//                new Card(4, 4, SPADES),
//        };
//        SinglePlay last = new SinglePlay(threeTwo, "last");
//        assertEquals(1, AI.playThreeOfAKind(last)[0]);
//        assertEquals(2, AI.playThreeOfAKind(last)[1]);
//        assertEquals(3, AI.playThreeOfAKind(last)[2]);
//
//        BasicAI AITwo = new BasicAI("AI", true);
//        Card[] singleTwo = {new Card(10, 10, SPADES)};
//        AITwo.addCardToHand(singleTwo[0]);
//        assertEquals(SKIP_TURN, AITwo.playThreeOfAKind(last));
//    }
//}