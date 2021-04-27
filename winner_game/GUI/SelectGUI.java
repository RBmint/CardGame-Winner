import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SelectGUI {
    JFrame frame;
    JLabel basicText;
    JLabel mediumText;
    JLabel hardText;
    JTextField nameBox;
    String playerName;
    int[] AIs;
    public SelectGUI() {
        AIs = new int[]{0, 0, 0};

        frame  = new JFrame();
        frame.setSize(900, 600);
        frame.setLayout(null);

        Container pane = frame.getContentPane();

        JLabel yourName = new JLabel("Your name: ");
        yourName.setBounds(315, 450, 100, 50);
        yourName.setFont(new Font("Verdana", Font.PLAIN, 15));
        pane.add(yourName);

        nameBox = new JTextField();
        nameBox.setBounds(415, 455, 100, 40);
        pane.add(nameBox);

        JLabel text = new JLabel("Select 2 AI players");
        text.setBounds(315, 100,500, 50);
        text.setFont(new Font("Verdana", Font.PLAIN, 30));
        text.setForeground(Color.black);
        pane.add(text);

        JButton basic = new JButton();
        basic.addActionListener((e) -> basicAction());
        basic.setIcon(new ImageIcon(new ImageIcon("images/cards/3_of_diamonds.png").getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
        basic.setBounds(150, 200, 150, 200);
        pane.add(basic);
        basicText = new JLabel("Basic AI");
        basicText.setBounds(150, 170, 150, 30);
        basicText.setFont(new Font("Verdana", Font.PLAIN, 20));
        pane.add(basicText);


        JButton medium = new JButton();
        medium.addActionListener((e) -> mediumAction());
        medium.setIcon(new ImageIcon(new ImageIcon("images/cards/8_of_hearts.png").getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
        medium.setBounds(375, 200, 150, 200);
        pane.add(medium);
        mediumText = new JLabel("Medium AI");
        mediumText.setBounds(375, 170, 150, 30);
        mediumText.setFont(new Font("Verdana", Font.PLAIN, 20));
        pane.add(mediumText);

        JButton hard = new JButton();
        hard.addActionListener((e) -> hardAction());
        hard.setIcon(new ImageIcon(new ImageIcon("images/cards/king_of_spades2.png").getImage().getScaledInstance(150, 200, Image.SCALE_DEFAULT)));
        hard.setBounds(600, 200, 150, 200);
        pane.add(hard);
        hardText = new JLabel("Hard AI");
        hardText.setBounds(600, 170, 150, 30);
        hardText.setFont(new Font("Verdana", Font.PLAIN, 20));
        pane.add(hardText);

        JButton backButton = new JButton("Back");
        backButton.addActionListener((e) -> {
            frame.dispose();
            try {
                new StartGUI();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        backButton.setBounds(100, 450, 100, 50);
        pane.add(backButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener((e) -> startGame());
        nextButton.setBounds(700, 450, 100, 50);
        pane.add(nextButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Player Setting");
        frame.setVisible(true);

    }

    private void startGame() {
        String name = nameBox.getText();
        if (name.length() == 0) {
            JOptionPane.showMessageDialog(frame, "Please enter a valid user name!");
            return;
        }

        if (countAI() < 2) {
            JOptionPane.showMessageDialog(frame, "Select more player!");
            return;
        }

        this.playerName = name;
        System.out.println("got a player: " + this.playerName);
        frame.dispose();
        new inGameGUI(this.playerName, this.AIs);
    }

    private int countAI() {
        int count = 0;
        for (int i : AIs) {
            if (i == 1) { count++; }
        }
        return count;
    }

    private void basicAction() {
        if (AIs[0] == 1) {
            AIs[0] = 0;
            basicText.setForeground(Color.black);
            return;
        }

        if (countAI() >= 2) { return; }

        AIs[0] = 1;
        basicText.setForeground(Color.orange);
    }

    private void mediumAction() {
        if (AIs[1] == 1) {
            AIs[1] = 0;
            mediumText.setForeground(Color.black);
            return;
        }

        if (countAI() >= 2) { return; }

        AIs[1] = 1;
        mediumText.setForeground(Color.orange);
    }

    private void hardAction() {
        if (AIs[2] == 1) {
            AIs[2] = 0;
            hardText.setForeground(Color.black);
            return;
        }

        if (countAI() >= 2) { return; }

        AIs[2] = 1;
        hardText.setForeground(Color.orange);
    }


    public static void main(String[] args) {
        new SelectGUI();
    }

}
