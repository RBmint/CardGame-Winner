package GameInterface;

import Card.Card;

/**
 * This class contains essential constants used by card and game class.
 */
public interface CardConstants {

    /*Constants for game initiation */
    int DEFAULT_PLAYER_COUNT = 3;
    int STARTING_HAND = 18;
    String STARTING_PLAYER = "START";
    Card[] STARTING_CARD = {new Card(0, 0, 0)};

    /*From Ace to King, each card has a facial value from 1 to 13 */
    int[] FACIAL_VALUE = {1,2,3,4,5,6,7,8,9,10,11,12,13};

    /*Constants for suits */
    int CLUBS = 1;
    int DIAMONDS = 2;
    int HEARTS = 3;
    int SPADES = 4;
    int[] SUIT_NAME = {HEARTS, CLUBS, SPADES, DIAMONDS};
    int JOKER = 5;

    /*Constants for special cards */
    int ACE = 1;
    int BIG_TWO = 2;
    /*Joker value is set to 19 and 20 for comparison and eliminate possibility of joining a STRAIGHT */
    int JOKER_BLACK = 19;
    int JOKER_RED = 20;

    /*For ACE and BIG TWO, there is a value difference of 13 */
    int ACTUAL_VALUE_DIFF = 13;
}
