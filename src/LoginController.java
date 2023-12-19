import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 
/**
 * @author Kelompok 6
 *
 */
public class LoginController implements ActionListener {
    static JButton loginButton = new JButton("Login");
    static JButton resetButton = new JButton("Reset");
    static JCheckBox showPassword = new JCheckBox("Tunjukkan Password"); 
    private JTextField searchTermTextField = new JTextField(26);
    private DefaultTableModel model;

    public LoginController(JTextField searchTermTextField, DefaultTableModel model) {
        super();
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
        this.searchTermTextField = searchTermTextField;
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}