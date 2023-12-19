package proyek.user;
import javax.swing.*;

import proyek.MainFrame;
import proyek.gui.HomeGUI;

import java.awt.*;
import java.awt.event.*;

/**
 * @author Kelompok 6
 *
 */
//Creating LoginFrame class
public class LoginViews extends JPanel {
    public static final String KEY = "LOGIN";
    //private JPanel mainPanel;
    //Container container = getContentPane(); // Penyimpan Content Pane
    JLabel userLabel = new JLabel("Nama Anda");
    JLabel NPMLabel = new JLabel("NPM Anda");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField(26);
    JTextField NPMTextField = new JTextField(26);
    JPasswordField passwordField = new JPasswordField(26);
    private JButton backButton = new JButton("Kembali");;
    static JButton loginButton = new JButton("Login");
    static JButton resetButton = new JButton("Reset");
    static JCheckBox showPassword = new JCheckBox("Tunjukkan Password"); 

    JTextField searchTermTextField = new JTextField(26);
    
    public LoginViews(){
        setLayout(new GridLayout(4, 2, 10, 10));
        setBackground(Color.WHITE);

        // Membuat controller
        LoginController controllerLogin = new LoginController(userTextField, NPMTextField,
            passwordField);
        loginButton.addActionListener(controllerLogin);
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBack();
            }
        });

        // container.setLayout(null);

        // Error handling untuk input NPM
        NPMTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
               if (key.getKeyChar() >= '0' && key.getKeyChar() <= '9') {
                  NPMTextField.setEditable(true);
               } else {
                  NPMTextField.setEditable(false);
               }
            }
         });

        // Menambahkan komponen label ke container
        add(userLabel);
        add(NPMLabel);
        add(passwordLabel);
        add(userTextField);
        add(NPMTextField);
        add(passwordField);
        add(showPassword);
        add(loginButton);
        add(resetButton);
        add(backButton);

        //setVisible(true);
    }

    private void handleBack() {
        MainFrame.getInstance().navigateTo(HomeGUI.KEY);
        userTextField.setText("");
        NPMTextField.setText("");
        passwordField.setText("");
    }
}