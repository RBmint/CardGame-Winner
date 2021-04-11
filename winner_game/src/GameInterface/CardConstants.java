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
    int CLUBS = 0;
    int DIAMONDS = 1;
    int HEARTS = 2;
    int SPADES = 3;
    int JOKER = 4;
    int[] SUIT_NAME = {CLUBS, DIAMONDS, HEARTS, SPADES};
    String[] SUIT_NAME_STRING = {"CLUBS", "DIAMONDS", "HEARTS", "SPADES", "JOKER"};

    /*Constants for special cards */
    int ACE = 1;
    int BIG_TWO = 2;

    /*Joker value is set to 19 and 20 for comparison and eliminate possibility of joining a STRAIGHT */
    int JOKER_BLACK = 19;
    int JOKER_RED = 20;

    /*For ACE and BIG TWO, there is a value difference of 13 */
    int ACTUAL_VALUE_DIFF = 13;

    /*Combo type name constants */
    String SINGLE = "Single";
    String PAIR = "Pair";
    String THREE_OF_A_KIND = "Three of a kind";
    String CONSECUTIVE_PAIRS = "Consecutive pairs";
    String FULL_HOUSE = "Full house";
    String STRAIGHT = "Straight";
    String BOMB = "Bomb";
    String STRAIGHT_FLUSH = "Straight flush";
    String INVALID = "Invalid";
    String[] VALID_COMBO_TYPES = {SINGLE, PAIR, THREE_OF_A_KIND, CONSECUTIVE_PAIRS, FULL_HOUSE, STRAIGHT,
            BOMB, STRAIGHT_FLUSH};
}
