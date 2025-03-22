import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Console;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUI extends JFrame implements ActionListener {

    int height = 500;
    int width = 400;

    protected JLabel computerLabel, playerLabel, computerChoose;
    protected JButton scissorsButton, rockButton, paperButton;

    Logic logic;

    public GUI() {
        super("Scissors Rock Paper");
        setSize(width, height);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        logic = new Logic();
        addGUIComponents();
    }

    private void addGUIComponents() {

        computerChoose = new JLabel();
        computerLabel = new JLabel();
        playerLabel = new JLabel();

        scoreLabel(computerLabel, "Computer: 0", 0, 30);
        scoreLabel(playerLabel, "Player: 0", 0, height - 230);
        computerChoice(computerChoose, "?");
        gameButton(scissorsButton, "Scissors", 5);
        gameButton(rockButton, "Rock", 5 + width / 3);
        gameButton(paperButton, "Paper", 5 + width - width / 3);
    }

    private void scoreLabel(JLabel label, String title, int x, int y) {

        label.setText(title);
        label.setBounds(x, y, width, 30);
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
    }

    private void computerChoice(JLabel label, String title) {
        label.setText(title);
        label.setBounds((width / 2) - 100 / 2, 80, 100, 80);
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(label);

    }

    private void gameButton(JButton button, String buttonName, int x) {
        button = new JButton(buttonName);
        button.setBounds(x, height - 150, width / 4 + 10, 50);
        button.setFont(new Font("Dialog", Font.PLAIN, 18));
        button.addActionListener((ActionListener) this);
        add(button);
    }

    public void showDialog(String title, String message) {
        JDialog dialog = new JDialog(this, title, true);
        dialog.setSize(200, 100);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setResizable(false);

        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(resultLabel, BorderLayout.CENTER);

        JButton tryAgainButton = new JButton("Try Again");
        tryAgainButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                computerChoose.setText("?");

                dialog.dispose();
            }
        });

        dialog.add(tryAgainButton, BorderLayout.SOUTH);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand().toString();
        String result = logic.play(playerChoice);
        computerChoose.setText(logic.getComputerChoice());
        System.out.println("Computer: " + logic.getComputerChoice());
        computerLabel.setText("Computer: " + logic.getComputerScore());
        playerLabel.setText("Player: " + logic.getPlayerScore());

        showDialog("Result", result);
    }

}