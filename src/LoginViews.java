import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Kelompok 6
 *
 */
//Creating LoginFrame class
public class LoginViews extends JPanel {
    public static final String KEY = "LOGIN";
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
    private static String loggedInUserName;

    JTextField searchTermTextField = new JTextField(26);
    
    LoginViews(){
        setLayout(new GridLayout(7, 2, 10, 10));
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
        

        // Error handling untuk input NPM
        NPMTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent key) {
               if (key.getKeyChar() >= '0' && key.getKeyChar() <= '9' || key.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                  NPMTextField.setEditable(true);
               } else {
                  NPMTextField.setEditable(false);
               }
            }
         });

        // Menambahkan komponen label ke container
        add(userLabel);
        add(userTextField);
        add(NPMLabel);
        add(NPMTextField);
        add(passwordLabel);
        add(passwordField);
        add(showPassword);
        add(loginButton);
        add(resetButton);
        add(backButton);

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

    private void handleBack() {
        Main.getInstance().navigateTo(HomeViews.KEY);
        userTextField.setText("");
        NPMTextField.setText("");
        passwordField.setText("");
        NPMTextField.setEditable(true);
    }
}