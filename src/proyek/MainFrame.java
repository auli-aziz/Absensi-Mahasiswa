package proyek;


import javax.swing.*;

import proyek.gui.HomeGUI;
import proyek.gui.LoginGUI;
import proyek.gui.RegisterGUI;
import proyek.gui.member.Loginable;
import proyek.gui.member.dosen.DosenSystemGUI;
import proyek.gui.member.mahasiswa.MahasiswaSystemGUI; 
import proyek.user.Menu.DosenSystem;
import proyek.user.Menu.MahasiswaSystem;
import proyek.user.Dosen;
import proyek.user.LoginManager;
import proyek.user.Mahasiswa;

import java.awt.*;

public class MainFrame extends JFrame{
    private static MainFrame instance;
    private final Loginable[] loginablePanel;
    private final MahasiswaSystem mahasiswaSystem = new MahasiswaSystem();
    private final DosenSystem dosenSystem = new DosenSystem();
    private final CardLayout cards = new CardLayout();
    private final JPanel mainPanel = new JPanel(cards);
    private final LoginManager loginManager = new LoginManager(dosenSystem, mahasiswaSystem);
    private final HomeGUI homeGUI = new HomeGUI();
    private final RegisterGUI registerGUI = new RegisterGUI(loginManager);
    private final LoginGUI loginGUI = new LoginGUI(loginManager);
    private final DosenSystemGUI dosenSystemGUI = new DosenSystemGUI(dosenSystem);
    private final MahasiswaSystemGUI mahasiswaSystemGUI = new MahasiswaSystemGUI(mahasiswaSystem);

    private MainFrame() {
        super("Absensi Mahasiswa");

        dosenSystem.addDosen(new Dosen[] {
            new Dosen("Gde Dharma", "pakGede"),
            new Dosen("Firdaus Syawaludin", "pakDaus")
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 432);
        setVisible(true);

        loginablePanel = new Loginable[] {
            mahasiswaSystemGUI,
            dosenSystemGUI,
        };

        initGUI();
        cards.show(mainPanel, HomeGUI.KEY);
        add(mainPanel);
    }

    private void initGUI() {
        mainPanel.add(homeGUI, HomeGUI.KEY);
        mainPanel.add(registerGUI, RegisterGUI.KEY);
        mainPanel.add(loginGUI, LoginGUI.KEY);
        mainPanel.add(dosenSystemGUI, DosenSystemGUI.KEY);
        mainPanel.add(mahasiswaSystemGUI, MahasiswaSystemGUI.KEY);
    }


    /**
     * Method untuk mendapatkan instance MainFrame.
     * Instance Class MainFrame harus diambil melalui method ini agar menjamin hanya
     * terdapat satu Frame pada program.
     *
     * @return instance dari class MainFrame
     */
    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    /**
     * Method untuk pergi ke panel sesuai dengan yang diberikan pada param.
     *
     * @param page -> key dari halaman yang diinginkan.
     */
    public void navigateTo(String page) {
        // navigate page dengan CardLayout
        cards.show(mainPanel, page);
    }

    public boolean login(String id, String password) {
        for (Loginable panel : loginablePanel) {
            // login dengan id dan password kemudian navigate ke page dengan id dan pass
            // tersebut
            if (panel.login(id, password)) {
                navigateTo(panel.getPageName());
                return true;
            }
        }
        JOptionPane.showMessageDialog(this, "ID atau Password salah!", "Invalid ID atau Password",
                JOptionPane.ERROR_MESSAGE);
        return false;
    }

    public void logout() {
        for (Loginable panel : loginablePanel) {
            panel.logout();
        }
        navigateTo(HomeGUI.KEY);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::getInstance);
    }
}
