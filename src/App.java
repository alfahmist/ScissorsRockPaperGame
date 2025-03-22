import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI gui = new GUI();

                gui.setVisible(true);
            }
        });
    }
}
