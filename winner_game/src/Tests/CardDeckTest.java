package Tests;

import org.junit.jupiter.api.Test;
import Card.Card;
import Card.CardDeck;

import static org.junit.jupiter.api.Assertions.*;

/**
 * unit tests for CardDeck class
 */
class CardDeckTest {

    /**
     * testing addNumberCards()
     */
    @Test
    void testAddNumberCards() {
        CardDeck deck = new CardDeck(true);
        int sizeOne = deck.getCardDeck().size();
        deck.addNumberCards();
        int sizeTwo = deck.getCardDeck().size();
        assertEquals(52, sizeTwo - sizeOne);
    }

    /**
     * testing addJokers()
     */
    @Test
    void testAddJokers() {
        CardDeck deck = new CardDeck(true);
        deck.addJokers();
        assertEquals(4, deck.getCardDeck().getLast().getSuit());
    }

    /**
     * testing shuffleCardDeck()
     */
    @Test
    void shuffleCardDeck() {
        CardDeck deck = new CardDeck(true);
        Card cardOne = deck.getCardDeck().getFirst();
        deck.shuffleCardDeck();
        Card cardTwo = deck.getCardDeck().getFirst();
        assertNotEquals(cardOne, cardTwo);
    }

    /**
     * testing dealOneCard()
     */
    @Test
    void TestDealOneCard() {
        CardDeck deck = new CardDeck(true);
        int sizeOne = deck.getCardDeck().size();
        deck.dealOneCard();
        int sizeTwo = deck.getCardDeck().size();
        int diff = sizeOne - sizeTwo;
        assertEquals(1, diff);
    }

    /**
     * testing deck getter
     */
    @Test
    void getCardDeck() {
        CardDeck deck = new CardDeck(true);
        assertEquals(54, deck.getCardDeck().size());
    }
}