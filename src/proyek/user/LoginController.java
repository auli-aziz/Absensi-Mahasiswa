package proyek.user;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import proyek.Constants;
import proyek.MainFrame;
import proyek.gui.HomeGUI;
import proyek.gui.member.dosen.DosenSystemGUI;
import proyek.gui.member.mahasiswa.MahasiswaSystemGUI;
import proyek.user.Menu.MahasiswaSystem;
import proyek.user.Menu.SystemCLI;
 
/**
 * @author Kelompok 6
 *
 */
public class LoginController implements ActionListener {
    private JTextField userTextField = new JTextField(26);
    private JTextField NPMTextField = new JTextField(26);
    private JPasswordField passwordField = new JPasswordField(26);
    private final CardLayout cards = new CardLayout();
    final MahasiswaSystem mahasiswaSystem = new MahasiswaSystem();
    private final MahasiswaSystemGUI mahasiswaSystemGUI = new MahasiswaSystemGUI(mahasiswaSystem);
    private final JPanel mainPanel = new JPanel(cards);

    public LoginController(JTextField nama, JTextField NPM, JPasswordField password) {
        super();
        this.userTextField = nama;
        this.NPMTextField = NPM;
        this.passwordField = password;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = userTextField.getText();
        String npm = NPMTextField.getText();
        String password = String.valueOf(passwordField.getPassword());

        if (!"".equals(name) && !"".equals(npm) && !"".equals(password)){
            for (Object[] o : Constants.DATA) {
                if (o[0].equals(name) && o[1].equals(npm) && o[2].equals(password)){
                    System.out.println("Kepanggil");
                    // PINDAH KE MAIN ACTIVITY 
                    //MainFrame.mainPanel.add(mahasiswaSystemGUI, MahasiswaSystemGUI.KEY);
                    cards.show(MainFrame.mainPanel, MahasiswaSystemGUI.KEY);
                    return;
                } 
            }
            JOptionPane.showMessageDialog(null,
                "Input is Incorrect", "Error",
                JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,
                "Field cannot be empty", "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    } 
    
    // public void navigateTo(String page) {
    //     // navigate page dengan CardLayout
    //     cards.show(mainPanel, page);
    // }
}