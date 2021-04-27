import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class StartGUI {
    JFrame frame;

    public StartGUI() throws IOException {
        frame  = new JFrame();
        frame.setSize(626, 357);
        frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images/startGUI.jpeg")))));
        frame.setLayout(null);

        Container pane = frame.getContentPane();


        JLabel text = new JLabel("~WINNER~");
        text.setBounds(150, 100,500, 50);
        text.setFont(new Font("Verdana", Font.PLAIN, 60));
        text.setForeground(new Color(255, 170, 0));
        text.setForeground(Color.pink);

        pane.add(text);


        JButton startNew = new JButton("Start Game");
        startNew.setBounds(50, 270,130, 40 );
        pane.add(startNew);
        startNew.addActionListener((e) -> {
            startNew();
        });

        JButton leaderBoard = new JButton("Leader Board");
        leaderBoard.setBounds(250, 270,130, 40 );
        leaderBoard.addActionListener((e) -> {
            leaderBoard();
        });
        pane.add(leaderBoard);


        JButton exitGame = new JButton("Exit Game");
        exitGame.setBounds(450, 270,130, 40 );
        exitGame.addActionListener((e) -> {
//            frame.dispose();
            System.exit(0);
        });

        pane.add(exitGame);


        frame.setForeground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Welcome!");
        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new StartGUI();
    }


//    public void addUserAction() {
//        countUsers ++;
//        label_user.setText("number of users: " + countUsers);
//    }
//

    private void leaderBoard() {
        frame.dispose();
        new leaderBoardGUI();
    }

    public void startNew() {
        frame.dispose();
        new SelectGUI();
    }

}
