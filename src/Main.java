import javax.swing.JFrame;
import javax.swing.SwingUtilities;
/**
 * @author Kelompok 6
 *
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    createAndShowGUI();
                } catch (Exception e) {
                    e.printStackTrace(); 
                }
            }
        });
    }
    
    public static void createAndShowGUI() throws Exception {
        LoginViews loginView = new LoginViews();
        loginView.setTitle("Login");
        loginView.setVisible(true);
        loginView.setBounds(10,10,370,600);
        loginView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginView.setResizable(false);
    }
}
