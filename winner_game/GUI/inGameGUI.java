import Card.Card;
import Game.Game;
import Game.SinglePlay;
import GameInterface.CardConstants;
import Player.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class inGameGUI {
    JFrame frame;
    String playerName;
    int[] AIs;
    Game g;
    JLabel handAIOne;
    JLabel handAITwo;
    JLabel nameOne;
    JLabel nameTwo;
    JLabel yourCardInHand;
    ArrayList<Card> userSelected = new ArrayList<Card>();

    public inGameGUI(String inputName, int[] AIs) {
        this.playerName = inputName;
        this.AIs = AIs;
//        this.AIs = new int[]{1, 1, 0};
        g = new Game(this.playerName, this.AIs);

        Player user = g.getCurrentPlayingPlayer();
        Player AI_one = g.getActivePlayers()[1];
        Player AI_two = g.getActivePlayers()[2];

        frame = new JFrame();
        frame.setSize(900, 600);
        frame.setLayout(null);

        JLabel imageOne = new JLabel();
        imageOne.setIcon(new ImageIcon(new ImageIcon("images/blitz.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        imageOne.setBounds(0, 0, 100, 100);
        frame.add(imageOne);
        nameOne = new JLabel(AI_one.getPlayerName());
        nameOne.setBounds(120, 0, 150, 50);
        nameOne.setFont(new Font("Verdana", Font.BOLD, 20));
        frame.add(nameOne);
        handAIOne = new JLabel();
        handAIOne.setText(AI_one.getNumCardInHand() + " in hand");
        handAIOne.setBounds(120, 50, 120, 50);
        handAIOne.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(handAIOne);

        JLabel imageTwo = new JLabel();
        imageTwo.setIcon(new ImageIcon(new ImageIcon("images/blitz.jpeg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        imageTwo.setBounds(800, 0, 100, 100);
        frame.add(imageTwo);
        nameTwo = new JLabel(AI_two.getPlayerName());
        nameTwo.setBounds(650, 0, 150, 50);
        nameTwo.setFont(new Font("Verdana", Font.BOLD, 20));
        frame.add(nameTwo);
        handAITwo = new JLabel();
        handAITwo.setText(AI_two.getNumCardInHand() + " in hand");
        handAITwo.setBounds(680, 50, 120, 50);
        handAITwo.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(handAITwo);

        yourCardInHand = new JLabel("Your hand:");
        yourCardInHand.setBounds(50, 270, 150, 50);
        yourCardInHand.setFont(new Font("Verdana", Font.BOLD, 20));
        frame.add(yourCardInHand);

        yourCardInHand.setForeground(Color.orange);

        JLayeredPane layeredPane = frame.getLayeredPane();
        LinkedList<Card> userHands = user.getAllCards();
        int x = 80;
        Integer layer = 0;
        for (Card card : userHands) {
            JButton cardButton = new JButton();
            String path = getImagePath(card);
            cardButton.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
            cardButton.setBounds(x, 350, 150, 200);
            cardButton.addActionListener((e) -> cardClick(card, cardButton));
            layeredPane.add(cardButton, layer);
            x += 30;
            layer += 1;
        }

        JButton playButton = new JButton("play");
        playButton.setBounds(770, 350, 99, 66);
        playButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(playButton);
        JButton skipButton = new JButton("skip");
        skipButton.setBounds(770, 450, 99, 66);
        skipButton.setFont(new Font("Verdana", Font.PLAIN, 20));
        frame.add(skipButton);
        skipButton.addActionListener((e) -> skip());

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("In Game");
    }

    private void skip() {
        g.skipCurrentPlayerTurn();
        g.printCurrentPlayingPlayer();
        if (g.getActivePlayers()[0].isTurnToPlay()) {
            yourCardInHand.setForeground(Color.orange);
            nameOne.setForeground(Color.black);
            nameTwo.setForeground(Color.black);
        } else if (g.getActivePlayers()[1].isTurnToPlay()) {
            yourCardInHand.setForeground(Color.black);
            nameOne.setForeground(Color.orange);
            nameTwo.setForeground(Color.black);
        } else {
            yourCardInHand.setForeground(Color.black);
            nameOne.setForeground(Color.black);
            nameTwo.setForeground(Color.orange);
        }
    }

    private void cardClick(Card card, JButton cardButton) {
        if (cardButton.getY() == 350) {
            userSelected.add(card);
            cardButton.setBounds(cardButton.getX(), 320, cardButton.getWidth(), cardButton.getHeight());
        } else {
            userSelected.remove(card);
            cardButton.setBounds(cardButton.getX(), 350, cardButton.getWidth(), cardButton.getHeight());
        }

    }


    private String getImagePath(Card card) {
        String imagePath = "images/cards/";
        if (card.getFacialValue() == 1) {
            imagePath += "ace_of_";
        } else if (card.getFacialValue() == 11) {
            imagePath += "jack_of_";
        } else if (card.getFacialValue() == 12) {
            imagePath += "queen_of_";
        } else if (card.getFacialValue() == 13) {
            imagePath += "king_of_";
        } else if (card.getFacialValue() == 19) {
            imagePath += "black_joker.png";
            return imagePath;
        } else if (card.getFacialValue() == 20) {
            imagePath += "red_joker.png";
            return imagePath;
        }
        else {
            imagePath += card.getFacialValue() + "_of_";
        }
        if (card.getSuit() == CardConstants.CLUBS) {
            if (card.getFacialValue() > 10) {
                imagePath += "clubs2.png";
            } else {
                imagePath += "clubs.png";
            }
        } else if (card.getSuit() == CardConstants.DIAMONDS) {
            if (card.getFacialValue() > 10) {
                imagePath += "diamonds2.png";
            } else {
                imagePath += "diamonds.png";
            }
        } else if (card.getSuit() == CardConstants.HEARTS) {
            if (card.getFacialValue() > 10) {
                imagePath += "hearts2.png";
            } else {
                imagePath += "hearts.png";
            }
        } else {
            if (card.getFacialValue() > 10) {
                imagePath += "spades2.png";
            } else {
                imagePath += "spades.png";
            }
        }
        return imagePath;
    }

    public static void main(String[] args) {
        String inputName = "Ricky";
        int[] AIs = new int[]{1, 1, 0};
        new inGameGUI(inputName, AIs);
    }

}
