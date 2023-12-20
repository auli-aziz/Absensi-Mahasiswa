import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Kelas LoginViews merupakan tampilan untuk proses login dalam aplikasi.
 * Memuat elemen-elemen GUI seperti label, teksfield, dan tombol yang terkait dengan proses login.
 */
public class LoginViews extends JPanel {
    public static final String KEY = "LOGIN";
    JLabel userLabel = new JLabel("Nama Anda");
    JLabel NPMLabel = new JLabel("NPM Anda");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userTextField = new JTextField(26);
    JTextField NPMTextField = new JTextField(26);
    JPasswordField passwordField = new JPasswordField(26);
    private JButton backButton = new JButton("Kembali");
    static JButton loginButton = new JButton("Login");
    static JButton resetButton = new JButton("Reset");
    static JCheckBox showPassword = new JCheckBox("Tunjukkan Password");
    private static String loggedInUserName;

    JTextField searchTermTextField = new JTextField(26);

    /**
     * Konstruktor untuk kelas LoginViews.
     * Mengatur tampilan GUI untuk proses login, termasuk teksfield, tombol, dan fungsi-fungsi terkait.
     */
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

    /**
     * Method untuk mendapatkan nama pengguna yang sedang login.
     *
     * @return String Nama pengguna yang sedang login.
     */
    public static String getLoggedInUserName() {
        return loggedInUserName;
    }

    /**
     * Method untuk menangani proses login yang berhasil.
     *
     * @param name String Nama pengguna yang berhasil login.
     */
    public static void handleSuccessfulLogin(String name) {
        loggedInUserName = name;
    }

    /**
     * Method untuk mengatur aksi saat tombol kembali ditekan.
     * Kembali ke tampilan utama (HomeViews) setelah menekan tombol kembali.
     */
    private void handleBack() {
        Main.getInstance().navigateTo(HomeViews.KEY);
        userTextField.setText("");
        NPMTextField.setText("");
        passwordField.setText("");
        NPMTextField.setEditable(true);
    }
}
