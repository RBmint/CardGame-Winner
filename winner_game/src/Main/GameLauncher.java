package Main;

import Card.Card;
import Game.Game;
import Game.SinglePlay;
import GameInterface.CardConstants;
import Player.Player;
import java.util.LinkedList;

/**
 * The class that starts the game and holds a game loop.
 */
public class GameLauncher implements CardConstants {
    private Game game;
    private boolean gameIsOver = false;
    private boolean newPlayerTurn = true;
    private int turns = 1;
    /**
     * The default constructor will start a new game and bring the
     * players into the game loop.
     */
    public GameLauncher() {
        game = new Game();
        enterGameLoop();
    }

    /**
     *  The main game loop. Ends the game and print out the winner when
     *  a player no longer has any card in hand.
     */
    private void enterGameLoop() {
        while (!gameIsOver) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            System.out.print("This is turn #" + turns + " and it is ");
            game.printCurrentPlayingPlayer();
            Player currentPlayingPlayer = game.getCurrentPlayingPlayer();
//            String playerName = currentPlayingPlayer.getPlayerName();
            if (newPlayerTurn) {
                if (turns == 1) {
                    System.out.println("The first player can play whatever he wants.");
                } else {
                    System.out.println("Current play is the following cards:");
                    for (Card card : game.getLastPlay().getCards()) {
                        printCurrentCard(card);
                    }
                }
                if (!currentPlayingPlayer.isAI()) {
                    printAllCardsInHand(currentPlayingPlayer.getAllCards());
                }
                newPlayerTurn = false;
            }
            SinglePlay thisPlay = currentPlayingPlayer.playAHand(game.getLastPlay());
            if (thisPlay == null) {
                game.skipCurrentPlayerTurn();
                newPlayerTurn = true;
                turns++;
            } else {
                playSelectedCards(thisPlay);
            }
        }
    }

    /**
     * Try play the selected cards. If successful, skip current player's
     * turn and back to the main game loop. If failed, just go back to the
     * main game loop and let the player start over.
     * @param thisPlay cards to be played.
     */
    private void playSelectedCards(SinglePlay thisPlay) {
        Player p = game.getCurrentPlayingPlayer();
        SinglePlay lastPlay = game.getLastPlay();
        if (thisPlay.compareCanBePlayed(lastPlay) ||
                /*The first hand is always playable as long as it is valid */
                (lastPlay.getPlayerName().equals(STARTING_PLAYER) && thisPlay.getComboType().isValid()) ||
                /*If all other players choose to skip turn then the leading player can play freely */
                (lastPlay.getPlayerName().equals(p.getPlayerName()) && thisPlay.getComboType().isValid())) {
            if (p.isAI()) {
                System.out.print("AI chose to play " );
                for (Card card : thisPlay.getCards()) {
                    printCurrentCard(card);
                }
            }
            game.addToLastPlay(thisPlay);
            game.removeMultipleFromPlayer(thisPlay.getCards());
            checkGameStatus();
            if (gameIsOver) {return;}
            game.skipCurrentPlayerTurn();
            newPlayerTurn = true;
            turns++;
        } else {
            System.out.println("Selected cards cannot be played. Please try input index again: ");
        }
    }

    /**
     * Check if the game is over after a player plays out a list of cards.
     */
    private void checkGameStatus() {
        if (game.isOver()) {
            gameIsOver = true;
            System.out.println("Game is over, "
                    + game.getCurrentPlayingPlayer().getPlayerName() + " wins!!!");
        }
    }

    /**
     * Print all cards that a player has out to System.out. Index 0 means
     * the player choose to skip his turn.
     * @param cardsToPrint the cards of a player
     */
    private void printAllCardsInHand(LinkedList<Card> cardsToPrint) {
        System.out.println("You have the following options:");
        System.out.println("0. Skip current turn.");
        int cardNum = 1;
        for(Card card : cardsToPrint) {
            System.out.print(cardNum + ". ");
            printCurrentCard(card);
            cardNum++;
        }
        System.out.println("Please type the index of card you want to play: ");
    }

    /**
     * Print one card to System.out.
     * @param cardToPrint the card to be printed
     */
    private void printCurrentCard(Card cardToPrint) {
        String facialValue = getCorrectFacialValue(cardToPrint);
        String suitName = getCorrectSuitName(cardToPrint);
        System.out.println(facialValue + " of " + suitName);
    }

    /**
     * Convert the facial value which is integer to human-readable string.
     * @param cardToPrint the card to be printed
     * @return the correct facial value
     */
    private String getCorrectFacialValue(Card cardToPrint) {
        if (cardToPrint.getFacialValue() == 11) {
            return "Jack";
        } else if (cardToPrint.getFacialValue() == 12) {
            return "Queen";
        } else if (cardToPrint.getFacialValue() == 13) {
            return "King";
        } else if (cardToPrint.getFacialValue() == ACE){
            return "Ace";
        } else if (cardToPrint.getFacialValue() == JOKER_BLACK) {
            return "Joker(black)";
        } else if (cardToPrint.getFacialValue() == JOKER_RED) {
            return "Joker(red)";
        } else {
            return String.valueOf(cardToPrint.getFacialValue());
        }
    }

    /**
     * Convert the suit which is integer to human-readable string.
     * @param cardToPrint the card to be printed
     * @return the correct suit
     */
    private String getCorrectSuitName(Card cardToPrint) {
        return SUIT_NAME_STRING[cardToPrint.getSuit()];
    }
}
