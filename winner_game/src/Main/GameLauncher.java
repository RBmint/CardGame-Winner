package Main;

import Card.Card;
import Game.Game;
import Game.SinglePlay;
import GameInterface.CardConstants;
import Player.Player;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * The class that starts the game and holds a game loop.
 */
public class GameLauncher implements CardConstants {
    private Game game;
    private boolean gameIsOver = false;

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
            game.printCurrentPlayingPlayer();
            Player currentPlayingPlayer = game.getCurrentPlayingPlayer();
//            String playerName = currentPlayingPlayer.getPlayerName();
            printAllCardsInHand(currentPlayingPlayer.getAllCards());

            int[] indexOfCards = getIndexOfCards();
            if (indexOfCards[0] == 0) {
                game.skipCurrentPlayerTurn();
            } else {
                playSelectedCards(indexOfCards);
            }
        }
    }

    /**
     * Use the scanner to get the index of cards that a player chooses to
     * play and convert to an array of integers.
     * @return the cards as an array of integers.
     */
    private int[] getIndexOfCards() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        /*Terminal UI will be replaced in later weeks, so currently only comma will be used for testing */
        String[] inputAsArray = input.split(",");
        int[] indexOfCards = new int[inputAsArray.length];
        for (int i = 0; i < inputAsArray.length; i++) {
            indexOfCards[i] = Integer.parseInt(inputAsArray[i]);
        }
        return indexOfCards;
    }

    /**
     * Try play the selected cards. If successful, skip current player's
     * turn and back to the main game loop. If failed, just go back to the
     * main game loop and let the player start over.
     * @param indexOfCardsToBePlayed cards to be played.
     */
    private void playSelectedCards(int[] indexOfCardsToBePlayed) {
        Player p = game.getCurrentPlayingPlayer();
        Card[] toBeChecked = new Card[indexOfCardsToBePlayed.length];
        /*Convert the index array from int to a card array */
        for (int i = 0; i < indexOfCardsToBePlayed.length; i++) {
            toBeChecked[i] = p.getCardByIndex(indexOfCardsToBePlayed[i]);
        }

        /*Compare two plays to check if this play can be played. Currently set to always true */
        SinglePlay thisPlay = new SinglePlay(toBeChecked, p.getPlayerName());
        SinglePlay lastPlay = game.getLastPlay();
        if (thisPlay.compareCanBePlayed(lastPlay) || lastPlay.getPlayerName().equals(STARTING_PLAYER)) {
            game.addToLastPlay(thisPlay);
            game.removeMultipleFromPlayer(toBeChecked);
            checkGameStatus();
            if (gameIsOver) {return;}
            game.skipCurrentPlayerTurn();
        } else {
            System.out.println("Selected cards cannot be played. Please try again.");
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
