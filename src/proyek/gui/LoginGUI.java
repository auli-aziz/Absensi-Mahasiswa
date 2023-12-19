package proyek.gui;

import javax.swing.*;

import proyek.MainFrame;
import proyek.user.LoginManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JPanel {
    public static final String KEY = "LOGIN";
    private JPanel mainPanel;
    private JLabel idLabel;
    private JTextField idTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton backButton;
    private LoginManager loginManager;

    public LoginGUI(LoginManager loginManager) {
        super(new BorderLayout()); // Setup layout
        this.loginManager = loginManager;

        // Set up main panel
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setBackground(Color.WHITE);

        initGUI();

        add(mainPanel, BorderLayout.CENTER);
    }

    /**
     * Method untuk menginisialisasi GUI.
     * Selama funsionalitas sesuai dengan soal, tidak apa apa tidak 100% sama.
     * Be creative and have fun!
     */
    private void initGUI() {
        setLayout(new GridLayout(4, 2, 10, 10));
        setBackground(Color.WHITE);

        // membuat id label dan text field
        idLabel = new JLabel("Masukkan ID Anda:");
        idTextField = new JTextField();
        idTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#97BFB1")));
        idTextField.setBackground(null);

        // membuat password label dan text field
        passwordLabel = new JLabel("Masukkan password Anda:");
        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#97BFB1")));
        passwordField.setBackground(null);

        // membuat login button
        loginButton = new JButton("Login");
        loginButton.setBackground(Color.decode("#97BFB1"));
        loginButton.setForeground(Color.WHITE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
        // membuat back button
        backButton = new JButton("Kembali");
        backButton.setBackground(Color.decode("#97BFB1"));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBack();
            }
        });

        add(idLabel);
        add(idTextField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(backButton);
    }

    /**
     * Method untuk kembali ke halaman home.
     * Akan dipanggil jika pengguna menekan "backButton"
     */
    private void handleBack() {
        MainFrame.getInstance().navigateTo(HomeGUI.KEY);
        idTextField.setText("");
        passwordField.setText("");
    }

    /**
     * Method untuk login pada sistem.
     * Akan dipanggil jika pengguna menekan "loginButton"
     */
    private void handleLogin() {
        // memanggil method login dari main frame
        MainFrame.getInstance().login(idTextField.getText(), String.valueOf(passwordField.getPassword()));
        idTextField.setText("");
        passwordField.setText("");
    }
}
