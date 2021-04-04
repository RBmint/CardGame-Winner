package winner.game;

import java.util.Stack;

/**
 * This class contains the core functionality of the Winner game.
 */
public class Game implements CardConstants{
    private boolean gameIsOver;
    private Player[] activePlayers;

    private Stack<SinglePlay> pastPlays = new Stack<>();
    private CardDeck newDeck;

    /**
     *
     */
    public Game() {
        newDeck = new CardDeck(false);
        activePlayers = new Player[DEFAULT_PLAYER_COUNT];
        for (int i = 0; i < DEFAULT_PLAYER_COUNT; i++) {
            activePlayers[i] = new Player("Player" + i);
        }
        activePlayers[0].switchTurn();
        dealCardsToPlayers();
        SinglePlay startingPlay = new SinglePlay(STARTING_CARD, "START");
        System.out.println(startingPlay.getPlayerName());
        pastPlays.add(startingPlay);

    }

    /**
     * Deal one card to a player at a time and in sequential order
     * until all cards in the deck has been dealt.
     */
    public void dealCardsToPlayers() {
        for (int i = 0; i < STARTING_HAND; i++) {
            for (Player p : activePlayers) {
                p.addCardToHand(newDeck.dealOneCard());
            }
        }
        for (Player p : activePlayers) {
            p.sortCurrentHand();
        }
    }

    /**
     * Add the current play into the play stack.
     * @param currentPlay the play to be added.
     */
    public void addToLastPlay(SinglePlay currentPlay) {
        pastPlays.add(currentPlay);
    }

    /**
     * Get the last play in the play stack.
     * @return the last play.
     */
    public SinglePlay getLastPlay() {
        return pastPlays.peek();
    }

    /**
     * Print the current player name to indicate that it is his
     * turn to play to System.out
     */
    public void printCurrentPlayingPlayer() {
        Player p = getCurrentPlayingPlayer();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(p.getPlayerName() + "'s Turn");
    }

    /**
     * Get the current player that is playing his turn.
     * @return the current player
     */
    public Player getCurrentPlayingPlayer() {
        for (Player p : activePlayers) {
            if (p.isTurnToPlay()) {
                return p;
            }
        }
        return null;
    }

    /**
     * Remove the list of cards played by the player.
     * @param cardsPlayed the list of cards to be removed.
     */
    public void removeMultipleFromPlayer(Card[] cardsPlayed) {
        for (Card toBeRemoved : cardsPlayed) {
            removeSingleFromPlayer(toBeRemoved);
        }
    }

    /**
     * Remove a card that is played by the player from his hand.
     * @param cardPlayed the card to be removed.
     */
    public void removeSingleFromPlayer(Card cardPlayed) {
        Player p = getCurrentPlayingPlayer();
        if (p.hasThisCard(cardPlayed)) {
            p.removeCardFromHand(cardPlayed);
        }
    }

    /**
     * Skip the current player's turn and makes the next player to
     * be able to start his turn.
     */
    public void skipCurrentPlayerTurn() {
        Player currentPlayingPlayer = getCurrentPlayingPlayer();
        Player nextPlayer = getNextPlayer();
        currentPlayingPlayer.switchTurn();
        nextPlayer.switchTurn();
    }

    /**
     * Get the next possible player if current player ends his turn.
     * @return the next possible player
     */
    public Player getNextPlayer() {
        for (int i = 0; i < activePlayers.length; i++) {
            if (activePlayers[i].isTurnToPlay()) {
                return activePlayers[(i + 1) % activePlayers.length];
            }
        }
        return null;
    }

    /**
     * Check if the game is over, that is, a player no long has any card in hand.
     * @return True if the game is over, false otherwise
     */
    public boolean isOver() {
        for (Player p : activePlayers) {
            if (!p.hasCardInHand()) {
                gameIsOver = true;
                return true;
            }
        }
        return gameIsOver;
    }
}