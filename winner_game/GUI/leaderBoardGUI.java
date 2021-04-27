import javax.swing.*;

public class leaderBoardGUI {
    JFrame frame;
    public leaderBoardGUI() {
        frame  = new JFrame();
        frame.setSize(900, 600);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Leaderboard");
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new leaderBoardGUI();
    }
}
