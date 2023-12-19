import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;
 
/**
 * @author Kelompok 6
 *
 */
public class LoginController implements ActionListener {
    private DefaultTableModel model;
    private JTextField userTextField = new JTextField(26);
    private JTextField NPMTextField = new JTextField(26);
    private JPasswordField passwordField = new JPasswordField(26);

    public LoginController(JTextField nama, JTextField NPM, JPasswordField password, DefaultTableModel model) {
        super();
        this.userTextField = nama;
        this.NPMTextField = NPM;
        this.passwordField = password;
        this.model = model;
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
    
    
}