package Tests;

import org.junit.jupiter.api.Test;
import Card.Card;
import Card.CardDeck;

import static org.junit.jupiter.api.Assertions.*;

class CardDeckTest {

    @Test
    void testAddNumberCards() {
        CardDeck deck = new CardDeck(true);
        int sizeOne = deck.getCardDeck().size();
        deck.addNumberCards();
        int sizeTwo = deck.getCardDeck().size();
        assertEquals(52, sizeTwo - sizeOne);
    }

    @Test
    void testAddJokers() {
        CardDeck deck = new CardDeck(true);
        deck.addJokers();
        assertEquals(5, deck.getCardDeck().getLast().getSuit());
    }

    @Test
    void shuffleCardDeck() {
        CardDeck deck = new CardDeck(true);
        Card cardOne = deck.getCardDeck().getFirst();
        deck.shuffleCardDeck();
        Card cardTwo = deck.getCardDeck().getFirst();
        assertNotEquals(cardOne, cardTwo);
    }

    @Test
    void TestDealOneCard() {
        CardDeck deck = new CardDeck(true);
        int sizeOne = deck.getCardDeck().size();
        deck.dealOneCard();
        int sizeTwo = deck.getCardDeck().size();
        int diff = sizeOne - sizeTwo;
        assertEquals(1, diff);
    }

    @Test
    void getCardDeck() {
        CardDeck deck = new CardDeck(true);
        assertEquals(54, deck.getCardDeck().size());
    }
}