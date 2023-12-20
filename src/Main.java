import java.awt.CardLayout;

import javax.swing.*;

/**
 * @author Kelompok 6
 *
 */
public class Main extends JFrame {
    private static Main instance;
    public static CardLayout cards = new CardLayout();
    public static JPanel mainPanel = new JPanel(cards);
    private final HomeViews homeGUI = new HomeViews();
    private final ListViews listMahasiswaViews = new ListViews();
    private final LoginViews loginViews = new LoginViews();
    private final StudentRegisterView registerView = new StudentRegisterView();

    public Main() {
        super("Absensi Mahasiswa");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 432);
        setVisible(true);

        initGUI();
        cards.show(mainPanel, HomeViews.KEY);
        add(mainPanel);
    }

    public void initGUI() {
        mainPanel.add(homeGUI, HomeViews.KEY);

        mainPanel.add(loginViews, LoginViews.KEY);
        
        mainPanel.add(registerView, StudentRegisterView.KEY);

        mainPanel.add(listMahasiswaViews, ListViews.KEY);
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public static void navigateTo(String page) {
        cards.show(mainPanel, page);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::getInstance);
    }

    public static void createAndShowReg() throws Exception {
        new StudentRegisterView();
    }
    
}
