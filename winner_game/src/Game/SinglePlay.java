package Game;


import Card.Card;
import GameInterface.CardConstants;

/**
 * This class contains the information of one single play.
 */
public class SinglePlay implements CardConstants {
    private Card[] cards;
    private ComboType comboType;
    private String playerName;

    /**
     * The default constructor takes in the cards array and a player name.
     * It will call on Combotype class using the cards and check things.
     * @param input the array of card the player selected
     * @param inputPlayerName the name of the current player
     */
    public SinglePlay(Card[] input, String inputPlayerName) {
        cards = input;
        comboType = new ComboType(cards);
        playerName = inputPlayerName;
    }

    /**
     * This function check the current play and compare it with the last play
     * to check if current play can stand.
     * @param lastPlay last play to be compared
     * @return true if the cards can be played, false otherwise
     */
    public boolean compareCanBePlayed(SinglePlay lastPlay) {
        /*Check if a play is valid first */
        if (!this.getComboType().isValid()) {
            return false;
        }
        /*Straight flush is top priority and can only beaten by a bigger straight flush */
        if (this.getComboType().getType().equals(STRAIGHT_FLUSH)) {
            return compareStraightFlush(lastPlay);
        }
        /*Bomb is smaller than straight flush but can be played against any other combo */
        if (this.getComboType().getType().equals(BOMB)) {
            return compareBomb(lastPlay);
        }
        /*Compare the singles because suit will matter in this case */
        if (this.getComboType().getType().equals(SINGLE) && lastPlay.getComboType().getType().equals(SINGLE)) {
            return compareSingle(lastPlay);
        }
        /*The rest cases, suit must be the same, just compare top card directly */
        if (this.getComboType().getType().equals(lastPlay.getComboType().getType())) {
            return this.getComboType().getTopCard() > lastPlay.getComboType().getTopCard();
        }
        return false;
    }

    /**
     * The helper function compares the rank of two straight flushes (if there was one),
     * and let the straight flush beat everything else.
     * @param lastPlay last play to be compared
     * @return true if current straight flush is ranked higher, false otherwise
     */
    public boolean compareStraightFlush(SinglePlay lastPlay) {
        if (lastPlay.comboType.getType().equals(STRAIGHT_FLUSH)) {
            return this.comboType.getTopCard() > lastPlay.comboType.getTopCard();
        } else {
            return true;
        }
    }

    /**
     * The helper function compares the rank of two bombs (if there was one).
     * Though the bomb ranked lower than a straight flush, it would still beat everything else.
     * @param lastPlay last play to be compared
     * @return true if current bomb is ranked higher, false otherwise
     */
    public boolean compareBomb(SinglePlay lastPlay) {
        if (lastPlay.comboType.getType().equals(STRAIGHT_FLUSH)) {
            return false;
        } else if (lastPlay.comboType.getType().equals(BOMB)) {
            return this.comboType.getTopCard() > lastPlay.comboType.getTopCard();
        } else {
            return true;
        }
    }

    /**
     * The helper function compares the rank of two single cards.
     * If there is a tie in the value of cards, the suit will be the tie-breaker.
     * @param lastPlay last play to be compared
     * @return true if current single is ranked higher, false otherwise
     */
    public boolean compareSingle(SinglePlay lastPlay) {
        if (this.getCards()[0].getActualValue() == lastPlay.getCards()[0].getActualValue()) {
            return this.getCards()[0].getSuit() > lastPlay.getCards()[0].getSuit();
        }
        return this.getCards()[0].getActualValue() > lastPlay.getCards()[0].getActualValue();
    }

    /**
     * Get the cards in this single play.
     * @return the cards in this play
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * Get the name of player who played this hand.
     * @return the name of the player.
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Get the Combotype object in this play.
     * @return the combotype object
     */
    public ComboType getComboType() {
        return comboType;
    }
}
