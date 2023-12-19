import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Kelompok 6
 *
 */
//Creating LoginFrame class
public class LoginViews extends JFrame {
    Container container = getContentPane(); // Penyimpan Content Pane
    JLabel userLabel = new JLabel("Nama Anda");
    JLabel NPMLabel = new JLabel("NPM Anda");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField(26);
    JTextField NPMTextField = new JTextField(26);
    JPasswordField passwordField = new JPasswordField(26);
    static JButton loginButton = new JButton("Login");
    static JButton resetButton = new JButton("Reset");
    static JCheckBox showPassword = new JCheckBox("Tunjukkan Password");
    private static String loggedInUserName;

    JTextField searchTermTextField = new JTextField(26);
    
    LoginViews(){
        JTable table = new JTable();

        // Membuat model data
        Model model = new Model();
        table.setModel(model); 

        // Membuat controller
        LoginController controllerLogin = new LoginController(userTextField, NPMTextField,
            passwordField, model);
        loginButton.addActionListener(controllerLogin);
        

        // Mengganti border layout halaman login
        container.setLayout(null);

        // Mengatur peletakkan button
        userLabel.setBounds(50,80,100,30);
        NPMLabel.setBounds(50,150,100,30);
        passwordLabel.setBounds(50,220,100,30);
        userTextField.setBounds(150,80,150,30);
        NPMTextField.setBounds(150,150,150,30);
        passwordField.setBounds(150,220,150,30);
        showPassword.setBounds(150,250,150,30);
        loginButton.setBounds(50,300,100,30);
        resetButton.setBounds(200,300,100,30);

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
        container.add(userLabel);
        container.add(NPMLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(NPMTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);

        showPassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userTextField.setText("");
                NPMTextField.setText("");
                passwordField.setText("");
            }
        });
    }
    public static String getLoggedInUserName() {
        return loggedInUserName;
    }

    public static void handleSuccessfulLogin(String name) {
        loggedInUserName = name;
    }


}