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
        new Views();
    }
}
