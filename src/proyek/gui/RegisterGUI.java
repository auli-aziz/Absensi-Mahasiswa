package proyek.gui;

import proyek.user.Mahasiswa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import proyek.MainFrame;
import proyek.user.LoginManager;

public class RegisterGUI extends JPanel {
    public static final String KEY = "REGISTER";
    private JPanel mainPanel;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JButton registerButton;
    private LoginManager loginManager;
    private JButton backButton;

    public RegisterGUI(LoginManager loginManager) {
        super(new BorderLayout()); // Setup layout, Feel free to make any changes
        this.loginManager = loginManager;

        // Set up main panel, Feel free to make any changes
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
        // tampilan registerGUI
        setBackground(Color.WHITE);
        setLayout(new GridLayout(5, 2, 10, 10));

        // membuat name label beserta text fieldnya
        nameLabel = new JLabel("Masukkan nama Anda:");
        nameTextField = new JTextField(10);
        nameTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#97BFB1")));
        nameTextField.setBackground(null);

        // membuat phone label beserta text fieldnya
        phoneLabel = new JLabel("Masukkan nomor NPM Anda");
        phoneTextField = new JTextField();
        phoneTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#97BFB1")));
        phoneTextField.setBackground(null);

        // membuat password label beserta tect fieldnya
        passwordLabel = new JLabel("Masukkan password Anda:");
        passwordField = new JPasswordField();
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#97BFB1")));
        passwordField.setBackground(null);

        // membuat backbutton
        backButton = new JButton("Kembali");
        backButton.setBackground(Color.decode("#97BFB1"));
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(200, 30));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBack();
            }
        });

        // membuat registerbutton
        registerButton = new JButton("Register");
        registerButton.setBackground(Color.decode("#97BFB1"));
        registerButton.setForeground(Color.WHITE);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegister();
            }
        });

        add(nameLabel);
        add(nameTextField);
        add(phoneLabel);
        add(phoneTextField);
        add(passwordLabel);
        add(passwordField);
        add(backButton);
        add(registerButton);
    }

    /**
     * Method untuk kembali ke halaman home.
     * Akan dipanggil jika pengguna menekan "backButton"
     */
    private void handleBack() {
        MainFrame.getInstance().navigateTo(HomeGUI.KEY);
        nameTextField.setText("");
        phoneTextField.setText("");
        passwordField.setText("");
    }

    /**
     * Method untuk mendaftarkan mahasiswa pada sistem.
     * Akan dipanggil jika pengguna menekan "registerButton"
     */
    private void handleRegister() {
        // kondisional jika nomor telepon bukan angka
        if (!LoginManager.isNumeric(phoneTextField.getText())) {
            JOptionPane.showMessageDialog(mainPanel, "Nomor Handphone harus berisi angka!", "Invalid Phone Number",
                    JOptionPane.ERROR_MESSAGE);
            phoneTextField.setText("");
        }
        // kondisional jika ada field yang kosong
        if (nameTextField.getText().isEmpty() || phoneTextField.getText().isEmpty()
                || String.valueOf(passwordField.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(mainPanel, "Semua field di atas wajib diisi!", "Empty Field",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            Mahasiswa mahasiswa = loginManager.register(nameTextField.getText(), phoneTextField.getText(),
                    String.valueOf(passwordField.getPassword()));
            if (mahasiswa == null) {
                JOptionPane.showMessageDialog(mainPanel,
                        "User dengan nama " + nameTextField.getText() + " dan nomor Handphone "
                                + phoneTextField.getText() + " sudah ada!",
                        "Registration Unsuccessful", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mainPanel, "Berhasil membuat user dengan ID  " + mahasiswa.getId() + "!",
                        "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
            }
            handleBack();
        }
    }
}
