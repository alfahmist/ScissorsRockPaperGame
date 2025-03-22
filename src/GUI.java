import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GUI extends JFrame {

    int height = 500;
    int width = 400;

    // TODO Auto-generated method stub
    JLabel computerLabel = new JLabel();
    JLabel playerLabel = new JLabel();
    JLabel computerChoice = new JLabel();
    JButton scissorsButton = new JButton();
    JButton rockButton = new JButton();
    JButton paperButton = new JButton();

    public GUI() {
        super("Scissors Rock Paper");
        setSize(width, height);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addGUIComponents();
    }

    private void addGUIComponents() {

        scoreLabel(computerLabel, "Computer: 0", 0, 30);
        scoreLabel(playerLabel, "Player: 0", 0, height - 230);
        computerChoice(computerChoice, "?");
        gameButton(scissorsButton, "Scissors", 10);
        gameButton(rockButton, "Rock", 10 + width / 3);
        gameButton(paperButton, "Paper", 10 + width - width / 3);
        // showDialog("Result", "You Win!");
    }

    private void scoreLabel(JLabel label, String title, int x, int y) {

        label = new JLabel(title);
        label.setBounds(x, y, width, 30);
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
    }

    private void computerChoice(JLabel label, String title) {
        label = new JLabel(title);
        label.setBounds((width / 2) - 100 / 2, 80, 100, 80);
        label.setFont(new Font("Dialog", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(label);

    }

    private void gameButton(JButton button, String buttonName, int x) {
        button = new JButton(buttonName);
        button.setBounds(x, height - 150, width / 4, 50);
        button.setFont(new Font("Dialog", Font.PLAIN, 18));
        // button.addActionListener(this);
        add(button);
    }

    private void showDialog(String title, String message) {
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
                computerChoice.setText("?");

                dialog.dispose();
            }
        });

        dialog.add(tryAgainButton, BorderLayout.SOUTH);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
    }

}