package Game;


import Card.Card;
import GameInterface.CardConstants;

import java.util.Collections;
import java.util.LinkedList;

/**
 * This class contains all valid combo types and provides crucial information
 * for the single play class.
 */
public class ComboType implements CardConstants {
    private String type;
    private boolean isValid;
    private int topCard;

    /**
     * The default constructor takes in the card array as input and
     * check if the card combination is valid, also get the top card.
     * @param input the card array to be checked
     */
    public ComboType(Card[] input) {
        isValid = true;
        if (isSingle(input)) {
            type = SINGLE;
            topCard = topCardValue(input);
        } else if (isPair(input)) {
            type = PAIR;
            topCard = topCardValue(input);
        } else if (isThreeOfAKind(input)) {
            type = THREE_OF_A_KIND;
            topCard = topCardValue(input);
        } else if (isConsecutivePairs(input)) {
            type = CONSECUTIVE_PAIRS;
            topCard = topCardValue(input);
        } else if (isFullHouse(input)) {
            type = FULL_HOUSE;
            topCard = topCardValue(input);
        } else if (isStraight(input)) {
            type = STRAIGHT;
            topCard = topCardValue(input);
        } else if (isBomb(input)) {
            type = BOMB;
            topCard = topCardValue(input);
        } else if (isStraightFlush(input)) {
            type = STRAIGHT_FLUSH;
            topCard = topCardValue(input);
        } else {
            type = INVALID;
            isValid = false;
        }
    }

    /**
     * This function checks if the card array contains only one single card.
     * @param input the card array to be checked
     * @return true if there's only one card, false otherwise
     */
    public static boolean isSingle(Card[] input) {
        return input.length == 1;
    }

    /**
     * This function checks if the card array contains a valid pair.
     * @param input the card array to be checked
     * @return true if there's a valid pair, false otherwise
     */
    public static boolean isPair(Card[] input) {
        if (input.length == 2) {
            return input[0].getFacialValue() == input[1].getFacialValue();
        }
        return false;
    }

    /**
     * This function checks if the card array contains a valid three of a kind.
     * @param input the card array to be checked
     * @return true if there's a valid three of a kind, false otherwise
     */
    public static boolean isThreeOfAKind(Card[] input) {
        if (input.length == 3) {
            return input[0].getFacialValue() == input[1].getFacialValue()
                    && input[0].getFacialValue() == input[2].getFacialValue();
        }
        return false;
    }

    /**
     * This function checks if the card array contains multiple consecutive pairs.
     * @param input the card array to be checked
     * @return true if there are consecutive pairs, false otherwise
     */
    public static boolean isConsecutivePairs(Card[] input) {
        if (input.length >= 4 && input.length % 2 == 0) {
            LinkedList <Integer> value = new LinkedList<>();
            for (Card card : input) {
                value.add(card.getFacialValue());
            }
            Collections.sort(value);
            /*Special case for .. QQ KK AA */
            if (value.get(0) == 1 && value.get(1) == 1) {
                /*If we have a pair of K at the end */
                if (value.get(value.size() - 1) == 13 && value.get(value.size() - 2) == 13) {
                    /*Remove the A and add 14 so the pairs are consecutive */
                    value.remove(0);
                    value.remove(0);
                    value.add(14);
                    value.add(14);
                }
            }
            /*Compare a pair at a time, so i += 2 and avoid index out of bound */
            for (int i = 0; i < value.size() - 1; i += 2) {
                /*Check if two cards represent a pair */
                if (!value.get(i).equals(value.get(i + 1))) {
                    return false;
                }
            }
            for (int i = 0; i < value.size() - 2; i += 2) {
                /*Check if the pairs are consecutive*/
                if (value.get(i) + 1 != value.get(i + 2)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * This function checks if the card array contains a full house.
     * @param input the card array to be checked
     * @return true if there's a valid full house, false otherwise
     */
    public static boolean isFullHouse(Card[] input) {
        if (input.length == 5) {
            LinkedList <Integer> value = new LinkedList<>();
            int valueCount = 0;
            int num = 0;
            for (Card card: input) {
                /*Full house should only contain 2 different card values */
                if (!value.contains(card.getFacialValue())) {
                    value.add(card.getFacialValue());
                    valueCount++;
                }
                /*Full house should contain a three of a kind and a pair*/
                if (card.getFacialValue() == input[0].getFacialValue()) {
                    num++;
                }
            }
            /*Two value, a pair and a three of a kind means valid full house */
            if (valueCount == 2) {
                return num == 2 || num == 3;
            }
        }
        return false;
    }

    /**
     * This function checks if the card array contains a valid straight.
     * @param input the card array to be checked
     * @return true if there's a valid straight, false otherwise
     */
    public static boolean isStraight(Card[] input) {
        if (input.length >= 5) {
            LinkedList<Integer> value = new LinkedList<>();
            for (Card card : input) {
                value.add(card.getFacialValue());
            }
            if (value.size() == input.length) {
                /*Special case for 2 3 4 5 6 7 8 9 10 J Q K A*/
                if (value.size() == 13) {
                    return true;
                }
                Collections.sort(value);
                /*Special case for ... 10 J Q K A*/
                if (value.contains(1) && value.contains(13)) {
                    value.remove(0); /*Remove the A */
                    value.add(14); /*Add 14 so the straight would stand */
                    if (checkIfInARow(value)) {
                        return true;
                    }
                }
                /*Normal cases including A 2 3 4 5*/
                return checkIfInARow(value);
            }
        }
        return false;
    }

    /**
     * This function checks if the card array contains a bomb.
     * @param input the card array to be checked
     * @return true if there's a bomb, false otherwise
     */
    public static boolean isBomb(Card[] input) {
        if (input.length == 4) {
            for (Card card : input) {
                /*Check if all four cards have the same facial value */
                if (card.getFacialValue() != input[0].getFacialValue()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * This function checks if the card array contains a straight flush.
     * @param input the card array to be checked
     * @return true if there's a straight flush, false otherwise
     */
    public static boolean isStraightFlush(Card[] input) {
        /*Check if the input is a straight first */
        if (isStraight(input)) {
            for (Card card : input) {
                /*Check if all cards in the straight have the same suit */
                if (card.getSuit() != input[0].getSuit()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * This helper function checks if the integers in the linked list is consecutive.
     * @param list the list of integer to be checked
     * @return true if the integers are consecutive, false otherwise
     */
    public static boolean checkIfInARow(LinkedList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) + 1 != list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * This function get the top card value of several valid combo types that will be
     * used for comparison in the single play class.
     * @param input the card array to be calculated
     * @return the top card value in the array
     */
    public static int topCardValue(Card[] input) {
        LinkedList <Integer> value = new LinkedList<>();
        for (Card card : input) {
            value.add(card.getFacialValue());
        }
        Collections.sort(value);
        if (isConsecutivePairs(input) || isStraightFlush(input) || isStraight(input)) {
            /*Check for ... 10 J Q K A case where top card is A = 14 */
            if (value.contains(1) && value.contains(13)) {
                return 14;
            } else {
                return value.getLast();
            }
        }
        if (isFullHouse(input)) {
            /*Case 33555 return 5; case 33355 return 3, both are index 2 */
            return value.get(2);
        }
        /*For single, pair, three of a kind and bomb */
        return input[0].getActualValue();
    }

    /**
     * Get the type of current combo.
     * @return the type of current combo
     */
    public String getType() {
        return type;
    }

    /**
     * Check if current card combination is valid.
     * @return true if the combination is valid, false otherwise
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Get the top card value of current play.
     * @return the top card of current play
     */
    public int getTopCard() {
        return topCard;
    }
}
